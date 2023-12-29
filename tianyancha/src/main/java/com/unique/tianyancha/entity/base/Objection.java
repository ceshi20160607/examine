package com.kakarote.crm.entity.tianyancha;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class Objection implements Serializable {
    @ApiModelProperty("异议申请人")
    private String objection_apply_person;
    @ApiModelProperty("异议内容")
    private String objection_content;
    @ApiModelProperty("异议时间")
    private String objection_date;
}
