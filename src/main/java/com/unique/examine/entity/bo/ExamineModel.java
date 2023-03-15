package com.unique.examine.entity.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author UNIQUE
 * @create 2023-03-10
 * @verson 1.0.0
 */
@Data
public class ExamineModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("其他参数")
    private Map<String,Object> entity;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("创建人")
    private Long createUserId;

    @ApiModelProperty("修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("修改人")
    private Long updateUserId;

    @ApiModelProperty("企业id")
    private Long companyId;
}
