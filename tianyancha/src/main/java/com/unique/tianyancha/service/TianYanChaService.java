package com.unique.tianyancha.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.unique.tianyancha.entity.bo.TianYanChaSearchBO;
import com.unique.tianyancha.entity.po.CrmTianyancha;
import com.unique.tianyancha.config.TianYanChaResult;
import com.unique.tianyancha.enums.TianYanChaErrorCodeEnum;
import com.unique.tianyancha.enums.TianYanChaUrlEnum;
import com.unique.tianyancha.util.TianYanChaUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 天眼查服务类
 * @author UNIQUE
 * @date 2023/3/7
 */
@Service
public class TianYanChaService {

    @Autowired
    private TianYanChaUtil tianYanChaUtil;
//    @Autowired
//    private ICrmTianyanchaService iCrmTianyanchaService;

    public TianYanChaResult<Map<String, Object>> queryData(TianYanChaSearchBO searchBO) {
        return buildData(searchBO);
    }

    public TianYanChaResult<Map<String, Object>> search(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.OLD_SEARCH.getLabel());
        return buildData(searchBO);
    }


    public TianYanChaResult<Map<String, Object>> icBaseinfo(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.IC_BASEINFO.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> icStaff(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.IC_STAFF.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> icHolder(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.IC_HOLDER.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> icHolderList(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.IC_HOLDER_LIST.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> icHolderChange(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.IC_HOLDER_CHANGE.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> icInverst(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.IC_INVERST.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> icBranch(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.IC_BRANCH.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> icParentCompany(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.IC_PARENT_COMPANY.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> icChangeinfo(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.IC_CHANGEINFO.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> jrJudicialCase(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.JR_JUDICIAL_CASE.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> jrLawSultBase(TianYanChaSearchBO searchBO) {
//        searchBO.setLabel(TianYanChaUrlEnum.JR_LAW_SULT_DETAIL.getLabel());
        searchBO.setLabel(TianYanChaUrlEnum.JR_LAW_SULT_LIST.getLabel());
        return buildData(searchBO);
    }
        public TianYanChaResult<Map<String, Object>> jrLawSult(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.JR_LAW_SULT_DETAIL.getLabel());
//        searchBO.setLabel(TianYanChaUrlEnum.JR_LAW_SULT_BASE.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> jrKtannouncement(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.JR_KTANNOUNCEMENT.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> jrCourtRegister(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.JR_COURT_REGISTER.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> getJudiciaBase(TianYanChaSearchBO searchBO) {
//        searchBO.setLabel(TianYanChaUrlEnum.GET_JUDICIA_DETAIL.getLabel());
        searchBO.setLabel(TianYanChaUrlEnum.GET_JUDICIA_LIST.getLabel());
        return buildData(searchBO);
    }
        public TianYanChaResult<Map<String, Object>> getJudiciaDetail(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.GET_JUDICIA_DETAIL.getLabel());
//        searchBO.setLabel(TianYanChaUrlEnum.GET_JUDICIA_BASE.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> jrBankruptcyBase(TianYanChaSearchBO searchBO) {
//        searchBO.setLabel(TianYanChaUrlEnum.JR_BANKRUPTCY_DETAIL.getLabel());
        searchBO.setLabel(TianYanChaUrlEnum.JR_BANKRUPTCY_List.getLabel());
        return buildData(searchBO);
    }
        public TianYanChaResult<Map<String, Object>> jrBankruptcy(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.JR_BANKRUPTCY_DETAIL.getLabel());
//        searchBO.setLabel(TianYanChaUrlEnum.JR_BANKRUPTCY_BASE.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> jrZhixinginfo(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.JR_ZHIXINGINFO.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mGetLicense(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.M_GET_LICENSE.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mCheckInfo(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.M_CHECK_INFO.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mDoubleRandomCheckDetailBase(TianYanChaSearchBO searchBO) {
//        searchBO.setLabel(TianYanChaUrlEnum.M_DOUBLE_RANDOM_CHECK_DETAIL_DETAIL.getLabel());
        searchBO.setLabel(TianYanChaUrlEnum.M_DOUBLE_RANDOM_CHECK_DETAIL_LIST.getLabel());
        return buildData(searchBO);
    }
        public TianYanChaResult<Map<String, Object>> mDoubleRandomCheckDetail(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.M_DOUBLE_RANDOM_CHECK_DETAIL_DETAIL.getLabel());
//        searchBO.setLabel(TianYanChaUrlEnum.M_DOUBLE_RANDOM_CHECK_DETAIL_BASE.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mPurchaseLand(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.M_PURCHASE_LAND.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mSupply(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.M_SUPPLY.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mCustomer(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.M_CUSTOMER.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mBids(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.M_BIDS.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mLandTransfer(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.M_LAND_TRANSFER.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrPunishmentInfo(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.MR_PUNISHMENT_INFO.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> hiPunishmentInfo(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.HI_PUNISHMENT_INFO.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrOwnTax(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.MR_OWN_TAX.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrTaxContraventionBase(TianYanChaSearchBO searchBO) {
//        searchBO.setLabel(TianYanChaUrlEnum.MR_TAX_CONTRAVENTION_DETAIL.getLabel());
        searchBO.setLabel(TianYanChaUrlEnum.MR_TAX_CONTRAVENTION_LIST.getLabel());
        return buildData(searchBO);
    }
        public TianYanChaResult<Map<String, Object>> mrTaxContravention(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.MR_TAX_CONTRAVENTION_DETAIL.getLabel());
//        searchBO.setLabel(TianYanChaUrlEnum.MR_TAX_CONTRAVENTION_BASE.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrAbnormal(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.MR_ABNORMAL.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> hiAbnormal(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.HI_ABNORMAL.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrIllegalinfo(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.MR_ILLEGALINFO.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrLiquidating(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.MR_LIQUIDATING.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrBriefCancel(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.MR_BRIEF_CANCEL.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrInquiryEvaluation(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.MR_INQUIRY_EVALUATION.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrJudicialSale(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.MR_JUDICIAL_SALE.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> publicNotice(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.PUBLIC_NOTICE.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrMortgageInfo(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.MR_MORTGAGE_INFO.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> hiMortgageInfo(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.HI_MORTGAGE_INFO.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrLandMortgageBase(TianYanChaSearchBO searchBO) {
//        searchBO.setLabel(TianYanChaUrlEnum.MR_LAND_MORTGAGE_DETAIL.getLabel());
        searchBO.setLabel(TianYanChaUrlEnum.MR_LAND_MORTGAGE_LIST.getLabel());
        return buildData(searchBO);
    }
        public TianYanChaResult<Map<String, Object>> mrLandMortgage(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.MR_LAND_MORTGAGE_DETAIL.getLabel());
//        searchBO.setLabel(TianYanChaUrlEnum.MR_LAND_MORTGAGE_BASE.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> getPledgeReg(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.GET_PLEDGE_REG.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrEquityInfo(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.MR_EQUITY_INFO.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> hiEquityInfo(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.HI_EQUITY_INFO.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrStockPledgeBase(TianYanChaSearchBO searchBO) {
//        searchBO.setLabel(TianYanChaUrlEnum.MR_STOCK_PLEDGE_DETAIL.getLabel());
        searchBO.setLabel(TianYanChaUrlEnum.MR_STOCK_PLEDGE_LIST.getLabel());
        return buildData(searchBO);
    }
        public TianYanChaResult<Map<String, Object>> mrStockPledge(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.MR_STOCK_PLEDGE_DETAIL.getLabel());
//        searchBO.setLabel(TianYanChaUrlEnum.MR_STOCK_PLEDGE_BASE.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrStockPledgeShareholderBase(TianYanChaSearchBO searchBO) {
//        searchBO.setLabel(TianYanChaUrlEnum.MR_STOCK_PLEDGE_SHAREHOLDER_DETAIL.getLabel());
        searchBO.setLabel(TianYanChaUrlEnum.MR_STOCK_PLEDGE_SHAREHOLDER_LIST.getLabel());
        return buildData(searchBO);
    }
        public TianYanChaResult<Map<String, Object>> mrStockPledgeShareholder(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.MR_STOCK_PLEDGE_SHAREHOLDER_DETAIL.getLabel());
//        searchBO.setLabel(TianYanChaUrlEnum.MR_STOCK_PLEDGE_SHAREHOLDER_BASE.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrStockPledgeRatio(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.MR_STOCK_PLEDGE_RATIO.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrStockPledgeTrend(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.MR_STOCK_PLEDGE_TREND.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> icBaseinfoV3List(TianYanChaSearchBO searchBO) {
//        searchBO.setLabel(TianYanChaUrlEnum.HUMAN_COMPANYHOLDING_DETAIL.getLabel());
        searchBO.setLabel(TianYanChaUrlEnum.IC_BASEINFO_V3_LIST.getLabel());
        return buildData(searchBO);

    }
        public TianYanChaResult<Map<String, Object>> humanCompanyholding(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.HUMAN_COMPANYHOLDING_DETAIL.getLabel());
//        searchBO.setLabel(TianYanChaUrlEnum.HUMAN_COMPANYHOLDING_BASE.getLabel());
        return buildData(searchBO);
    }

        public TianYanChaResult<Map<String, Object>> roles(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.ROLES_DETAIL.getLabel());
//        searchBO.setLabel(TianYanChaUrlEnum.ROLES_BASE.getLabel());
        return buildData(searchBO);
    }

    public TianYanChaResult<Map<String, Object>> hiRoles(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.HI_ROLES_DETAIL.getLabel());
