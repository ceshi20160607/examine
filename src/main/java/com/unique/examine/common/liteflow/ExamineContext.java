package com.unique.examine.common.liteflow;

import com.unique.examine.entity.bo.ExamineBefore;
import com.unique.examine.entity.bo.ExamineModel;
import com.unique.examine.entity.po.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ExamineContext implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 审批基础信息
     */
    private Examine examine;
    private List<ExamineTemplate> examineTemplateList;

    //-------------------------
    /**
     * 具体审批
     */
    private ExamineRecord examineRecord ;
    /**
     * 具体审批-审批日志
     */
    private List<ExamineRecordLog> examineRecordLogList;



    /**
     * 审批基础信息
     */
    private ExamineSetting examineSetting;
    /**
     * 审批基础信息
     */
    private ExamineSettingUser examineSettingUser;


    //-------------------------审批参数------------------------------
    private List<ExamineTemplate> fillTemplateList;

    /**
     * 审批业务数据
     */
    private ExamineModel examineModel ;

    /**
     * 审批入参
     */
    private ExamineBefore examineBefore;

}
