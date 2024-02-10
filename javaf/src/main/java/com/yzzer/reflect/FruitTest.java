package com.yzzer.reflect;

import com.yzzer.reflect.beans.Fruit;
import com.yzzer.reflect.beans.Juicer;
import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class FruitTest {

  @Test
  public void test1() throws Exception {
    InputStream is = ClassLoader.getSystemResourceAsStream("beanConfig.properties");
    Properties props = new Properties();
    props.load(is);
    String className = props.getProperty("fruitName");

    Class<?> friutClass = Class.forName(className);
    Constructor<?> constructor = friutClass.getDeclaredConstructor();
    constructor.setAccessible(true);
    Fruit fruit = (Fruit) constructor.newInstance();
    new Juicer().run(fruit );
  }
}
