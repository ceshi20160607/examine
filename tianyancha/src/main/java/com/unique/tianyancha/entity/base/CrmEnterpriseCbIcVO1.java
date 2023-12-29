package com.kakarote.crm.entity.tianyancha;

import com.kakarote.crm.entity.VO.CrmEnterpriseBranchsVO;
import com.kakarote.crm.entity.VO.CrmEnterpriseChangeRecordVO;
import com.kakarote.crm.entity.VO.CrmEnterpriseInvestmentVO;
import com.kakarote.crm.entity.VO.CrmEnterprisePartnersVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@ApiModel("工商信息VO")
public class CrmEnterpriseCbIcVO1 {
    @ApiModelProperty("搜索的KEY")
    private String searchKey;

    @ApiModelProperty("公司id")
    private String id;
    @ApiModelProperty("省份简称")
    private String base;
    @ApiModelProperty("企业名")
    private String name;
    @ApiModelProperty("法人")
    private String legalPersonName;
    @ApiModelProperty("法人类型 ，1 人 2 公司")
    private String legalPersonType;
    @ApiModelProperty("注册号")
    private String regNumber;
    @ApiModelProperty("行业")
    private String industry;
    @ApiModelProperty("企业类型")
    private String companyOrgType;
    @ApiModelProperty("注册地址")
    private String regLocation;
    @ApiModelProperty("成立时间")
    private String estiblishTime;
    @ApiModelProperty("经营开始时间")
    private String fromTime;
    @ApiModelProperty("经营结束时间")
    private String toTime;
    @ApiModelProperty("经营范围")
    private String businessScope;
    @ApiModelProperty("核准时间")
    private String approvedTime;
    @ApiModelProperty("企业状态")
    private String regStatus;
    @ApiModelProperty("注册资本")
    private String regCapital;
    @ApiModelProperty("登记机关")
    private String regInstitute;
    @ApiModelProperty("组织机构代码")
    private String orgNumber;
    @ApiModelProperty("统一社会信用代码")
    private String creditCode;
    @ApiModelProperty("英文名")
    private String property3;
    @ApiModelProperty("更新时间")
    private String updatetime;
    @ApiModelProperty("表对应id")
    private String companyId;
    @ApiModelProperty("纳税人识别号")
    private String taxNumber;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("网址")
    private String website;
    @ApiModelProperty("电话号")
    private String phoneNumber;
    @ApiModelProperty("吊销日期")
    private String revokeDate;
    @ApiModelProperty("吊销原因")
    private String revokeReason;
    @ApiModelProperty("注销日期")
    private String cancelDate;
    @ApiModelProperty("注销原因")
    private String cancelReason;

    //-------------------------------------------

