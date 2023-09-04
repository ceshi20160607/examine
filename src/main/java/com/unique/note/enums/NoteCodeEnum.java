package com.unique.note.enums;

import com.unique.core.common.ResultBaseCode;


/** 系统响应错误代码枚举类
 * @author UNIQUE
 * @create 2023-02-15 16:56
 * @verson 1.0.0
 */


public enum NoteCodeEnum implements ResultBaseCode {
    //系统响应成功
    NOTE_ERROR_PARAM(40000, "参数异常"),
    ;

    NoteCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;
    private String msg;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public static NoteCodeEnum parse(Integer status) {
        for (NoteCodeEnum value : values()) {
            if (value.getCode() == status) {
                return value;
            }
        }
        return NoteCodeEnum.NOTE_ERROR_PARAM;
    }
}
