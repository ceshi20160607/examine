package com.kakarote.crm.entity.tianyancha;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class Punish implements Serializable {
    @ApiModelProperty("表id")
    private String id;
    @ApiModelProperty("省份简称（无用)")
    private String base;
    @ApiModelProperty("行政处罚决定书文号")
    private String punishNumber;
    @ApiModelProperty("公司名称")
    private String name;
    @ApiModelProperty("注册号")
    private String regNumber;
    @ApiModelProperty("法定代表人（负责人）姓名")
    private String legalPersonName;
    @ApiModelProperty("违法行为类型")
    private String type;
    @ApiModelProperty("行政处罚内容")
    private String content;
    @ApiModelProperty("作出行政处罚决定机关名称")
    private String departmentName;
    @ApiModelProperty("作出行政处罚决定日期")
    private String decisionDate;
    @ApiModelProperty("无用")
    private String publishDate;
    @ApiModelProperty("无用")
    private String description;
    @ApiModelProperty("来源名称")
    private String sourceName;
}
