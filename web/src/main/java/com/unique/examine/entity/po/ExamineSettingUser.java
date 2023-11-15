package com.unique.examine.entity.po;

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
 * 审批适用用户部门表
 * </p>
 *
 * @author UNIQUE
 * @since 2023-03-15
 */
@Getter
@Setter
@TableName("un_examine_setting_user")
@ApiModel(value = "ExamineSettingUser对象", description = "审批适用用户部门表")
public class ExamineSettingUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("审批id")
    private Long examineId;

    @ApiModelProperty("适用类型 0用户 1部门")
    private Integer applyType;

    @ApiModelProperty("适用用户id")
    private Long userId;

    @ApiModelProperty("适用部门id")
    private Long deptId;

    @ApiModelProperty("创建人")
    @TableField(fill = FieldFill.INSERT)
    private Long createUserId;

    @ApiModelProperty("更新人")
    @TableField(fill = FieldFill.UPDATE)
    private Long updateUserId;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("企业id")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long companyId;


}
