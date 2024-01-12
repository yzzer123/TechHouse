package com.yzzer.interfaces;

public interface Interface2 {
    final public static int staticProp = 1;

    public void method12();

    public default void method2() {
        method3();
        System.out.println("hello");
    }

    private void method3() {
        System.out.println("method3");
    }

    public default void method4() {
        method3();
        System.out.println("hello4");
    }

    public default void method5() {
        method3();
        System.out.println("hello5");
    }
}
