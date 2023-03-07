package com.unique.examine.common.liteflow;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.annotation.LiteflowMethod;
import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.enums.LiteFlowMethodEnum;
import com.yomahub.liteflow.enums.NodeTypeEnum;

/**
 * 审批组件
 * @author UNIQUE
 * @date 2023/3/2
 */
@LiteflowComponent
public class LiteFlowTask {

    //普通组件的定义
    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS, nodeId = "ta")
    public void processA(NodeComponent bindCmp) {

    }

    //SWITCH组件的定义
    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS_SWITCH, nodeId = "ts", nodeType = NodeTypeEnum.SWITCH)
    public String processB(NodeComponent bindCmp) {
        String ret = "";
        return ret;
    }

    //IF组件的定义
    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS_IF, nodeId = "ti", nodeType = NodeTypeEnum.IF)
    public boolean processC(NodeComponent bindCmp) {
        boolean ret = true;
        return ret;
    }

    //FOR组件的定义
    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS_FOR, nodeId = "tf", nodeType = NodeTypeEnum.FOR)
    public int processD(NodeComponent bindCmp) {
        int ret = 0;
        return ret;
    }

    //WHILE组件的定义
    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS_WHILE, nodeId = "tw", nodeType = NodeTypeEnum.WHILE)
    public int processE(NodeComponent bindCmp) {
        int ret = 0;
        return ret;
    }

    //BREAK组件的定义
    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS_BREAK, nodeId = "tb", nodeType = NodeTypeEnum.BREAK)
    public int processF(NodeComponent bindCmp) {
        int ret = 0;
        return ret;
    }
}
