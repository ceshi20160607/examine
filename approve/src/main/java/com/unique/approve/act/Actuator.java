package com.unique.approve.act;

import cn.hutool.core.collection.CollectionUtil;
import com.unique.approve.entity.dto.ExamineContext;
import com.unique.approve.entity.po.ExamineRecordNode;
import com.unique.approve.enums.ExamineNodeTypeEnum;
import com.unique.approve.handler.AbstractHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Actuator {

    private Map<ExamineNodeTypeEnum, AbstractHandler> nextHandlerMap = new HashMap<>();
    AbstractHandler abstractHandler;

    public void handle(ExamineContext context) {
        Boolean baseFlag = Boolean.FALSE;
        //1.校验
        Long examineNodeId = context.getExamineNodeId();
        List<ExamineRecordNode> examineRecordNodes = context.getExamineRecordNodeListMap().get(examineNodeId);
        if (CollectionUtil.isNotEmpty(examineRecordNodes)) {
            //2.审核操作

            //3.设置下一个处理人
            ExamineRecordNode examineRecordNode = examineRecordNodes.get(0);
            switch (ExamineNodeTypeEnum.parse(examineRecordNode.getNodeType())){
                case CONDITION:
                    abstractHandler.handle(context);
                    break;
                case CC:
                    break;
                case TRANSFER:
                    break;
                case WITHIN_CONDITIONS:
                    break;
                default:
                    break;
            }

        }
    }

}