//        searchBO.setLabel(TianYanChaUrlEnum.HI_ROLES_BASE.getLabel());
        return buildData(searchBO);
    }


    public TianYanChaResult<Map<String, Object>> allCompanys(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.ALL_COMPANYS_DETAIL.getLabel());
//        searchBO.setLabel(TianYanChaUrlEnum.ALL_COMPANYS_BASE.getLabel());
        return buildData(searchBO);
    }

    public TianYanChaResult<Map<String, Object>> partners(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.PARTNERS_DETAIL.getLabel());
//        searchBO.setLabel(TianYanChaUrlEnum.PARTNERS_BASE.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> oneKey(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.ONE_KEY.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> equityRatio(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.EQUITY_RATIO.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> investtree(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.INVESTTREE.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> icHumanholding(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.IC_HUMANHOLDING.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> companyholding(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.COMPANYHOLDING.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> icActualControl(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.IC_ACTUAL_CONTROL.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> relaShortPath(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.RELA_SHORT_PATH.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> groupBase(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.GROUP_BASE.getLabel());
        return buildData(searchBO);
    }


    public TianYanChaResult<Map<String, Object>> groupBaseDetails(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.GROUP_BASE_DETAILS_DETAIL.getLabel());
//        searchBO.setLabel(TianYanChaUrlEnum.GROUP_BASE_DETAILS_BASE.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> groupMember(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.GROUP_MEMBER_DETAIL.getLabel());
//        searchBO.setLabel(TianYanChaUrlEnum.GROUP_MEMBER_BASE.getLabel());
        return buildData(searchBO);
    }

    public TianYanChaResult<Map<String, Object>> groupInvestors(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.GROUP_INVESTORS_DETAIL.getLabel());
//        searchBO.setLabel(TianYanChaUrlEnum.GROUP_INVESTORS_BASE.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> groupInvestorMember(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.GROUP_INVESTOR_MEMBER.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> groupShareholders(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.GROUP_SHAREHOLDERS_DETAIL.getLabel());
//        searchBO.setLabel(TianYanChaUrlEnum.GROUP_SHAREHOLDERS_BASE.getLabel());
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> groupShareholdersMember(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.GROUP_SHAREHOLDERS_MEMBER.getLabel());
        return buildData(searchBO);
    }

    public TianYanChaResult<Map<String, Object>> humanZhixinginfo(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.HUMAN_ZHIXINGINFO_DETAIL.getLabel());