    @ApiModelProperty("经营异常列表")
    private List<StaffVO> staffList;
    @ApiModelProperty("经营异常列表")
    private List<AbnormalVO> abnormalList;
    @ApiModelProperty("严重违法")
    private List<IllegalVO> illegalList;
    @ApiModelProperty("行政处罚")
    private List<PunishVO> punishList;
    @ApiModelProperty("抽查检查")
    private List<CheckVO> checkList;
    @ApiModelProperty("行政许可")
    private List<LicenseVO> licenseList;
    @ApiModelProperty("清算信息")
    private List<LiquidatingInfoVO> liquidatingInfo;
    @ApiModelProperty("股权出质")
    private List<EquityVO> equityList;
    @ApiModelProperty("司法协助")
    private List<CrmEnterpriseBranchsVO> branchList;
    @ApiModelProperty("司法协助")
    private List<JudicialVO> judicialList;
    @ApiModelProperty("简易注销")
    private BriefCancelVO briefCancel;
    @ApiModelProperty("动产抵押")
    private List<IprPledgeVO> iprPledgeList;
    @ApiModelProperty("动产抵押")
    private List<MortVO> mortList;
    @ApiModelProperty("年报")
    private List<ReportListVO> reportList;
    @ApiModelProperty("企业变更")
    private List<CrmEnterpriseChangeRecordVO> changeList;
    @ApiModelProperty("对外投资")
    private List<CrmEnterpriseInvestmentVO> investList;
    @ApiModelProperty("股东")
    private List<CrmEnterprisePartnersVO> shareHolderList;
    //-------------------------------------------
    @NoArgsConstructor
    @Data
    public static class StaffVO {
        @ApiModelProperty("id")
        private String id;
        @ApiModelProperty("主要人员名称")
        private String name;
        @ApiModelProperty("logo")
        private String logo;
        @ApiModelProperty("主要人员类型 1-公司 2-人")
        private String type;
        @ApiModelProperty("主要人员职位")
        private String staffTypeName;
        @ApiModelProperty("职位")
        private List<String> typeJoin;
    }
    @NoArgsConstructor
    @Data
    public static class AbnormalVO {
        @ApiModelProperty("表id")
        private String id;
        @ApiModelProperty("列入原因")
        private String putReason;
        @ApiModelProperty("列入时间")
        private String putDate;
        @ApiModelProperty("决定列入机关")
        private String putDepartment;
        @ApiModelProperty("移出原因")
        private String removeReason;
        @ApiModelProperty("移出时间")
        private String removeDate;
        @ApiModelProperty("移出机关")
        private String removeDepartment;
    }
    @NoArgsConstructor
    @Data
    public static class IllegalVO {
        @ApiModelProperty("表id")
        private String id;
        @ApiModelProperty("列入原因")
        private String putReason;
        @ApiModelProperty("列入时间")
        private String putDate;
        @ApiModelProperty("决定列入机关")
        private String putDepartment;
        @ApiModelProperty("移出原因")
        private String removeReason;
        @ApiModelProperty("移出时间")
        private String removeDate;
        @ApiModelProperty("决定移出机关")
        private String removeDepartment;
        @ApiModelProperty("类别")
        private String type;
        @ApiModelProperty("违法事实")
        private String fact;
    }
    @NoArgsConstructor
    @Data
    public static class PunishVO {
        @ApiModelProperty("表id")
        private String id;
        @ApiModelProperty("省份简称（无用)")
        private String base;
        @ApiModelProperty("行政处罚决定书文号")
        private String punishNumber;
        @ApiModelProperty("公司名称")
        private String name;
        @ApiModelProperty("注册号")
        private String regNumber;
        @ApiModelProperty("法定代表人（负责人）姓名")
        private String legalPersonName;
        @ApiModelProperty("违法行为类型")
        private String type;
        @ApiModelProperty("行政处罚内容")
        private String content;
        @ApiModelProperty("作出行政处罚决定机关名称")
        private String departmentName;
        @ApiModelProperty("作出行政处罚决定日期")
        private String decisionDate;
        @ApiModelProperty("无用")
        private String publishDate;
        @ApiModelProperty("无用")
        private String description;
        @ApiModelProperty("来源名称")
        private String sourceName;
    }

    @NoArgsConstructor
    @Data
    public static class CheckVO {
        @ApiModelProperty("表id")
        private String id;
        @ApiModelProperty("检查实施机关")
        private String checkOrg;
        @ApiModelProperty("类型")
        private String checkType;
        @ApiModelProperty("日期")
        private String checkDate;
        @ApiModelProperty("结果")
        private String checkResult;
        @ApiModelProperty("备注")
        private String remark;
    }
    @NoArgsConstructor
    @Data
    public static class LicenseVO {
        @ApiModelProperty("id")
        private String id;
        @ApiModelProperty("许可证名称")
        private String licencename;
        @ApiModelProperty("许可书文编号")
        private String licencenumber;
        @ApiModelProperty("来源")
        private String source;
        @ApiModelProperty("范围")
        private String scope;
        @ApiModelProperty("起始日期")
        private String fromdate;
        @ApiModelProperty("截止日期")
        private String todate;
        @ApiModelProperty("发证机关")
        private String department;
    }
    @NoArgsConstructor
    @Data
    public static class LiquidatingInfoVO {
        @ApiModelProperty("表id")
        private String id;
        @ApiModelProperty("清算组负责人")
        private String manager;
        @ApiModelProperty("清算成员名称")
        private String member;
    }
    @NoArgsConstructor
    @Data
    public static class EquityVO {
        @ApiModelProperty("表id")
        private String id;
        @ApiModelProperty("登记编号")
        private String regNumber;
        @ApiModelProperty("出质股权标的企业")
        private String targetCompany;
        @ApiModelProperty("出质人")
        private String pledgor;
        @ApiModelProperty("出质人证照/证件号码")
        private String certifNumber;
        @ApiModelProperty("出质股权数额")
        private String equityAmount;
        @ApiModelProperty("质权人")
        private String pledgee;
        @ApiModelProperty("质权人证照/证件号码")
        private String certifNumberR;
        @ApiModelProperty("股权出质设立登记日期")
        private String regDate;
        @ApiModelProperty("状态")
        private String state;
        @ApiModelProperty("股权出质设立发布日期")
        private String putDate;
        @ApiModelProperty("注销日期")
        private String cancelDate;
        @ApiModelProperty("注销原因")
        private String cancelReason;
    }

