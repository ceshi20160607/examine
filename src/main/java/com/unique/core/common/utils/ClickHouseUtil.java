package com.unique.core.common.utils;

import com.unique.examine.common.enums.FieldEnum;

/**
 * @author ceshi
 * @description clickHouse工具类
 * @date 2022/12/29 11:12
 */

public class ClickHouseUtil {


    /**
     * @Description  clickhouse中类型转换为crm中类型
     * @Author UNIQUE
     * @Date 2022/11/15
     * @Param
     * @return
     **/
    public static Integer getTypeFromClickHouse(String clickhouseType){
        if (clickhouseType.contains("Int")) {
            return FieldEnum.NUMBER.getType();
        }
        if (clickhouseType.contains("DateTime")) {
            return FieldEnum.DATETIME.getType();
        }
        if (clickhouseType.contains("Date")) {
            return FieldEnum.DATE.getType();
        }
        if (clickhouseType.contains("Decimal")) {
            return FieldEnum.NUMBER_FLOAT.getType();
        }
        return FieldEnum.TEXT.getType();
    }
}
