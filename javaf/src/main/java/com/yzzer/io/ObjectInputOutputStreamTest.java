package com.yzzer.io;

import com.yzzer.io.beans.Person;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ObjectInputOutputStreamTest {

  @Test
  public void testWriteData() {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.bin"))) {
      oos.writeInt(123);
      oos.writeUTF("hello");
      oos.writeDouble(12.3);
      oos.writeBoolean(false);
      oos.writeShort(10);
      oos.writeObject(new String("这是一个对象哈哈哈哈".getBytes(StandardCharsets.UTF_16BE), StandardCharsets.UTF_16BE));
    } catch (IOException e) {
      throw  new RuntimeException(e);
    }
  }

  @Test
  public void testReadData() {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.bin"))) {
      System.out.println(ois.readInt());
      System.out.println(ois.readUTF());
      System.out.println(ois.readDouble());
      System.out.println(ois.readBoolean());
      System.out.println(ois.readShort());
      System.out.println(ois. readObject());
    } catch (IOException | ClassNotFoundException ioe) {
      throw  new RuntimeException(ioe);
    }
  }

  @Test
  public void testWriteObj() {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.bin"))) {
       oos.writeObject(new Person("y zer", 24));
    } catch (IOException e) {
      throw  new RuntimeException(e);
    }
  }

  @Test
  public void testReadObj() {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.bin"))) {
      Object o = ois.readObject();
      System.out.println(o);
    } catch (IOException | ClassNotFoundException ioe) {
      throw  new RuntimeException(ioe);
    }
  }
  
  
}
