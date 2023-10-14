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
 * 流程记录表
 * </p>
 *
 * @author UNIQUE
 * @since 2023-10-07
 */
@Getter
@Setter
@TableName("un_flow_record_log")
@ApiModel(value = "FlowRecordLog对象", description = "流程记录表")
public class FlowRecordLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("流程记录ID")
    private Long id;

    @ApiModelProperty("流程ID")
    private Long flowId;

    @ApiModelProperty("1 合同 2 回款 3发票")
    private Long moduleType;

    @ApiModelProperty("关联业务主键ID")
    private Long relationId;

    @ApiModelProperty("关联审批主键ID")
    private Long examineId;

    @ApiModelProperty("关联审批的进行recordId")
    private Long examineRecordId;

    @ApiModelProperty("记录状态 0 正常 1 终止 2 暂停  3 作废")
    private Integer status;

    @ApiModelProperty("流程状态 0 未流程 1 流程通过 2 流程拒绝 3 流程中 4 已撤回 6创建")
    private Integer flowStatus;

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
