package com.unique.approve.enums;

/**
 * 审批类型
 * @author UNIQUE
 * @date 2023/3/9
 */
public enum ExamineTypeEnum {
    /**
     * 审批 类型枚举
     */
    DEFAULT(0,"初始"),
    FIXED (1, "固定人员"),
    FIXED_SUPER (2, "固定人员上级"),
    ROLE(3, "角色"),
    CHOOSE (4, "发起人自选"),
    ;

    ExamineTypeEnum(Integer type, String remarks) {
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

    public static ExamineTypeEnum parse(Integer type) {
        for (ExamineTypeEnum item : values()) {
            if (item.getType().equals(type)) {
                return item;
            }
        }
        return null;
    }
}
