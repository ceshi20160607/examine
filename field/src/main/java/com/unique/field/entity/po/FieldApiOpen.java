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
 * 第三方接口 字段对照表
 * </p>
 *
 * @author UNIQUE
 * @since 2023-11-23
 */
@Getter
@Setter
@TableName("un_field_api_open")
@ApiModel(value = "FieldApiOpen对象", description = "第三方接口 字段对照表")
public class FieldApiOpen implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("模块 ENUM中类型")
    private Integer moduleType;

    @ApiModelProperty("字段ID")
    private Long fieldId;

    @ApiModelProperty("父字段ID 目前适配逻辑表单")
    private Long parentFieldId;

    @ApiModelProperty("自定义字段英文标识")
    private String fieldName;

    @ApiModelProperty("字段名称")
    private String name;

    @ApiModelProperty("字段类型 1 单行文本 2 多行文本 3 单选 4日期 5 数字 6 小数 7 手机  8 文件 9 多选 10 人员 11 附件 12 部门 13 日期时间 14 邮箱 15客户 16 商机 17 联系人 18 地图 19 产品类型 20 合同 21 回款计划")
    private Integer type;

    @ApiModelProperty("第三方类型 0ttc 1erp 2广告")
    private Integer apiType;

    @ApiModelProperty("自定义字段数组的名称")
    private String apiFieldGroup;

    @ApiModelProperty("自定义字段英文标识")
    private String apiFieldName;

    @ApiModelProperty("备注")
    private String apiRemark;

    @ApiModelProperty("创建人ID")
    @TableField(fill = FieldFill.INSERT)
    private Long createUserId;

    @ApiModelProperty("负责人ID")
    private Long ownerUserId;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;


}
