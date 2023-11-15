package com.unique.core.log;


import com.unique.core.enums.BehaviorEnum;
import com.unique.core.enums.ModelTypeEnum;

import java.lang.annotation.*;

/** 记录日志
 * @author UNIQUE
 * @create 2023-02-15 16:56
 * @verson 1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface SysLogHandler {

    /**
     * 模块名称
     */
    String applicationName() default "";

    /**
     * 子模块名称
     */
    ModelTypeEnum subModel() default ModelTypeEnum.NULL;


    /**
     * 操作
     */
    BehaviorEnum behavior() default BehaviorEnum.NULL;

    /**
     * 操作对象
     */
    String object() default "";
    /**
     * 操作详情
     */
    String detail() default "";

    /**
     * 默认为false
     * false 注解在Controller,需要自己重写操作日志逻辑,返回Content
     * true 注解在操作记录实现类,针对已经写过操作记录的方法,直接修改操作记录返回值为Content类型,切面直接获取返回值。
     */
    boolean isReturn() default false;

}
