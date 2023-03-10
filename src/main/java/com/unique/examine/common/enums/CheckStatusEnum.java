package com.unique.examine.common.enums;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description  审批类型枚举
 * @Author UNIQUE
 * @Date 2022/12/28
 * @param
 * @return
 **/
public enum CheckStatusEnum {
    /**
     * 审批 类型枚举
     */
    CHECK_CREATE(0,"创建"),
    CHECK_ING(1, "待审核"),
    CHECK_PASS(2, "通过"),
    CHECK_CAMAL(3, "拒绝"),
    CHECK_ON(4, "审核中"),
    CHECK_BACK(5, "已撤回"),
    CHECK_UNPUSH(6, "未提交"),
    CHECK_DISCARD(7, "已作废")
    ;

    CheckStatusEnum(Integer type, String remarks) {
        this.type = type;
        this.remarks = remarks;
    }
    private final Integer type;
    private final String remarks;


    public Integer getType() {
        return type;
    }

    public String getRemarks() {
        return remarks;
    }

    public static CheckStatusEnum parse(Integer type) {
        for (CheckStatusEnum item : values()) {
            if (item.getType().equals(type)) {
                return item;
            }
        }
        return null;
    }

    public static List<Object> getEnumJsonList() {
        List<Object> enumList = new ArrayList<>();
        for (CheckStatusEnum crmEnum : values()) {
            enumList.add(new JSONObject().fluentPut("name", crmEnum.getRemarks()).fluentPut("value", crmEnum.getType()));
        }
        return enumList;
    }

    public static List<Object> getEnumJsonReceivablesList() {
        List<Object> enumList = new ArrayList<>();
        for (CheckStatusEnum crmEnum : values()) {
            if (Arrays.asList(0,1,2,3,5).contains(crmEnum.getType())) {
                enumList.add(new JSONObject().fluentPut("name", crmEnum.getRemarks()).fluentPut("value", crmEnum.getType()));
            }
        }
        return enumList;
    }
}
