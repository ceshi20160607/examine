package com.unique.tianyancha.enums;

/**
 * @author UNIQUE
 * @create 2023-03-06
 * @verson 1.0.0
 */

import com.unique.core.common.ResultBaseCode;

import java.util.Arrays;
import java.util.List;

/**
 * @author UNIQUE
 * @create 2023-03-06 18:11
 * @verson 1.0.0
 */
public enum TianYanChaErrorCodeEnum implements ResultBaseCode {

    TIAN_YAN_CHA_ERROR(6000, "天眼查请求异常！"),
    TIAN_YAN_CHA_SUCCESS(0, "请求成功"),
    TIAN_YAN_CHA_NO_DATA(300000, "⽆数据"),
    TIAN_YAN_CHA_FAIL(300001, "请求失败"),
    TIAN_YAN_CHA_ACCOUNT_INVALID(300002, "账号失效"),
    TIAN_YAN_CHA_ACCOUNT_EXPIRED(300003, "账号过期"),
    TIAN_YAN_CHA_ACCESS_FAST(300004, "访问频率过快"),
    TIAN_YAN_CHA_NO_AUTH_API(300005, "⽆权限访问此api"),
    TIAN_YAN_CHA_NO_MONEY(300006, "余额不⾜"),
    TIAN_YAN_CHA_NO_TIME(300007, "剩余次数不⾜"),
    TIAN_YAN_CHA_NO_PARAM(300008, "缺少必要参数"),
    TIAN_YAN_CHA_ACCOUNT_ERROR(300009, "账号信息有误"),
    TIAN_YAN_CHA_NO_URL(300010, "URL不存在"),
    TIAN_YAN_CHA_NO_AUTH_IP(300011, "此IP⽆权限访问此api"),
    TIAN_YAN_CHA_REPORT_CREATING(300012, "报告⽣成中"),


    ;

    TianYanChaErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;
    private String msg;
    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public static List<Integer> rightCode(){
        return Arrays.asList(TIAN_YAN_CHA_SUCCESS.getCode());
    }
}
