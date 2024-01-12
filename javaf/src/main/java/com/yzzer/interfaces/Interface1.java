package com.yzzer.interfaces;

public interface Interface1 {

    final public static int staticProp = 1;

    // 接口方法
    public void method1();

    // jdk8 默认方法
    public default void method2() {
        method3();
        System.out.println("hello");
    }

    // jdk9 私有方法
    private void method3() {
        System.out.println("method3");
    }

    public default void method4() {
        method3();
        System.out.println("hello");
    }
}
