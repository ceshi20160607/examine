package com.unique.core.common.utils;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.Method;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author UNIQUE
 * @create 2023-03-07
 * @verson 1.0.0
 */
@Slf4j
@Component
public class TianYanChaOldUtil {

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * http get请求
     * @param url 接口url
     * @param token token
     * @return  返回接口数据
     */
    @SneakyThrows
    public JSONObject executeGet(String url, String token, Map<String, Object> param) {
        HttpRequest request = new HttpRequest(url);
        request.setMethod(Method.GET);
        request.form(param);
        request.header("Authorization", token);
        String result = request.execute().body();
        JSONObject jsonObject = objectMapper.readValue(result, JSONObject.class);
        return jsonObject;
    }
}
