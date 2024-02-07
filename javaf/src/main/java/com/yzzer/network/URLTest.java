package com.yzzer.network;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {

  @Test
  public void testUrl1() {
    String imgUrl = "https://pss.bdstatic.com:9090/static/superman/img/logo/bd_logo1-66368c33f8.png?name=yzzer";
    try {
      URL url = new URL(imgUrl);
      System.out.println(url.getProtocol());
      System.out.println(url.getHost());
      System.out.println(url.getPort());
      System.out.println(url.getPath());
      System.out.println(url.getQuery());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  public void testDownload() {
    String imgUrl = "https://pss.bdstatic.com/static/superman/img/logo/bd_logo1-66368c33f8.png";
    try {
      URL url = new URL(imgUrl);
      URLConnection urlConnection = url.openConnection();
      try (InputStream inputStream = urlConnection.getInputStream();
           FileOutputStream outputStream = new FileOutputStream("net.png")) {
        byte[] buffer = new byte[256];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
          outputStream.write(buffer, 0, len);
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
