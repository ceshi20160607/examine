package com.unique.tianyancha.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.Method;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unique.tianyancha.config.TianYanChaResult;
import com.unique.tianyancha.entity.bo.TianYanChaSearchBO;
import com.unique.tianyancha.enums.TianYanChaUrlEnum;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author UNIQUE
 * @create 2023-03-07
 * @verson 1.0.0
 */
@Slf4j
@Component
public class TianYanChaUtil {

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${tianyancha.url}")
    private String baseUrl;
    @Value("${tianyancha.token}")
    private String token;

    public static final List<String> SEARCH_NO_PARAM = Arrays.asList("label","groupId","customerId","updateFlag","loopFlag","groupId","url","name");

    /**
     * http get请求
     * @return  返回接口数据
     */
    @SneakyThrows
    public TianYanChaResult<Map<String, Object>> doGet(TianYanChaSearchBO searchBO) {
        String urlStr = doGetUrl(searchBO);
        log.info("请求天眼查："+urlStr);
        HttpRequest request = new HttpRequest(urlStr);
        request.setMethod(Method.GET);
        request.header("Authorization", token);
        String result = request.execute().body();
        log.info("请求天眼查返回结果："+result);
        TianYanChaResult jsonObject = objectMapper.readValue(result, TianYanChaResult.class);
        return jsonObject;
    }

    private String doGetUrl(TianYanChaSearchBO searchBO){
        StringBuffer sb = new StringBuffer().append(baseUrl).append(searchBO.getUrl());
        Map<String, Object> searchMap = BeanUtil.beanToMap(searchBO);
        StringBuffer sbp = new StringBuffer();
        int i=0;
        for (String k : searchMap.keySet()) {
            if (!SEARCH_NO_PARAM.contains(k)) {
                Object v = searchMap.get(k);
                if (ObjectUtil.isNotEmpty(v)) {
                    if (i!=0) {
                        sbp.append("&");
                    }
                    sbp.append(k).append("=").append(v);
                    i++;
                }
            }
        }
        if (sbp.length()>0) {
            sb.append("?").append(URLUtil.encode(sbp.toString()));
        }
        return sb.toString();
    }

    public static void fillParam(TianYanChaSearchBO searchBO, TianYanChaUrlEnum baseEnum){
        if (ObjectUtil.isNotEmpty(baseEnum)) {
            searchBO.setUrl(baseEnum.getUrl());
            searchBO.setName(baseEnum.getName());
            searchBO.setGroupId(baseEnum.getGroupId());
            searchBO.setLabel(baseEnum.getLabel());
        }
    }
}
