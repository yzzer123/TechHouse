package com.yzzer.reflect;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ClassTest {

  @Test
  public void test1 () throws ClassNotFoundException {
    Class<?> aClass = Class.forName("java.util.LinkedList");
    System.out.println(aClass.getSuperclass());
  }

  /**
   * 获取带泛型的夫类
   */
  @Test
  public void test2 () throws ClassNotFoundException {
    Class<?> aClass = Class.forName("java.util.LinkedList");
    System.out.println(aClass.getGenericSuperclass());
  }

  @Test
  public void test3() throws ClassNotFoundException {
    Class<?> aClass = Class.forName("java.util.LinkedList");
    System.out.println(Arrays.toString(aClass.getInterfaces()));
  }

  @Test
   public void test4() throws Exception {
    Class<?> aClass = Class.forName("com.yzzer.reflect.beans.NewList");
    ParameterizedType type = (ParameterizedType) aClass.getGenericSuperclass();
    for (Type actualTypeArgument : type.getActualTypeArguments()) {
      System.out.println(actualTypeArgument.getClass());
      System.out.println(actualTypeArgument.getTypeName());
    }
  }
}
