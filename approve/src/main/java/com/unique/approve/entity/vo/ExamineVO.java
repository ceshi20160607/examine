package com.unique.approve.entity.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 审批表
 * </p>
 *
 * @author UNIQUE
 * @since 2024-01-30
 */
@Data
@ApiModel(value = "Examine对象", description = "审批表")
public class ExamineVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("审批ID")
    private Long id;

    @ApiModelProperty("模块id 关联模块--可以是业务，也可以是特殊的模块，比如oa 1 合同 2 回款 3发票   101 普通审批 102 请假审批 103 出差审批 104 加班审批 105 差旅报销 106 借款申请")
    private Long moduleId;

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
    private LocalDateTime createTime;
    @ApiModelProperty("创建人")
    private Long createUserId;
    @ApiModelProperty("修改时间")
    private LocalDateTime updateTime;
    @ApiModelProperty("修改人")
    private Long updateUserId;
    @ApiModelProperty("企业id")
    private Long companyId;


}
