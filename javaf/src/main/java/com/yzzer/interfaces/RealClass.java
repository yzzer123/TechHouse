package com.yzzer.interfaces;

public class RealClass extends SubClass implements Interface1, Interface2{
    @Override
    public void method1() {

    }

    @Override
    public void method12() {

    }

    // method4 冲突了必须实现
    @Override
    public void method4() {
        Interface1.super.method4();
        Interface2.super.method4();
    }

    // 继承了SubClass后，SubClass自带method2的实现，所以不需要实现method2
//    @Override
//    public void method2() {
//        super.method2();
//    }
}
