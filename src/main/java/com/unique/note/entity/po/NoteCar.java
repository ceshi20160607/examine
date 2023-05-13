package com.unique.note.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 车加油笔记
 * </p>
 *
 * @author UNIQUE
 * @since 2023-04-23
 */
@Getter
@Setter
@TableName("un_note_car")
@ApiModel(value = "NoteCar对象", description = "车加油笔记")
public class NoteCar implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("类型,0日常 1 充值 2加油")
    private Integer carType;

    @ApiModelProperty("区间开始时间")
    private LocalDateTime startTime;

    @ApiModelProperty("区间结束时间")
    private LocalDateTime endTime;

    @ApiModelProperty("区间结开始公里数")
    private Integer startKiloNumber;

    @ApiModelProperty("区间结束公里数")
    private Integer endKiloNumber;

    @ApiModelProperty("区间公里数")
    private Integer betweenKiloNumber;

    @ApiModelProperty("避险次数")
    private Integer dangerNumber;

    @ApiModelProperty("预计剩余里程")
    private Integer futureKiloNumber;

    @ApiModelProperty("油名称")
    private String oilTitle;

    @ApiModelProperty("加之前的油量")
    private BigDecimal beforeOilNumber;

    @ApiModelProperty("加多少升油")
    private Integer oilLiterNumber;

    @ApiModelProperty("油价")
    private BigDecimal oilPrice;

    @ApiModelProperty("花费多少钱")
    private BigDecimal oilMoney;

    @ApiModelProperty("加之后的油量")
    private BigDecimal afterOilNumber;

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

    @ApiModelProperty("企业id")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long companyId;


}
