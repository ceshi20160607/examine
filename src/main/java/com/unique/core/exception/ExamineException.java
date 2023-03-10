package com.unique.core.exception;


import com.unique.core.common.ResultBaseCode;

/**
 * crm默认的异常处理
 *
 * @author UNIQUE
 */
public class ExamineException extends RuntimeException implements ResultBaseCode {

    private String msg;
    private int code;


    public ExamineException(int code, String msg) {
        super(code + ":" + msg, null, true, true);
        this.code = code;
        this.msg = msg;
    }

    public ExamineException(ResultBaseCode ResultBaseCode) {
        this(ResultBaseCode.getCode(), ResultBaseCode.getMsg());
    }

    public ExamineException(ResultBaseCode ResultBaseCode, Object... args) {
        this(ResultBaseCode.getCode(), String.format(ResultBaseCode.getMsg(), args));
    }

    public ExamineException(ResultBaseCode ResultBaseCode, String str, Boolean flag) {
        this(ResultBaseCode.getCode(), ResultBaseCode.getMsg() + ":" + str);
    }

    public ExamineException(ResultBaseCode ResultBaseCode, Throwable t) {

        this(ResultBaseCode.getCode(), ResultBaseCode.getMsg(), t);
    }

    public ExamineException(int code, String msg, Throwable t) {
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
