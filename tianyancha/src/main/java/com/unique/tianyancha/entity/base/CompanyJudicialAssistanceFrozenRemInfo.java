package com.kakarote.crm.entity.tianyancha;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class CompanyJudicialAssistanceFrozenRemInfo implements Serializable {
    @ApiModelProperty("执行法院")
    private String executiveCourt;
    @ApiModelProperty("执行事项")
    private String implementationMatters;
    @ApiModelProperty("执行裁定书文号")
    private String executeOrderNum;
    @ApiModelProperty("执行通知书文号")
    private String executeNoticeNum;
    @ApiModelProperty("被执行人")
    private String executedPerson;
    @ApiModelProperty("被执行人持有股权、其它投资权益的数额")
    private String equityAmountOther;
    @ApiModelProperty("被执行人证照种类")
    private String licenseType;
    @ApiModelProperty("被执行人证照号码")
    private String licenseNum;
    @ApiModelProperty("解除冻结日期")
    private String frozenRemoveDate;
    @ApiModelProperty("公示日期")
    private String publicityDate;
}
