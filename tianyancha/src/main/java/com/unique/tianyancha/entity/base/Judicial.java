package com.kakarote.crm.entity.tianyancha;

import com.kakarote.crm.entity.VO.CrmEnterpriseCbIcVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class Judicial implements Serializable {
    @ApiModelProperty("表id")
    private String assId;
    @ApiModelProperty("被执行人")
    private String executedPerson;
    @ApiModelProperty("股权数额")
    private String equityAmount;
    @ApiModelProperty("执行通知书文号")
    private String executeNoticeNum;
    @ApiModelProperty("执行法院")
    private String executiveCourt;
    @ApiModelProperty("类型|状态")
    private String typeState;
    @ApiModelProperty("股权变更")
    private CompanyJudicialShareholderChangeInfo companyJudicialShareholderChangeInfo;
    @ApiModelProperty("冻结")
    private CompanyJudicialAssistanceFrozenRemInfo companyJudicialAssistanceFrozenInfo;
    @ApiModelProperty("冻结失效")
    private CompanyJudicialAssistanceFrozenInvalidationInfo companyJudicialAssistanceFrozenInvalidationInfo;
    @ApiModelProperty("冻结续行")
    private CompanyJudicialAssistanceFrozenKeepInfo companyJudicialAssistanceFrozenKeepInfo;
    @ApiModelProperty("解除冻结")
    private CompanyJudicialAssistanceFrozenRemInfo companyJudicialAssistanceFrozenRemInfo;

}
