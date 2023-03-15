package com.unique.examine.common.liteflow;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.unique.examine.common.context.ExamineContext;
import com.unique.examine.common.enums.CheckStatusEnum;
import com.unique.examine.common.enums.ExamineTypeEnum;
import com.unique.examine.common.enums.TaskTypeEnum;
import com.unique.examine.common.utils.SearchFieldUtil;
import com.unique.examine.entity.bo.ExamineBefore;
import com.unique.examine.entity.bo.ExamineModel;
import com.unique.examine.entity.bo.ExamineSearch;
import com.unique.examine.entity.po.*;
import com.unique.examine.service.IExamineRecordLogService;
import com.unique.examine.service.IExamineRecordService;
import com.unique.examine.service.IExamineRecordTaskService;
import com.unique.examine.service.IExamineTaskService;
import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.annotation.LiteflowMethod;
import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.enums.LiteFlowMethodEnum;
import com.yomahub.liteflow.enums.NodeTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 审批组件
 * @author UNIQUE
 * @date 2023/3/2
 */
@LiteflowComponent
public class LiteFlowTask{
    @Autowired
    private IExamineRecordService iExamineRecordService;
    @Autowired
    private IExamineRecordTaskService iExamineRecordTaskService;
    @Autowired
    private IExamineRecordLogService iExamineRecordLogService;