//        searchBO.setLabel(TianYanChaUrlEnum.HUMAN_ZHIXINGINFO_BASE.getLabel());
        return buildData(searchBO);
    }

    public TianYanChaResult<Map<String, Object>> humanConsumptionRestriction(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.HUMAN_CONSUMPTION_RESTRICTION_DETAIL.getLabel());
//        searchBO.setLabel(TianYanChaUrlEnum.HUMAN_CONSUMPTION_RESTRICTION_BASE.getLabel());
        return buildData(searchBO);
    }

    public TianYanChaResult<Map<String, Object>> humanJudicialAssistance(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.HUMAN_JUDICIAL_ASSISTANCE_DETAIL.getLabel());
//        searchBO.setLabel(TianYanChaUrlEnum.HUMAN_JUDICIAL_ASSISTANCE_BASE.getLabel());
        return buildData(searchBO);
    }

    public TianYanChaResult<Map<String, Object>> humanJudicialAssistanceDetail(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.HUMAN_JUDICIAL_ASSISTANCE_DETAIL_DETAIL.getLabel());
//        searchBO.setLabel(TianYanChaUrlEnum.HUMAN_JUDICIAL_ASSISTANCE_DETAIL_BASE.getLabel());
        return buildData(searchBO);
    }

    public TianYanChaResult<Map<String, Object>> humanEndCase(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.HUMAN_END_CASE_DETAIL.getLabel());
//        searchBO.setLabel(TianYanChaUrlEnum.HUMAN_END_CASE_BASE.getLabel());
        return buildData(searchBO);
    }

    public TianYanChaResult<Map<String, Object>> humanDishonest(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(TianYanChaUrlEnum.HUMAN_DISHONEST_DETAIL.getLabel());
//        searchBO.setLabel(TianYanChaUrlEnum.HUMAN_DISHONEST_BASE.getLabel());
        return buildData(searchBO);
    }








    //------------------------------------------获取数据new---------------------------------

    @SneakyThrows
    private TianYanChaResult<Map<String, Object>> buildData(TianYanChaSearchBO searchBO) {
        return queryBaseData(searchBO);
    }

    //-----------------------------------------------------
