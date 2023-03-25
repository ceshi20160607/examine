package com.unique.tianyancha.entity;

import com.alibaba.fastjson.JSON;
import com.unique.core.common.ResultBaseCode;
import com.unique.core.enums.SystemCodeEnum;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/**
 * 天眼查返回类
 * @author UNIQUE
 * @date 2023/3/25
 */
public class TianYanChaResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "error_code", required = true, example = "0")
    private Integer error_code ;

    @ApiModelProperty(value = "reason", required = true, example = "错误信息")
    private String reason;

    private T result;

    TianYanChaResult() {

    }

    private TianYanChaResult(ResultBaseCode resultCode) {
        this.error_code = resultCode.getCode();
        this.reason = resultCode.getMsg();
    }
    private TianYanChaResult(int code, String msg) {
        this.error_code = code;
        this.reason = msg;
    }

    public void setError_code(Integer error_code) {
        this.error_code = error_code;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    public Integer getError_code() {
        return error_code;
    }

    public String getReason() {
        return reason;
    }

    public static <T> TianYanChaResult error() {
        return new TianYanChaResult(SystemCodeEnum.SYSTEM_NOT_LOGIN);
    }
    public static <T> TianYanChaResult<T> error(ResultBaseCode resultCode) {
        return new TianYanChaResult<>(resultCode);
    }


    public static <T> TianYanChaResult ok() {
        return new TianYanChaResult(SystemCodeEnum.SYSTEM_OK);
    }
    public static <T> TianYanChaResult<T> ok(T data) {
        TianYanChaResult<T> ret = new TianYanChaResult<>(SystemCodeEnum.SYSTEM_OK);
        ret.setResult(data);
        return ret;
    }


    public TianYanChaResult setResult(T repData) {
        this.result = repData;
        return this;
    }

    @SuppressWarnings("unchecked")
    public T getResult() {
        return this.result;
    }


    public String toJSONString() {
        return JSON.toJSONString(this);
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
