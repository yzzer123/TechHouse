package com.yzzer.reflect;

import com.yzzer.reflect.beans.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.LinkedList;

public class ConstructorTest {

  @Test
  public void test1() throws Exception {
    Class<Person> personClass = Person.class;
    Constructor<Person> constructor = personClass.getDeclaredConstructor(Collection.class, String.class, int.class);
    constructor.setAccessible(true);
    Person person = constructor.newInstance(new LinkedList<String>(), "yzzer", 25);
    person.show();
  }

  @Test
  public void test2() throws Exception {
    Class<Person> personClass = Person.class;
    Constructor<Person> constructor = personClass.getDeclaredConstructor();
    constructor.setAccessible(true);
    Person person = constructor.newInstance();
    person.show();
  }

}
