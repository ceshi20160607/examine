package com.unique.core.common.enums;

/**
 * 字段匹配类型
 * @author UNIQUE
 * @date 2023/3/11
 */
public enum SearchFieldEnum {
    /**
     * 为空
     */
    IS_NULL(0,"为空"),
    /**
     * 不为空
     */
    IS_NOT_NULL(1,"不为空"),
    /**
     * 包含
     */
    CONTAINS(2,"包含"),
    /**
     * 不包含
     */
    NOT_CONTAINS(3,"不包含"),
    /**
     * 等于
     */
    IS(4,"等于"),
    /**
     * 不等于
     */
    IS_NOT(5,"不等于"),
    /**
     * 大于
     */
    GT(6,"大于"),
    /**
     * 大于等于
     */
    EGT(7,"大于等于"),
    /**
     * 小于
     */
    LT(8,"小于"),
    /**
     * 小于等于
     */
    ELT(9,"小于等于"),
    /**
     * 日期时间筛选
     */
    DATE_TIME(10,"日期时间筛选"),
    /**
     * 日期筛选
     */
    DATE(11,"日期筛选"),

    ;

    SearchFieldEnum(Integer type, String remarks) {
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

    public static SearchFieldEnum parse(Integer type) {
        for (SearchFieldEnum item : values()) {
            if (item.getType().equals(type)) {
                return item;
            }
        }
        return null;
    }

}
