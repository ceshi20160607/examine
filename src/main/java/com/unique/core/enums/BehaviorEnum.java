package com.unique.core.enums;

public enum BehaviorEnum {

    /**
     * 操作记录行为
     */
    SAVE(1, "新建"),

    UPDATE(2, "编辑"),
    DELETE(3, "删除"),
    NULL(0, "null");

    private int type;
    private String name;

    BehaviorEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static BehaviorEnum parse(int type) {
        for (BehaviorEnum Enum : BehaviorEnum.values()) {
            if (Enum.getType() == type) {
                return Enum;
            }
        }
        return NULL;
    }
}