    @LiteflowMethod(value = LiteFlowMethodEnum.IS_ACCESS, nodeId = "other")
    public boolean other11(NodeComponent bindCmp) {
        Boolean gFlag = Boolean.FALSE;
        return gFlag;
    }
    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS, nodeId = "other")
    public void other12(NodeComponent bindCmp) {}

    @LiteflowMethod(value = LiteFlowMethodEnum.IS_ACCESS, nodeId = "general")
    public boolean comp11(NodeComponent bindCmp) {
        Boolean gFlag = Boolean.FALSE;
        ExamineContext context = bindCmp.getContextBean(ExamineContext.class);
        ExamineBefore examineBefore = context.getExamineBefore();
        for (ExamineRecordLog r : context.getExamineRecordLogList()) {
            if(!r.getTransferFlag().equals(0) && r.getStatus().equals(1)){
                if (r.getUserId().equals(examineBefore.getUserId())) {
                    gFlag = Boolean.TRUE;
                }
            }
            if(r.getTransferFlag().equals(1) && r.getTransferStatus().equals(1)){
                if (r.getTransferUserId().equals(examineBefore.getUserId())) {
                    gFlag = Boolean.TRUE;
                }
            }
        }
        return gFlag;
    }
    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS, nodeId = "general")
    public void comp12(NodeComponent bindCmp) {
        ExamineContext context = bindCmp.getContextBean(ExamineContext.class);
        //审批通过  拒绝  做相关更新
        updateStatusExamine(context.getExamineBefore());
    }

    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS_SWITCH, nodeId = "condition", nodeType = NodeTypeEnum.SWITCH)
    public String condition11(NodeComponent bindCmp) {
        ExamineContext context = bindCmp.getContextBean(ExamineContext.class);
        Map<String, Object> entity = context.getExamineModel().getEntity();
        List<ExamineRecordLog> examineRecordLogList = context.getExamineRecordLogList().stream().filter(r->r.getStatus().equals(CheckStatusEnum.CHECK_ING.getType())).collect(Collectors.toList());
        Boolean itemRet = Boolean.TRUE;
        for (ExamineRecordLog r : examineRecordLogList) {
            List<ExamineSearch> examineSearcheList = JSON.parseArray(r.getConditionModuleSearch(), ExamineSearch.class);
            for (ExamineSearch search : examineSearcheList) {
                itemRet = itemRet && SearchFieldUtil.searchConditionValue(search, entity);
            }
            if (itemRet) {
                r.setStatus(CheckStatusEnum.CHECK_PASS.getType());
                //该分支下一部后续
                updateConditionExamine(context.getExamineBefore());
            }else {
                r.setStatus(CheckStatusEnum.CHECK_DISCARD.getType());
            }
        }
        return "next";
    }
    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS_SWITCH, nodeId = "next", nodeType = NodeTypeEnum.SWITCH)
    public String condition12(NodeComponent bindCmp) {
        ExamineContext context = bindCmp.getContextBean(ExamineContext.class);
        List<ExamineRecordLog> examineRecordLogList = context.getExamineRecordLogList().stream().filter(r->r.getStatus().equals(CheckStatusEnum.CHECK_ING.getType())).collect(Collectors.toList());
        String ret = "other";
        switch (TaskTypeEnum.parse(examineRecordLogList.get(0).getTaskType())){
            case GENERAL:
                ret = "general";
                break;
            case CONDITION:
                ret = "condition";
                break;
            case CC:
                ret = "cc";
                break;
            case TRANSFER:
                ret = "tran";
                break;
            case WITHIN_CONDITIONS:
                ret = "inc";
                break;
            default:
                break;
        }
        return ret;
    }


    //-----------------------------------------------------------------

    @LiteflowMethod(value = LiteFlowMethodEnum.IS_ACCESS, nodeId = "create")
    public boolean create11(NodeComponent bindCmp) {
        Boolean gFlag = Boolean.FALSE;
        ExamineContext context = bindCmp.getContextBean(ExamineContext.class);
        List<ExamineRecordLog> examineRecordLogList = context.getExamineRecordLogList();
        if (CollectionUtil.isEmpty(examineRecordLogList)) {
            gFlag = Boolean.TRUE;
        }
        return gFlag;
    }
    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS, nodeId = "create")
    public void create12(NodeComponent bindCmp) {
        ExamineContext context = bindCmp.getContextBean(ExamineContext.class);
        //业务数据
        ExamineModel examineModel = context.getExamineModel();
        Examine examine = context.getExamine();
        //创建具体审批
        ExamineRecord examineRecord = BeanUtil.copyProperties(examine, ExamineRecord.class);
        examineRecord.setCreateUserId(examineModel.getCreateUserId());
        examineRecord.setCreateTime(LocalDateTime.now());
        examineRecord.setUpdateTime(LocalDateTime.now());
        iExamineRecordService.save(examineRecord);

        List<ExamineTemplate> examineTaskList = context.getExamineTemplateList();
        List<ExamineTemplate> fillTemplateList = context.getFillTemplateList();
        //自选人员数据
        Map<Long, List<ExamineTemplate>> fillTemplateGroup = new HashMap<>();
        if (CollectionUtil.isNotEmpty(fillTemplateList)) {
            fillTemplateGroup = fillTemplateList.stream().collect(Collectors.groupingBy(r -> r.getId()));
        }

        //创建初始数据
        List<ExamineRecordLog> examineRecordLogList = new ArrayList<>();
        ExamineRecordLog recordLog = new ExamineRecordLog();
        recordLog.setRecordId(examineRecord.getId());
        recordLog.setTaskType(TaskTypeEnum.CREATE.getType());
        recordLog.setExamineType(ExamineTypeEnum.DEFAULT.getType());
        recordLog.setUserId(examineModel.getCreateUserId());
        recordLog.setStatus(CheckStatusEnum.CHECK_PASS.getType());
        examineRecordLogList.add(recordLog);
        for (int i = 0; i < examineTaskList.size(); i++) {
            ExamineTemplate r = examineTaskList.get(i);
            Integer status = CheckStatusEnum.CHECK_CREATE.getType();
            if (i==0) {
                status = CheckStatusEnum.CHECK_ING.getType();
            }
            switch (TaskTypeEnum.parse(r.getTaskType())) {
                case GENERAL:
                    //审批人员  审批人类型 0 固定人员 1 固定人员上级 2角色 3发起人自选4
                    switch (ExamineTypeEnum.parse(r.getExamineType())) {
                        case FIXED:
                            String[] userIds1 = r.getUserIds().split(",");
                            for (String userId : userIds1) {
                                ExamineRecordLog recordLog1 = BeanUtil.copyProperties(r,ExamineRecordLog.class);
                                recordLog1.setRecordId(examineRecord.getId());
                                recordLog1.setUserId(Long.valueOf(userId));
                                examineRecordLogList.add(recordLog1);
                            }
                            break;
                        case FIXED_SUPER:
                            //依据userId来获取该用户的上级
                            List<Long> upUserList = new ArrayList<>();
                            for (Long userId : upUserList) {
                                ExamineRecordLog recordLog2 = BeanUtil.copyProperties(r,ExamineRecordLog.class);
                                recordLog2.setRecordId(examineRecord.getId());
                                recordLog2.setUserId(userId);
                                recordLog2.setStatus(status);
                                examineRecordLogList.add(recordLog2);
                            }
                            break;
                        case ROLE:
                            //获取该role 对应用户
                            String[] roleIds3 = r.getRoleIds().split(",");
                            for (String roleId : roleIds3) {
                                ExamineRecordLog recordLog3 = BeanUtil.copyProperties(r,ExamineRecordLog.class);
                                recordLog3.setRecordId(examineRecord.getId());
                                recordLog3.setRoleId(Long.valueOf(roleId));
                                recordLog3.setStatus(status);
                                examineRecordLogList.add(recordLog3);
                            }
                            break;
                        case CHOOSE:
                            if (ObjectUtil.isNotEmpty(fillTemplateGroup.get(r.getId()))) {
                                String[] userIds4 = r.getUserIds().split(",");
                                for (String userId : userIds4) {
                                    ExamineRecordLog recordLog4 = BeanUtil.copyProperties(r,ExamineRecordLog.class);
                                    recordLog4.setRecordId(examineRecord.getId());
                                    recordLog4.setUserId(Long.valueOf(userId));
                                    recordLog4.setStatus(status);
                                    examineRecordLogList.add(recordLog4);
                                }
                            }
                            break;
                    }
                    break;
                case CONDITION:
                    ExamineRecordLog recordLog5 = BeanUtil.copyProperties(r,ExamineRecordLog.class);
                    recordLog5.setRecordId(examineRecord.getId());
                    recordLog5.setStatus(status);
                    examineRecordLogList.add(recordLog5);
                    break;
                case CC:
                    break;
                case TRANSFER:
                    break;
                case WITHIN_CONDITIONS:
                    break;
                default:
            }
        }

        //插入数据
        context.setExamineRecordLogList(examineRecordLogList);
        iExamineRecordLogService.saveBatch(examineRecordLogList);
    }



