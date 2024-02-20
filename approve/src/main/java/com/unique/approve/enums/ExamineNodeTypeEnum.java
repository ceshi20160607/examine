package com.unique.approve.enums;

/**
 * 审批类型
 * @author UNIQUE
 * @date 2023/3/9
 */
public enum ExamineNodeTypeEnum {
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

    ExamineNodeTypeEnum(Integer type, String remarks) {
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

    public static ExamineNodeTypeEnum parse(Integer type) {
        for (ExamineNodeTypeEnum item : values()) {
            if (item.getType().equals(type)) {
                return item;
            }
        }
        return null;
    }
}
