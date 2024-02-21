package com.unique.core.utils;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.unique.core.context.ConstCity;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ceshi
 * @description 城市解析
 * @date 2022/11/26 9:23
 */

public class CityUtil {

    /**
     * 解析地址
     * @param AllAddress 详细地址
     * @return
     */
    public static Map<String,String> addressResolution(String AllAddress){
        //有手动空格解析
        Matcher m = ConstCity.PEEK_ALL_CHAR.matcher(AllAddress);
        List<String> list = new ArrayList<>();
        while (m.find()){
            list.add(m.group());
        }
        Map map =new HashMap<>();
        if (list.size()==4){
            map.put("province", ObjectUtil.isNotEmpty(list.get(0))?list.get(0):"");
            map.put("city",ObjectUtil.isNotEmpty(list.get(1))?list.get(1):"");
            map.put("town",ObjectUtil.isNotEmpty(list.get(2))?list.get(2):"");
            map.put("address",ObjectUtil.isNotEmpty(list.get(3))?list.get(3):"");
            return map;
        }
        //省份处理
        String prov=AllAddress.substring(0,2);//截取前2位
        //直辖市4 zxs
        String[] arrZXS ={"北京","天津","上海","重庆"};
        //省23 sf
        String[] arrSF ={"黑龙","吉林","辽宁","河北","山西","青海","山东","河南","江苏", "安徽","浙江",
                "福建","江西","湖南","湖北","广东","台湾", "海南","甘肃","陕西","四川","贵州","云南"
        };
        if (Arrays.asList(arrZXS).contains(prov)){
            int s=AllAddress.indexOf('市');
            if (s != 2){
                StringBuffer stringBuilder=new StringBuffer(AllAddress);
                stringBuilder.insert(2,"市");
                AllAddress=stringBuilder.toString();
            }
        }else if(Arrays.asList(arrSF).contains(prov)){
            int s=AllAddress.indexOf('省');
            StringBuffer stringBuilder=new StringBuffer(AllAddress);
            if (prov=="黑龙" && s !=3){
                stringBuilder.insert(3,"省");
                AllAddress=stringBuilder.toString();
            }else if(prov !="黑龙" && s !=2){
                stringBuilder.insert(2,"省");
                AllAddress=stringBuilder.toString();
            }
        }
        //正则表达式
        String regex="(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)";
        regex+="(?<city>[^市]+自治州|.*?地区|.*?行政单位|.*行政区划|.+盟|市辖区|.*?市|.*?县)";
        regex+="(?<town>[^区].*?县|.*?区|.*?市|.*?旗|.+海域|.*?岛)?" ;
        regex+="(?<address>.*)";
        m= Pattern.compile(regex).matcher(AllAddress);
        while(m.find()){
            //一级地址
            String province=m.group("province");
            map.put("province", StrUtil.isEmpty(province) ?"":province.trim());
            //二级地址
            String city=m.group("city");
            map.put("city", StrUtil.isEmpty(city)?"":city.trim());
            //三级地址
            String town=m.group("town");
            map.put("town", StrUtil.isEmpty(town)?"":town.trim());
            //四级地址
            String address=m.group("address");
            map.put("address", StrUtil.isEmpty(address)?"":address.trim());
        }
        return map;
    }
}
