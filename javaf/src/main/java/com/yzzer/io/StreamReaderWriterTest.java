package com.yzzer.io;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 转换流
 */
public class StreamReaderWriterTest {

  @Test
  public void testRead() {
     try (InputStreamReader reader = new InputStreamReader(new FileInputStream("hello_gbk.txt"), "gbk")) {
       char[] buffer = new char[256];
       int len;
       while ((len = reader.read(buffer)) != -1) {
         System.out.println(new String(buffer, 0, len));
       }

     } catch (IOException e) {
       throw new RuntimeException(e);
     }
  }

  @Test
  public void testWriter() {
    final String sourceCode = "gbk";
    final String targetCode = "utf-8";

    try (InputStreamReader reader = new InputStreamReader(new FileInputStream("hello_gbk.txt"), "gbk");
         OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("hello_gkb_2_utf8.txt"), StandardCharsets.UTF_8)) {
      char[] buffer = new char[256];
      int len;
      while ((len = reader.read(buffer)) != -1) {
        writer.write(buffer, 0, len);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }
}
