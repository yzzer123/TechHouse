package com.yzzer.anotations;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE}) // 注解的修饰区域
@Retention(RetentionPolicy.SOURCE) // 注解需要保留在什么生命周期， SOURCE 表示只保留在代码中，CLASS表示只存在在字节码文件和源代码，RUNTIME表示在运行时有
@Documented // 表示需要被JavaDoc解析
@Inherited // 允许子类继承父类中的注解
public @interface MyAnnotation {

    String value();
}
