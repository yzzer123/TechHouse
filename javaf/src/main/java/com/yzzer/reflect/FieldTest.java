package com.yzzer.reflect;

import com.yzzer.reflect.beans.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * JDK17 中对于 JDK Core API 做了强封装，无法通过反射访问私有属性和方法了
 */
public class FieldTest {

  @Test
  public void testGetField() {
    Class<Person> personClass = Person.class;
    Field[] fields = personClass.getFields();
    System.out.println(Arrays.toString(fields));

    Field[] declaredFields = personClass.getDeclaredFields();
    System.out.println(Arrays.toString(declaredFields));

    for (Field declaredField : declaredFields) {
      // 获取权限修饰符
      System.out.print(Modifier.toString(declaredField.getModifiers()) + " ");

      // 获取类型
      System.out.print(declaredField.getType() + "  ");

      // 获取名字
      System.out.println(declaredField.getName());
    }
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testGetAndSet() throws Exception {
    Class<Person> personClass = Person.class;
    Person person = personClass.newInstance();
    Field age = personClass.getField("age");  // 只能获取public
    Field name = personClass.getDeclaredField("name");
    Field weight = personClass.getDeclaredField("weight");

    age.set(person, 123);
    name.setAccessible(true);
    name.set(person, "yzer");
    weight.setAccessible(true);
    weight.set(Person.class, 10000);
    System.out.println(age.get(person)) ;
    System.out.println(name.get(person));
    System.out.println(weight.get(Person.class));

    weight.set(null, 1000);
    System.out.println(weight.get(null));

  }
}
