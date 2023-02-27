package com.unique.core.enums;

import lombok.Getter;

@Getter
public enum ModelTypeEnum {
    NULL(0,""),
    //crm
    CRM_LEADS(21,"线索"),
    CRM_CUSTOMER(22,"客户"),
    CRM_CONTACTS(23,"联系人"),
    CRM_BUSINESS(24,"项目"),
    CRM_CONTRACT(25,"合同"),
    CRM_RECEIVABLES(26,"回款"),
    CRM_INVOICE(27,"发票"),
    CRM_RETURN_VISIT(28,"回访"),
    CRM_PRODUCT(29,"产品")
    ;


    ModelTypeEnum(Integer label, String name) {
        this.label = label;
        this.name = name;
    }

    private Integer label;

    private String name;

    public static String valueOfName(Integer label){
        for (ModelTypeEnum modelType : values()) {
            if (label.equals(modelType.getLabel())){
                return modelType.getName();
            }
        }
        return "";
    }
}
