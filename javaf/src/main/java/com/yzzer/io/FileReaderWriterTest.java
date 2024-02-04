package com.yzzer.io;

import org.junit.Test;

import java.io.*;

public class FileReaderWriterTest {

  @Test
  public void readTest1() {
    File file = new File("hello.txt");

    try (FileReader fileReader = new FileReader(file)) {
      int data;
      while ((data = fileReader.read()) != -1) {
        System.out.println((char) data);
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  @Test
  public void readTest2() {
    File file = new File("hello.txt");

    try (FileReader fileReader = new FileReader(file)) {
      char[] buffer = new char[256];
      int len;
      while ((len = fileReader.read(buffer)) != -1) {
        for (int i = 0; i < len; i++) {
          System.out.print(buffer[i]);
        }
        System.out.println();
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  @Test
  public void writeTest1() {
    File file = new File("hello.txt");

    try (FileWriter fileWriter = new FileWriter(file)) {
      fileWriter.write("Hello World\n");
      fileWriter.write("Hello World2");
      fileWriter.write("Hello World3\n");
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  @Test
  public void writeTest2() {
    File file = new File("hello.txt");

    try (FileWriter fileWriter = new FileWriter(file, true)) {
      fileWriter.write("Hello World\n");
      fileWriter.write("Hello World2");
      fileWriter.write("Hello World3\n");
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }


  @Test
  public void copyTest() {
    File readFile = new File("hello.txt");
    File writeFile = new File("hello_copy.txt");

    try (FileReader fileReader = new FileReader(readFile);
         FileWriter fileWriter = new FileWriter(writeFile, false)) {
      char[] buffer = new char[4];
      int len = 0;
      while ((len = fileReader.read(buffer)) != -1) {
        fileWriter.write(buffer, 0, len);
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  @Test
  public void copyTest2() {
    // 无法处理图片
    File readFile = new File("hello.png");
    File writeFile = new File("hello_copy.png");

    try (FileReader fileReader = new FileReader(readFile);
         FileWriter fileWriter = new FileWriter(writeFile, false)) {
      char[] buffer = new char[4];
      int len = 0;
      while ((len = fileReader.read(buffer)) != -1) {
        fileWriter.write(buffer, 0, len);
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
