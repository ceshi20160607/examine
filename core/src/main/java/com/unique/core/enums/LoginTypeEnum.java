package com.unique.core.enums;

/**
 * 用户状态枚举
 *
 * @author UNIQUE
 * @date 2023/3/27
 */
public enum LoginTypeEnum {
    /**
     * 审批 类型枚举
     */
    PASSWORD(0, "password"),
    MOBIEL(1, "mobiel"),
    SSO(2, "sso"),
    ;

    LoginTypeEnum(Integer type, String remarks) {
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

    public static LoginTypeEnum parse(Integer type) {
        for (LoginTypeEnum item : values()) {
            if (item.getType().equals(type)) {
                return item;
            }
        }
        return null;
    }
}
