package com.unique.admin.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 菜单权限配置表
 * </p>
 *
 * @author UNIQUE
 * @since 2023-03-25
 */
@Getter
@Setter
@TableName("un_admin_menu")
@ApiModel(value = "AdminMenu对象", description = "菜单权限配置表")
public class AdminMenuVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("菜单ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("上级菜单ID")
    private Integer parentId;

    @ApiModelProperty("parent_id 构建的深度")
    private String deepth;

    @ApiModelProperty("菜单名称")
    private String menuName;

    @ApiModelProperty("权限标识")
    private String realm;

    @ApiModelProperty("权限URL")
    private String realmUrl;

    @ApiModelProperty("所属模块")
    private String moduleType;

    @ApiModelProperty("菜单类型  1目录 2 菜单 3 按钮 4特殊")
    private Integer menuType;

    @ApiModelProperty("排序（同级有效）")
    private Integer sort;

    @ApiModelProperty("状态  0 禁用 1 启用")
    private Integer status;

    @ApiModelProperty("菜单说明")
    private String remarks;


}
