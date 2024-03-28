package com.unique.approve.entity.po;

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
 * 审批节点表
 * </p>
 *
 * @author UNIQUE
 * @since 2024-01-30
 */
@Getter
@Setter
@TableName("un_examine_record_node")
@ApiModel(value = "ExamineRecordNode对象", description = "审批节点表")
public class ExamineRecordNode implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("审批id--关联的审批的高级配置，以及审批的基础信息")
    private Long examineId;

    @ApiModelProperty("模块id 关联模块--可以是业务，也可以是特殊的模块，比如oa")
    private Long moduleId;

    @ApiModelProperty("关联的record_id")
    private Long recordId;

    @ApiModelProperty("审批的类型 0开始节点或者其他节点")
    private Long nodeBeforeId;

    @ApiModelProperty("审批的类型 0动态添加 1普通审批 2条件审批 3抄送 4转他人处理 ")
    private Integer nodeType;

//    @ApiModelProperty("审批的类型 1结束节点或者其他节点")
//    private Long nodeAfterId;

    @ApiModelProperty("节点排序 默认0")
    private Integer nodeSort;

    @ApiModelProperty("节点深度,存储节点的父级，从0开始逗号分隔")
    private String nodeDepth;

    @ApiModelProperty("审批人类型 0 固定人员 1 固定人员上级 2角色 3发起人自选")
    private Integer examineType;

    @ApiModelProperty("多人情况时候审批的人员审批方式  0默认一个爱一个默认顺序  1一个爱一个无序 2只要有一个")
    private Integer examineFlag;

    @ApiModelProperty("适用用户id 选择类型是上级时候可以指定某人的上级来处理")
    private Long userId;

    @ApiModelProperty("适用角色id")
    private Long roleId;

    @ApiModelProperty("抄送的 email")
    private String copyEmails;

    @ApiModelProperty("审批状态")
    private Integer status;

    @ApiModelProperty("条件")
    private String conditionModuleFieldSearch;

    @ApiModelProperty("转他人处理flag 默认0 1表示这个是转他人的审批场景 2抄送的邮箱")
    private Integer transferFlag;

    @ApiModelProperty("类型是转他人对应的主键")
    private Long transferUserId;

    @ApiModelProperty("类型是转他人 审批状态")
    private Integer transferStatus;

    @ApiModelProperty("上级审批截至人员 配置这个如果没有上级转该人审批 有上级这个配置失效")
    private Long endUserId;

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
