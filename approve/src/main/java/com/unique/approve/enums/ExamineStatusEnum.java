package com.unique.approve.enums;

/**
 * 审批启停状态
 * @author UNIQUE
 * @date 2023/3/9
 */
public enum ExamineStatusEnum {
    /**
     * 审批 类型枚举
     */
    ON(1, "正常"),
    OFF(2, "停用"),
    DELETE(3, "删除"),
    ;

    ExamineStatusEnum(Integer type, String remarks) {
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

    public static ExamineStatusEnum parse(Integer type) {
        for (ExamineStatusEnum item : values()) {
            if (item.getType().equals(type)) {
                return item;
            }
        }
        return null;
    }
}
