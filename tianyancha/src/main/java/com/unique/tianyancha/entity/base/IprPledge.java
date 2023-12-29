package com.kakarote.crm.entity.tianyancha;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data
public class IprPledge implements Serializable {
    @ApiModelProperty("表id")
    private String id;
    @ApiModelProperty("知识产权登记证号")
    private String iprCertificateNum;
    @ApiModelProperty("名称")
    private String iprName;
    @ApiModelProperty("种类")
    private String iprType;
    @ApiModelProperty("出质人")
    private String pledgorName;
    @ApiModelProperty("质权人名称")
    private String pledgeeName;
    @ApiModelProperty("质权登记期限")
    private String pledgeRegPeriod;
    @ApiModelProperty("状态")
    private String state;
    @ApiModelProperty("公示日期")
    private String publicityDate;
    @ApiModelProperty("注销日期")
    private String cancleDate;
    @ApiModelProperty("注销原因")
    private String cancleReason;
    @ApiModelProperty("变更记录")
    private List<Change> changeList;
}
