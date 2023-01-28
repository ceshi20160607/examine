package com.unique.examine.common.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class Generator {

    public static final String GENERATOR_URL="localhost:3306/anji20221229";
    public static final String GENERATOR_USERNAME="root";
    public static final String GENERATOR_PASSWORD="password";
    public static final String GENERATOR_AUTHOR="UNIQUE";
    public static final String GENERATOR_PACKAGE="com.unique.examine";
    public static final String GENERATOR_LOCAL_PATH="D://download//java//generator";

    public static void main(String[] args) {
        FastAutoGenerator.create(GENERATOR_URL, GENERATOR_USERNAME, GENERATOR_PASSWORD)
                .globalConfig(builder -> {
                    builder.author(GENERATOR_AUTHOR) // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(GENERATOR_LOCAL_PATH); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent(GENERATOR_PACKAGE) // 设置父包名
                            .moduleName("examine") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, GENERATOR_LOCAL_PATH)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("wk_examine") // 设置需要生成的表名
//                            .addTablePrefix("t_", "c_")// 设置过滤表前缀
                    ;
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
