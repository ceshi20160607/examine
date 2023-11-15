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
 * 自定义字段表
 * </p>
 *
 * @author UNIQUE
 * @since 2023-08-28
 */
@Getter
@Setter
@TableName("un_field")
@ApiModel(value = "Field对象", description = "自定义字段表")
public class Field implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("1 合同 2 回款 3发票")
    private Long moduleType;

    @ApiModelProperty("自定义字段英文标识")
    private String fieldName;

    @ApiModelProperty("字段名称")
    private String name;

    @ApiModelProperty("字段类型 1 单行文本 2 多行文本 3 单选 4日期 5 数字 6 小数 7 手机  8 文件 9 多选 10 人员 11 附件 12 部门 13 日期时间 14 邮箱 15客户 16 商机 17 联系人 18 地图 19 产品类型 20 合同 21 回款计划")
    private Integer type;

    @ApiModelProperty("字段说明")
    private String remark;

    @ApiModelProperty("输入提示")
    private String inputTips;

    @ApiModelProperty("最大长度")
    private Integer maxLength;

    @ApiModelProperty("默认值")
    private String defaultValue;

    @ApiModelProperty("是否唯一 1 是 0 否")
    private Integer uniqueFlag;

    @ApiModelProperty("是否必填 1 是 0 否")
    private Integer nullFlag;

    @ApiModelProperty("是否隐藏  0不隐藏 1隐藏")
    private Integer hiddenFlag;

    @ApiModelProperty("排序 从小到大")
    private Integer sorting;

    @ApiModelProperty("如果类型是选项，此处不能为空，多个选项以，隔开")
    private String options;

    @ApiModelProperty("字段来源  0.自定义 1.原始固定 2原始字段但值存在扩展表中")
    private Integer fieldType;

    @ApiModelProperty("只有线索需要，转换客户的自定义字段ID")
    private Integer relevant;

    @ApiModelProperty("样式百分比%")
    private Integer stylePercent;

    @ApiModelProperty("精度，允许的最大小数位")
    private Integer precisions;

    @ApiModelProperty("限制的最大数值")
    private String maxNumRestrict;

    @ApiModelProperty("限制的最小数值")
    private String minNumRestrict;

    @ApiModelProperty("是否列表显示 1 是 0 否")
    private Integer indexFlag;

    @ApiModelProperty("是否新建显示 1 是 0 否")
    private Integer addFlag;

    @ApiModelProperty("是否详情显示 1 是 0 否")
    private Integer detailFlag;

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