//
////    @LiteflowMethod(value = LiteFlowMethodEnum.IS_ACCESS, nodeId = "ta")
////    public void processAccess(NodeComponent bindCmp) {
////        ExamineContext context = bindCmp.getContextBean(ExamineContext.class);
////        List<ExamineRecordTask> examineRecordTaskList = context.getExamineRecordTaskList();
////
////    }
//    //普通组件的定义
//    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS, nodeId = "create")
//    public void examineCreate(NodeComponent bindCmp) {
//        ExamineContext context = bindCmp.getContextBean(ExamineContext.class);
//        List<ExamineTask> examineTaskList = context.getExamineTaskList();
//        List<ExamineCondition> examineConditionList = context.getExamineConditionList();
//        //业务数据
//        ExamineModel examineModel = context.getExamineModel();
//
//        //创建初始数据
//        ExamineTask examineTask = examineTaskList.get(0);
//        List<ExamineRecordTask> creatRecordTaskList = new ArrayList<>();
//        ExamineRecordTask recordTask = new ExamineRecordTask();
//        recordTask.setTaskType(TaskTypeEnum.CREATE.getType());
//        recordTask.setExamineType(ExamineTypeEnum.DEFAULT.getType());
//        recordTask.setUserId(examineModel.getCreateUserId());
//        recordTask.setStatus(CheckStatusEnum.CHECK_CREATE.getType());
//        creatRecordTaskList.add(recordTask);
//        //下一个
//        //审批类别 审批的任务类别 0 普通审批 1 条件审批 2抄送 3转他人处理 4条件内的审批5
//        switch (TaskTypeEnum.parse(examineTask.getTaskType())){
//            case GENERAL:
//                //审批人员  审批人类型 0 固定人员 1 固定人员上级 2角色 3发起人自选4
//                switch (ExamineTypeEnum.parse(examineTask.getExamineType())){
//                    case FIXED:
//                        String[] userIds1 = examineTask.getUserIds().split(",");
//                        for (String userId : userIds1) {
//                            ExamineRecordTask recordTask1 = new ExamineRecordTask();
//                            recordTask1.setTaskType(examineTask.getTaskType());
//                            recordTask1.setExamineType(examineTask.getExamineType());
//                            recordTask1.setUserId(Long.valueOf(userId));
//                            recordTask1.setStatus(CheckStatusEnum.CHECK_ING.getType());
//                            recordTask1.setExamineFlag(examineTask.getExamineFlag());
//                            creatRecordTaskList.add(recordTask1);
//                        }
//                        break;
//                    case FIXED_SUPER:
//                        //依据userId来获取该用户的上级
//                        String userId2 = "0";
//                        ExamineRecordTask recordTask2 = new ExamineRecordTask();
//                        recordTask2.setTaskType(examineTask.getTaskType());
//                        recordTask2.setExamineType(examineTask.getExamineType());
//                        recordTask2.setUserId(Long.valueOf(userId2));
//                        recordTask2.setStatus(CheckStatusEnum.CHECK_ING.getType());
//                        recordTask2.setExamineFlag(examineTask.getExamineFlag());
//                        creatRecordTaskList.add(recordTask2);
//                        break;
//                    case ROLE:
//                        //获取该role 对应用户
//                        String[] userIds3 = examineTask.getRoleIds().split(",");
//                        for (String userId : userIds3) {
//                            ExamineRecordTask recordTask1 = new ExamineRecordTask();
//                            recordTask1.setTaskType(examineTask.getTaskType());
//                            recordTask1.setExamineType(examineTask.getExamineType());
//                            recordTask1.setUserId(Long.valueOf(userId));
//                            recordTask1.setRoleId(Long.valueOf(userId));
//                            recordTask1.setStatus(CheckStatusEnum.CHECK_ING.getType());
//                            recordTask1.setExamineFlag(examineTask.getExamineFlag());
//                            creatRecordTaskList.add(recordTask1);
//                        }
//                        break;
//                    case CHOOSE:
////                        List<ExamineTask> fillExamineList = examineModel.getFillExamineList();
////                        List<ExamineTask> chooseList = fillExamineList.stream().filter(r -> r.getFillType().equals(1)).collect(Collectors.toList());
////                        String[] userIds4 = chooseList.get(0).getUserIds().split(",");
////                        for (String userId : userIds4) {
////                            ExamineRecordTask recordTask1 = new ExamineRecordTask();
////                            recordTask1.setTaskType(examineTask.getTaskType());
////                            recordTask1.setExamineType(examineTask.getExamineType());
////                            recordTask1.setUserId(Long.valueOf(userId));
////                            recordTask1.setStatus(CheckStatusEnum.CHECK_ING.getType());
////                            recordTask1.setExamineFlag(examineTask.getExamineFlag());
////                            creatRecordTaskList.add(recordTask1);
////                        }
//                        break;
//                }
//                break;
//            case CONDITION:
//
//                List<ExamineCondition> currentConditonList = examineConditionList.stream().filter(r -> r.getExamineTaskId().equals(examineTask.getId())).collect(Collectors.toList());
//
//                break;
//            case CC:
//                break;
//            case TRANSFER:
//                break;
//            case WITHIN_CONDITIONS:
//                break;
//            default:
//        }
//
//
//
//
//
//        //添加下一条数据
//
//
//        iExamineRecordTaskService.saveBatch(creatRecordTaskList);
//    }
//    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS, nodeId = "gen")
//    public void general(NodeComponent bindCmp) {
//        ExamineContext context = bindCmp.getContextBean(ExamineContext.class);
//        ExamineTask currentTask = context.getExamineTaskList().stream().filter(r -> r.getId().equals(context.getTaskId())).collect(Collectors.toList()).get(0);
//        //todo:chkeck 是否可以审批
//        switch (ExamineTypeEnum.parse(currentTask.getExamineType())){
//            case FIXED:
//                //审批通过  拒绝  做相关更新
//                updateStatusExamine(context.getExamineBefore());
//                break;
//            case FIXED_SUPER:
//                break;
//            case ROLE:
//                break;
//            case CHOOSE:
//                break;
//        }
//    }
//
//
//    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS, nodeId = "con")
//    public void condition(NodeComponent bindCmp) {
//        ExamineContext context = bindCmp.getContextBean(ExamineContext.class);
//
//    }
//    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS, nodeId = "cc")
//    public void cc(NodeComponent bindCmp) {
//        ExamineContext context = bindCmp.getContextBean(ExamineContext.class);
//
//    }
//    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS, nodeId = "win")
//    public void within(NodeComponent bindCmp) {
//        ExamineContext context = bindCmp.getContextBean(ExamineContext.class);
//
//    }
//    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS, nodeId = "tran")
//    public void transfer(NodeComponent bindCmp) {
//        ExamineContext context = bindCmp.getContextBean(ExamineContext.class);
//
//    }
//    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS, nodeId = "other")
//    public void other(NodeComponent bindCmp) {
//        ExamineContext context = bindCmp.getContextBean(ExamineContext.class);
//
//    }
//
//
//    //SWITCH组件的定义
//    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS_SWITCH, nodeId = "sw", nodeType = NodeTypeEnum.SWITCH)
//    public String processB(NodeComponent bindCmp) {
//        ExamineContext context = bindCmp.getContextBean(ExamineContext.class);
//        ExamineTask currentTask = context.getExamineTaskList().stream().filter(r -> r.getId().equals(context.getTaskId())).collect(Collectors.toList()).get(0);
//        String ret = "other";
//        switch (TaskTypeEnum.parse(currentTask.getTaskType())){
//            case CREATE:
//                ret = "create";
//                break;
//            case GENERAL:
//                ret = "gen";
//                break;
//            case CONDITION:
//                ret = "con";
//                break;
//            case CC:
//                ret = "cc";
//                break;
//            case TRANSFER:
//                ret = "tran";
//                break;
//            case WITHIN_CONDITIONS:
//                ret = "inc";
//                break;
//            default:
//                break;
//        }
//        return ret;
//    }
//
////    //IF组件的定义
////    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS_IF, nodeId = "ti", nodeType = NodeTypeEnum.IF)
////    public boolean processC(NodeComponent bindCmp) {
////        boolean ret = true;
////        return ret;
////    }
////
////    //FOR组件的定义
////    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS_FOR, nodeId = "tf", nodeType = NodeTypeEnum.FOR)
////    public int processD(NodeComponent bindCmp) {
////        int ret = 0;
////        return ret;
////    }
////
////    //WHILE组件的定义
////    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS_WHILE, nodeId = "tw", nodeType = NodeTypeEnum.WHILE)
////    public int processE(NodeComponent bindCmp) {
////        int ret = 0;
////        return ret;
////    }
////
////    //BREAK组件的定义
////    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS_BREAK, nodeId = "tb", nodeType = NodeTypeEnum.BREAK)
////    public int processF(NodeComponent bindCmp) {
////        int ret = 0;
////        return ret;
////    }




    private void updateStatusExamine(ExamineBefore examineBefore) {
    }
    private void updateConditionExamine(ExamineBefore examineBefore) {
    }

}
