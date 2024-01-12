package com.yzzer.enums;

/**
 * 使用枚举类实现单例子模式
 */
public enum SingleInstance {

    INSTANCE;

    public void method() {
        System.out.println(this);
    }
}