//    @SneakyThrows
//    private TianYanChaResult<Map<String, Object>> buildDataNew(TianYanChaSearchBO searchBO) {
//        TianYanChaUrlEnum itemEnum = TianYanChaUrlEnum.parse(searchBO.getLabel());
//        TianYanChaResult<Map<String, Object>> newData = null;
//        switch (itemEnum){
//            case IC_BASEINFO:
//            case IC_STAFF:
//            case IC_HOLDER:
//            case IC_HOLDER_LIST:
//            case IC_HOLDER_CHANGE:
//            case IC_INVERST:
//            case IC_BRANCH:
//            case IC_PARENT_COMPANY:
//            case IC_CHANGEINFO:
//            case JR_JUDICIAL_CASE:
//                newData = queryBaseData(searchBO);
//                break;
//            case JR_LAW_SULT_BASE:
//                newData = queryBaseTwoDepthTwoParamsData(searchBO,TianYanChaUrlEnum.JR_LAW_SULT_LIST,TianYanChaUrlEnum.JR_LAW_SULT_DETAIL,"uuid",null);
//                break;
//            case JR_KTANNOUNCEMENT:
//            case JR_COURT_REGISTER:
//                newData = queryBaseData(searchBO);
//                break;
//            case GET_JUDICIA_BASE:
//                newData = queryBaseTwoDepthTwoParamsData(searchBO,TianYanChaUrlEnum.GET_JUDICIA_LIST,TianYanChaUrlEnum.GET_JUDICIA_DETAIL,"businessId",null);
//                break;
//            case JR_BANKRUPTCY_BASE:
//                newData = queryBaseTwoDepthTwoParamsData(searchBO,TianYanChaUrlEnum.JR_BANKRUPTCY_List,TianYanChaUrlEnum.JR_BANKRUPTCY_DETAIL,"uuid","gid");
//                break;
//            case JR_ZHIXINGINFO:
//            case M_GET_LICENSE:
//            case M_CHECK_INFO:
//                newData = queryBaseData(searchBO);
//                break;
//            case M_DOUBLE_RANDOM_CHECK_DETAIL_BASE:
//                newData = queryBasetthirdDepthData(searchBO,TianYanChaUrlEnum.M_DOUBLE_RANDOM_CHECK_DETAIL_LIST,TianYanChaUrlEnum.M_DOUBLE_RANDOM_CHECK_DETAIL_DETAIL,"businessId",null);
//                break;
//            case M_PURCHASE_LAND:
//            case M_SUPPLY:
//            case M_CUSTOMER:
//            case M_BIDS:
//            case M_LAND_TRANSFER:
//            case MR_PUNISHMENT_INFO:
//            case HI_PUNISHMENT_INFO:
//            case MR_OWN_TAX:
//                newData = queryBaseData(searchBO);
//                break;
//            case MR_TAX_CONTRAVENTION_BASE:
//                newData = queryBaseTwoDepthTwoParamsData(searchBO,TianYanChaUrlEnum.MR_TAX_CONTRAVENTION_LIST,TianYanChaUrlEnum.MR_TAX_CONTRAVENTION_DETAIL,"id",null);
//                break;
//            case MR_ABNORMAL:
//            case HI_ABNORMAL:
//            case MR_ILLEGALINFO:
//            case MR_LIQUIDATING:
//            case MR_BRIEF_CANCEL:
//            case MR_INQUIRY_EVALUATION:
//            case MR_JUDICIAL_SALE:
//            case PUBLIC_NOTICE:
//            case MR_MORTGAGE_INFO:
//            case HI_MORTGAGE_INFO:
//                newData = queryBaseData(searchBO);
//                break;
//            case MR_LAND_MORTGAGE_BASE:
//                newData = queryBaseTwoDepthTwoParamsData(searchBO,TianYanChaUrlEnum.MR_LAND_MORTGAGE_LIST,TianYanChaUrlEnum.MR_LAND_MORTGAGE_DETAIL,"id",null);
//                break;
//            case GET_PLEDGE_REG:
//            case MR_EQUITY_INFO:
//            case HI_EQUITY_INFO:
//                newData = queryBaseData(searchBO);
//                break;
//            case MR_STOCK_PLEDGE_BASE:
//                newData = queryBaseTwoDepthTwoParamsData(searchBO,TianYanChaUrlEnum.MR_STOCK_PLEDGE_LIST,TianYanChaUrlEnum.MR_STOCK_PLEDGE_DETAIL,"businessId","graphId");
//                break;
//            case MR_STOCK_PLEDGE_SHAREHOLDER_BASE:
//                newData = queryBaseTwoDepthTwoParamsData(searchBO,TianYanChaUrlEnum.MR_STOCK_PLEDGE_SHAREHOLDER_LIST,TianYanChaUrlEnum.MR_STOCK_PLEDGE_SHAREHOLDER_DETAIL,"businessId","graphId");
//                break;
//            case MR_STOCK_PLEDGE_RATIO:
//            case MR_STOCK_PLEDGE_TREND:
//                newData = queryBaseData(searchBO);
//                break;
//            case HUMAN_COMPANYHOLDING_BASE:
//                newData = queryBasetthirdDepthUserData(searchBO,TianYanChaUrlEnum.IC_BASEINFO_V3_LIST,TianYanChaUrlEnum.HUMAN_COMPANYHOLDING_DETAIL,"hid","cid");
//                break;
//            case ROLES_BASE:
//                newData = queryBasetthirdDepthUserData(searchBO,TianYanChaUrlEnum.IC_BASEINFO_V3_LIST,TianYanChaUrlEnum.ROLES_DETAIL,"hid","cid");
//                break;
//            case HI_ROLES_BASE:
//                newData = queryBasetthirdDepthUserData(searchBO,TianYanChaUrlEnum.IC_BASEINFO_V3_LIST,TianYanChaUrlEnum.HI_ROLES_DETAIL,"hid","cid");
//                break;
//            case ALL_COMPANYS_BASE:
//                newData = queryBasetthirdDepthUserData(searchBO,TianYanChaUrlEnum.IC_BASEINFO_V3_LIST,TianYanChaUrlEnum.ALL_COMPANYS_DETAIL,"hid","cid");
//                break;
//            case PARTNERS_BASE:
//                newData = queryBasetthirdDepthUserData(searchBO,TianYanChaUrlEnum.IC_BASEINFO_V3_LIST,TianYanChaUrlEnum.PARTNERS_DETAIL,"hid","cid");
//                break;
//            case ONE_KEY:
//            case EQUITY_RATIO:
//            case INVESTTREE:
//            case IC_HUMANHOLDING:
//            case COMPANYHOLDING:
//            case IC_ACTUAL_CONTROL:
//            case RELA_SHORT_PATH:
//            case GROUP_BASE:
//                newData = queryBaseData(searchBO);
//                break;
//            case GROUP_BASE_DETAILS_BASE:
//                newData = queryBasetTwoRequestData(searchBO,TianYanChaUrlEnum.GROUP_BASE,TianYanChaUrlEnum.GROUP_BASE_DETAILS_DETAIL);
//                break;
//            case GROUP_MEMBER_BASE:
//                newData = queryBasetTwoRequestData(searchBO,TianYanChaUrlEnum.GROUP_BASE,TianYanChaUrlEnum.GROUP_MEMBER_DETAIL);
//                break;
//            case GROUP_INVESTORS_BASE:
//                newData = queryBasetTwoRequestData(searchBO,TianYanChaUrlEnum.GROUP_BASE,TianYanChaUrlEnum.GROUP_INVESTORS_DETAIL);
//                break;
//            case GROUP_INVESTOR_MEMBER:
//                newData = queryBaseData(searchBO);
//                break;
//            case GROUP_SHAREHOLDERS_BASE:
//                newData = queryBasetTwoRequestData(searchBO,TianYanChaUrlEnum.GROUP_BASE,TianYanChaUrlEnum.GROUP_SHAREHOLDERS_DETAIL);
//                break;
//            case GROUP_SHAREHOLDERS_MEMBER:
//                newData = queryBaseData(searchBO);
//                break;
//            case HUMAN_ZHIXINGINFO_BASE:
//                newData = queryBasetthirdDepthUserData(searchBO,TianYanChaUrlEnum.IC_BASEINFO_V3_LIST,TianYanChaUrlEnum.HUMAN_ZHIXINGINFO_DETAIL,"hid","cid");
//                break;
//            case HUMAN_CONSUMPTION_RESTRICTION_BASE:
//                newData = queryBasetthirdDepthUserData(searchBO,TianYanChaUrlEnum.IC_BASEINFO_V3_LIST,TianYanChaUrlEnum.HUMAN_CONSUMPTION_RESTRICTION_DETAIL,"hid","cid");
//                break;
//            case HUMAN_JUDICIAL_ASSISTANCE_BASE:
//                newData = queryBasetthirdDepthUserData(searchBO,TianYanChaUrlEnum.IC_BASEINFO_V3_LIST,TianYanChaUrlEnum.HUMAN_JUDICIAL_ASSISTANCE_DETAIL,"hid","cid");
//                break;
//            case HUMAN_JUDICIAL_ASSISTANCE_DETAIL_BASE:
//                newData = queryBasetFourDepthUserData(searchBO,TianYanChaUrlEnum.IC_BASEINFO_V3_LIST,TianYanChaUrlEnum.HUMAN_JUDICIAL_ASSISTANCE_DETAIL,TianYanChaUrlEnum.HUMAN_JUDICIAL_ASSISTANCE_DETAIL_DETAIL,"hid","cid","assId");
//                break;
//            case HUMAN_END_CASE_BASE:
//                newData = queryBasetthirdDepthUserData(searchBO,TianYanChaUrlEnum.IC_BASEINFO_V3_LIST,TianYanChaUrlEnum.HUMAN_END_CASE_DETAIL,"hid","cid");
//                break;
//            case HUMAN_DISHONEST_BASE:
//                newData = queryBasetthirdDepthUserData(searchBO,TianYanChaUrlEnum.IC_BASEINFO_V3_LIST,TianYanChaUrlEnum.HUMAN_DISHONEST_DETAIL,"hid","cid");
//                break;
//            case OLD_SEARCH:
//            case OLD_IC_BASEINFO_NORMAL:
//            case OLD_IC_CONTACT:
//                newData = queryBaseData(searchBO);
//                break;
//        }
//        return newData;
//    }




    //------------------------------------------获取数据---------------------------------

    /**
     * 集团簇群 需要2次接口获取数据
     * @return { com.kakarote.crm.tianyancha.entity.TianYanChaResult<java.util.Map<java.lang.String,java.lang.Object>>}
     * @author UNIQUE
     * @date 2023/3/9
     */
    private TianYanChaResult<Map<String, Object>> queryBasetTwoRequestData(TianYanChaSearchBO searchBO,TianYanChaUrlEnum fromEnum,TianYanChaUrlEnum fromSubEnum){
        TianYanChaUtil.fillParam(searchBO,TianYanChaUrlEnum.parse(searchBO.getLabel()));
        TianYanChaResult<Map<String, Object>> oldData = searchMysqlData(searchBO);
        if (ObjectUtil.isNotEmpty(oldData.getResult())) {
            return oldData;
        }
        //获取法律诉讼列表
        TianYanChaSearchBO subList = BeanUtil.copyProperties(searchBO, TianYanChaSearchBO.class);
        subList.setLoopFlag(0);
        subList.setLabel(fromEnum.getLabel());
        subList.setPageNum(null);
        subList.setPageSize(null);
        TianYanChaResult<Map<String, Object>> baseList = queryBaseData(subList);
        List<Map<String,Object>> subRetList = new ArrayList<>();
        if (ObjectUtil.isNotEmpty(baseList.getResult())) {
            TianYanChaSearchBO subDetail = BeanUtil.copyProperties(searchBO, TianYanChaSearchBO.class);
            subDetail.setKeyword(null);
            subDetail.setLabel(fromSubEnum.getLabel());
            subDetail.setUuid(baseList.getResult().get("groupUUID").toString());
            TianYanChaResult<Map<String, Object>> subDetailRet = queryBaseData(subDetail);
            subRetList.add(subDetailRet.getResult());
        }
        baseList.getResult().put("otherItems",subRetList);
        insertMysqlData(searchBO,baseList);
        return baseList;
    }

    /**
     * 员工信息 需要从企业主要员工信息 来获取后续的信息
     * @return { com.kakarote.crm.tianyancha.entity.TianYanChaResult<java.util.Map<java.lang.String,java.lang.Object>>}
     * @author UNIQUE
     * @date 2023/3/9
     */
    private TianYanChaResult<Map<String, Object>> queryBasetthirdDepthUserData(TianYanChaSearchBO searchBO,TianYanChaUrlEnum fromEnum,TianYanChaUrlEnum fromSubEnum,String relationkey,String relationkey2){
        TianYanChaUtil.fillParam(searchBO,TianYanChaUrlEnum.parse(searchBO.getLabel()));
        TianYanChaResult<Map<String, Object>> oldData = searchMysqlData(searchBO);
        if (ObjectUtil.isNotEmpty(oldData.getResult())) {
            return oldData;
        }
        //获取法律诉讼列表
        TianYanChaSearchBO subList = BeanUtil.copyProperties(searchBO, TianYanChaSearchBO.class);
        subList.setLoopFlag(0);
        subList.setLabel(fromEnum.getLabel());
        subList.setPageNum(null);
        subList.setPageSize(null);
        TianYanChaResult<Map<String, Object>> baseList = queryBaseData(subList);
        Map<String, Object> result = baseList.getResult();
        if (ObjectUtil.isNotEmpty(result)) {
            JSONObject items = JSON.parseObject(result.get("staffList").toString());
            JSONArray taskList = items.getJSONArray("result");
            List<JSONObject> zhenghe = new ArrayList<>();
            for (Object t : taskList) {
                JSONObject b = (JSONObject) t;
                if (2!=b.getIntValue("type")) {
                    continue;
                }
                TianYanChaSearchBO subDetail = BeanUtil.copyProperties(searchBO, TianYanChaSearchBO.class);
                subDetail.setKeyword(null);
                subDetail.setLabel(fromSubEnum.getLabel());
                if ("hid".equals(relationkey)) {
                    subDetail.setHid(b.getString("id"));
                }
                if ("cid".equals(relationkey2)) {
                    subDetail.setCid(result.get("id").toString());
                }
                TianYanChaResult<Map<String, Object>> subDetailRet = queryBaseData(subDetail);
                b.put("otherItems",subDetailRet.getResult());
                zhenghe.add(b);
            }
            result.put("otherItems",zhenghe);
        }
        insertMysqlData(searchBO,baseList);
        return baseList;
    }

    private TianYanChaResult<Map<String, Object>> queryBasetFourDepthUserData(TianYanChaSearchBO searchBO, TianYanChaUrlEnum fromEnum, TianYanChaUrlEnum fromSubEnum, TianYanChaUrlEnum thirdEnum,String relationkey, String relationkey2, String relationkey3) {
        TianYanChaUtil.fillParam(searchBO,TianYanChaUrlEnum.parse(searchBO.getLabel()));
        TianYanChaResult<Map<String, Object>> oldData = searchMysqlData(searchBO);
        if (ObjectUtil.isNotEmpty(oldData.getResult())) {
            return oldData;
        }
        //获取法律诉讼列表
        TianYanChaSearchBO subList = BeanUtil.copyProperties(searchBO, TianYanChaSearchBO.class);
        subList.setLoopFlag(0);
        subList.setLabel(fromEnum.getLabel());
        subList.setPageNum(null);
        subList.setPageSize(null);
        TianYanChaResult<Map<String, Object>> baseList = queryBaseData(subList);
        Map<String, Object> result = baseList.getResult();
        if (ObjectUtil.isNotEmpty(result)) {
            JSONObject items = JSON.parseObject(result.get("staffList").toString());
            JSONArray taskList = items.getJSONArray("result");
            List<JSONObject> zhenghe = new ArrayList<>();
            for (Object t : taskList) {
                JSONObject b = (JSONObject) t;
                if (2!=b.getIntValue("type")) {
                    continue;
                }
                TianYanChaSearchBO subDetail = BeanUtil.copyProperties(searchBO, TianYanChaSearchBO.class);
                subDetail.setKeyword(null);
                subDetail.setLabel(fromSubEnum.getLabel());
                if ("hid".equals(relationkey)) {
                    subDetail.setHid(b.getString("id"));
                }
                if ("cid".equals(relationkey2)) {
                    subDetail.setCid(result.get("id").toString());
                }
                TianYanChaResult<Map<String, Object>> subDetailRet = queryBaseData(subDetail);
                //获取人员详情
                Map<String, Object> result1 = subDetailRet.getResult();
                if (ObjectUtil.isNotEmpty(subDetailRet)) {
                    JSONArray items1 = JSON.parseArray(result1.get("items").toString());
                    for (Object d : items1) {
                        JSONObject detail = (JSONObject) d;
                        TianYanChaSearchBO thirdSearch = BeanUtil.copyProperties(searchBO, TianYanChaSearchBO.class);
                        thirdSearch.setKeyword(null);
                        thirdSearch.setLabel(thirdEnum.getLabel());
                        thirdSearch.setAssistanceId(detail.getString(relationkey3));
                        TianYanChaResult<Map<String, Object>> thirdDetailRet = queryBaseData(thirdSearch);
                        result1.put("otherItems",thirdDetailRet.getResult());
                    }
                }

                b.put("otherItems", result1);
                zhenghe.add(b);
            }
            result.put("otherItems",zhenghe);
        }
        insertMysqlData(searchBO,baseList);
        return baseList;
    }

    /**
     * 双随机抽查, 上级接口返回数据是2层结构中的  数据来获取后续详情
     * @return { com.kakarote.crm.tianyancha.entity.TianYanChaResult<java.util.Map<java.lang.String,java.lang.Object>>}
     * @author UNIQUE
     * @date 2023/3/9
     */
    private TianYanChaResult<Map<String, Object>> queryBasetthirdDepthData(TianYanChaSearchBO searchBO,TianYanChaUrlEnum fromEnum,TianYanChaUrlEnum fromSubEnum,String relationkey,String relationkey2){
        TianYanChaUtil.fillParam(searchBO,TianYanChaUrlEnum.parse(searchBO.getLabel()));
        TianYanChaResult<Map<String, Object>> oldData = searchMysqlData(searchBO);
        if (ObjectUtil.isNotEmpty(oldData.getResult())) {
            return oldData;
        }
        //获取法律诉讼列表
        TianYanChaSearchBO subList = BeanUtil.copyProperties(searchBO, TianYanChaSearchBO.class);
        subList.setLabel(fromEnum.getLabel());
        TianYanChaResult<Map<String, Object>> baseList = queryBaseData(subList);
        List<Map<String,Object>> subRetList = new ArrayList<>();
        Map<String, Object> result = baseList.getResult();
        if (ObjectUtil.isNotEmpty(result)) {
            JSONArray items = JSON.parseArray(result.get("items").toString());
            List<JSONObject> zhenghe = new ArrayList<>();
            for (Object r : items) {
                JSONObject i = (JSONObject) r;
                JSONArray taskList = i.getJSONArray("taskList");
                for (Object t : taskList) {
                    JSONObject b = (JSONObject) t;
                    TianYanChaSearchBO subDetail = BeanUtil.copyProperties(searchBO, TianYanChaSearchBO.class);
                    subDetail.setKeyword(null);
                    subDetail.setLabel(fromSubEnum.getLabel());
                    if ("businessId".equals(relationkey)) {
                        subDetail.setBusinessId(b.getString(relationkey));
                    }
                    TianYanChaResult<Map<String, Object>> subDetailRet = queryBaseData(subDetail);
//                    subRetList.add(subDetailRet.getResult());
                    b.put("otherItems",subDetailRet.getResult());
                    zhenghe.add(b);
                }
            }
            result.put("otherItems",zhenghe);
        }
//        baseList.getResult().put("items",subRetList);
        insertMysqlData(searchBO,baseList);
        return baseList;
    }

    /**
     *
     * @return { com.kakarote.crm.tianyancha.entity.TianYanChaResult<java.util.Map<java.lang.String,java.lang.Object>>}
     * @author UNIQUE
     * @date 2023/3/9
     */
    private TianYanChaResult<Map<String, Object>> queryBaseTwoDepthTwoParamsData(TianYanChaSearchBO searchBO,TianYanChaUrlEnum fromEnum,TianYanChaUrlEnum fromSubEnum,String relationkey,String relationkey2){
        TianYanChaUtil.fillParam(searchBO,TianYanChaUrlEnum.parse(searchBO.getLabel()));
        TianYanChaResult<Map<String, Object>> oldData = searchMysqlData(searchBO);
        if (ObjectUtil.isNotEmpty(oldData.getResult())) {
            return oldData;
        }
        //获取法律诉讼列表
        TianYanChaSearchBO subList = BeanUtil.copyProperties(searchBO, TianYanChaSearchBO.class);
        subList.setLabel(fromEnum.getLabel());
        TianYanChaResult<Map<String, Object>> baseList = queryBaseData(subList);
        List<Map<String,Object>> subRetList = new ArrayList<>();
        Map<String, Object> result = baseList.getResult();
        if (ObjectUtil.isNotEmpty(result)) {
            JSONArray items = JSON.parseArray(result.get("items").toString());
            List<JSONObject> zhenghe = new ArrayList<>();
            for (Object r : items) {
                JSONObject i = (JSONObject) r;
                TianYanChaSearchBO subDetail = BeanUtil.copyProperties(searchBO, TianYanChaSearchBO.class);
                subDetail.setKeyword(null);
                subDetail.setLabel(fromSubEnum.getLabel());
                if ("uuid".equals(relationkey)) {
                    subDetail.setUuid(i.getString(relationkey));
                }else if ("id".equals(relationkey)) {
                    subDetail.setId(i.getString(relationkey));
                }else if ("businessId".equals(relationkey)) {
                    subDetail.setBusinessId(i.getString(relationkey));
                }else if ("groupUUID".equals(relationkey)) {
                    subDetail.setUuid(i.getString(relationkey));
                }
                if ("gid".equals(relationkey2)) {
                    subDetail.setGid(result.get(relationkey2).toString());
                }else if ("graphId".equals(relationkey2)) {
                    subDetail.setId(i.getString(relationkey2));
                }
                TianYanChaResult<Map<String, Object>> subDetailRet = queryBaseData(subDetail);
//                subRetList.add(subDetailRet.getResult());
                i.put("otherItems",subDetailRet.getResult());
                zhenghe.add(i);
            }
            result.put("otherItems",zhenghe);
        }
//        baseList.getResult().put("items",subRetList);
        insertMysqlData(searchBO,baseList);
        return baseList;
    }



    /**
     * 查询基础数据 并存储 db  或者更新
     * @return { com.kakarote.crm.tianyancha.entity.TianYanChaResult<java.util.Map<java.lang.String,java.lang.Object>>}
     * @throws
     * @author UNIQUE
     * @date 2023/3/8
     */
    private TianYanChaResult<Map<String, Object>> queryBaseData(TianYanChaSearchBO searchBO){
        TianYanChaUrlEnum itemEnum = TianYanChaUrlEnum.parse(searchBO.getLabel());
        //补全基础信息
        TianYanChaUtil.fillParam(searchBO,itemEnum);
//        //todo: 补充详情获取全部
//        if (Arrays.asList(TianYanChaUrlEnum.HUMAN_COMPANYHOLDING_DETAIL,
//                TianYanChaUrlEnum.ROLES_DETAIL,
//                TianYanChaUrlEnum.HI_ROLES_DETAIL,
//                TianYanChaUrlEnum.ALL_COMPANYS_DETAIL,
//                TianYanChaUrlEnum.PARTNERS_DETAIL,
//                TianYanChaUrlEnum.HUMAN_ZHIXINGINFO_DETAIL,
//                TianYanChaUrlEnum.HUMAN_CONSUMPTION_RESTRICTION_DETAIL,
//                TianYanChaUrlEnum.HUMAN_JUDICIAL_ASSISTANCE_DETAIL,
//                TianYanChaUrlEnum.HUMAN_END_CASE_DETAIL,
//                TianYanChaUrlEnum.HUMAN_DISHONEST_DETAIL).contains(itemEnum)) {
//            searchBO.setLoopFlag(1);
//        }
        //是否循环调用
        if (searchBO.getLoopFlag().equals(1)) {
            TianYanChaSearchBO loopSearch = BeanUtil.copyProperties(searchBO, TianYanChaSearchBO.class);
            loopSearch.setLoopFlag(0);
            TianYanChaResult<Map<String, Object>> loopData = queryBaseData(loopSearch);
            if (ObjectUtil.isNotEmpty(loopData.getResult())) {
                JSONObject ret = JSONObject.parseObject(loopData.getResult().toString());
                int currentTotal = (loopSearch.getPageNum()-1)* loopSearch.getPageSize()+ret.getJSONArray("items").size();
                while (ret.getIntValue("total") > currentTotal){
                    loopSearch.setPageNum(loopSearch.getPageNum()+1);
                    TianYanChaResult<Map<String, Object>> appendData = queryBaseData(loopSearch);
                    JSONObject loopRet1 = JSONObject.parseObject(appendData.getResult().toString());
                    ret.getJSONArray("items").addAll(loopRet1.getJSONArray("items"));
                }
                // 插入db
                insertMysqlData(searchBO,loopData);
            }
            return loopData;
        }else{
            TianYanChaResult<Map<String, Object>> oldData = searchMysqlData(searchBO);
            if (ObjectUtil.isNotEmpty(oldData.getResult())) {
                return oldData;
            }
            TianYanChaResult<Map<String, Object>> newData = tianYanChaUtil.doGet(searchBO);
            // 插入db
            insertMysqlData(searchBO,newData);
            return newData;
        }
    }


    /**
     * 查询mysql中缓存的数据
     * @return { com.kakarote.crm.tianyancha.entity.TianYanChaResult<java.util.Map<java.lang.String,java.lang.Object>>}
     * @throws
     * @author UNIQUE
     * @date 2023/3/7
     */
    private TianYanChaResult<Map<String, Object>> searchMysqlData(TianYanChaSearchBO searchBO){
        if (!searchBO.getUpdateFlag().equals(1)) {
//            List<CrmTianyancha> had = iCrmTianyanchaService.queryHadData(searchBO);
            List<CrmTianyancha> had = new ArrayList<>();
            if (CollectionUtil.isNotEmpty(had)) {
                return JSON.parseObject(had.get(0).getParamReturn(),TianYanChaResult.class);
            }
        }
        return TianYanChaResult.ok();
    }

    /**
     * 保存天眼查数据到db里
     * @return { void}
     * @throws
     * @author UNIQUE
     * @date 2023/3/7
     */
    private void insertMysqlData(TianYanChaSearchBO searchBO, TianYanChaResult<Map<String, Object>> oldData){
        if (TianYanChaErrorCodeEnum.rightCode().contains(oldData.getError_code())) {
            LambdaQueryWrapper<CrmTianyancha> qw = new LambdaQueryWrapper<>();
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getName()), CrmTianyancha::getName, searchBO.getName());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getGroupId()), CrmTianyancha::getGroupId, searchBO.getGroupId());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getCustomerId()), CrmTianyancha::getCustomerId, searchBO.getCustomerId());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getLoopFlag()), CrmTianyancha::getLoopFlag, searchBO.getLoopFlag());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getUrl()), CrmTianyancha::getParamUrl, searchBO.getUrl());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getWord()), CrmTianyancha::getParamWord, searchBO.getWord());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getPageNum()), CrmTianyancha::getParamPageNum, searchBO.getPageNum());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getPageSize()), CrmTianyancha::getParamPageSize, searchBO.getPageSize());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getKeyword()), CrmTianyancha::getParamKeyword, searchBO.getKeyword());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getPublishStartTime()), CrmTianyancha::getParamPublishStartTime, searchBO.getPublishStartTime());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getPublishEndTime()), CrmTianyancha::getParamPublishEndTime, searchBO.getPublishEndTime());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getProvince()), CrmTianyancha::getParamProvince, searchBO.getProvince());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getType()), CrmTianyancha::getParamType, searchBO.getType());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getCid()), CrmTianyancha::getParamCid, searchBO.getCid());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getHumanName()), CrmTianyancha::getParamHumanName, searchBO.getHumanName());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getUuid()), CrmTianyancha::getParamUuid, searchBO.getUuid());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getId()), CrmTianyancha::getParamId, searchBO.getId());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getName()), CrmTianyancha::getParamName, searchBO.getName());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getFlag()), CrmTianyancha::getParamFlag, searchBO.getFlag());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getDir()), CrmTianyancha::getParamDir, searchBO.getDir());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getAssistanceId()), CrmTianyancha::getParamAssistanceId, searchBO.getAssistanceId());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getGid()), CrmTianyancha::getParamGid, searchBO.getGid());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getBusinessId()), CrmTianyancha::getParamBusinessId, searchBO.getBusinessId());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getYear()), CrmTianyancha::getParamYear, searchBO.getYear());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getDate()), CrmTianyancha::getParamDate, searchBO.getDate());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getHid()), CrmTianyancha::getParamHid, searchBO.getHid());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getTypes()), CrmTianyancha::getParamTypes, searchBO.getTypes());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getDepth()), CrmTianyancha::getParamDepth, searchBO.getDepth());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getIdTo()), CrmTianyancha::getParamIdTo, searchBO.getIdTo());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getNameTo()), CrmTianyancha::getParamNameTo, searchBO.getNameTo());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getIdFrom()), CrmTianyancha::getParamIdFrom, searchBO.getIdFrom());
            qw.eq(ObjectUtil.isNotEmpty(searchBO.getNameFrom()), CrmTianyancha::getParamNameFrom, searchBO.getNameFrom());
            //做清理旧的操作
