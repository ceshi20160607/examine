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
 * 审批高级设置及异常处理规则
 * </p>
 *
 * @author UNIQUE
 * @since 2023-02-15
 */
@Getter
@Setter
@TableName("un_examine_setting")
@ApiModel(value = "ExamineSetting对象", description = "审批高级设置及异常处理规则")
public class ExamineSetting implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("审批id")
    private Long examineId;

    @ApiModelProperty("0撤回规则 1通过规则 ")
    private Integer ruleType;

    @ApiModelProperty("撤回之后重新审核操作 1 从第一层开始 2 从拒绝的层级开始")
    private Integer recheckType;

    @ApiModelProperty("通过规则类型 1 超时自动通过 2 转他人处理")
    private Integer passType;

    @ApiModelProperty("通过规则类型 1 该审批人一个同意该人全部同意 2 该相同审批人同意 3该审批人依次审批")
    private Integer passRule;

    @ApiModelProperty("现时配置是否开启  0默认不开启  1开启 设置超时通过必须设置现时")
    private Integer limitTimeType;

    @ApiModelProperty("现时时间")
    private Integer limitTimeNum;

    @ApiModelProperty("现时时间单位")
    private Integer limitTimeUnit;

    @ApiModelProperty("适用类型 0默认全公司 1用户 2部门")
    private Integer applyType;

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
