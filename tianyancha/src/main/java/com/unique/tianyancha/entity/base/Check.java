package com.kakarote.crm.entity.tianyancha;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class Check implements Serializable {
    @ApiModelProperty("表id")
    private String id;
    @ApiModelProperty("检查实施机关")
    private String checkOrg;
    @ApiModelProperty("类型")
    private String checkType;
    @ApiModelProperty("日期")
    private String checkDate;
    @ApiModelProperty("结果")
    private String checkResult;
    @ApiModelProperty("备注")
    private String remark;
}
