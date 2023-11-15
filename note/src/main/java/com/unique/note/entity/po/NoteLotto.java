package com.unique.note.entity.po;

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
 * 购买彩票
 * </p>
 *
 * @author UNIQUE
 * @since 2023-04-23
 */
@Getter
@Setter
@TableName("un_note_lotto")
@ApiModel(value = "NoteLotto对象", description = "购买彩票")
public class NoteLotto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("类型,0大乐透 1双色球 2 七星彩 3快乐八 4排列三 5排列5")
    private Integer lottoType;

    @ApiModelProperty("期号")
    private Integer openStage;

    @ApiModelProperty("买奖时间")
    private LocalDateTime buyTime;

    @ApiModelProperty("买奖号码,分割")
    private String buyNumber;

    @ApiModelProperty("个位数字")
    private String singleNumber;

    @ApiModelProperty("奇偶比")
    private String parityRatio;

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
