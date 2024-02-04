package com.yzzer.io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamTest {

  @Test
  public void copyTest3() {
    // 可以处理图片和文本 更通用
    File readFile = new File("hello.png");
    File writeFile = new File("hello_copy.png");

    try (FileInputStream inputStream = new FileInputStream(readFile);
         FileOutputStream outputStream = new FileOutputStream(writeFile, false)) {
      byte[] buffer = new byte[4];
      int len = 0;
      while ((len = inputStream.read(buffer)) != -1) {
        outputStream.write(buffer, 0, len);
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
