package com.unique.approve.entity.dto;

import com.unique.approve.entity.po.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class ExamineContext implements Serializable {

    private static final long serialVersionUID = 1L;
    //-------------------------前置参数------------------------------
    /**
     * 关联审批模块
     */
    private Long examineId;
    //-------------------------审批基础参数------------------------------
    /**
     * 审批基础信息
     */
    private Examine examine;
    /**
     * 审批配置--基础信息
     */
    private ExamineSetting examineSetting;
    /**
     * 审批配置--基础用户信息
     */
    private List<ExamineSettingUser> examineSettingUserList;

    /**
     * 审批节点信息
     */
    private List<ExamineNode> examineNodeList;
    /**
     * 审批节点信息用户相关
     */
    private Map<Long,List<ExamineNodeUser>> examineNodeUserList;
    //-------------------------审批节点信息------------------------------
    /**
     * 审批业务数据---用于以后拓展 字段相关
     */
    private ExamineRecordParams examineRecordParams;
    /**
     * 具体审批recordId
     */
    private Long examineRecordId ;
    /**
     * 具体审批
     */
    private ExamineRecord examineRecord ;
    /**
     * 具体审批-审批日志
     */
    private List<ExamineRecordNode> examineRecordNodeList;

    /**
     * 具体审批-临时 以父级点为分组，顶级0开始
     */
    private Map<Long,List<ExamineRecordNode>> examineRecordNodeListMap;

    //-------------------------审批-----------------------------
//    //1.请求时候已经构建完成了审批的node
//    //2.动态的添加审批节点的时候配置
//    /**
//     * 审批过程构建的参数
//     */
//    private List<ExamineNodeFill> examineNodeFillList;
    //-------------------------审批前------------------------------
    /**
     * 审批人自选的参数
     */
    private List<ExamineFillParams> examineFillParamsList;
    /**
     * 审批人审批的---入参
     * 张三审批通过了选择的通过+填写的备注信息
     */
    private ExamineBO examineBO;

    //-------------------------审批中------------------------------
    /**
     * 具体nodeId
     */
    private Long examineNodeId ;

    //-------------------------审批结果------------------------------
    /**
     * 审批后进行的数据更新
     */
    private List<ExamineRecordNode> examineRecordNodeUpdateList;



}
