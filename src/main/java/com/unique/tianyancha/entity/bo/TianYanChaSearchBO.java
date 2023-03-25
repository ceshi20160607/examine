package com.unique.tianyancha.entity.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author UNIQUE
 * 天眼查入参
 */
@Data
public class TianYanChaSearchBO {

    @ApiModelProperty("接口区分：TianYanChaUrlEnum")
    private Integer label;
    @ApiModelProperty("分组id")
    private Long groupId;

    @ApiModelProperty("客户id")
    private Long customerId;

    @ApiModelProperty("更新标志 0默认 1强制更新")
    private Integer updateFlag=0;

    @ApiModelProperty("循环查询标志 0不循环只查询一次 1循环获取所有数据")
    private Integer loopFlag=0;



    @ApiModelProperty("请求地址")
    private String url;


    @ApiModelProperty("搜索关键字-- 兼容以前的")
    private String word;

    @ApiModelProperty("当前页数（默认第1页）")
    private Integer pageNum;

    @ApiModelProperty("每页条数（默认20条，最大20条）")
    private Integer pageSize;

    @ApiModelProperty("搜索关键字（公司名称、公司id、注册号或社会统一信用代码）---必填")
    private String keyword;

    @ApiModelProperty("发布结束日期")
    private String publishStartTime;

    @ApiModelProperty("发布开始日期")
    private String publishEndTime;

    @ApiModelProperty("省份地区")
    private String province;

    @ApiModelProperty("公告类型 1. 招标预告、2. 招标公告、3. 招标变更（废弃）、4. 中标结果")
    private String type;

    @ApiModelProperty("公司id（cid和name只需输入其中一个）")
    private String cid;

    @ApiModelProperty("姓名（humanName和hid只需输入其中一个）")
    private String humanName;

    @ApiModelProperty("集团uuid")
    private String uuid;

    @ApiModelProperty("请求参数")
    private String id;

    @ApiModelProperty("公司名称（cid和name只需输入其中一个）")
    private String name;

    @ApiModelProperty("层次，最大4")
    private String flag;

    @ApiModelProperty("up,down")
    private String dir;

    @ApiModelProperty("司法协助基本信息id")
    private String assistanceId;

    @ApiModelProperty("公司id")
    private String gid;

    @ApiModelProperty("抽查id")
    private String businessId;

    @ApiModelProperty("年份（默认所有年份）")
    private String year;

    @ApiModelProperty("时间")
    private String date;

    @ApiModelProperty("人id（humanName和hid只需输入其中一个）")
    private String hid;

    @ApiModelProperty("类型 OWN-法人,SERVE_ALL-任职,INVEST-投资,BRANCH-分支机构,LAW-诉讼,CAC-竞合,EQ-债务, STOCK_PLEDGE_M-股权质押,MORTGAGE_M-动产抵押,LAND_MORTGAGE_M-土地抵押,SUPPLY_M-供应商,CLIENT_M-客户,FOREIGN_GUARANTEE_M-对外担保,ALL-所有类型")
    private String types;

    @ApiModelProperty("深度（最大支持10，默认5）")
    private String depth;

    @ApiModelProperty("目标公司id（与目标公司名必须输入其中之一）")
    private String idTo;

    @ApiModelProperty("目标公司名")
    private String nameTo;

    @ApiModelProperty("源公司id（与源公司名必须输入其中之一）")
    private String idFrom;

    @ApiModelProperty("源公司名")
    private String nameFrom;

}
