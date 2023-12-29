package com.kakarote.crm.entity.tianyancha;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class Change implements Serializable {
    @ApiModelProperty("变更事项")
    private String changeItem;
    @ApiModelProperty("变更前")
    private String contentBefore;
    @ApiModelProperty("变更后")
    private String contentAfter;
    @ApiModelProperty("变更日期")
    private String changeTime;
}
