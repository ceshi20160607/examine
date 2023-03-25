package com.unique.tianyancha.enums;

import lombok.Getter;

/**
 * @author hmb
 */

@Getter
public enum TianYanChaUrlEnum {
    IC_BASEINFO(1,"企业基本信息（含企业联系方式）","/open/ic/baseinfoV2/2.0",1L),
    IC_STAFF(2,"主要人员","/open/ic/staff/2.0",1L),
    IC_HOLDER(3,"企业股东","/open/ic/holder/2.0",1L),
    IC_HOLDER_LIST(4,"公司公示-股东出资","/open/ic/holderList/2.0",1L),
    IC_HOLDER_CHANGE(5,"公司公示-股权变更","/open/ic/holderChange/2.0",1L),
    IC_INVERST(6,"对外投资","/open/ic/inverst/2.0",1L),
    IC_BRANCH(7,"分支机构","/open/ic/branch/2.0",1L),
    IC_PARENT_COMPANY(8,"总公司","/open/ic/parentCompany/2.0",1L),
    IC_CHANGEINFO(9,"变更记录","/open/ic/changeinfo/2.0",1L),
    JR_JUDICIAL_CASE(10,"司法解析","/open/jr/judicialCase/2.0",2L),
    JR_LAW_SULT_BASE(11,"法律诉讼详情","/open/jr/lawSuit/zhenghe",2L),
    JR_KTANNOUNCEMENT(12,"开庭公告","/open/jr/ktannouncement/2.0",2L),
    JR_COURT_REGISTER(13,"立案信息","/open/jr/courtRegister/2.0",2L),
    GET_JUDICIA_BASE(14,"司法协助详情","/v4/open/judicial/zhenghe",2L),
    JR_BANKRUPTCY_BASE(15,"破产重整详情","/open/jr/bankruptcy/zhenghe",2L),
    JR_ZHIXINGINFO(16,"被执行人","/open/jr/zhixinginfo/2.0",2L),
    M_GET_LICENSE(17,"行政许可（工商局）","/open/m/getLicense/2.0",3L),
    M_CHECK_INFO(18,"抽查检查","/open/m/checkInfo/3.0",3L),
    M_DOUBLE_RANDOM_CHECK_DETAIL_BASE(19,"双随机抽查详情","/open/m/doubleRandomCheck/zhenghe",3L),
    M_PURCHASE_LAND(20,"购地信息","/open/m/purchaseLand/2.0",3L),
    M_SUPPLY(21,"供应商","/open/m/supply/2.0",3L),
    M_CUSTOMER(22,"客户","/open/m/customer/2.0",3L),
    M_BIDS(23,"企业招投标信息","/open/m/bids/2.0",3L),
    M_LAND_TRANSFER(24,"土地转让","/open/m/landTransfer/2.0",3L),
    MR_PUNISHMENT_INFO(25,"行政处罚","/open/mr/punishmentInfo/3.0",4L),
    HI_PUNISHMENT_INFO(26,"历史行政处罚","/open/hi/punishmentInfo/3.0",4L),
    MR_OWN_TAX(27,"欠税公告","/open/mr/ownTax/2.0",4L),
    MR_TAX_CONTRAVENTION_BASE(28,"税收违法详情","/open/mr/taxContravention/zhenghe",4L),
    MR_ABNORMAL(29,"经营异常","/open/mr/abnormal/2.0",4L),
    HI_ABNORMAL(30,"历史经营异常","/open/hi/abnormal/2.0",4L),
    MR_ILLEGALINFO(31,"严重违法","/open/mr/illegalinfo/2.0",4L),
    MR_LIQUIDATING(32,"清算信息","/open/mr/liquidating/2.0",4L),
    MR_BRIEF_CANCEL(33,"简易注销","/open/mr/briefCancel/2.0",4L),
    MR_INQUIRY_EVALUATION(34,"询价评估","/open/mr/inquiryEvaluation/2.0",4L),
    MR_JUDICIAL_SALE(35,"司法拍卖","/open/mr/judicialSale/3.0",4L),
    PUBLIC_NOTICE(36,"公示催告","/v4/open/publicNotice",4L),
    MR_MORTGAGE_INFO(37,"动产抵押","/open/mr/mortgageInfo/2.0",4L),
    HI_MORTGAGE_INFO(38,"历史动产抵押","/open/hi/mortgageInfo/2.0",4L),
    MR_LAND_MORTGAGE_BASE(39,"土地抵押详情","/open/mr/landMortgage/zhenghe",4L),
    GET_PLEDGE_REG(40,"知识产权出质","/v4/open/getPledgeReg",4L),
    MR_EQUITY_INFO(41,"股权出质","/open/mr/equityInfo/2.0",4L),
    HI_EQUITY_INFO(42,"历史股权出质","/open/hi/equityInfo/2.0",4L),
    MR_STOCK_PLEDGE_BASE(43,"质押明细详情","/open/mr/stockPledge/zhenghe",4L),
    MR_STOCK_PLEDGE_SHAREHOLDER_BASE(44,"重要股东质押详情","/open/mr/stockPledge/shareholder/zhenghe",4L),
    MR_STOCK_PLEDGE_RATIO(45,"质押比例","/open/mr/stockPledge/ratio/2.0",4L),
    MR_STOCK_PLEDGE_TREND(46,"质押走势","/open/mr/stockPledge/trend/2.0",4L),
    HUMAN_COMPANYHOLDING_BASE(47,"人员控股企业","/open/human/companyholding/zhenghe",5L),
    ROLES_BASE(48,"人员所有角色","/v4/open/roles/zhenghe",5L),
    HI_ROLES_BASE(49,"人员所有历史角色","/open/hi/roles/zhenghe",5L),
    ALL_COMPANYS_BASE(50,"人员所有公司","/v4/open/allCompanys/zhenghe",5L),
    PARTNERS_BASE(51,"人员所有合作伙伴","/v4/open/partners/zhenghe",5L),
    ONE_KEY(52,"企业图谱","/v4/open/oneKey/c",6L),
    EQUITY_RATIO(53,"股权结构图","/v4/open/equityRatio",6L),
    INVESTTREE(54,"股权穿透图","/v3/open/investtree",6L),
    IC_HUMANHOLDING(55,"最终受益人","/open/ic/humanholding/2.0",6L),
    COMPANYHOLDING(56,"实际控制权","/v4/open/companyholding",6L),
    IC_ACTUAL_CONTROL(57,"疑似实际控制人","/open/ic/actualControl/3.0",6L),
    RELA_SHORT_PATH(58,"最短路径发现","/open/rela/shortPath",6L),
    GROUP_BASE(59,"所属集团查询","/open/group/base",7L),
    GROUP_BASE_DETAILS_BASE(60,"集团详细信息","/open/group/base/details/zhenghe",7L),
    GROUP_MEMBER_BASE(61,"集团成员","/open/group/member/zhenghe",7L),
    GROUP_INVESTORS_BASE(62,"集团对外投资","/open/group/investors/zhenghe",7L),
    GROUP_INVESTOR_MEMBER_BASE(63,"集团内参与投资该企业的成员列表","/open/group/investorMember/zhenghe",7L),
    GROUP_SHAREHOLDERS_BASE(64,"集团投资方","/open/group/shareholders/zhenghe",7L),
    GROUP_SHAREHOLDERS_MEMBER_BASE(65,"集团内被该投资方投资的成员列表","/open/group/shareholdersMember/zhenghe",7L),
    HUMAN_ZHIXINGINFO_BASE(66,"被执行人（人员）","/v4/open/human/zhixinginfo/zhenghe",8L),
    HUMAN_CONSUMPTION_RESTRICTION_BASE(67,"限制消费令（人员）","/v4/open/human/consumptionRestriction/zhenghe",8L),
    HUMAN_JUDICIAL_ASSISTANCE_BASE(68,"司法协助（人员）","/v4/open/human/judicialAssistance/zhenghe",8L),
    HUMAN_JUDICIAL_ASSISTANCE_DETAIL_BASE(69,"司法协助（人员）详情","/v4/open/human/judicialAssistanceDetail/zhenghe",8L),
    HUMAN_END_CASE_BASE(70,"终本案件（人员）","/v4/open/human/endCase/zhenghe",8L),
    HUMAN_DISHONEST_BASE(71,"失信被执行人（人员）","/v4/open/human/dishonest/zhenghe",8L),



