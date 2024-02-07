package com.yzzer.network;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

public class UDPTest {

  @Test
  public void sender() {
    try (DatagramSocket datagramSocket = new DatagramSocket()) {
      byte[] data = "你好啊,我是yzer".getBytes();
      InetAddress localhost = InetAddress.getByName("localhost");
      DatagramPacket packet = new DatagramPacket(data, data.length, localhost, 8989);
      for (int i = 0; i < 10; i++) {
        datagramSocket.send(packet);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  public void receiver() {
    try (DatagramSocket ds = new DatagramSocket(8989)) {
      byte[] buffer = new byte[2048];
      DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

      for(int i = 0; i < 10; i++) {
        ds.receive(packet);
        System.out.println(new String(packet.getData(), 0, packet.getLength()));
      }

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
