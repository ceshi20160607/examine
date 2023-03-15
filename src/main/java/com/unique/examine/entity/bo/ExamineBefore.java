package com.unique.examine.entity.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author UNIQUE
 * @create 2023-03-10
 * @verson 1.0.0
 */
@Data
public class ExamineBefore implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 具体审批
     */
    private Long examineRecordId ;

    /**
     * 审批人
     */
    private Long userId ;

    /**
     * 审批状态 通过 拒绝 撤回 作废
     */
    private Integer status ;

    /**
     * 具体审批-备注信息
     */
    private String remark;
}
