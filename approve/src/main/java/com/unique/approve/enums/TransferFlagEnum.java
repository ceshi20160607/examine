package com.unique.approve.enums;


/**转他人处理类型
 * @author UNIQUE
 * @date 2024/02/18
 */
public enum TransferFlagEnum {
    DEFAULT(0,"不转他人处理"),
    TRANSFER (1, "转他人的审批场景"),
    EMAIL (2, "抄送的邮箱"),
    ;

    TransferFlagEnum(Integer type, String remarks) {
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

    public static TransferFlagEnum parse(Integer type) {
        for (TransferFlagEnum item : values()) {
            if (item.getType().equals(type)) {
                return item;
            }
        }
        return null;
    }
}
