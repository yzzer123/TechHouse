package com.yzzer.reflect.beans;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE}) // 注解的修饰区域
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation{
  String value() default "123";
}
