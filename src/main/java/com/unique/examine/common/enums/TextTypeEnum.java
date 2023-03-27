package com.unique.examine.common.enums;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public enum TextTypeEnum {

    /**
     * 单行文本
     */
    TEXT(1, "text"),
    /**
     * 多行文本
     */
    TEXTAREA(2, "textarea"),

    /**
     * 手机
     */
    MOBILE(3, "mobile"),
    /**
     * 邮件
     */
    EMAIL(4, "email"),
    /**
     * 网址
     */
    WEBSITE(5, "website"),
    ;

    TextTypeEnum(int type, String formType) {
        this.type = type;
        this.formType = formType;
    }

    /**
     * 字段类型数字
     */
    private final Integer type;

    /**
     * 字段类型文本
     */
    private final String formType;

    public static TextTypeEnum parse(Integer type) {
        for (TextTypeEnum fieldTypeEnum : TextTypeEnum.values()) {
            if (fieldTypeEnum.getType().equals(type)) {
                return fieldTypeEnum;
            }
        }
        return TextTypeEnum.TEXT;
    }

    public static TextTypeEnum parse(String formType) {
        for (TextTypeEnum fieldTypeEnum : TextTypeEnum.values()) {
            if (fieldTypeEnum.getFormType().equals(formType)) {
                return fieldTypeEnum;
            }
        }
        return TEXT;
    }

}
