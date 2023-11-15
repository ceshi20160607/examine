package com.unique;

import cn.dev33.satoken.SaManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.unique.*.mapper")
public class ExamineApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamineApplication.class, args);

        System.out.println("启动成功：Sa-Token配置如下：" + SaManager.getConfig());
    }
//    public static void main(String[] args) throws JsonProcessingException {
//        SpringApplication.run(ExamineApplication.class, args);
//        System.out.println("启动成功：Sa-Token配置如下：" + SaManager.getConfig());
//    }

}
