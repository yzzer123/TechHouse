package com.yzzer.reflect;

import com.yzzer.reflect.beans.Person;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class MethodTest {

  @Test
  public void testMethod() {
    Class<Person> personClass = Person.class;
    for (Method declaredMethod : personClass.getDeclaredMethods()) {
      System.out.print(declaredMethod.getName() + " ");
      System.out.print(Modifier.toString(declaredMethod.getModifiers()) + " ");
      System.out.print(declaredMethod.getReturnType() + " ");
      System.out.print(Arrays.toString(declaredMethod.getAnnotations()) + " ");
      System.out.print(Arrays.toString(declaredMethod.getParameterTypes()) + "\n ");
      System.out.println(declaredMethod);

    }
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testMethod2() throws Exception {
    Class<Person> personClass = Person.class;
    Person person = personClass.newInstance();

    Method showNation = personClass.getDeclaredMethod("showNation", String.class);
    showNation.setAccessible(true);

    // 如果方法返回值为void 则返回null
    System.out.println(showNation.invoke(person, "yzzer"));

    Method showNation1 = personClass.getDeclaredMethod("showNation", String.class, int.class, double.class);
    showNation1.setAccessible(true);
    System.out.println(showNation1.invoke(null, "CN", 123, 12.1));
  }
}
