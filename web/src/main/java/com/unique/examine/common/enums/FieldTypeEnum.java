package com.unique.examine.common.enums;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.unique.core.common.utils.CityUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Getter
public enum FieldTypeEnum {

    /**
     * 单行文本
     */
    TEXT(1, "text"),
    /**
     * 多行文本
     */
    TEXTAREA(2, "textarea"),

    /**
     * 数字
     */
    NUMBER(3, "number"),
    /**
     * 小数
     */
    NUMBER_FLOAT(4, "number_float"),
    /**
     * 百分数
     */
    PERCENT(5, "percent"),
    /**
     * 日期
     */
    DATE(6, "date"),
    /**
     * 日期时间
     */
    DATETIME(7, "datetime"),
    /**
     * 单选
     */
    SELECT(8, "select"),
    /**
     * 多选
     */
    CHECKBOX(9, "checkbox"),
    /**
     * 手机
     */
    MOBILE(10, "mobile"),
    /**
     * 邮件
     */
    EMAIL(11, "email"),
    /**
     * 文件
     */
    FILE(12, "file"),
    /**
     * 人员
     */
    USER(13, "user"),
    /**
     * 部门
     */
    DEPT(14, "dept"),
    /**
     * 布尔值
     */
    BOOLEAN_VALUE(15, "boolean_value"),
    /**
     * 网址
     */
    WEBSITE(16, "website"),
    /**
     * crm 地图
     */
    ADDRESS(17, "address"),
    /**
     * 定位
     */
    POSITION(18, "position"),


    /**
     * 明细表格
     */
    DETAIL_TABLE(30, "detail_table"),
    /**
     * 手写签名
     */
    HANDWRITING_SIGN(31, "handwriting_sign"),
    /**
     * 日期区间
     */
    DATE_INTERVAL(32, "date_interval"),
    /**
     * 标签
     */
    TAG(33, "field_tag"),
    /**
     * 关注度字段
     */
    ATTENTION(34, "field_attention"),

    /**
     * 唯一编号
     */
    SERIAL_NUMBER(35, "serial_number"),

    /**
     * 计算公式
     */
    FORMULA(36, "formula"),
    /**
     * 经纬度字段类型
     */
    POSITION_LNG_LAT(37, "position_lng_lat"),
    ;

    FieldTypeEnum(int type, String formType) {
        this.type = type;
        this.formType = formType;
    }

    /**
     * 字段类型数字
     */
    private final Integer type;

    /**
     * 字段类型文本
     */
    private final String formType;

    public static FieldTypeEnum parse(Integer type) {
        for (FieldTypeEnum fieldTypeEnum : FieldTypeEnum.values()) {
            if (fieldTypeEnum.getType().equals(type)) {
                return fieldTypeEnum;
            }
        }
        return FieldTypeEnum.TEXT;
    }

    public static FieldTypeEnum parse(String formType) {
        for (FieldTypeEnum fieldTypeEnum : FieldTypeEnum.values()) {
            if (fieldTypeEnum.getFormType().equals(formType)) {
                return fieldTypeEnum;
            }
        }
        return TEXT;
    }



    public static String getCkDataType(Integer type) {
        String ret = "Nullable(String)";
        switch (parse(type)){
            case TEXT:
                break;
            case TEXTAREA:
                break;
            case SELECT:
                break;
            case DATE:
                ret = "Nullable(DateTime)";
                break;
            case NUMBER:
                ret = "Nullable(Int64)";
                break;
            case NUMBER_FLOAT:
                ret = "Nullable(Decimal(18, 2))";
                break;
            case MOBILE:
                break;
            case FILE:
                break;
            case CHECKBOX:
                break;
            case USER:
                break;
            case DEPT:
                break;
            case DATETIME:
                ret = "Nullable(DateTime)";
                break;
            case EMAIL:
                break;
            case WEBSITE:
                break;
            case BOOLEAN_VALUE:
                ret = "Nullable(Int8)";
                break;
            case PERCENT:
                break;
            case DETAIL_TABLE:
                break;
            case HANDWRITING_SIGN:
                break;
            case DATE_INTERVAL:
                break;
            case TAG:
                break;
            case ATTENTION:
                ret = "Nullable(Int8)";
                break;
            case SERIAL_NUMBER:
                break;
            case FORMULA:
                break;
            case POSITION_LNG_LAT:
                ret = "Nullable(Decimal(30, 20))";
                break;
        }
        return ret;
    }

    /**
     * @Description  module使用的es的类型做转换
     * @Author UNIQUE
     * @Date 2022/12/19
     * @Param
     * @return
     **/
    public static Integer getEsModuleType(Integer type) {
        switch (type) {
            case 2:
                return FieldTypeEnum.DATE.getType();
            case 3:
                return FieldTypeEnum.NUMBER_FLOAT.getType();
            case 5:
                return FieldTypeEnum.DATETIME.getType();
            default:
                return FieldTypeEnum.TEXT.getType();
        }
    }
    public static Integer getMysqlModuleType(String typeStr) {
        Integer ret = FieldTypeEnum.TEXT.getType();
        switch (typeStr) {
            case "bigint":
            case "timestamp":
            case "longblob":
            case "int":
            case "tinyint":
                ret = FieldTypeEnum.NUMBER.getType();
                break;
            case "datetime":
                ret = FieldTypeEnum.DATETIME.getType();
                break;
            case "decimal":
            case "double":
                ret = FieldTypeEnum.NUMBER_FLOAT.getType();
                break;
            case "date":
                ret = FieldTypeEnum.DATE.getType();
                break;
            case "varchar":
            case "text":
            case "longtext":
            case "char":
                ret = FieldTypeEnum.TEXT.getType();
                break;
            default:
        }
        return ret;
    }

