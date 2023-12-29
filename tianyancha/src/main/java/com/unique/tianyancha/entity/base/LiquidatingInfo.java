package com.kakarote.crm.entity.tianyancha;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class LiquidatingInfo implements Serializable {
    @ApiModelProperty("表id")
    private String id;
    @ApiModelProperty("清算组负责人")
    private String manager;
    @ApiModelProperty("清算成员名称")
    private String member;
}
