package com.unique.admin.entity.vo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author UNIQUE
 * @since 2023-03-25
 */
@Getter
@Setter
@TableName("un_admin_role")
@ApiModel(value = "AdminRole对象", description = "角色表")
public class AdminRoleVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("名称")
    private String roleName;

    @ApiModelProperty("0 超管 1自定义 ")
    private Integer roleType;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty(" 0 禁用 1 启用")
    private Integer status;

    @ApiModelProperty("数据权限 0默认全部 1本人，2本人及下属 3本部门 4本部门及下属部门 ")
    private Integer dataType;

    @ApiModelProperty("0 隐藏 1 不隐藏")
    private Integer hidden;

    @ApiModelProperty("0默认系统级别  1 审批级别")
    private Integer moduleType;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("创建人ID")
    @TableField(fill = FieldFill.INSERT)
    private Long createUserId;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("修改人ID")
    @TableField(fill = FieldFill.UPDATE)
    private Long updateUserId;


}
