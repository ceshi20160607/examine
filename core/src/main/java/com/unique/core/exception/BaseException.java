package com.unique.core.exception;


import com.unique.core.common.ResultBaseCode;

/**
 * crm默认的异常处理
 *
 * @author UNIQUE
 */
public class BaseException extends RuntimeException implements ResultBaseCode {

    private String msg;
    private int code;


    public BaseException(int code, String msg) {
        super(code + ":" + msg, null, true, true);
        this.code = code;
        this.msg = msg;
    }

    public BaseException(ResultBaseCode ResultBaseCode) {
        this(ResultBaseCode.getCode(), ResultBaseCode.getMsg());
    }

    public BaseException(ResultBaseCode ResultBaseCode, Object... args) {
        this(ResultBaseCode.getCode(), String.format(ResultBaseCode.getMsg(), args));
    }

    public BaseException(ResultBaseCode ResultBaseCode, String str, Boolean flag) {
        this(ResultBaseCode.getCode(), ResultBaseCode.getMsg() + ":" + str);
    }

    public BaseException(ResultBaseCode ResultBaseCode, Throwable t) {

        this(ResultBaseCode.getCode(), ResultBaseCode.getMsg(), t);
    }

    public BaseException(int code, String msg, Throwable t) {
        super(code + ":" + msg, t, true, true);
        this.code = code;
        this.msg = msg;
    }
    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
