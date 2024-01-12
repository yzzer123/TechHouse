package com.yzzer.enums;

/**
 * JDK5
 * 当开发中实例数量可以确定时 可以将其变为枚举类
 */
public enum Season implements Info{

    // 必须将枚举类的开头声明多个变量, 各自实现接口
    SPRING("春天", "春暖花开") {
        @Override
        public void greet() {
            System.out.println("hello spring");
        }
    },
    SUMMER("夏天", "夏日炎炎")  {
        @Override
        public void greet() {
            System.out.println("hello summer");
        }
    },
    AUTUMN("秋天", "秋高气爽")  {
        @Override
        public void greet() {
            System.out.println("hello autumn");
        }
    },
    WINTER("冬天", "白雪皑皑")  {
        @Override
        public void greet() {
            System.out.println("hello winter");
        }
    };


    private final String seasonName;
    private final String seasonDesc;

    Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public void show() {
        System.out.println(this);
    }
}

interface Info {
    void show();

    void greet();
}