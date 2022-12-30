package com.unique.examine.common.context;

import java.util.Arrays;
import java.util.List;

/**
 * @author ceshi
 * @description 基础常量
 * @date 2022/12/28 10:07
 */

public class Const {
    /**
     * 默认分隔符
     */
    public static final String SEPARATOR =",";

    /**
     * 默认编码
     */
    public static final String DEFAULT_CONTENT_TYPE = "application/json;charset=UTF-8";

    /**
     * 用于地址转换成clickhouse后尽心后续截取做检索处理
     */
    public static final List<String> MYSQL_ADDRESS_TO_CLICKHOUSE_SPLIT = Arrays.asList(",",":",";");

}
