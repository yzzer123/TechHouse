package com.yzzer.enums;

import java.util.Arrays;

public class SeasonTest {

    public static void main(String[] args) {

        // enum的父类
        System.out.println(Season.SPRING.getClass());
        System.out.println(Season.SPRING.getClass().getSuperclass());
        System.out.println(Season.SPRING.getClass().getSuperclass().getSuperclass());

        // enum的方法
        System.out.println(Season.SPRING); // 优先使用toString
        System.out.println(Season.SPRING.name());
        Arrays.stream(Season.values()).forEach(System.out::println);

        System.out.println(Season.valueOf("WINTER").getSeasonName());
        System.out.println(Season.valueOf("WINTER").ordinal()); // 获取次序号 默认从0开始

        // enum实现接口
        Info info = Season.SPRING;
        info.show();
        info.greet();
    }
}
