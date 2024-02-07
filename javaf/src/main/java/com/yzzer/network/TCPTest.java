package com.yzzer.network;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class TCPTest {
  @Test
  public void client() throws UnknownHostException {
    InetAddress localhost = InetAddress.getByName("localhost");
    int port = 8989;
    try (Socket socket = new Socket(localhost, port);
         OutputStream outputStream = socket.getOutputStream();
         InputStream inputStream = socket.getInputStream()) {

      outputStream.write("你好，我是客户端".getBytes(StandardCharsets.UTF_8));
      System.out.println(new String(inputStream.readAllBytes()));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  public void client2() throws UnknownHostException {
    InetAddress localhost = InetAddress.getByName("localhost");
    int port = 8989;
    try (Socket socket = new Socket(localhost, port);
         OutputStream outputStream = socket.getOutputStream();
         InputStream inputStream = socket.getInputStream();
         ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {

      outputStream.write("你好，我是客户端".getBytes(StandardCharsets.UTF_8));

      byte[] buffer = new byte[3];
      int len;
      while ((len = inputStream.read(buffer)) != -1) {
        byteArrayOutputStream.write(buffer, 0, len);  // 防止将字符拆封为多个字节导致的乱码
      }
      System.out.println(byteArrayOutputStream);

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  public void client3() throws UnknownHostException {
    InetAddress localhost = InetAddress.getByName("localhost");
    int port = 8989;
    try (Socket socket = new Socket(localhost, port);
         OutputStream outputStream = socket.getOutputStream();
         FileInputStream fileInputStream = new FileInputStream("hello.png");
         InputStream msgReceiver = socket.getInputStream();
         ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {

      byte[] buffer = new byte[1024];
      int size = 0;
      while ((size = fileInputStream.read(buffer)) != -1) {
        outputStream.write(buffer, 0, size);
      }
      socket.shutdownOutput();

      while ((size = msgReceiver.read(buffer)) != -1) {
        byteArrayOutputStream.write(buffer, 0, size);
      }
      System.out.println(byteArrayOutputStream);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  public void server() {
    try (ServerSocket server = new ServerSocket(8989)) {

      while (true) {
        try (Socket socket = server.accept();
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream()) {
          byte[] buffer = new byte[2048];
          int len = is.read(buffer);
          System.out.println(new String(buffer, 0, len));
          os.write("我收到了，欢迎～".getBytes(StandardCharsets.UTF_8));
          os.flush();
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  public void server2() {
    try (ServerSocket server = new ServerSocket(8989)) {

      while (true) {
        try (Socket socket = server.accept();
             InputStream is = socket.getInputStream();
             OutputStream os = socket.getOutputStream();
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
          System.out.println("收到来自 " + socket.getInetAddress().getHostAddress() + "的消息");

          byte[] buffer = new byte[2048];
          int len = is.read(buffer);
          byteArrayOutputStream.write(buffer, 0, len);
          System.out.println(byteArrayOutputStream);
          os.write("我收到了，欢迎～".getBytes(StandardCharsets.UTF_8));
          os.flush();
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  public void server3() {
    try (ServerSocket server = new ServerSocket(8989)) {

      while (true) {
        try (Socket socket = server.accept();
             InputStream is = socket.getInputStream();
             FileOutputStream os = new FileOutputStream("hello-net.png");
             OutputStream msgSender = socket.getOutputStream()) {
          System.out.println("收到来自 " + socket.getInetAddress().getHostAddress() + "的消息");

          byte[] buffer = new byte[32];
          int len = 0;
          while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
          }

          msgSender.write("我收到了图片，感谢～".getBytes(StandardCharsets.UTF_8));
          msgSender.flush();
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
