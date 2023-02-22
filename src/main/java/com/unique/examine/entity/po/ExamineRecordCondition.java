package com.unique.examine.entity.po;

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
 * 审批条件表
 * </p>
 *
 * @author UNIQUE
 * @since 2023-02-15
 */
@Getter
@Setter
@TableName("un_examine_record_condition")
@ApiModel(value = "ExamineRecordCondition对象", description = "审批条件表")
public class ExamineRecordCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("关联taskid")
    private Long taskId;

    @ApiModelProperty("条件父关联 默认0")
    private Long parentId;

    @ApiModelProperty("条件内关联的深度 有序")
    private String deepIds;

    @ApiModelProperty("条件的名称")
    private String name;

    @ApiModelProperty("1 合同 2 回款 3发票")
    private Long moduleType;

    @ApiModelProperty("字段名称")
    private String moduleFieldName;

    @ApiModelProperty("比较条件符号")
    private Integer moduleFieldSearch;

    @ApiModelProperty("字段值")
    private String moduleFieldValue;

    @ApiModelProperty("条件内 关联的审批")
    private Long examineTaskId;

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
