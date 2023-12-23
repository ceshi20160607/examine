package com.unique.core.common.thirdapi;

import cn.hutool.crypto.digest.DigestUtil;

import javax.annotation.Resource;
import java.util.*;


/**
 * 第三方接口工具类
 * @author UNIQUE
 * @date 2023/12/15
 */
public class ThirdApiUtil {


    /**
     * 创建请求头,进行生成摘要
     * @param params
     * @param staticParamsList
     * @return {@link Map}<{@link String}, {@link String}>
     */
    public static Map<String, String> createHeaderParams(Map<String, Object> params,List<ThirdApiHeaderParams> staticParamsList) {
        Map<String, String> headerParams = new HashMap<>();
        Set<String> keysSet = params.keySet();
        Object[] keys = keysSet.toArray();
        Arrays.sort(keys);
        StringBuilder temp = new StringBuilder();
        for (Object key : keys) {
            Object value = params.get(key);
            if (null != value && !(value instanceof Resource)){
                String val = String.valueOf(value);
                if(!"".equals(val)){
                    temp.append(key).append("=").append(val).append("&");
                }
            }
        }
        staticParamsList.forEach(k->{
            temp.append(k.getKey()).append("=").append(k.getValue()).append("&");
            if (k.getHeaderFlag()) {
                headerParams.put(k.getKey(),k.getValue());
            }
        });
        String sha1Hex= DigestUtil.sha1Hex(temp.toString());
        headerParams.put("sign",sha1Hex);
        return headerParams;
    }


//    public static void main(String[] args) {
//        Map<String, Object> param = new HashMap<>();
////        param.put("accountCode", "L3944");
//        param.put("accountCode", "L00000009");
//        param.put("orgCode", "CM00000010");
//        param.put("loginName", "xhang@sina.com");
//        param.put("mobile", "19937905211");
//        param.put("name", "nccbsg联系人");
//        param.put("businessType", "21");
//        param.put("email", "xhang@sina.com");
//        param.put("jobNumber", "APT06666");
//
//        createHeaderParams(param);
////        HeaderParams headerParams = createHeaderParams(JSONObject.parseObject(params));
////        String ret = HttpRequest.post("https://css-test.aptbiotech.com/apt-user/pub/getAccounts").body(params)
////                .header("accessKey", headerParams.getAccessKey())
////                .header("timestamp", headerParams.getTimestamp())
////                .header("sign", headerParams.getSign())
////                .execute().body();
////        return ret;
//    }

}
