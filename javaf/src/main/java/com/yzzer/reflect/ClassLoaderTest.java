package com.yzzer.reflect;

import com.yzzer.reflect.beans.Person;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClassLoaderTest {

  @Test
  public void test1() {
    ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
    // 系统类加载器
    System.out.println(systemClassLoader);

    // 扩展类加载器
    System.out.println(systemClassLoader.getParent());

    // 引导类加载器
    System.out.println(systemClassLoader.getParent().getParent());
  }

  @Test
  public void test2() throws ClassNotFoundException {
    // 用户自定义类使用系统类加载器
    System.out.println(Person.class.getClassLoader());

    // 核心api使用引导类加载器
    Class<?> aClass = Class.forName("java.lang.String");
    System.out.println(aClass.getClassLoader());
  }

  @Test
  public void test3() throws IOException {
    Properties properties = new Properties();
    FileInputStream inputStream = new FileInputStream("info.properties");
    properties.load(inputStream);

    System.out.println(properties.get("name"));
    System.out.println(properties.get("password"));

    inputStream.close();
  }

  @Test
  public void test4() throws Exception{
    Properties properties = new Properties();

    // 读取src下的文件
    InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("info.properties");
    properties.load(inputStream);

    System.out.println(properties.get("name"));
    System.out.println(properties.get("password"));

    assert inputStream != null;
    inputStream.close();
  }

}
