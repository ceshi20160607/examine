package com.unique.examine.common.enums;

/**
 * 审批类型
 * @author UNIQUE
 * @date 2023/3/9
 */
public enum ExamineFlagEnum {
    /**
     * 审批 类型枚举
     */
    DEFAULT(0, "一个爱一个有序"),
    MUST_ALL_ORDER(0, "一个爱一个有序"),
    MUST_ALL_NO_ORDER(1, "一个爱一个无序"),
    ANY_ONE(2, "任何一个"),
    ;

    ExamineFlagEnum(Integer type, String remarks) {
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

    public static ExamineFlagEnum parse(Integer type) {
        for (ExamineFlagEnum item : values()) {
            if (item.getType().equals(type)) {
                return item;
            }
        }
        return null;
    }
}
