package com.unique.core.common.enums;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 用户状态枚举
 *
 * @author UNIQUE
 * @date 2023/3/27
 */
public enum UserStatusEnum {
    /**
     * 审批 类型枚举
     */
    NOT_ACTIVE(0, "未激活"),
    NORMAL(1, "正常"),
    DISABLED(2, "禁用"),
    ;

    UserStatusEnum(Integer type, String remarks) {
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

    public static UserStatusEnum parse(Integer type) {
        for (UserStatusEnum item : values()) {
            if (item.getType().equals(type)) {
                return item;
            }
        }
        return null;
    }
}
