package com.kakarote.crm.entity.tianyancha;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class License implements Serializable {
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("许可证名称")
    private String licencename;
    @ApiModelProperty("许可书文编号")
    private String licencenumber;
    @ApiModelProperty("来源")
    private String source;
    @ApiModelProperty("范围")
    private String scope;
    @ApiModelProperty("起始日期")
    private String fromdate;
    @ApiModelProperty("截止日期")
    private String todate;
    @ApiModelProperty("发证机关")
    private String department;
}
