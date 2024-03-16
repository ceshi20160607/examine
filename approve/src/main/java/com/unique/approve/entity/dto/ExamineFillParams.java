package com.unique.approve.entity.dto;

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
public class ExamineFillParams implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("nodeId")
    private Long nodeId;

    @ApiModelProperty("选择的审批人")
    private Long userId;


}
