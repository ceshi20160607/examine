package com.kakarote.crm.common.swaggerparams;

import com.kakarote.core.common.enums.CrmEnum;

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
    CrmEnum label() default CrmEnum.NULL;
}
