<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package.Mapper}.${table.mapperName}">

<#if enableCache>
    <!-- 开启二级缓存 -->
    <cache type="${cacheClassName}"/>

</#if>
<#if baseResultMap>
    <!-- 通用查询映射结果 -->
    <resultMap id="BaseResultMap" type="${package.Entity}.${entity}">
<#list table.fields as field>
<#if field.keyFlag><#--生成主键排在第一位-->
        <id column="${field.name}" property="${field.propertyName}" />
</#if>
</#list>
<#list table.commonFields as field><#--生成公共字段 -->
        <result column="${field.name}" property="${field.propertyName}" />
</#list>
<#list table.fields as field>
<#if !field.keyFlag><#--生成普通字段 -->
        <result column="${field.name}" property="${field.propertyName}" />
</#if>
</#list>
    </resultMap>

</#if>
<#if baseColumnList>
    <!-- 通用查询结果列 -->
    <sql id="Base_Column_List">
<#list table.commonFields as field>
        ${field.columnName},
</#list>
        ${table.fieldNames}
    </sql>

</#if>

    <select id="queryPageList" resultType="java.util.Map">
        select * from ${table.name} where 1=1
    </select>
    <select id="queryById" resultType="com.kakarote.crm.common.CrmModel">
        select a.* from ${table.name} as a
<#--        where customer_id = #{id}-->
    </select>
    <select id="queryDigestById" resultType="com.kakarote.crm.common.CrmModel">
        select
        (select count(1) from wk_crm_activity where type in (1,4) and activity_type = 2 and activity_type_id = a.customer_id and activity_type_id = activity_id) as activityCount
        from ${table.name}  as a
<#--        where a.customer_id = #{id}-->
    </select>
</mapper>
