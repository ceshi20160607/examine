package com.unique.tianyancha.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 天眼查记录表
 * </p>
 *
 * @author UNIQUE
 * @since 2023-03-06
 */
@Getter
@Setter
@TableName("wk_crm_tianyancha")
@ApiModel(value = "CrmTianyancha对象", description = "天眼查记录表")
public class CrmTianyancha implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("所属分组")
    private Long groupId;

    @ApiModelProperty("所属分组 名称")
    @TableField(exist = false)
    private String groupName;

    @ApiModelProperty("关联业务主键ID")
    private Long customerId;

    @ApiModelProperty("循环查询标志 0不循环只查询一次 1循环获取所有数据")
    private Integer loopFlag;

    @ApiModelProperty("更新标志 0默认 1强制更新")
    private Integer updateFlag=0;

    @ApiModelProperty("记录状态 0 正常 1 终止 2 暂停  3 作废")
    private Integer status;

    @ApiModelProperty("请求url")
    private String paramUrl;

    @ApiModelProperty("查询公司关键字 word")
    private String paramWord;

    @ApiModelProperty("当前页数（默认第1页）")
    private Integer paramPageNum;

    @ApiModelProperty("每页条数（默认20条，最大20条）")
    private Integer paramPageSize;

    @ApiModelProperty("搜索关键字（公司名称、公司id、注册号或社会统一信用代码）")
    private String paramKeyword;

    @ApiModelProperty("发布结束日期")
    private String paramPublishStartTime;

    @ApiModelProperty("发布开始日期")
    private String paramPublishEndTime;

    @ApiModelProperty("省份地区")
    private String paramProvince;

    @ApiModelProperty("公告类型 1. 招标预告、2. 招标公告、3. 招标变更（废弃）、4. 中标结果")
    private String paramType;

    @ApiModelProperty("公司id（cid和name只需输入其中一个）")
    private String paramCid;

    @ApiModelProperty("姓名（humanName和hid只需输入其中一个）")
    private String paramHumanName;

    @ApiModelProperty("集团uuid")
    private String paramUuid;

    @ApiModelProperty("请求参数")
    private String paramId;

    @ApiModelProperty("公司名称（cid和name只需输入其中一个）")
    private String paramName;

    @ApiModelProperty("层次，最大4")
    private String paramFlag;

    @ApiModelProperty("up,down")
    private String paramDir;

    @ApiModelProperty("司法协助基本信息id")
    private String paramAssistanceId;

    @ApiModelProperty("公司id")
    private String paramGid;

    @ApiModelProperty("抽查id")
    private String paramBusinessId;

    @ApiModelProperty("年份（默认所有年份）")
    private String paramYear;

    @ApiModelProperty("时间")
    private String paramDate;

    @ApiModelProperty("人id（humanName和hid只需输入其中一个）")
    private String paramHid;

    @ApiModelProperty("类型 OWN-法人,SERVE_ALL-任职,INVEST-投资,BRANCH-分支机构,LAW-诉讼,CAC-竞合,EQ-债务, STOCK_PLEDGE_M-股权质押,MORTGAGE_M-动产抵押,LAND_MORTGAGE_M-土地抵押,SUPPLY_M-供应商,CLIENT_M-客户,FOREIGN_GUARANTEE_M-对外担保,ALL-所有类型")
    private String paramTypes;

    @ApiModelProperty("深度（最大支持10，默认5）")
    private String paramDepth;

    @ApiModelProperty("目标公司id（与目标公司名必须输入其中之一）")
    private String paramIdTo;

    @ApiModelProperty("目标公司名")
    private String paramNameTo;

    @ApiModelProperty("源公司id（与源公司名必须输入其中之一）")
    private String paramIdFrom;

    @ApiModelProperty("源公司名")
    private String paramNameFrom;

    @ApiModelProperty("请求返回")
    private String paramReturn;

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



}
