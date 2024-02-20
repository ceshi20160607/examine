package com.unique.approve.utils;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.unique.approve.entity.po.*;
import com.unique.approve.enums.TransferFlagEnum;
import com.unique.core.common.bo.SendEmailBO;
import com.unique.core.common.utils.EmailUtil;
import com.unique.core.common.utils.SearchFieldUtil;
import com.unique.approve.enums.CheckStatusEnum;
import com.unique.approve.enums.ExamineTypeEnum;
import com.unique.approve.enums.ExamineNodeTypeEnum;
import com.unique.approve.entity.dto.ExamineBefore;
import com.unique.approve.entity.dto.ExamineContext;
import com.unique.approve.entity.dto.ExamineOtherParams;
import com.unique.approve.entity.dto.ExamineSearch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author UNIQUE
 * @create 2023-03-07
 * @verson 1.0.0
 */
@Slf4j
@Component
public class ExamineUtil {
    /** 基础审批节点创建
     * @param r
     * @param status
     * @param examineRecordNodeList
     */
    private static void examineBaseProcessCreate(ExamineNode r, Integer status, List<ExamineRecordNode> examineRecordNodeList) {
        List<ExamineNodeUser> nodeUserList = r.getNodeUserList();
        //审批人员  审批人类型 0 固定人员 1 固定人员上级 2角色 3发起人自选4
        ExamineTypeEnum examineTypeEnum = ExamineTypeEnum.parse(r.getExamineType());
        for (ExamineNodeUser t : nodeUserList) {
            ExamineRecordNode recordLog1 = BeanUtil.copyProperties(r,ExamineRecordNode.class);
            switch (examineTypeEnum){
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
                    recordLog1.setUserId(t.getUserId());
                    break;
            }
            recordLog1.setStatus(status);
            examineRecordNodeList.add(recordLog1);
        }
    }

    /**
     * 创建初始化  （只一次）
     * @author UNIQUE
     * @date 2023/3/14
     */
    public static void createProcess(ExamineContext context) {
        //业务数据
        ExamineOtherParams examineOtherParams = context.getExamineOtherParams();
        Examine examine = context.getExamine();
        //创建具体审批
        ExamineRecord examineRecord = BeanUtil.copyProperties(examine, ExamineRecord.class);
        examineRecord.setCreateUserId(examineOtherParams.getCreateUserId());
        examineRecord.setCreateTime(LocalDateTime.now());
        examineRecord.setUpdateTime(LocalDateTime.now());
        context.setExamineRecord(examineRecord);

        List<ExamineNode> examineTaskList = context.getExamineNodeList();

        //创建初始数据
        List<ExamineRecordNode> examineRecordNodeList = new ArrayList<>();
        ExamineRecordNode recordLog = new ExamineRecordNode();
        recordLog.setNodeType(ExamineNodeTypeEnum.CREATE.getType());
        recordLog.setExamineType(ExamineTypeEnum.DEFAULT.getType());
        recordLog.setUserId(examineOtherParams.getCreateUserId());
        recordLog.setStatus(CheckStatusEnum.CHECK_PASS.getType());
        examineRecordNodeList.add(recordLog);
        for (int i = 0; i < examineTaskList.size(); i++) {
            ExamineNode r = examineTaskList.get(i);
            Integer status = CheckStatusEnum.CHECK_CREATE.getType();
            if (i==0) {
                status = CheckStatusEnum.CHECK_ING.getType();
            }
            switch (ExamineNodeTypeEnum.parse(r.getNodeType())) {
                case GENERAL:
                    examineBaseProcessCreate(r,status, examineRecordNodeList);
                    break;
                case CONDITION:
                    ExamineRecordNode recordLog5 = BeanUtil.copyProperties(r,ExamineRecordNode.class);
                    recordLog5.setStatus(status);
                    examineRecordNodeList.add(recordLog5);
                    break;
                case CC:
                    ExamineRecordNode recordLog6 = BeanUtil.copyProperties(r,ExamineRecordNode.class);
                    recordLog6.setStatus(status);
                    examineRecordNodeList.add(recordLog6);
                    break;
                case TRANSFER:
                    ExamineRecordNode recordLog7 = BeanUtil.copyProperties(r,ExamineRecordNode.class);
                    recordLog7.setStatus(status);
                    examineRecordNodeList.add(recordLog7);
                    break;
                default:
            }
        }
        //插入数据
        context.setExamineRecordNodeList(examineRecordNodeList);
    }



    /**审批--执行
     * @param context
     */
    public static void examineProcess (ExamineContext context){
        List<ExamineRecordNode> ExamineRecordNodeList = context.getExamineRecordNodeList().stream().filter(r->r.getStatus().equals(CheckStatusEnum.CHECK_ING.getType())).collect(Collectors.toList());
        switch (ExamineNodeTypeEnum.parse(ExamineRecordNodeList.get(0).getNodeType())){
            case GENERAL:
                generalProcess(context);
                break;
            case CONDITION:
                conditionProcess(context);
                break;
            case CC:
                String[] split = ExamineRecordNodeList.get(0).getCopyEmails().split(",");
                SendEmailBO sendEmailBO = new SendEmailBO();
                sendEmailBO.setEmails(split);
                EmailUtil.sendEmailProcess(sendEmailBO);
                break;
            case TRANSFER:
                generalProcess(context);
                break;
            default:
                break;
        }
    }

    /**基础审批--执行
     * @param context
     */
    public static void generalProcess(ExamineContext context) {
        Boolean gFlag = Boolean.FALSE;
        ExamineBefore examineBefore = context.getExamineBefore();
        List<ExamineRecordNode> ExamineRecordNodeList = context.getExamineRecordNodeList();
        Long recordLogId = null;
        for (ExamineRecordNode r : ExamineRecordNodeList) {
            CheckStatusEnum checkStatusEnum = CheckStatusEnum.parse(r.getStatus());
            TransferFlagEnum transferFlagEnum = TransferFlagEnum.parse(r.getTransferFlag());
            if (CheckStatusEnum.CHECK_ING.equals(checkStatusEnum)) {
                if(!TransferFlagEnum.DEFAULT.equals(transferFlagEnum)){
                    if (r.getUserId().equals(examineBefore.getUserId())) {
                        gFlag = Boolean.TRUE;
                        recordLogId = r.getId();
                        r.setStatus(CheckStatusEnum.CHECK_PASS.getType());
                    }
                }
                if(TransferFlagEnum.TRANSFER.equals(transferFlagEnum)){
                    if (r.getTransferUserId().equals(examineBefore.getUserId())) {
                        gFlag = Boolean.TRUE;
                        recordLogId = r.getId();
                        r.setStatus(CheckStatusEnum.CHECK_PASS.getType());
                    }
                }
            }
        }
        if (gFlag) {
            for (ExamineRecordNode r : ExamineRecordNodeList) {
                if (r.getId().equals(recordLogId)) {
                    r.setStatus(CheckStatusEnum.CHECK_PASS.getType());
                }else {
                    r.setStatus(CheckStatusEnum.CHECK_DISCARD.getType());
                }
            }
        }
    }

    /**条件审批--执行
     * @param context
     */
    public static void  conditionProcess(ExamineContext context) {
        Map<String, Object> entity = context.getExamineOtherParams().getEntity();
        List<ExamineRecordNode> ExamineRecordNodeList = context.getExamineRecordNodeList().stream().filter(r->r.getStatus().equals(CheckStatusEnum.CHECK_ING.getType())).collect(Collectors.toList());
        Boolean itemRet = Boolean.TRUE;
        for (ExamineRecordNode r : ExamineRecordNodeList) {
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
    }

}
