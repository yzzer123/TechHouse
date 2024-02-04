package com.yzzer.io.beans;

import java.io.Serial;
import java.io.Serializable;

public class Person implements Serializable {

  // 没有声明的话会自动生成， 一旦修改会出现问题
  @Serial
  private static final long  serialVersionUID = 42L;

  private String name;
  transient private Integer age;  // 不会实现序列化

  public Person(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public Person() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
  }
}
