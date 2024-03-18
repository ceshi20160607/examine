package com.unique.approve.handler;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSON;
import com.unique.approve.entity.dto.ExamineContext;
import com.unique.approve.entity.dto.ExamineSearch;
import com.unique.approve.entity.po.ExamineRecordNode;
import com.unique.approve.enums.CheckStatusEnum;
import com.unique.approve.enums.ExamineNodeTypeEnum;
import com.unique.core.utils.SearchFieldUtil;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConditionHandler extends AbstractHandler{
    @Resource
    private HandlerService handlerService;
    @Override
    public ExamineNodeTypeEnum examineNodeTypeEnum() {
        return ExamineNodeTypeEnum.CONDITION;
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
        Map<String, Object> entity = context.getExamineRecordParams().getEntity();
        Boolean itemRet = Boolean.TRUE;
        for (ExamineRecordNode r : nodes) {
            if (!itemRet) {
                r.setStatus(CheckStatusEnum.CHECK_DISCARD.getType());
            }
            List<ExamineSearch> examineSearcheList = JSON.parseArray(r.getConditionModuleFieldSearch(), ExamineSearch.class);
            for (ExamineSearch search : examineSearcheList) {
                itemRet = itemRet && SearchFieldUtil.searchConditionValue(search, entity);
            }
            if (itemRet) {
                r.setStatus(CheckStatusEnum.CHECK_PASS.getType());
            }
        }

        Long nodeAfterId = nodes.get(0).getNodeAfterId();
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
