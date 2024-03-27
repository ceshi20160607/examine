package com.unique.approve.handler;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.unique.approve.entity.dto.ExamineBO;
import com.unique.approve.entity.dto.ExamineContext;
import com.unique.approve.entity.dto.ExamineFillParams;
import com.unique.approve.entity.po.ExamineNode;
import com.unique.approve.entity.po.ExamineNodeUser;
import com.unique.approve.entity.po.ExamineRecordNode;
import com.unique.approve.enums.CheckStatusEnum;
import com.unique.approve.enums.ExamineFlagEnum;
import com.unique.approve.enums.ExamineNodeTypeEnum;
import com.unique.approve.enums.ExamineTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseHandler extends AbstractHandler{

    @Resource
    private HandlerService handlerService;
    @Override
    public ExamineNodeTypeEnum examineNodeTypeEnum() {
        return ExamineNodeTypeEnum.BASE;
    }

    /** 创建
     * @param context
     */
    @Override
    public void build(ExamineContext context) {
        //0.更新
        List<ExamineRecordNode> examineRecordNodes = context.getExamineRecordNodeUpdateList();
        //1.本次节点
        Long examineNodeId = context.getExamineNodeId();
        Map<Long, List<ExamineNode>> examineNodeListMap = new HashMap<>();
        List<ExamineNode> examineNodes = examineNodeListMap.get(examineNodeId);
        //2.用户
        Map<Long, List<ExamineNodeUser>> examineNodeUserListMap = new HashMap<>();
        List<ExamineNodeUser> ExamineNodeUsers = examineNodeUserListMap.get(examineNodeId);
        //3.自选的数据
        Map<Long, List<ExamineFillParams>> examineFillParamsListMap = new HashMap<>();
        List<ExamineFillParams> examineFillParams = examineFillParamsListMap.get(examineNodeId);

        //5.构建node
        Long nodeAfterId = examineNodes.get(0).getNodeAfterId();
        for (ExamineNode r : examineNodes) {
            Integer status = CheckStatusEnum.CHECK_ING.getType();
            //审批人员  审批人类型 0 固定人员 1 固定人员上级 2角色 3发起人自选4
            ExamineTypeEnum examineTypeEnum = ExamineTypeEnum.parse(r.getExamineType());
            for (ExamineNodeUser t : ExamineNodeUsers) {
                ExamineRecordNode recordLog1 = BeanUtil.copyProperties(r, ExamineRecordNode.class);
                switch (examineTypeEnum) {
                    case FIXED:
                        recordLog1.setUserId(t.getUserId());
                        break;
                    case FIXED_SUPER:
                        //依据userId来获取该用户的上级
                        recordLog1.setUserId(t.getUserId());
                        break;
                    case ROLE:
                        recordLog1.setRoleId(t.getRoleId());
                        break;
                    case CHOOSE:
                        //2.1.如果审批不全，需要补充的这里添加构建
                        recordLog1.setUserId(examineFillParams.get(0).getUserId());
                        break;
                }
                recordLog1.setStatus(status);
                examineRecordNodes.add(recordLog1);
            }
        }
        //6.最后的数据
        context.setExamineRecordNodeUpdateList(examineRecordNodes);
        //9.如果要进行下一步需要处理
        List<ExamineRecordNode> afterNodes = context.getExamineRecordNodeListMap().get(nodeAfterId);
        if (CollectionUtil.isNotEmpty(afterNodes)) {
            setNextHandler(handlerService.getHandlerService(ExamineNodeTypeEnum.parse(afterNodes.get(0).getNodeType())));
            //8.执行下一个处理人
            getNextHandler().build(context);
        }
    }

    /** 执行逻辑
     * @param context
     */
    @Override
    public void handle(ExamineContext context) {
        //1.校验
        Long examineNodeId = context.getExamineNodeId();
        List<ExamineRecordNode> examineRecordNodes = context.getExamineRecordNodeListMap().get(examineNodeId);
        if (CollectionUtil.isNotEmpty(examineRecordNodes)) {
            //2.审核操作
            baseProcess(examineRecordNodes, context);
        }
    }

    /** 处理逻辑
     * @param nodes
     * @param context
     */
    private void baseProcess(List<ExamineRecordNode> nodes,ExamineContext context) {
        //0.审批数据
        ExamineBO examineBO = context.getExamineBO();
        Long examineUserId = examineBO.getUserId();
        Boolean gFlag = Boolean.FALSE;
        Long nodeAfterId = null;
        //1.0循环处理
        for (ExamineRecordNode r : nodes) {
            //1.是否审核通过
            if (r.getStatus().equals(1)) {
                //1.1.是否转他人过来的
                Long tempUserId = r.getUserId();
                if (r.getTransferFlag().equals(1)) {
                    tempUserId = r.getTransferUserId();
                }
                if (r.getUserId().equals(examineUserId)) {
                    gFlag = Boolean.TRUE;
                    nodeAfterId = r.getNodeAfterId();
                    r.setStatus(CheckStatusEnum.CHECK_PASS.getType());
                }
            }else{
                //3.多人审批场景
                if (ExamineFlagEnum.ANY_ONE.equals(r.getExamineFlag()) && gFlag) {
                    continue;
                }
                //2.正常审核
                switch (ExamineTypeEnum.parse(r.getExamineType())) {
                    case CHOOSE:
                    case FIXED:
                        //2.1.固定审批人
                        if (r.getUserId().equals(examineUserId)) {
                            gFlag = Boolean.TRUE;
                            nodeAfterId = r.getNodeAfterId();
                            r.setStatus(CheckStatusEnum.CHECK_PASS.getType());
                        }
                        break;
                    case FIXED_SUPER:
                        //2.2.固定审批人上级

                        break;
                    case ROLE:
                        //2.3.角色审批
                        break;
                    default:
                }
            }
        }
        if (gFlag) {
            //6.设置下一个处理人
            List<ExamineRecordNode> afterNodes = context.getExamineRecordNodeListMap().get(nodeAfterId);
            if (CollectionUtil.isNotEmpty(afterNodes)) {
                setNextHandler(handlerService.getHandlerService(ExamineNodeTypeEnum.parse(afterNodes.get(0).getNodeType())));
                //7.要更新数据
                context.getExamineRecordNodeUpdateList().addAll(nodes);
                //8.执行下一个处理人
                getNextHandler().handle(context);
            }
        }
    }
}
