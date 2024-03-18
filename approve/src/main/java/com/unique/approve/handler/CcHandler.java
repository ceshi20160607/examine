package com.unique.approve.handler;

import cn.hutool.core.collection.CollectionUtil;
import com.unique.approve.entity.dto.ExamineContext;
import com.unique.approve.entity.po.ExamineRecordNode;
import com.unique.approve.enums.ExamineNodeTypeEnum;
import com.unique.core.bo.SendEmailBO;
import com.unique.core.utils.EmailUtil;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CcHandler extends AbstractHandler{

    @Resource
    private HandlerService handlerService;
    @Override
    public ExamineNodeTypeEnum examineNodeTypeEnum() {
        return ExamineNodeTypeEnum.CC;
    }

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

    private void baseProcess(List<ExamineRecordNode> nodes, ExamineContext context) {
        Long nodeAfterId = null;
        for (ExamineRecordNode r : nodes) {
            nodeAfterId = r.getNodeAfterId();
            String[] split = r.getCopyEmails().split(",");
            SendEmailBO sendEmailBO = new SendEmailBO();
            sendEmailBO.setEmails(split);
            EmailUtil.sendEmailProcess(sendEmailBO);
        }
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
