package com.kakarote.crm.entity.tianyancha;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@NoArgsConstructor
@Data
public class Staff implements Serializable {
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("主要人员名称")
    private String name;
    @ApiModelProperty("logo")
    private String logo;
    @ApiModelProperty("主要人员类型 1-公司 2-人")
    private String type;
    @ApiModelProperty("主要人员职位")
    private String staffTypeName;
    @ApiModelProperty("职位")
    private List<String> typeJoin;
}
