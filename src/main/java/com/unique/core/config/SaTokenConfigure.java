package com.unique.core.config;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaHttpMethod;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author UNIQUE
 * @create 2023-03-25
 * @verson 1.0.0
 */
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {

    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册 Sa-Token 拦截器，校验规则为 StpUtil.checkLogin() 登录校验。
        registry.addInterceptor(new SaInterceptor(handle -> StpUtil.checkLogin()))
                .addPathPatterns("/**")
                .excludePathPatterns("/user/doLogin");
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new SaInterceptor(handle -> {
//            SaRouter.match("/**")
//                    .notMatch(excludePaths())
//                    .check(r -> StpUtil.checkLogin());
//        })).addPathPatterns("/**");
//    }
//
//    // 动态获取哪些 path 可以忽略鉴权
//    public List<String> excludePaths() {
//        // 此处仅为示例，实际项目你可以写任意代码来查询这些path
//        return Arrays.asList("/user/doLogin");
//    }

    //当实现了implements WebMvcConfigurer的时候，必须手动设置进去。
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(getObjectMapper());
        converters.add(converter);
    }
    /**
     * 设置localdatetime的序列化与反序列化的方式
     *
     * @return
     */
    @Bean(name = "mapperObject")
    public ObjectMapper getObjectMapper() {
        ObjectMapper om = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();

        //这个返回时间戳   注意这里的LocalDateTimeSerializer是上面自己实现的一
        //javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        //返回指定字符串格式 这里的LocalDateTimeSerializer是com.fasterxml.jackson.datatype.jsr310.ser下的
        javaTimeModule.addSerializer(LocalDateTime.class, new com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
        javaTimeModule.addSerializer(Long.class, ToStringSerializer.instance);
        javaTimeModule.addSerializer(Long.TYPE, ToStringSerializer.instance);

        // 这个反序列化。接受前端传来的格式
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        // 这两个得加上。不然他俩默认返回了List结构
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        javaTimeModule.addDeserializer(Date.class, new DateDeserializers.DateDeserializer());
//        javaTimeModule.addDeserializer(Date.class, new DateDeserializer());

        om.registerModule(javaTimeModule);
        return om;
    }


    /**
     * get方式的参数 定义String与对应类型的转换方式
     *
     * @return
     */
    @Bean
    public Converter<String, LocalDateTime> LocalDateTimeConvert() {
        return new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(String source) {
                if (ObjectUtil.isEmpty(source)) {
                    return null;
                }
                return LocalDateTime.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            }

        };
    }

    /**
     * date反序列化
     */
    public static class DateDeSerializer extends JsonDeserializer<Date> {

        @Override
        public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            String text = p.getText();
            if (StrUtil.isNotEmpty(text)) {
                return DateUtil.parse(text);
            }
            return null;
        }
    }

//    /**
//     * 注册 [Sa-Token全局过滤器]
//     */
//    @Bean
//    public SaServletFilter getSaServletFilter() {
//        return new SaServletFilter()
//                    // 拦截与排除 path
//                .addInclude("/**")
//                .addExclude("/favicon.ico","/user/doLogin")
////                    // 全局认证函数
////                .setAuth(obj -> {
////                    System.out.println("---------- 进入Sa-Token全局认证 -----------");
////
////                    // 登录认证 -- 拦截所有路由，并排除/user/doLogin 用于开放登录
////                    SaRouter.match("/**", "/user/doLogin", () -> StpUtil.checkLogin());
////                    // 更多拦截处理方式，请参考“路由拦截式鉴权”章节 */
////                })
////
////                // 异常处理函数
////                .setError(e -> {
////                    return AjaxJson.getError(e.getMessage());
////                })
//                // 前置函数：在每次认证函数之前执行
//                .setBeforeAuth(obj -> {
//                    // ---------- 设置跨域响应头 ----------
//                    SaHolder.getResponse()
//                            // 允许指定域访问跨域资源
//                            .setHeader("Access-Control-Allow-Origin", "*")
//                            // 允许所有请求方式
////                            .setHeader("Access-Control-Allow-Methods", "*")
//                            .setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
//                            // 有效时间
//                            .setHeader("Access-Control-Max-Age", "3600")
//                            // 允许的header参数
//                            .setHeader("Access-Control-Allow-Headers", "*");
//                    // 如果是预检请求，则立即返回到前端
//                    SaRouter.match(SaHttpMethod.OPTIONS)
//                            .free(r -> System.out.println("--------OPTIONS预检请求，不做处理"))
//                            .back();
//                });
//    }
}
