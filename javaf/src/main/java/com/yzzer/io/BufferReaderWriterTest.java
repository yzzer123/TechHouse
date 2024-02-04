package com.yzzer.io;

import org.junit.Test;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 缓冲流
 */
public class BufferReaderWriterTest {

  @Test
  public void test1() {
    copyByBuffer("hello.txt", "hello_copy.txt");
  }

  @Test
  public void testPerformance() {
    long start = System.currentTimeMillis();
    copyByBuffer("hello.txt", "hello_copy.txt");
    long end = System.currentTimeMillis();
    System.out.println("cost: " + (end - start) + "ms");

    start = System.currentTimeMillis();
    copyByRaw("hello.txt", "hello_copy.txt");
    end = System.currentTimeMillis();
    System.out.println("cost: " + (end - start) + "ms");
  }

  @Test
  public void testReader() {
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader("hello.txt"))) {
      for (int i = 0; i < 10; i++) {
        System.out.println(bufferedReader.readLine());
        assert bufferedReader.readLine() != null;  // check if jump to end-of-file
      }
      List<String> lines = bufferedReader.lines().sorted().collect(Collectors.toList());
      for (int i = 0; i < 10; i++) {
        System.out.println(lines.get(i));
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  public void testWriter() {
    try (BufferedWriter bufferedWriter = new  BufferedWriter(new FileWriter("write.txt"))) {
      bufferedWriter.newLine();
      bufferedWriter.newLine();
      bufferedWriter.flush();  // 刷写磁盘
      bufferedWriter.write("hello\n");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void copyByBuffer(String src, String des) {
    File sourceFile = new File(src);
    File targetFile = new File(des);

     /*
    try (FileInputStream is = new FileInputStream(sourceFile);
         BufferedInputStream inputStream = new BufferedInputStream(is);
         FileOutputStream os = new FileOutputStream(targetFile);
         BufferedOutputStream outputStream = new BufferedOutputStream(os)){
     */

    try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(sourceFile));
         BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(targetFile))){
      byte[] buffer = new byte[1024];
      int len;
      while ((len = inputStream.read(buffer)) != -1) {
        outputStream.write(buffer, 0, len);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void copyByRaw(String src, String des) {
    File sourceFile = new File(src);
    File targetFile = new File(des);

    try (FileInputStream inputStream = new FileInputStream(sourceFile);
         FileOutputStream outputStream = new FileOutputStream(targetFile)){
      byte[] buffer = new byte[1024];
      int len;
      while ((len = inputStream.read(buffer)) != -1) {
        outputStream.write(buffer, 0, len);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
