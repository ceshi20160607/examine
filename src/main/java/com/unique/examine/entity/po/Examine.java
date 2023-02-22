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
 * 审批表
 * </p>
 *
 * @author UNIQUE
 * @since 2023-02-15
 */
@Getter
@Setter
@TableName("un_examine")
@ApiModel(value = "Examine对象", description = "审批表")
public class Examine implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("审批ID")
    private Long id;

    @ApiModelProperty("1 合同 2 回款 3发票   101 普通审批 102 请假审批 103 出差审批 104 加班审批 105 差旅报销 106 借款申请")
    private Long moduleType;

    @ApiModelProperty("0 默认基础 1默认修改使用中 2自定义")
    private Integer type;

    @ApiModelProperty("图标")
    private String icon;

    @ApiModelProperty("审批名称")
    private String name;

    @ApiModelProperty("审批的排序")
    private Integer sortNum;

    @ApiModelProperty("所属分组")
    private Long groupId;

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
