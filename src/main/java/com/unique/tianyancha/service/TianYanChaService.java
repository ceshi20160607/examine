package com.unique.tianyancha.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.unique.tianyancha.entity.bo.TianYanChaSearchBO;
import com.unique.tianyancha.entity.po.CrmTianyancha;
import com.unique.tianyancha.entity.TianYanChaResult;
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

    public TianYanChaResult<Map<String, Object>> queryData(TianYanChaSearchBO searchBO) {
        return buildData(searchBO);
    }

    public TianYanChaResult<Map<String, Object>> icBaseinfo(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(1);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> icStaff(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(2);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> icHolder(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(3);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> icHolderList(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(4);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> icHolderChange(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(5);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> icInverst(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(6);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> icBranch(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(7);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> icParentCompany(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(8);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> icChangeinfo(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(9);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> jrJudicialCase(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(10);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> jrLawSult(TianYanChaSearchBO searchBO) {


        searchBO.setLabel(11);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> jrKtannouncement(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(12);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> jrCourtRegister(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(13);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> getJudiciaDetail(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(14);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> jrBankruptcy(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(15);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> jrZhixinginfo(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(16);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mGetLicense(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(17);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mCheckInfo(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(18);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mDoubleRandomCheckDetail(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(19);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mPurchaseLand(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(20);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mSupply(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(21);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mCustomer(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(22);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mBids(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(23);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mLandTransfer(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(24);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrPunishmentInfo(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(25);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> hiPunishmentInfo(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(26);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrOwnTax(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(27);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrTaxContravention(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(28);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrAbnormal(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(29);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> hiAbnormal(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(30);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrIllegalinfo(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(31);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrLiquidating(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(32);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrBriefCancel(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(33);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrInquiryEvaluation(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(34);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrJudicialSale(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(35);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> publicNotice(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(36);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrMortgageInfo(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(37);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> hiMortgageInfo(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(38);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrLandMortgage(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(39);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> getPledgeReg(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(40);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrEquityInfo(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(41);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> hiEquityInfo(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(42);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrStockPledge(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(43);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrStockPledgeShareholder(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(44);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrStockPledgeRatio(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(45);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> mrStockPledgeTrend(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(46);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> humanCompanyholding(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(47);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> roles(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(48);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> hiRoles(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(49);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> allCompanys(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(50);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> partners(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(51);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> oneKey(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(52);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> equityRatio(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(53);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> investtree(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(54);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> icHumanholding(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(55);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> companyholding(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(56);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> icActualControl(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(57);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> relaShortPath(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(58);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> groupBase(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(59);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> groupBaseDetails(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(60);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> groupMember(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(61);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> groupInvestors(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(62);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> groupInvestorMember(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(63);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> groupShareholders(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(64);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> groupShareholdersMember(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(65);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> humanZhixinginfo(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(66);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> humanConsumptionRestriction(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(67);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> humanJudicialAssistance(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(68);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> humanJudicialAssistanceDetail(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(69);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> humanEndCase(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(70);
        return buildData(searchBO);
    }
    public TianYanChaResult<Map<String, Object>> humanDishonest(TianYanChaSearchBO searchBO) {
        searchBO.setLabel(71);
        return buildData(searchBO);
    }




    //------------------------------------------获取数据---------------------------------
    /**
     *
     * @return { com.kakarote.crm.entity.tianyancha.TianYanChaResult<java.util.Map<java.lang.String,java.lang.Object>>}
     * @throws
     * @author UNIQUE
     * @date 2023/3/7
     */
    @SneakyThrows
    private TianYanChaResult<Map<String, Object>> buildData(TianYanChaSearchBO searchBO) {
        TianYanChaUrlEnum itemEnum = TianYanChaUrlEnum.parse(searchBO.getLabel());
        TianYanChaResult<Map<String, Object>> newData = null;
//        CrmCustomer byId = null;
        switch (itemEnum){
            case OLD_SEARCH:
            case OLD_IC_BASEINFO_NORMAL:
            case OLD_IC_CONTACT:
            case IC_BASEINFO:
            case IC_PARENT_COMPANY:
                newData = queryBaseData(searchBO);
                break;
            case IC_STAFF:
            case IC_HOLDER:
            case IC_HOLDER_LIST:
            case IC_HOLDER_CHANGE:
            case IC_INVERST:
            case IC_BRANCH:
            case IC_CHANGEINFO:
            case JR_JUDICIAL_CASE:
            case JR_KTANNOUNCEMENT:
            case JR_COURT_REGISTER:
                newData = queryBaseData(searchBO);
                break;
            case JR_LAW_SULT_BASE:
                newData = queryBaseTwoDepthTwoParamsData(searchBO,TianYanChaUrlEnum.JR_LAW_SULT_LIST,TianYanChaUrlEnum.JR_LAW_SULT_DETAIL,"uuid",null);
                break;
            case GET_JUDICIA_DETAIL:
                newData = queryBaseTwoDepthTwoParamsData(searchBO,TianYanChaUrlEnum.GET_JUDICIA_LIST,TianYanChaUrlEnum.GET_JUDICIA_DETAIL,"id",null);
                break;
            case JR_BANKRUPTCY_BASE:
                newData = queryBaseTwoDepthTwoParamsData(searchBO,TianYanChaUrlEnum.JR_BANKRUPTCY_List,TianYanChaUrlEnum.JR_BANKRUPTCY_DETAIL,"uuid","gid");
                break;
            case JR_ZHIXINGINFO:
            case M_GET_LICENSE:
            case M_CHECK_INFO:
                newData = queryBaseData(searchBO);
                break;
            case M_DOUBLE_RANDOM_CHECK_DETAIL_BASE:
                newData = queryBasetthirdDepthData(searchBO,TianYanChaUrlEnum.M_DOUBLE_RANDOM_CHECK_DETAIL_LIST,TianYanChaUrlEnum.M_DOUBLE_RANDOM_CHECK_DETAIL_DETAIL,"businessId",null);
                break;
            case M_PURCHASE_LAND:
            case M_SUPPLY:
            case M_CUSTOMER:
            case M_BIDS:
            case M_LAND_TRANSFER:
            case MR_PUNISHMENT_INFO:
            case HI_PUNISHMENT_INFO:
            case MR_OWN_TAX:
                newData = queryBaseData(searchBO);
                break;
            case MR_TAX_CONTRAVENTION_BASE:
                newData = queryBaseTwoDepthTwoParamsData(searchBO,TianYanChaUrlEnum.MR_TAX_CONTRAVENTION_LIST,TianYanChaUrlEnum.MR_TAX_CONTRAVENTION_DETAIL,"id",null);
                break;
            case MR_ABNORMAL:
            case HI_ABNORMAL:
            case MR_ILLEGALINFO:
            case MR_LIQUIDATING:
            case MR_BRIEF_CANCEL:
            case MR_INQUIRY_EVALUATION:
            case MR_JUDICIAL_SALE:
            case PUBLIC_NOTICE:
            case MR_MORTGAGE_INFO:
            case HI_MORTGAGE_INFO:
                newData = queryBaseData(searchBO);
                break;
            case MR_LAND_MORTGAGE_BASE:
                newData = queryBaseTwoDepthTwoParamsData(searchBO,TianYanChaUrlEnum.MR_LAND_MORTGAGE_LIST,TianYanChaUrlEnum.MR_LAND_MORTGAGE_DETAIL,"id",null);
                break;
            case GET_PLEDGE_REG:
            case MR_EQUITY_INFO:
            case HI_EQUITY_INFO:
                newData = queryBaseData(searchBO);
                break;
            case MR_STOCK_PLEDGE_BASE:
                newData = queryBaseTwoDepthTwoParamsData(searchBO,TianYanChaUrlEnum.MR_STOCK_PLEDGE_LIST,TianYanChaUrlEnum.MR_STOCK_PLEDGE_DETAIL,"businessId","graphId");
                break;
            case MR_STOCK_PLEDGE_SHAREHOLDER_BASE:
                newData = queryBaseTwoDepthTwoParamsData(searchBO,TianYanChaUrlEnum.MR_STOCK_PLEDGE_SHAREHOLDER_LIST,TianYanChaUrlEnum.MR_STOCK_PLEDGE_SHAREHOLDER_DETAIL,"businessId","graphId");
                break;
            case MR_STOCK_PLEDGE_RATIO:
            case MR_STOCK_PLEDGE_TREND:
                newData = queryBaseData(searchBO);
                break;
            case HUMAN_COMPANYHOLDING_BASE:
                newData = queryBasetthirdDepthUserData(searchBO,TianYanChaUrlEnum.IC_BASEINFO_V3_LIST,TianYanChaUrlEnum.HUMAN_COMPANYHOLDING_DETAIL,"hid","cid");
                break;
            case ROLES_BASE:
                newData = queryBasetthirdDepthUserData(searchBO,TianYanChaUrlEnum.IC_BASEINFO_V3_LIST,TianYanChaUrlEnum.ROLES_DETAIL,"hid","cid");
                break;
            case HI_ROLES_BASE:
                newData = queryBasetthirdDepthUserData(searchBO,TianYanChaUrlEnum.IC_BASEINFO_V3_LIST,TianYanChaUrlEnum.HI_ROLES_DETAIL,"hid","cid");
                break;
            case ALL_COMPANYS_BASE:
                newData = queryBasetthirdDepthUserData(searchBO,TianYanChaUrlEnum.IC_BASEINFO_V3_LIST,TianYanChaUrlEnum.ALL_COMPANYS_DETAIL,"hid","cid");
                break;
            case PARTNERS_BASE:
                newData = queryBasetthirdDepthUserData(searchBO,TianYanChaUrlEnum.IC_BASEINFO_V3_LIST,TianYanChaUrlEnum.PARTNERS_DETAIL,"hid","cid");
                break;
            case ONE_KEY:
            case EQUITY_RATIO:
            case INVESTTREE:
            case IC_HUMANHOLDING:
            case COMPANYHOLDING:
            case IC_ACTUAL_CONTROL:
            case RELA_SHORT_PATH:
            case GROUP_BASE:
                newData = queryBaseData(searchBO);
                break;
            case GROUP_BASE_DETAILS_BASE:
                newData = queryBasetTwoRequestData(searchBO,TianYanChaUrlEnum.GROUP_BASE,TianYanChaUrlEnum.GROUP_BASE_DETAILS_DETAIL);
                break;
            case GROUP_MEMBER_BASE:
                newData = queryBasetTwoRequestData(searchBO,TianYanChaUrlEnum.GROUP_BASE,TianYanChaUrlEnum.GROUP_MEMBER_DETAIL);
                break;
            case GROUP_INVESTORS_BASE:
                newData = queryBasetTwoRequestData(searchBO,TianYanChaUrlEnum.GROUP_BASE,TianYanChaUrlEnum.GROUP_INVESTORS_DETAIL);
                break;
            case GROUP_INVESTOR_MEMBER_BASE:
                searchBO.setLoopFlag(1);
                newData = queryBasetThirdRequestData(searchBO,TianYanChaUrlEnum.GROUP_BASE,TianYanChaUrlEnum.GROUP_INVESTORS_DETAIL,TianYanChaUrlEnum.GROUP_INVESTOR_MEMBER_DETAIL);
                break;
            case GROUP_SHAREHOLDERS_BASE:
                newData = queryBasetTwoRequestData(searchBO,TianYanChaUrlEnum.GROUP_BASE,TianYanChaUrlEnum.GROUP_SHAREHOLDERS_DETAIL);
                break;
            case GROUP_SHAREHOLDERS_MEMBER_BASE:
                searchBO.setLoopFlag(1);
                newData = queryBasetThirdRequestData(searchBO,TianYanChaUrlEnum.GROUP_BASE,TianYanChaUrlEnum.GROUP_INVESTORS_DETAIL,TianYanChaUrlEnum.GROUP_SHAREHOLDERS_MEMBER_DETAIL);
                break;
            case HUMAN_ZHIXINGINFO_BASE:
                newData = queryBasetthirdDepthUserData(searchBO,TianYanChaUrlEnum.IC_BASEINFO_V3_LIST,TianYanChaUrlEnum.HUMAN_ZHIXINGINFO_DETAIL,"hid","cid");
                break;
            case HUMAN_CONSUMPTION_RESTRICTION_BASE:
                newData = queryBasetthirdDepthUserData(searchBO,TianYanChaUrlEnum.IC_BASEINFO_V3_LIST,TianYanChaUrlEnum.HUMAN_CONSUMPTION_RESTRICTION_DETAIL,"hid","cid");
                break;
            case HUMAN_JUDICIAL_ASSISTANCE_BASE:
                newData = queryBasetthirdDepthUserData(searchBO,TianYanChaUrlEnum.IC_BASEINFO_V3_LIST,TianYanChaUrlEnum.HUMAN_JUDICIAL_ASSISTANCE_DETAIL,"hid","cid");
                break;
            case HUMAN_JUDICIAL_ASSISTANCE_DETAIL_BASE:
                newData = queryBasetthirdDepthUserData(searchBO,TianYanChaUrlEnum.IC_BASEINFO_V3_LIST,TianYanChaUrlEnum.HUMAN_JUDICIAL_ASSISTANCE_DETAIL_DETAIL,"hid","cid");
                break;
            case HUMAN_END_CASE_BASE:
                newData = queryBasetthirdDepthUserData(searchBO,TianYanChaUrlEnum.IC_BASEINFO_V3_LIST,TianYanChaUrlEnum.HUMAN_END_CASE_DETAIL,"hid","cid");
                break;
            case HUMAN_DISHONEST_BASE:
                newData = queryBasetthirdDepthUserData(searchBO,TianYanChaUrlEnum.IC_BASEINFO_V3_LIST,TianYanChaUrlEnum.HUMAN_DISHONEST_DETAIL,"hid","cid");
                break;
        }
        return newData;
    }
    /**
     * 集团簇群  需要3次才能获取数据，还要涉及多层分页问题
     * @return { com.kakarote.crm.entity.tianyancha.TianYanChaResult<java.util.Map<java.lang.String,java.lang.Object>>}
     * @author UNIQUE
     * @date 2023/3/9
     */
    private TianYanChaResult<Map<String, Object>> queryBasetThirdRequestData(TianYanChaSearchBO searchBO,TianYanChaUrlEnum fromEnum,TianYanChaUrlEnum fromSubEnum,TianYanChaUrlEnum fromThirdEnum){
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
            String groupUUID = baseList.getResult().get("groupUUID").toString();
            TianYanChaSearchBO subDetail = BeanUtil.copyProperties(searchBO, TianYanChaSearchBO.class);
            subDetail.setKeyword(null);
            subDetail.setLabel(fromSubEnum.getLabel());
            subDetail.setUuid(groupUUID);
//            if (ObjectUtil.isEmpty(subDetail.getPagenum())) {
//                subDetail.setPagenum(1);
//            }
//            if (ObjectUtil.isEmpty(subDetail.getPagesize())) {
//                subDetail.setPagesize(20);
//            }
            TianYanChaResult<Map<String, Object>> subDetailRet = queryBaseData(subDetail);
            if (ObjectUtil.isNotEmpty(subDetailRet.getResult())) {
                JSONArray items = JSON.parseArray(baseList.getResult().get("items").toString());
                for (Object r : items) {
                    Map<String,Object> i = (Map<String, Object>) r;
                    String investorCgid = i.get("investorCgid").toString();
                    TianYanChaSearchBO thirdDetail = BeanUtil.copyProperties(searchBO, TianYanChaSearchBO.class);
                    thirdDetail.setKeyword(null);
                    thirdDetail.setLabel(fromThirdEnum.getLabel());
                    thirdDetail.setUuid(groupUUID);
                    thirdDetail.setId(investorCgid);
                    TianYanChaResult<Map<String, Object>> thirdDetailRet = queryBaseData(thirdDetail);
                    //构建自定义返回结构
                    i.put("items",thirdDetailRet.getResult());
                    subRetList.add(i);
                }
            }
        }
        baseList.getResult().put("items",subRetList);
        insertMysqlData(searchBO,baseList);
        return baseList;
    }

    /**
     * 集团簇群 需要2次接口获取数据
     * @return { com.kakarote.crm.entity.tianyancha.TianYanChaResult<java.util.Map<java.lang.String,java.lang.Object>>}
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
            subList.setKeyword(null);
            subList.setLabel(fromSubEnum.getLabel());
            subDetail.setUuid(baseList.getResult().get("groupUUID").toString());
            TianYanChaResult<Map<String, Object>> subDetailRet = queryBaseData(subDetail);
            subRetList.add(subDetailRet.getResult());
        }
        baseList.getResult().put("items",subRetList);
        insertMysqlData(searchBO,baseList);
        return baseList;
    }

    /**
     * 员工信息 需要从企业主要员工信息 来获取后续的信息
     * @return { com.kakarote.crm.entity.tianyancha.TianYanChaResult<java.util.Map<java.lang.String,java.lang.Object>>}
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
        List<Map<String,Object>> subRetList = new ArrayList<>();
        if (ObjectUtil.isNotEmpty(baseList.getResult())) {
            JSONArray items = JSON.parseArray(baseList.getResult().get("items").toString());
            for (Object r : items) {
                JSONObject i = (JSONObject) r;
                JSONObject staff = i.getJSONObject("staffList");
                JSONArray taskList = staff.getJSONArray("result");
                for (Object t : taskList) {
                    JSONObject b = (JSONObject) t;
                    if (2!=b.getIntValue("type")) {
                        continue;
                    }
                    TianYanChaSearchBO subDetail = BeanUtil.copyProperties(searchBO, TianYanChaSearchBO.class);
                    subList.setKeyword(null);
                    subList.setLabel(fromSubEnum.getLabel());
                    if ("hid".equals(relationkey)) {
                        subDetail.setHid(b.getString("id"));
                    }
                    if ("cid".equals(relationkey)) {
                        subDetail.setCid(i.getString("id"));
                    }
                    TianYanChaResult<Map<String, Object>> subDetailRet = queryBaseData(subDetail);
//                    subRetList.add(subDetailRet.getResult());
                    b.put("otherItems",subDetailRet.getResult());
                }
            }
        }
//        baseList.getResult().put("items",subRetList);
        insertMysqlData(searchBO,baseList);
        return baseList;
    }

    /**
     * 双随机抽查, 上级接口返回数据是2层结构中的  数据来获取后续详情
     * @return { com.kakarote.crm.entity.tianyancha.TianYanChaResult<java.util.Map<java.lang.String,java.lang.Object>>}
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
        if (ObjectUtil.isNotEmpty(baseList.getResult())) {
            JSONArray items = JSON.parseArray(baseList.getResult().get("items").toString());
            for (Object r : items) {
                JSONObject i = (JSONObject) r;
                JSONArray taskList = i.getJSONArray("taskList");
                for (Object t : taskList) {
                    JSONObject b = (JSONObject) t;
                    TianYanChaSearchBO subDetail = BeanUtil.copyProperties(searchBO, TianYanChaSearchBO.class);
                    subList.setKeyword(null);
                    subList.setLabel(fromSubEnum.getLabel());
                    if ("businessId".equals(relationkey)) {
                        subDetail.setBusinessId(b.getString(relationkey));
                    }
                    TianYanChaResult<Map<String, Object>> subDetailRet = queryBaseData(subDetail);
//                    subRetList.add(subDetailRet.getResult());
                    b.put("otherItems",subDetailRet.getResult());
                }
            }
        }
//        baseList.getResult().put("items",subRetList);
        insertMysqlData(searchBO,baseList);
        return baseList;
    }

    /**
     *
     * @return { com.kakarote.crm.entity.tianyancha.TianYanChaResult<java.util.Map<java.lang.String,java.lang.Object>>}
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
        if (ObjectUtil.isNotEmpty(baseList.getResult())) {
            JSONArray items = JSON.parseArray(baseList.getResult().get("items").toString());
            for (Object r : items) {
                JSONObject i = (JSONObject) r;
                TianYanChaSearchBO subDetail = BeanUtil.copyProperties(searchBO, TianYanChaSearchBO.class);
                subList.setKeyword(null);
                subList.setLabel(fromSubEnum.getLabel());
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
                    subDetail.setGid(baseList.getResult().get(relationkey2).toString());
                }else if ("graphId".equals(relationkey2)) {
                    subDetail.setId(i.getString(relationkey2));
                }
                TianYanChaResult<Map<String, Object>> subDetailRet = queryBaseData(subDetail);
//                subRetList.add(subDetailRet.getResult());
                i.put("otherItems",subDetailRet.getResult());
            }
        }
//        baseList.getResult().put("items",subRetList);
        insertMysqlData(searchBO,baseList);
        return baseList;
    }



    /**
     * 查询基础数据 并存储 db  或者更新
     * @return { com.kakarote.crm.entity.tianyancha.TianYanChaResult<java.util.Map<java.lang.String,java.lang.Object>>}
     * @throws
     * @author UNIQUE
     * @date 2023/3/8
     */
    private TianYanChaResult<Map<String, Object>> queryBaseData(TianYanChaSearchBO searchBO){
        TianYanChaUrlEnum itemEnum = TianYanChaUrlEnum.parse(searchBO.getLabel());
        //补全基础信息
        TianYanChaUtil.fillParam(searchBO,itemEnum);
        //是否循环调用
        if (searchBO.getLoopFlag().equals(1)) {
            TianYanChaSearchBO loopSearch = BeanUtil.copyProperties(searchBO, TianYanChaSearchBO.class);
            loopSearch.setLoopFlag(0);
            TianYanChaResult<Map<String, Object>> loopData = queryBaseData(loopSearch);
            JSONObject ret = JSONObject.parseObject(loopData.getResult().toString());
            int currentTotal = (loopSearch.getPageNum()-1)* loopSearch.getPageSize()+ret.getJSONArray("items").size();
            while (ret.getIntValue("total") > currentTotal){
                searchBO.setPageNum(loopSearch.getPageNum()+1);
                TianYanChaResult<Map<String, Object>> appendData = queryBaseData(loopSearch);
                JSONObject loopRet1 = JSONObject.parseObject(appendData.getResult().toString());
                ret.getJSONArray("items").addAll(loopRet1.getJSONArray("items"));
            }
            // 插入db
            insertMysqlData(searchBO,loopData);
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
     * @return { com.kakarote.crm.entity.tianyancha.TianYanChaResult<java.util.Map<java.lang.String,java.lang.Object>>}
     * @throws
     * @author UNIQUE
     * @date 2023/3/7
     */
    private TianYanChaResult<Map<String, Object>> searchMysqlData(TianYanChaSearchBO searchBO){
//        if (!searchBO.getUpdateFlag().equals(1)) {
//            List<CrmTianyancha> had = iCrmTianyanchaService.queryHadData(searchBO);
//            if (CollectionUtil.isNotEmpty(had)) {
//                return JSON.parseObject(had.get(0).getParamReturn(),TianYanChaResult.class);
//            }
//        }
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
//        if (oldData.getError_code().equals(0)) {
//            CrmTianyancha item = new CrmTianyancha();
//            item.setName(searchBO.getName());
//            item.setGroupId(searchBO.getGroupId());
//            item.setCustomerId(searchBO.getCustomerId());
//            item.setLoopFlag(searchBO.getLoopFlag());
//            item.setStatus(0);
//            item.setParamUrl(searchBO.getUrl());
//            item.setParamWord(searchBO.getWord());
//            item.setParamPageNum(searchBO.getPageNum());
//            item.setParamPageSize(searchBO.getPageSize());
//            item.setParamKeyword(searchBO.getKeyword());
//            item.setParamPublishStartTime(searchBO.getPublishStartTime());
//            item.setParamPublishEndTime(searchBO.getPublishEndTime());
//            item.setParamProvince(searchBO.getProvince());
//            item.setParamType(searchBO.getType());
//            item.setParamCid(searchBO.getCid());
//            item.setParamHumanName(searchBO.getHumanName());
//            item.setParamUuid(searchBO.getUuid());
//            item.setParamId(searchBO.getId());
//            item.setParamName(searchBO.getName());
//            item.setParamFlag(searchBO.getFlag());
//            item.setParamDir(searchBO.getDir());
//            item.setParamAssistanceId(searchBO.getAssistanceId());
//            item.setParamGid(searchBO.getGid());
//            item.setParamBusinessId(searchBO.getBusinessId());
//            item.setParamYear(searchBO.getYear());
//            item.setParamDate(searchBO.getDate());
//            item.setParamHid(searchBO.getHid());
//            item.setParamTypes(searchBO.getTypes());
//            item.setParamDepth(searchBO.getDepth());
//            item.setParamIdTo(searchBO.getIdTo());
//            item.setParamNameTo(searchBO.getNameTo());
//            item.setParamIdFrom(searchBO.getIdFrom());
//            item.setParamNameFrom(searchBO.getNameFrom());
//            item.setParamReturn(JSONObject.toJSONString(oldData));
//            item.setCreateTime(LocalDateTime.now());
//            item.setUpdateTime(LocalDateTime.now());
//            iCrmTianyanchaService.save(item);
//        }
    }

//    public static void main(String[] args) {
////        Map<String, Object> i = new HashMap<>();
////        JSONArray objects = new JSONArray();
////        objects.add(new JSONObject().fluentPut("bbb", 123));
////        i.put("items",objects);
////        TianYanChaResult<Map<String, Object>> baseList = TianYanChaResult.ok(i);
////        List<Map<String,Object>> subRetList = new ArrayList<>();
////        if (ObjectUtil.isNotEmpty(baseList.getResult())) {
////            JSONArray items = JSON.parseArray(baseList.getResult().get("items").toString());
////            for (Object r : items) {
////                Map<String, Object> item = new HashMap<>();
////                JSONArray objects1 = new JSONArray();
////                objects1.add(new JSONObject().fluentPut("bbb11111", 123));
////                item.put("items",objects1);
////
////                TianYanChaResult<Map<String, Object>> subDetailRet = TianYanChaResult.ok(item);
////                i.put("otherItems",subDetailRet.getResult());
////            }
////        }
//        TianYanChaService tianYanChaService = new TianYanChaService();
//
//        TianYanChaSearchBO searchBO = new TianYanChaSearchBO();
//        searchBO.setLabel(1);
//        TianYanChaResult<Map<String, Object>> ba = tianYanChaService.queryBaseData(searchBO);
//        System.out.println(ba);
//    }
}
