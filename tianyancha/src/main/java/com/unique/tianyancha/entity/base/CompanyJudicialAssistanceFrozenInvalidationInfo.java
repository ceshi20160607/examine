package com.kakarote.crm.entity.tianyancha;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class CompanyJudicialAssistanceFrozenInvalidationInfo implements Serializable {
    @ApiModelProperty("失效原因")
    private String invalidationReason;
    @ApiModelProperty("失效日期")
    private String invalidationDate;
}
