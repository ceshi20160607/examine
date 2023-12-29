package com.kakarote.crm.entity.tianyancha;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class Illegal implements Serializable {
    @ApiModelProperty("表id")
    private String id;
    @ApiModelProperty("列入原因")
    private String putReason;
    @ApiModelProperty("列入时间")
    private String putDate;
    @ApiModelProperty("决定列入机关")
    private String putDepartment;
    @ApiModelProperty("移出原因")
    private String removeReason;
    @ApiModelProperty("移出时间")
    private String removeDate;
    @ApiModelProperty("移出机关")
    private String removeDepartment;
}
