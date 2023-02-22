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
 * 审批任务日志表
 * </p>
 *
 * @author UNIQUE
 * @since 2023-02-15
 */
@Getter
@Setter
@TableName("un_examine_record_task")
@ApiModel(value = "ExamineRecordTask对象", description = "审批任务日志表")
public class ExamineRecordTask implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("审批的任务类别 0 普通审批 1 条件审批 2抄送 3转他人处理 4条件内的审批")
    private Integer taskType;

    @ApiModelProperty("审批人类型 0 固定人员 1 固定人员上级 2角色 3发起人自选")
    private Integer examineType;

    @ApiModelProperty("适用用户id 选择类型是上级时候可以指定某人的上级来处理")
    private String userIds;

    @ApiModelProperty("适用角色id")
    private String roleIds;

    @ApiModelProperty("多人情况时候审批的人员审批方式  0默认一个爱一个默认顺序  1一个爱一个无序 2只要有一个")
    private Integer examineFlag;

    @ApiModelProperty("上级审批截至人员 配置这个如果没有上级转该人审批 有上级这个配置失效")
    private Long endUserId;

    @ApiModelProperty("转他人处理flag 默认0 1表示这个是转他人的审批场景 2抄送的邮箱")
    private Integer transferFlag;

    @ApiModelProperty("类型是转他人对应的主键")
    private Long transferTaskId;

    @ApiModelProperty("抄送的 email")
    private String copyEmails;

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
