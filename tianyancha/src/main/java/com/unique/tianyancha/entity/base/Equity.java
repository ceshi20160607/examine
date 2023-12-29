package com.kakarote.crm.entity.tianyancha;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class Equity implements Serializable {
    @ApiModelProperty("表id")
    private String id;
    @ApiModelProperty("登记编号")
    private String regNumber;
    @ApiModelProperty("出质股权标的企业")
    private String targetCompany;
    @ApiModelProperty("出质人")
    private String pledgor;
    @ApiModelProperty("出质人证照/证件号码")
    private String certifNumber;
    @ApiModelProperty("出质股权数额")
    private String equityAmount;
    @ApiModelProperty("质权人")
    private String pledgee;
    @ApiModelProperty("质权人证照/证件号码")
    private String certifNumberR;
    @ApiModelProperty("股权出质设立登记日期")
    private String regDate;
    @ApiModelProperty("状态")
    private String state;
    @ApiModelProperty("股权出质设立发布日期")
    private String putDate;
    @ApiModelProperty("注销日期")
    private String cancelDate;
    @ApiModelProperty("注销原因")
    private String cancelReason;
}