    //前置数据获取
    JR_LAW_SULT_LIST(1001,"法律诉讼","open/jr/lawSuit/3.0",9L),
    JR_LAW_SULT_DETAIL(1002,"法律诉讼详情","/open/jr/lawSuit/detail",9L),

    GET_JUDICIA_LIST(1003,"司法协助","/v4/open/judicial",9L),
    GET_JUDICIA_DETAIL(1004,"司法协助详情","/v4/open/getJudicialDetail",9L),

    JR_BANKRUPTCY_List(1005,"破产重整","/open/jr/bankruptcy/2.0",9L),
    JR_BANKRUPTCY_DETAIL(1006,"破产重整详情","/open/jr/bankruptcy/detail/2.0",9L),

    M_DOUBLE_RANDOM_CHECK_DETAIL_LIST(1007,"双随机抽查","/open/m/doubleRandomCheck/2.0",9L),
    M_DOUBLE_RANDOM_CHECK_DETAIL_DETAIL(1008,"双随机抽查详情","/open/m/doubleRandomCheckDetail/2.0",9L),

    MR_TAX_CONTRAVENTION_LIST(1009,"税收违法","/open/mr/taxContravention/2.0",9L),
    MR_TAX_CONTRAVENTION_DETAIL(1010,"税收违法详情","/open/mr/taxContravention/detail/2.0",9L),

