package com.yzzer.reflect.beans;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;

public class Person extends LinkedList<String> implements MyInterface, Serializable, Comparable<Person> {

  @Serial
  private static final long serialVersionUID = 123L;

  //属性
  private String name;
  public int age;
  private static int weight = 100;

  //构造器
  public Person(){
    System.out.println("Person()...");
  }

  private Person(int age){
    this.age = age;
  }

  private Person(String name, int age){
    this.name = name;
    this.age = age;
  }

  private Person(Collection<? extends String> c, String name, int age) {
    super(c);
    this.name = name;
    this.age = age;
  }

  //方法
  public void show(){
    System.out.println("你好，我是一个Person");
  }

  @MyAnnotation(value = "hi")
  private String showNation(String nation){
    return "我的国籍是：" + nation;
  }
  private static void showNation(String nation, int age, double db){
    System.out.println("我的国籍是：" + nation + " " + age + " " + db);
  }

  @Override
  public String toString() {
    return "Person{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
  }

  @Override
  public int compareTo(Person o) {
    return 0;
  }
}


