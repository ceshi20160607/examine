package com.unique.field.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 自定义字段关联角色表
 * </p>
 *
 * @author UNIQUE
 * @since 2023-08-28
 */
@Getter
@Setter
@TableName("un_field_auth")
@ApiModel(value = "FieldAuth对象", description = "自定义字段关联角色表")
public class FieldAuth implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("字段ID")
    private Long fieldId;

    @ApiModelProperty("角色id")
    private Long roleId;

    @ApiModelProperty("授权类型   0不能查看   1只能看 2可以编辑")
    private Integer authType;

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
