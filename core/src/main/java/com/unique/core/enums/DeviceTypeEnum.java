package com.unique.core.enums;

/**
 * 用户状态枚举
 *
 * @author UNIQUE
 * @date 2023/3/27
 */
public enum DeviceTypeEnum {
    /**
     * 审批 类型枚举
     */
    PC(0, "PC"),
    APP(1, "APP"),
    ;

    DeviceTypeEnum(Integer type, String remarks) {
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

    public static DeviceTypeEnum parse(Integer type) {
        for (DeviceTypeEnum item : values()) {
            if (item.getType().equals(type)) {
                return item;
            }
        }
        return null;
    }
}
