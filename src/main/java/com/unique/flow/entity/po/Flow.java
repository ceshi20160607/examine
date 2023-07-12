package com.unique.flow.entity.po;

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
 * 流程表
 * </p>
 *
 * @author UNIQUE
 * @since 2023-07-12
 */
@Getter
@Setter
@TableName("un_flow")
@ApiModel(value = "Flow对象", description = "流程表")
public class Flow implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("流程ID")
    private Long id;

    @ApiModelProperty("0 默认基础 1默认修改使用中 2自定义")
    private Integer type;

    @ApiModelProperty("图标")
    private String icon;

    @ApiModelProperty("流程名称")
    private String name;

    @ApiModelProperty("流程的排序")
    private Integer sortNum;

    @ApiModelProperty("父级id")
    private Long parentId;

    @ApiModelProperty("列的深度")
    private String depthDepth;

    @ApiModelProperty("所属分组")
    private Long groupId;

    @ApiModelProperty("关联的类型")
    private Long moduleType;

    @ApiModelProperty("1 正常 2 停用 3 删除 ")
    private Integer status;

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
