package com.unique.javassist.swaggerbody;

public @interface ApiResponseProperty {

    String name();

    String description() default "";

    String type();

}

