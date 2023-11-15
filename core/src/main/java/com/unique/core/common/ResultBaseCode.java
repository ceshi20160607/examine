package com.unique.core.common;

/**
 * 返回消息构建类
 * @author UNIQUE
 * @date 2023/3/25
 */
public interface ResultBaseCode {

    /**
     * 系统响应码
     *
     * @return code
     */
    public int getCode();

    /**
     * 默认系统响应提示，code=0时此处为空
     *
     * @return msg
     */
    public String getMsg();
}
