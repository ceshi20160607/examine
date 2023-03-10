package com.unique.examine.common.utils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.Method;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unique.examine.common.enums.CheckStatusEnum;
import com.unique.examine.common.enums.ExamineTypeEnum;
import com.unique.examine.common.enums.TaskTypeEnum;
import com.unique.examine.common.liteflow.ExamineContext;
import com.unique.examine.entity.bo.ExamineBefore;
import com.unique.examine.entity.bo.ExamineModel;
import com.unique.examine.entity.bo.ExamineSearch;
import com.unique.examine.entity.po.Examine;
import com.unique.examine.entity.po.ExamineRecord;
import com.unique.examine.entity.po.ExamineRecordLog;
import com.unique.examine.entity.po.ExamineTemplate;
import com.unique.examine.service.IExamineRecordLogService;
import com.unique.examine.service.IExamineRecordService;
import com.unique.examine.service.IExamineRecordTaskService;
import com.yomahub.liteflow.annotation.LiteflowMethod;
import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.enums.LiteFlowMethodEnum;
import com.yomahub.liteflow.enums.NodeTypeEnum;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
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
    public static void generalProcess(ExamineContext context) {
        Boolean gFlag = Boolean.FALSE;
        ExamineBefore examineBefore = context.getExamineBefore();
        List<ExamineRecordLog> examineRecordLogList = context.getExamineRecordLogList();
        Long recordLogId = null;
        for (ExamineRecordLog r : examineRecordLogList) {
            if(!r.getTransferFlag().equals(0) && r.getStatus().equals(1)){
                if (r.getUserId().equals(examineBefore.getUserId())) {
                    gFlag = Boolean.TRUE;
                    recordLogId = r.getId();
                    r.setStatus(CheckStatusEnum.CHECK_PASS.getType());
                }
            }
            if(r.getTransferFlag().equals(1) && r.getTransferStatus().equals(1)){
                if (r.getTransferUserId().equals(examineBefore.getUserId())) {
                    gFlag = Boolean.TRUE;
                    recordLogId = r.getId();
                    r.setStatus(CheckStatusEnum.CHECK_PASS.getType());
                }
            }
        }
        if (gFlag) {
            for (ExamineRecordLog r : examineRecordLogList) {
                if (r.getId().equals(recordLogId)) {
                    r.setStatus(CheckStatusEnum.CHECK_PASS.getType());
                }else {
                    r.setStatus(CheckStatusEnum.CHECK_DISCARD.getType());
                }
            }
        }
    }

    public static void  conditionProcess(ExamineContext context) {
        Map<String, Object> entity = context.getExamineModel().getEntity();
        List<ExamineRecordLog> examineRecordLogList = context.getExamineRecordLogList().stream().filter(r->r.getStatus().equals(CheckStatusEnum.CHECK_ING.getType())).collect(Collectors.toList());
        Boolean itemRet = Boolean.TRUE;
        for (ExamineRecordLog r : examineRecordLogList) {
            if (!itemRet) {
                r.setStatus(CheckStatusEnum.CHECK_DISCARD.getType());
            }
            List<ExamineSearch> examineSearcheList = JSON.parseArray(r.getConditionModuleSearch(), ExamineSearch.class);
            for (ExamineSearch search : examineSearcheList) {
                itemRet = itemRet && SearchFieldUtil.searchConditionValue(search, entity);
            }
            if (itemRet) {
                r.setStatus(CheckStatusEnum.CHECK_PASS.getType());
            }
        }
    }

    /**
     * ???????????????  ???????????????
     * @author UNIQUE
     * @date 2023/3/14
     */
    public static void createProcess(ExamineContext context) {
        //????????????
        ExamineModel examineModel = context.getExamineModel();
        Examine examine = context.getExamine();
        //??????????????????
        ExamineRecord examineRecord = BeanUtil.copyProperties(examine, ExamineRecord.class);
        examineRecord.setCreateUserId(examineModel.getCreateUserId());
        examineRecord.setCreateTime(LocalDateTime.now());
        examineRecord.setUpdateTime(LocalDateTime.now());
        context.setExamineRecord(examineRecord);

        List<ExamineTemplate> examineTaskList = context.getExamineTemplateList();
        List<ExamineTemplate> fillTemplateList = context.getFillTemplateList();
        //??????????????????
        Map<Long, List<ExamineTemplate>> fillTemplateGroup = new HashMap<>();
        if (CollectionUtil.isNotEmpty(fillTemplateList)) {
            fillTemplateGroup = fillTemplateList.stream().collect(Collectors.groupingBy(r -> r.getId()));
        }

        //??????????????????
        List<ExamineRecordLog> examineRecordLogList = new ArrayList<>();
        ExamineRecordLog recordLog = new ExamineRecordLog();
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
                    //????????????  ??????????????? 0 ???????????? 1 ?????????????????? 2?????? 3???????????????4
                    switch (ExamineTypeEnum.parse(r.getExamineType())) {
                        case FIXED:
                            String[] userIds1 = r.getUserIds().split(",");
                            for (String userId : userIds1) {
                                ExamineRecordLog recordLog1 = BeanUtil.copyProperties(r,ExamineRecordLog.class);
                                recordLog1.setUserId(Long.valueOf(userId));
                                examineRecordLogList.add(recordLog1);
                            }
                            break;
                        case FIXED_SUPER:
                            //??????userId???????????????????????????
                            List<Long> upUserList = new ArrayList<>();
                            for (Long userId : upUserList) {
                                ExamineRecordLog recordLog2 = BeanUtil.copyProperties(r,ExamineRecordLog.class);
                                recordLog2.setUserId(userId);
                                recordLog2.setStatus(status);
                                examineRecordLogList.add(recordLog2);
                            }
                            break;
                        case ROLE:
                            //?????????role ????????????
                            String[] roleIds3 = r.getRoleIds().split(",");
                            for (String roleId : roleIds3) {
                                ExamineRecordLog recordLog3 = BeanUtil.copyProperties(r,ExamineRecordLog.class);
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
        //????????????
        context.setExamineRecordLogList(examineRecordLogList);
    }

    public static void examineProcess (ExamineContext context){
        List<ExamineRecordLog> examineRecordLogList = context.getExamineRecordLogList().stream().filter(r->r.getStatus().equals(CheckStatusEnum.CHECK_ING.getType())).collect(Collectors.toList());
        switch (TaskTypeEnum.parse(examineRecordLogList.get(0).getTaskType())){
            case GENERAL:
                generalProcess(context);
                break;
            case CONDITION:
                conditionProcess(context);
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
