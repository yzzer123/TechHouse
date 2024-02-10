package com.yzzer.newfeatures;


import org.junit.Test;

record RecordTestBean(int id, String name, int age, long height) {

  // 可以定义静态字段、方法、构造器和实例方法
  // 不能声明父类 定义实例变量 声明abstract类
}
public class RecordTest {

  @Test
  public void test1() {
    RecordTestBean recordTestBean = new RecordTestBean(12, "name", 12, 123L);
  }
}
