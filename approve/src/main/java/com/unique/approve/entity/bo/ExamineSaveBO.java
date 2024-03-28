package com.unique.approve.entity.bo;

import com.unique.approve.entity.po.Examine;
import com.unique.approve.entity.po.ExamineNode;
import com.unique.approve.entity.po.ExamineSetting;
import com.unique.approve.entity.po.ExamineSettingUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("审批保存BO")
public class ExamineSaveBO {

    @ApiModelProperty(value = "审批")
    private Examine examine;
    @ApiModelProperty(value = "审批")
    private ExamineSetting examineSetting;
    @ApiModelProperty(value = "审批")
    private List<ExamineSettingUser> examineSettingUser;

    @ApiModelProperty(value = "审批节点")
    private List<ExamineNodeBO> examineNodeList;

}
