package com.kakarote.crm.entity.tianyancha;

import com.kakarote.crm.entity.VO.CrmEnterpriseCbIcVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data
public class Report implements Serializable {
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