    @NoArgsConstructor
    @Data
    public static class JudicialVO {
        @ApiModelProperty("表id")
        private String assId;
        @ApiModelProperty("被执行人")
        private String executedPerson;
        @ApiModelProperty("股权数额")
        private String equityAmount;
        @ApiModelProperty("执行通知书文号")
        private String executeNoticeNum;
        @ApiModelProperty("执行法院")
        private String executiveCourt;
        @ApiModelProperty("类型|状态")
        private String typeState;
        @ApiModelProperty("股权变更")
        private CompanyJudicialShareholderChangeInfoVO companyJudicialShareholderChangeInfo;
        @ApiModelProperty("冻结")
        private CompanyJudicialAssistanceFrozenRemInfoVO companyJudicialAssistanceFrozenInfo;
        @ApiModelProperty("冻结失效")
        private CompanyJudicialAssistanceFrozenInvalidationInfoVO companyJudicialAssistanceFrozenInvalidationInfo;
        @ApiModelProperty("冻结续行")
        private CompanyJudicialAssistanceFrozenKeepInfoVO companyJudicialAssistanceFrozenKeepInfo;
        @ApiModelProperty("解除冻结")
        private CompanyJudicialAssistanceFrozenRemInfoVO companyJudicialAssistanceFrozenRemInfo;


        @NoArgsConstructor
        @Data
        public static class CompanyJudicialShareholderChangeInfoVO {
            @ApiModelProperty("执行法院")
            private String executiveCourt;
            @ApiModelProperty("执行事项")
            private String implementationMatters;
            @ApiModelProperty("执行裁定书文号")
            private String executeOrderNum;
            @ApiModelProperty("执行通知书文号")
            private String executeNoticeNum;
            @ApiModelProperty("被执行人")
            private String executedPerson;
            @ApiModelProperty("被执行人持有股权数额")
            private String equityAmountOther;
            @ApiModelProperty("被执行人证照种类")
            private String licenseType;
            @ApiModelProperty("被执行人证照号码")
            private String licenseNum;
            @ApiModelProperty("受让人")
            private String assignee;
            @ApiModelProperty("协助执行日期")
            private String executionDate;
            @ApiModelProperty("受让人证照种类")
            private String assigneeLicenseType;
            @ApiModelProperty("受让人证照号码")
            private String assigneeLicenseNum;
        }
        @NoArgsConstructor
        @Data
        public static class CompanyJudicialAssistanceFrozenInvalidationInfoVO {
            @ApiModelProperty("失效原因")
            private String invalidationReason;
            @ApiModelProperty("失效日期")
            private String invalidationDate;
        }
        @NoArgsConstructor
        @Data
        public static class CompanyJudicialAssistanceFrozenKeepInfoVO {
            @ApiModelProperty("执行法院")
            private String executiveCourt;
            @ApiModelProperty("执行事项")
            private String implementationMatters;
            @ApiModelProperty("执行裁定书文号")
            private String executeOrderNum;
            @ApiModelProperty("执行通知书文号")
            private String executeNoticeNum;
            @ApiModelProperty("被执行人")
            private String executedPerson;
            @ApiModelProperty("被执行人持有股权、其它投资权益的数额")
            private String equityAmountOther;
            @ApiModelProperty("被执行人证照种类")
            private String licenseType;
            @ApiModelProperty("被执行人证照号码")
            private String licenseNum;
            @ApiModelProperty("续行冻结期限自")
            private String fromDate;
            @ApiModelProperty("续行冻结期限至")
            private String toDate;
            @ApiModelProperty("续行冻结期限")
            private String period;
            @ApiModelProperty("公示日期")
            private String publicityDate;
        }
        @NoArgsConstructor
        @Data
        public static class CompanyJudicialAssistanceFrozenRemInfoVO {
            @ApiModelProperty("执行法院")
            private String executiveCourt;
            @ApiModelProperty("执行事项")
            private String implementationMatters;
            @ApiModelProperty("执行裁定书文号")
            private String executeOrderNum;
            @ApiModelProperty("执行通知书文号")
            private String executeNoticeNum;
            @ApiModelProperty("被执行人")
            private String executedPerson;
            @ApiModelProperty("被执行人持有股权、其它投资权益的数额")
            private String equityAmountOther;
            @ApiModelProperty("被执行人证照种类")
            private String licenseType;
            @ApiModelProperty("被执行人证照号码")
            private String licenseNum;
            @ApiModelProperty("解除冻结日期")
            private String frozenRemoveDate;
            @ApiModelProperty("公示日期")
            private String publicityDate;
        }
    }

