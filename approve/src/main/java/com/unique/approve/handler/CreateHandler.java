package com.unique.approve.handler;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.unique.approve.entity.dto.ExamineBO;
import com.unique.approve.entity.dto.ExamineContext;
import com.unique.approve.entity.dto.ExamineFillParams;
import com.unique.approve.entity.dto.ExamineRecordParams;
import com.unique.approve.entity.po.*;
import com.unique.approve.enums.CheckStatusEnum;
import com.unique.approve.enums.ExamineFlagEnum;
import com.unique.approve.enums.ExamineNodeTypeEnum;
import com.unique.approve.enums.ExamineTypeEnum;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CreateHandler extends AbstractHandler{

    @Resource
    private HandlerService handlerService;
    @Override
    public ExamineNodeTypeEnum examineNodeTypeEnum() {
        return ExamineNodeTypeEnum.CREATE;
    }

    /** 创建
     * @param context
     */
    @Override
    public void build(ExamineContext context) {
        //0.更新
        Boolean gFlag = Boolean.FALSE;
        Map<Long,List<ExamineNode>> examineRecordNodeListMap = new HashMap<>();
        //1.获取审批信息
        Examine examine = context.getExamine();
        //2.当前审批实例信息
        ExamineRecordParams examineOtherParams = context.getExamineRecordParams();
        //3.
        //4.创建审批记录
        ExamineRecord examineRecord = BeanUtil.copyProperties(examine, ExamineRecord.class);
        examineRecord.setCreateUserId(examineOtherParams.getCreateUserId());
        examineRecord.setCreateTime(LocalDateTime.now());
        examineRecord.setUpdateTime(LocalDateTime.now());
        context.setExamineRecord(examineRecord);

        //5.创建初始数据
        List<ExamineRecordNode> examineRecordNodes = new ArrayList<>();
        List<ExamineNode> examineNodes = context.getExamineNodeListMap().get(0);
        ExamineNode node = examineNodes.get(0);
        ExamineRecordNode recordLog = BeanUtil.copyProperties(node, ExamineRecordNode.class);
        examineRecordNodes.add(recordLog);
        //6.下一个处理人
        Long nodeAfterId = node.getNodeAfterId();
        
        
        //8.最后的数据
        context.setExamineRecordNodeList(examineRecordNodes);
        //9.如果要进行下一步需要处理
        if (gFlag) {
            List<ExamineRecordNode> afterNodes = context.getExamineRecordNodeListMap().get(nodeAfterId);
            if (CollectionUtil.isNotEmpty(afterNodes)) {
                setNextHandler(handlerService.getHandlerService(ExamineNodeTypeEnum.parse(afterNodes.get(0).getNodeType())));
                //8.执行下一个处理人
                getNextHandler().build(context);
            }
        }
    }

    /** 执行逻辑
     * @param context
     */
    @Override
    public void handle(ExamineContext context) {

    }
}