    MR_LAND_MORTGAGE_LIST(1011,"土地抵押","/open/mr/landMortgage/2.0",9L),
    MR_LAND_MORTGAGE_DETAIL(1012,"土地抵押详情","/open/mr/landMortgage/detail/2.0",9L),

    MR_STOCK_PLEDGE_LIST(1013,"质押明细","/open/mr/stockPledge/detailList/2.0",9L),
    MR_STOCK_PLEDGE_DETAIL(1014,"质押明细详情","/open/mr/stockPledge/detail/2.0",9L),

    MR_STOCK_PLEDGE_SHAREHOLDER_LIST(1015,"重要股东质押","/open/mr/stockPledge/shareholder/2.0",9L),
    MR_STOCK_PLEDGE_SHAREHOLDER_DETAIL(1016,"重要股东质押详情","/open/mr/stockPledge/shareholder/detail/2.0",9L),


    IC_BASEINFO_V3_LIST(1017,"企业基本信息（含主要人员）","/open/ic/baseinfoV3/2.0",9L),
    HUMAN_COMPANYHOLDING_DETAIL(1018,"人员控股企业","/open/human/companyholding/2.0",9L),
    ROLES_DETAIL(1019,"人员所有角色","/v4/open/roles",9L),
    HI_ROLES_DETAIL(1020,"人员所有历史角色","/open/hi/roles",9L),
    ALL_COMPANYS_DETAIL(1021,"人员所有公司","/v4/open/allCompanys",9L),
    PARTNERS_DETAIL(1022,"人员所有合作伙伴","/v4/open/partners",9L),

    GROUP_BASE_DETAILS_DETAIL(1023,"集团详细信息","/open/group/base/details",9L),
    GROUP_MEMBER_DETAIL(1024,"集团成员","/open/group/member",9L),
    GROUP_INVESTORS_DETAIL(1025,"集团对外投资","/open/group/investors",9L),
    GROUP_INVESTOR_MEMBER_DETAIL(1026,"集团内参与投资该企业的成员列表","/open/group/investorMember",9L),
    GROUP_SHAREHOLDERS_DETAIL(1027,"集团投资方","/open/group/shareholders",9L),
    GROUP_SHAREHOLDERS_MEMBER_DETAIL(1028,"集团内被该投资方投资的成员列表","/open/group/shareholdersMember",9L),


    HUMAN_ZHIXINGINFO_DETAIL(1029,"被执行人（人员）","/v4/open/human/zhixinginfo",9L),
    HUMAN_CONSUMPTION_RESTRICTION_DETAIL(1030,"限制消费令（人员）","/v4/open/human/consumptionRestriction",9L),
    HUMAN_JUDICIAL_ASSISTANCE_DETAIL(1031,"司法协助（人员）","/v4/open/human/judicialAssistance",9L),
    HUMAN_JUDICIAL_ASSISTANCE_DETAIL_DETAIL(1032,"司法协助（人员）详情","/v4/open/human/judicialAssistanceDetail",9L),
    HUMAN_END_CASE_DETAIL(1033,"终本案件（人员）","/v4/open/human/endCase",9L),
    HUMAN_DISHONEST_DETAIL(1034,"失信被执行人（人员）","/v4/open/human/dishonest",9L),

    //处理旧的适用的工商信息,
    OLD_SEARCH(2000,"搜索","/open/search/2.0",10L),
    OLD_IC_BASEINFO_NORMAL(2001,"企业基本信息","/open/ic/baseinfo/normal",10L),
    OLD_IC_CONTACT(2002,"企业联系方式","/open/ic/contact",10L),



    ;

    TianYanChaUrlEnum(Integer label,String name, String url, Long groupId){
        this.label = label;
        this.name = name;
        this.url = url;
        this.groupId = groupId;
    }
    private Integer label;
    private String name;
    private String url;
    private Long groupId;

    public static TianYanChaUrlEnum parse(Integer label) {
        for (TianYanChaUrlEnum item : TianYanChaUrlEnum.values()) {
            if (item.getLabel().equals(label)) {
                return item;
            }
        }
        return null;
    }
}