    @NoArgsConstructor
    @Data
    public static class BriefCancelVO {
        @ApiModelProperty("公告id")
        private String id;
        @ApiModelProperty("公司名")
        private String company_name;
        @ApiModelProperty("注册号")
        private String reg_num;
        @ApiModelProperty("统一社会信用代码")
        private String credit_code;
        @ApiModelProperty("公告期")
        private String announcement_term;
        @ApiModelProperty("公告结束日期")
        private String announcement_end_date;
        @ApiModelProperty("登记机关")
        private String reg_authority;
        @ApiModelProperty("原链接")
        private String investor_commitment_download_url;
        @ApiModelProperty("oss路径")
        private String ossPath;
        @ApiModelProperty("简易注销结果")
        private String brief_cancel_result;
        @ApiModelProperty("公告申请日期")
        private String announcement_apply_date;
        @ApiModelProperty("异议")
        private List<ObjectionVO> objectionList;


        @NoArgsConstructor
        @Data
        public static class ObjectionVO {
            @ApiModelProperty("异议申请人")
            private String objection_apply_person;
            @ApiModelProperty("异议内容")
            private String objection_content;
            @ApiModelProperty("异议时间")
            private String objection_date;
        }
    }
    @NoArgsConstructor
    @Data
    public static class IprPledgeVO {
        @ApiModelProperty("表id")
        private String id;
        @ApiModelProperty("知识产权登记证号")
        private String iprCertificateNum;
        @ApiModelProperty("名称")
        private String iprName;
        @ApiModelProperty("种类")
        private String iprType;
        @ApiModelProperty("出质人")
        private String pledgorName;
        @ApiModelProperty("质权人名称")
        private String pledgeeName;
        @ApiModelProperty("质权登记期限")
        private String pledgeRegPeriod;
        @ApiModelProperty("状态")
        private String state;
        @ApiModelProperty("公示日期")
        private String publicityDate;
        @ApiModelProperty("注销日期")
        private String cancleDate;
        @ApiModelProperty("注销原因")
        private String cancleReason;
        @ApiModelProperty("变更记录")
        private String changeList;


        @NoArgsConstructor
        @Data
        public static class ChangeVO {
            @ApiModelProperty("变更事项")
            private String changeItem;
            @ApiModelProperty("变更前")
            private String contentBefore;
            @ApiModelProperty("变更后")
            private String contentAfter;
            @ApiModelProperty("变更日期")
            private String changeTime;
        }
    }

