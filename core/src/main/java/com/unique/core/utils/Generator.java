package com.unique.core.utils;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.enums.SqlLike;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.IFill;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.po.LikeTable;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Generator {

    public static final String GENERATOR_URL = "jdbc:mysql://8.142.109.85:3306/unexamine2";
    public static final String GENERATOR_USERNAME = "un";
    public static final String GENERATOR_PASSWORD = "password";
    public static final String GENERATOR_AUTHOR = "UNIQUE";
    public static final String GENERATOR_PACKAGE="com.unique.";
    public static final String GENERATOR_LOCAL_PATH = "E://mysnow//open//examine//";
    public static final String GENERATOR_PACKAGE_PATH = "//src//main//java";

    public static final String GENERATOR_LOCAL_XML_PATH = "E://mysnow//open//examine//web//src//main//resources//xml";

    public static void main(String[] args) {
        System.out.println("请模块名称：");
        Scanner inputScanner = new Scanner(System.in);
        String moduleName = inputScanner.next();
        String moduleName1 = "approve";
        String parentPackageName = GENERATOR_PACKAGE+moduleName1;
        String parckagePath = GENERATOR_LOCAL_PATH + moduleName1 + GENERATOR_PACKAGE_PATH;
        inputScanner.close();
        FastAutoGenerator.create(GENERATOR_URL, GENERATOR_USERNAME, GENERATOR_PASSWORD)
                .globalConfig(builder -> {
                    builder.author(GENERATOR_AUTHOR) // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(parckagePath); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent(parentPackageName) // 设置父包名
                            .entity("entity.po")
//                            .moduleName("examine") // 设置父包模块名
//                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, GENERATOR_LOCAL_XML_PATH))// 设置mapperXml生成路径
                    ;
                })
                .strategyConfig(builder -> {
                    List<IFill> tableFillList=new ArrayList<>();
                    tableFillList.add(new Column("create_time", FieldFill.INSERT));
                    tableFillList.add(new Column("update_time", FieldFill.UPDATE));
                    tableFillList.add(new Column("create_user_id", FieldFill.INSERT));
                    tableFillList.add(new Column("update_user_id", FieldFill.UPDATE));
                    tableFillList.add(new Column("company_id", FieldFill.INSERT_UPDATE));
                    builder
//                            .addInclude("wk_examine") // 设置需要生成的表名
                            .enableSkipView()
                            .addTablePrefix("un_")// 设置过滤表前缀
                            .likeTable(new LikeTable("un_"+moduleName, SqlLike.RIGHT))
                            .entityBuilder().enableLombok().addTableFills(tableFillList)
                            .controllerBuilder().enableRestStyle()
//                            .mapperBuilder().superClass("com.kakarote.core.servlet.BaseMapper")
//                            .serviceBuilder().superServiceClass("com.kakarote.core.servlet.BaseService")
//                            .superServiceImplClass("com.kakarote.core.servlet.BaseServiceImpl")
                            .build()

                    ;
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
