package com.unique.examine.common.utils;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.text.StrPool;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.unique.examine.common.enums.SearchFieldEnum;
import com.unique.examine.entity.bo.ExamineSearch;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author UNIQUE
 * @create 2023-03-11
 * @verson 1.0.0
 */
public class SearchFieldUtil {

    public static Boolean searchConditionValue(ExamineSearch examineSearch, Map<String,Object> entity) {
        Boolean ret = Boolean.FALSE;
        Object oldValue = entity.get(examineSearch.getFieldName());
        switch (examineSearch.getFieldEnum()){
            case TEXTAREA:
            case TEXT:
            case MOBILE:
            case EMAIL:
            case SELECT:
            case WEBSITE:
                ret = textSearch(examineSearch.getSearchFieldEnum(),oldValue.toString(),examineSearch.getValue());
                break;
            case FILE:
                break;
            case CHECKBOX:
                ret = checkboxSearch(examineSearch.getSearchFieldEnum(),oldValue.toString(),examineSearch.getValue());
                break;
            case BOOLEAN_VALUE:
            case NUMBER_FLOAT:
            case NUMBER:
            case PERCENT:
                ret = numberSearch(examineSearch.getSearchFieldEnum(),oldValue.toString(),examineSearch.getValue());
                break;
            case DATE_INTERVAL:
                //todo:日期时间段类型
                ret = textSearch(examineSearch.getSearchFieldEnum(),oldValue.toString(),examineSearch.getValue());
                break;
            case DATE:
            case DATETIME:
                ret = dateSearch(examineSearch.getSearchFieldEnum(),oldValue.toString(),examineSearch.getValue());
                break;
            case USER:
                ret = textSearch(examineSearch.getSearchFieldEnum(),oldValue.toString(),examineSearch.getValue());
                break;
            case ADDRESS:
            case DETAIL_TABLE:
            case HANDWRITING_SIGN:
            case TAG:
            case ATTENTION:
            case SERIAL_NUMBER:
            case POSITION:
            case FORMULA:
            case POSITION_LNG_LAT:
                break;
            case DEPT:
                break;
            default:
                ret = textSearch(examineSearch.getSearchFieldEnum(),oldValue.toString(),examineSearch.getValue());
                break;
        }
        return ret;
    }

    public static Boolean textSearch(SearchFieldEnum search, String oldValue, String newValue) {
        Boolean ret = Boolean.FALSE;
        switch (search) {
            case IS:
                ret = oldValue.trim().equals(newValue.trim());
                break;
            case IS_NOT:
                ret = !oldValue.trim().equals(newValue.trim());
                break;
            case CONTAINS:
                ret = oldValue.contains(newValue.trim());
                break;
            case NOT_CONTAINS:
                ret = !oldValue.contains(newValue.trim());
                break;
            case IS_NULL:
                ret = ObjectUtil.isEmpty(oldValue);
                break;
            case IS_NOT_NULL:
                ret = ObjectUtil.isNotEmpty(oldValue);
                break;
            default:
                break;
        }
        return ret;
    }

    /**
     * 多选类型的es搜索
     *
     * @param search       搜索条件
     */
    public static Boolean checkboxSearch(SearchFieldEnum search, String oldValue, String newValue) {
        Boolean ret = Boolean.FALSE;
        List<String> values = StrUtil.split(newValue, ",");
        switch (search) {
            case IS_NOT:
                int i=0;
                for (String item : values) {
                    if (oldValue.contains(item)) {
                        i++;
                    }
                }
                if (i!=values.size()) {
                    ret = Boolean.TRUE;
                }
                break;
            case IS:
                int i1=0;
                for (String item : values) {
                    if (oldValue.contains(item)) {
                        i1++;
                    }
                }
                if (i1==values.size()) {
                    ret = Boolean.TRUE;
                }
                break;
            case CONTAINS:
                for (String item : values) {
                    if (oldValue.contains(item)) {
                        ret = Boolean.TRUE;
                        break;
                    }
                }
                break;
            case NOT_CONTAINS: {
                for (String item : values) {
                    if (oldValue.contains(item)) {
                        ret = Boolean.TRUE;
                        break;
                    }
                }
                ret = Boolean.FALSE;
                break;
            }
            case IS_NULL:
                ret = ObjectUtil.isEmpty(oldValue);
                break;
            case IS_NOT_NULL:
                ret = ObjectUtil.isNotEmpty(oldValue);
                break;
        }
        return ret;
    }

    /**
     * 数字类型的es搜索
     *
     * @param search       搜索条件
     */
    public static Boolean numberSearch(SearchFieldEnum search, String oldValue, String newValue) {
        Boolean ret = Boolean.FALSE;
        List<String> values = StrUtil.split(newValue, ",");
        switch (search) {
            case IS:
                ret = NumberUtil.equals(new BigDecimal(oldValue.trim()),new BigDecimal(newValue.trim()));
                break;
            case IS_NOT:
                ret = !NumberUtil.equals(new BigDecimal(oldValue.trim()),new BigDecimal(newValue.trim()));
                break;
            case GT:
                ret = NumberUtil.isGreater(new BigDecimal(oldValue.trim()),new BigDecimal(newValue.trim()));
                break;
            case EGT:
                ret = NumberUtil.isGreaterOrEqual(new BigDecimal(oldValue.trim()),new BigDecimal(newValue.trim()));
                break;
            case LT:
                ret = NumberUtil.isLess(new BigDecimal(oldValue.trim()),new BigDecimal(newValue.trim()));
                break;
            case ELT:
                ret = NumberUtil.isLessOrEqual(new BigDecimal(oldValue.trim()),new BigDecimal(newValue.trim()));
                break;
            case IS_NULL:
                ret = ObjectUtil.isEmpty(oldValue);
                break;
            case IS_NOT_NULL:
                ret = ObjectUtil.isNotEmpty(oldValue);
                break;
        }
        return ret;
    }

    /**
     * 时间类型的es搜索
     *
     * @param search       搜索条件
     */
    public static Boolean dateSearch(SearchFieldEnum search, String oldValue, String newValue) {
        Boolean ret = Boolean.FALSE;
        DateTime oldDate = DateUtil.parse(oldValue.trim());
        DateTime newDate = DateUtil.parse(newValue.trim());
        switch (search) {
            case IS:
                ret = DateUtil.between(oldDate,newDate, DateUnit.DAY)==0L;
                break;
            case IS_NOT:
                ret = DateUtil.between(oldDate,newDate,DateUnit.DAY)!=0L;
                break;
            case GT:
                ret = DateUtil.between(oldDate,newDate,DateUnit.DAY)>0L;
                break;
            case EGT:
                ret = DateUtil.between(oldDate,newDate,DateUnit.DAY)>=0L;
                break;
            case LT:
                ret = DateUtil.between(oldDate,newDate,DateUnit.DAY)<0L;
                break;
            case ELT:
                ret = DateUtil.between(oldDate,newDate,DateUnit.DAY)<=0L;
                break;
            case IS_NULL:
                ret = ObjectUtil.isEmpty(oldValue);
                break;
            case IS_NOT_NULL:
                ret = ObjectUtil.isNotEmpty(oldValue);
                break;
        }
        return ret;
    }



}