    @NoArgsConstructor
    @Data
    public static class MortVO {
        @ApiModelProperty("表id")
        private String id;
        @ApiModelProperty("省份简称")
        private String base;
        @ApiModelProperty("登记编号")
        private String regNum;
        @ApiModelProperty("登记日期")
        private String regDate;
        @ApiModelProperty("公示日期")
        private String publishDate;
        @ApiModelProperty("状态")
        private String status;
        @ApiModelProperty("登记机关")
        private String regDepartment;
        @ApiModelProperty("被担保债权种类")
        private String type;
        @ApiModelProperty("被担保债权数额")
        private String amount;
        @ApiModelProperty("债务人履行债务的期限")
        private String term;
        @ApiModelProperty("担保范围")
        private String scope;
        @ApiModelProperty("备注")
        private String remark;
        @ApiModelProperty("概况种类(字段弃用)")
        private String overviewType;
        @ApiModelProperty("概况数额(字段弃用)")
        private String overviewAmount;
        @ApiModelProperty("概况担保的范围(字段弃用)")
        private String overviewScope;
        @ApiModelProperty("概况债务人履行债务的期限(字段弃用)")
        private String overviewTerm;
        @ApiModelProperty("概况备注(字段弃用)")
        private String overviewRemark;
        @ApiModelProperty("注销日期")
        private String cancelDate;
        @ApiModelProperty("注销原因")
        private String cancelReason;
        @ApiModelProperty("变更")
        private List<ChangeVO> changeList;
        @ApiModelProperty("变更")
        private List<PawnVO> pawnList;
        @ApiModelProperty("变更")
        private List<PeopleVO> peopleList;


        @NoArgsConstructor
        @Data
        public static class ChangeVO {
            @ApiModelProperty("变更时间")
            private String changeDate;
            @ApiModelProperty("变更内容")
            private String changeContent;
        }
        @NoArgsConstructor
        @Data
        public static class PawnVO {
            @ApiModelProperty("名称")
            private String pawnName;
            @ApiModelProperty("所有权归属")
            private String ownership;
            @ApiModelProperty("数量、质量、状况、所在地等情况")
            private String detail;
            @ApiModelProperty("备注")
            private String remark;
        }
        @NoArgsConstructor
        @Data
        public static class PeopleVO {
            @ApiModelProperty("抵押权人名称")
            private String peopleName;
            @ApiModelProperty("抵押权人证照/证件类型")
            private String licenseType;
            @ApiModelProperty("证照/证件号码")
            private String licenseNum;
        }
    }

    @NoArgsConstructor
    @Data
    public static class ReportListVO {
        @ApiModelProperty("年报id")
        private String id;
        @ApiModelProperty("发布时间")
        private String 年报年度;
        @ApiModelProperty("企业名称")
        private String reportYear;
        @ApiModelProperty("统一社会信用代码")
        private String companyName;
        @ApiModelProperty("注册号")
        private String creditCode;
        @ApiModelProperty("电话号")
        private String regNumber;
        @ApiModelProperty("邮政编码")
        private String phoneNumber;
        @ApiModelProperty("企业通信地址")
        private String postcode;
        @ApiModelProperty("邮箱")
        private String postalAddress;
        @ApiModelProperty("企业经营状态")
        private String email;
        @ApiModelProperty("从业人数")
        private String manageState;
        @ApiModelProperty("经营者名称")
        private String employeeNum;
        @ApiModelProperty("资产总额")
        private String operatorName;
        @ApiModelProperty("所有者权益合计")
        private String totalAssets;
        @ApiModelProperty("销售总额(营业总收入)")
        private String totalEquity;
        @ApiModelProperty("利润总额")
        private String totalSales;

        @ApiModelProperty("年报股权变更")
        private List<EquityChangeVO> equityChangeList;
        @ApiModelProperty("年报对外提供保证担保")
        private List<GuaranteeVO> guaranteeList;
        @ApiModelProperty("年报对外投资")
        private List<OutBoundVO> outBoundList;
        @ApiModelProperty("年报股东")
        private List<ShareHolderVO> shareHolderList;
        @ApiModelProperty("年报网站")
        private List<WebVO> webList;
        @ApiModelProperty("年报社保")
        private List<SocialVO> socialList;


