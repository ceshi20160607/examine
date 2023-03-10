package com.unique.examine.common.enums;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 审批类型
 * @author UNIQUE
 * @date 2023/3/9
 */
public enum TaskTypeEnum {
    /**
     * 审批 类型枚举
     */
    CREATE(0,"创建"),
    GENERAL (1, "普通审批"),
    CONDITION (2, "条件审批"),
    CC(3, "抄送"),
    TRANSFER (4, "转他人处理"),
    WITHIN_CONDITIONS(5, "条件内的审批"),
    ;

    TaskTypeEnum(Integer type, String remarks) {
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

    public static TaskTypeEnum parse(Integer type) {
        for (TaskTypeEnum item : values()) {
            if (item.getType().equals(type)) {
                return item;
            }
        }
        return null;
    }
}
