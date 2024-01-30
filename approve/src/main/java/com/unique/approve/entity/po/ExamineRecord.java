package com.unique.approve.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 审核记录表
 * </p>
 *
 * @author UNIQUE
 * @since 2024-01-30
 */
@Getter
@Setter
@TableName("un_examine_record")
@ApiModel(value = "ExamineRecord对象", description = "审核记录表")
public class ExamineRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("审核记录ID")
    private Long id;

    @ApiModelProperty("审核ID")
    private Long examineId;

    @ApiModelProperty("模块id 关联模块--可以是业务，也可以是特殊的模块，比如oa")
    private Long moduleId;

    @ApiModelProperty("关联业务主键ID")
    private Long relationId;

    @ApiModelProperty("记录状态 0 正常 1 终止 2 暂停  3 作废")
    private Integer status;

    @ApiModelProperty("审核状态 0 未审核 1 审核通过 2 审核拒绝 3 审核中 4 已撤回 6创建")
    private Integer examineStatus;

    @ApiModelProperty("备注")
    private String remarks;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("创建人")
    @TableField(fill = FieldFill.INSERT)
    private Long createUserId;

    @ApiModelProperty("修改时间")
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("修改人")
    @TableField(fill = FieldFill.UPDATE)
    private Long updateUserId;

    @ApiModelProperty("企业id")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long companyId;


}