        @NoArgsConstructor
        @Data
        public static class EquityChangeVO {
            @ApiModelProperty("股东（发起人）")
            private String investorName;
            @ApiModelProperty("变更前股权比例")
            private String ratioBefore;
            @ApiModelProperty("变更后股权比例")
            private String ratioAfter;
            @ApiModelProperty("股权变更日期")
            private String changeTime;
        }
        @NoArgsConstructor
        @Data
        public static class GuaranteeVO {
            @ApiModelProperty("债权人")
            private String creditor;
            @ApiModelProperty("债务人")
            private String obligor;
            @ApiModelProperty("主债权种类")
            private String creditoType;
            @ApiModelProperty("主债权数额")
            private String creditoAmount;
            @ApiModelProperty("履行债务的期限")
            private String creditoTerm;
            @ApiModelProperty("保证的期间")
            private String guaranteeTerm;
            @ApiModelProperty("保证的方式")
            private String guaranteeWay;
            @ApiModelProperty("保证担保的范围")
            private String guaranteeScope;
        }
        @NoArgsConstructor
        @Data
        public static class OutBoundVO {
            @ApiModelProperty("对外投资企业名称")
            private String outcompanyName;
            @ApiModelProperty("注册号")
            private String regNum;
            @ApiModelProperty("统一信用代码")
            private String creditCode;
        }
        @NoArgsConstructor
        @Data
        public static class ShareHolderVO {
            @ApiModelProperty("股东名称")
            private String investorName;
            @ApiModelProperty("认缴出资额")
            private String subscribeAmount;
            @ApiModelProperty("认缴出资时间")
            private String subscribeTime;
            @ApiModelProperty("认缴出资方式")
            private String subscribeType;
            @ApiModelProperty("实缴出资额")
            private String paidAmount;
            @ApiModelProperty("实缴出资时间")
            private String paidTime;
            @ApiModelProperty("实缴出资方式")
            private String paidType;
        }
        @NoArgsConstructor
        @Data
        public static class SocialVO {
            @ApiModelProperty("城镇职工基本养老保险人数")
            private String endowmentInsurance;
            @ApiModelProperty("失业保险人数")
            private String unemploymentInsurance;
            @ApiModelProperty("职工基本医疗保险人数")
            private String medicalInsurance;
            @ApiModelProperty("工伤保险")
            private String employmentInjuryInsurance;
            @ApiModelProperty("生育保险人数")
            private String maternityInsurance;
            @ApiModelProperty("单位参加城镇职工基本养老保险缴费基数")
            private String endowmentInsuranceBase;
            @ApiModelProperty("单位参加失业保险缴费基数")
            private String unemploymentInsuranceBase;
            @ApiModelProperty("单位参加职工基本医疗保险缴费基数")
            private String medicalInsuranceBase;
            @ApiModelProperty("单位参加生育保险缴费基数")
            private String maternityInsuranceBase;
            @ApiModelProperty("参加城镇职工基本养老保险本期实际缴费金额")
            private String endowmentInsurancePayAmount;
            @ApiModelProperty("参加失业保险本期实际缴费金额")
            private String unemploymentInsurancePayAmount;
            @ApiModelProperty("参加职工基本医疗保险本期实际缴费金额")
            private String medicalInsurancePayAmount;
            @ApiModelProperty("参加工伤保险本期实际缴费金额")
            private String employmentInjuryInsurancePayAmount;
            @ApiModelProperty("参加生育保险本期实际缴费金额")
            private String maternityInsurancePayAmount;
            @ApiModelProperty("单位参加城镇职工基本养老保险累计欠缴金额")
            private String endowmentInsuranceOweAmount;
            @ApiModelProperty("单位参加失业保险累计欠缴金额")
            private String unemploymentInsuranceOweAmount;
            @ApiModelProperty("单位参加职工基本医疗保险累计欠缴金额")
            private String medicalInsuranceOweAmount;
            @ApiModelProperty("单位参加工伤保险累计欠缴金额")
            private String employmentInjuryInsuranceOweAmount;
            @ApiModelProperty("单位参加生育保险累计欠缴金额")
            private String maternityInsuranceOweAmount;
        }

        @NoArgsConstructor
        @Data
        public static class WebVO {
            @ApiModelProperty("网站类型")
            private String webType;
            @ApiModelProperty("网址")
            private String website;
            @ApiModelProperty("名称")
            private String name;
        }
    }

}
