package com.unique.approve.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author UNIQUE
 * @create 2023-03-10
 * @verson 1.0.0
 */
@Data
public class ExamineNodeFill implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 具体审批
     */
    private Long nodeId ;

    /**
     * 审批人
     */
    private Long userId ;

    /**
     * 审批邮箱
     */
    private String email ;
}
