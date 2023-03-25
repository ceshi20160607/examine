package com.unique.admin.entity.po;

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
 * 部门表
 * </p>
 *
 * @author UNIQUE
 * @since 2023-03-25
 */
@Getter
@Setter
@TableName("un_admin_dept")
@ApiModel(value = "AdminDept对象", description = "部门表")
public class AdminDept implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("默认0 部门  1公司")
    private Integer companyFlag;

    @ApiModelProperty("父级ID 顶级部门为0")
    private Long parentId;

    @ApiModelProperty("parent_id 构建的深度")
    private String deepth;

    @ApiModelProperty("部门名称")
    private String name;

    @ApiModelProperty("排序 越大越靠后")
    private Integer num;

    @ApiModelProperty("部门备注")
    private String remark;

    @ApiModelProperty("部门负责人")
    private Long ownerUserId;

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
