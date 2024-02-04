package com.yzzer.network;

import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressTest {

  @Test
  public void test1() throws IOException {
    InetAddress address1 = InetAddress.getByName("192.168.0.1");
    System.out.println(address1);

    InetAddress[] address2 = InetAddress.getAllByName("www.baidu.com");
    System.out.println(Arrays.toString(address2));

    System.out.println(InetAddress.getLocalHost());
    System.out.println(address1.getHostName());
    System.out.println(address1.getHostAddress());
    System.out.println(address1.getCanonicalHostName());
    System.out.println(address1.getAddress());
    System.out.println(address1.isReachable(100));
  }

}