//            iCrmTianyanchaService.remove(qw);

            //添加新的
            CrmTianyancha item = new CrmTianyancha();
            item.setName(searchBO.getName());
            item.setGroupId(searchBO.getGroupId());
            item.setCustomerId(searchBO.getCustomerId());
            item.setLoopFlag(searchBO.getLoopFlag());
            item.setStatus(0);
            item.setParamUrl(searchBO.getUrl());
            item.setParamWord(searchBO.getWord());
            item.setParamPageNum(searchBO.getPageNum());
            item.setParamPageSize(searchBO.getPageSize());
            item.setParamKeyword(searchBO.getKeyword());
            item.setParamPublishStartTime(searchBO.getPublishStartTime());
            item.setParamPublishEndTime(searchBO.getPublishEndTime());
            item.setParamProvince(searchBO.getProvince());
            item.setParamType(searchBO.getType());
            item.setParamCid(searchBO.getCid());
            item.setParamHumanName(searchBO.getHumanName());
            item.setParamUuid(searchBO.getUuid());
            item.setParamId(searchBO.getId());
            item.setParamName(searchBO.getName());
            item.setParamFlag(searchBO.getFlag());
            item.setParamDir(searchBO.getDir());
            item.setParamAssistanceId(searchBO.getAssistanceId());
            item.setParamGid(searchBO.getGid());
            item.setParamBusinessId(searchBO.getBusinessId());
            item.setParamYear(searchBO.getYear());
            item.setParamDate(searchBO.getDate());
            item.setParamHid(searchBO.getHid());
            item.setParamTypes(searchBO.getTypes());
            item.setParamDepth(searchBO.getDepth());
            item.setParamIdTo(searchBO.getIdTo());
            item.setParamNameTo(searchBO.getNameTo());
            item.setParamIdFrom(searchBO.getIdFrom());
            item.setParamNameFrom(searchBO.getNameFrom());
            item.setParamReturn(JSONObject.toJSONString(oldData));
            item.setCreateTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());
//            iCrmTianyanchaService.save(item);
        }
    }
}
