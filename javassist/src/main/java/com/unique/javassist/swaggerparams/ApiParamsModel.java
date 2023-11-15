package com.unique.javassist.swaggerparams;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * API处理方法注解
 *
 * @author UNIQUE
 * @date 2023/11/02
 */
@Target({
        ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiParamsModel {
//    CrmEnum label() default CrmEnum.NULL;
}
