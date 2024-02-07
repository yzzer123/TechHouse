package com.yzzer.reflect;

import com.yzzer.reflect.beans.Person;
import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {

  @Test
  public void test1() {
    // 创建对象
    Person person = new Person();

    // 调用属性
    person.age = 10;
    System.out.println(person.age);

    // 调用方法
    person.show();
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testReflection1() throws Exception {
    // 创建对象
    Class<Person> clazz = Person.class;
    Person person = clazz.newInstance();
    System.out.println(person);

    // 获取属性
    Field ageField = clazz.getField("age");
    ageField.set(person, 10);
    System.out.println(ageField.get(person));

    // 调用方法
    Method showMethod = clazz.getMethod("show");
    showMethod.invoke(person);
  }

  @Test
  public void testPrivatePriority() throws Exception {
     // 调用私有构造器
    Class<Person> clazz = Person.class;
    Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class, int.class);
    constructor.setAccessible(true);
    Person person = constructor.newInstance("yzer", 12);
    System.out.println(person);

    // 私有属性
    Field nameField = clazz.getDeclaredField("name");
    nameField.setAccessible(true);
    nameField.set(person, "Tom");
    System.out.println(person);
    System.out.println(nameField.get(person));

    // 私有方法
    Method showNationMethod = clazz.getDeclaredMethod("showNation", String.class);
    showNationMethod.setAccessible(true);
    String returnValue = (String) showNationMethod.invoke(person, "CN");
    System.out.println(returnValue);
  }

  @Test
  public void getClassInstance() throws ClassNotFoundException {
    Class<Person> personClass = Person.class;

    Person person = new Person();
    Class<? extends Person> personClass2 = person.getClass();

    Class<?> personClass3 = Class.forName("com.yzzer.reflect.beans.Person");

    // 类加载器
    Class<?> personClass4 = ClassLoader.getSystemClassLoader().loadClass("com.yzzer.reflect.beans.Person");

    Assert.assertEquals(personClass, personClass2);
    Assert.assertEquals(personClass2, personClass3);
    Assert.assertEquals(personClass3, personClass4);
  }

  @Test
  public void testClassObject() {
    Class c1 = Object.class;
    Class c2 = Comparable.class;
    Class c3 = String[].class;
    Class c4 = int[][].class;
    Class c5 = ElementType.class;
    Class c6 = Override.class;
    Class c7 = int.class;
    Class c8 = void.class;
    Class c9 = Class.class;
  }
}