    //--------------------------------------------------------------------
    public static void peekRecordValue(Map<String,Object> record ,String mapKey,Integer type, String value) {
        switch (parse(type)){
            case TEXT:
            case TEXTAREA:
            case NUMBER_FLOAT:
            case MOBILE:
            case FILE:
            case USER:
            case DEPT:
            case EMAIL:
            case WEBSITE:
            case PERCENT:
            case DETAIL_TABLE:
            case HANDWRITING_SIGN:
            case SERIAL_NUMBER:
            case FORMULA:
                record.put(mapKey,value);
                break;
            case SELECT:
                if (value.contains("{")) {
                    JSONObject item = JSONObject.parseObject(value);
                    if (ObjectUtil.isNotEmpty(item.get("value"))) {
                        record.put(mapKey,item.getString("value"));
                    }
                }else{
                    record.put(mapKey, value);
                }
                break;
            case CHECKBOX:
                if (value.contains("{")) {
                    JSONArray checkArray = JSONArray.parseArray(value);
                    StringBuffer checkStr = new StringBuffer();
                    for (Object r : checkArray) {
                        JSONObject item = (JSONObject) r;
                        if (ObjectUtil.isNotEmpty(item.get("value"))) {
                            checkStr.append(item.getString("value"));
                        }
                    }
                    if (ObjectUtil.isNotEmpty(checkStr.toString())) {
                        record.put(mapKey,checkStr.toString());
                    }
                }else{
                    record.put(mapKey, value);
                }
                break;
            case DATE_INTERVAL:
                if (value.contains("{")) {
                    JSONObject item = JSONObject.parseObject(value);
                    List<String> itemList = new ArrayList<>();
                    if (ObjectUtil.isNotEmpty(item.get("fromDate"))) {
                        itemList.add(item.getString("fromDate"));
                    }
                    if (ObjectUtil.isNotEmpty(item.get("toDate"))) {
                        itemList.add(item.getString("toDate"));
                    }
                    if (CollectionUtil.isNotEmpty(itemList)) {
                        record.put(mapKey, StrUtil.join(",",itemList));
                    }
                }else{
                    record.put(mapKey, value);
                }
                break;
            case ATTENTION:
            case BOOLEAN_VALUE:
                record.put(mapKey, NumberUtil.parseInt(value));
                break;
            case DATE:
            case DATETIME:
                record.put(mapKey, DateUtil.parse(value).toString());
                break;
            case NUMBER:
                record.put(mapKey,NumberUtil.parseLong(value));
                break;
            case ADDRESS:
                //地址转存结果
                if (value.contains("{")) {
                    JSONArray addressArray = JSONArray.parseArray(value);
                    List<String> addressList = new ArrayList<>();
                    String province = "", city = "", area = "", address = "";
                    for (Object r : addressArray) {
                        JSONObject item = (JSONObject) r;
                        String itemName = item.getString("name");
                        if (ObjectUtil.isNotEmpty(itemName)) {
                            addressList.add(itemName);
                            if (item.getInteger("id").equals(1)) {
                                province = itemName;
                            } else if (item.getInteger("id").equals(2)) {
                                city = itemName;
                            } else if (item.getInteger("id").equals(3)) {
                                area = itemName;
                            } else if (item.getInteger("id").equals(4)) {
                                address = itemName;
                            }
                        }
                    }
                    if (CollectionUtil.isNotEmpty(addressList)) {
                        record.put(mapKey, province + "," + city + ":" + area + ";" + address);
                    }
                }else{
                    record.put(mapKey, value);
                }
                break;
            case POSITION:
                //地址转存结果
                if (value.contains("{")) {
                    JSONObject item = JSONObject.parseObject(value);
                    if (ObjectUtil.isNotEmpty(item.getString("address"))) {
                        Map<String, String> address1 = CityUtil.addressResolution(item.getString("address"));
                        record.put(mapKey, address1.get("province") + "," + address1.get("city") + ":" + address1.get("town") + ";" + address1.get("address"));

                    }
                    if (ObjectUtil.isNotEmpty(item.get("lng"))) {
                        record.put(mapKey + "Lng", new BigDecimal(item.getString("lng")));
                    }
                    if (ObjectUtil.isNotEmpty(item.get("lat"))) {
                        record.put(mapKey + "Lat", new BigDecimal(item.getString("lat")));
                    }
                }else{
                    record.put(mapKey, value);
                }
                break;
            case TAG:
                //标签
                if (value.contains("{")) {
                    JSONArray tagArray = JSONArray.parseArray(value);
                    List<String> tagList = new ArrayList<>();
                    tagArray.forEach(r -> {
                        JSONObject tag = (JSONObject) r;
                        if (ObjectUtil.isNotEmpty(tag.get("name"))) {
                            tagList.add(tag.getString("name"));
                        }
                    });
                    record.put(mapKey, StrUtil.join(",", tagList));
                }else{
                    record.put(mapKey, value);
                }
                break;
            default:
                break;
        }
    }
}
