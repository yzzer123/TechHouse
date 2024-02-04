package com.yzzer.io;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

public class OtherStreamTest {

  @Test
  public void testSystemStream() throws FileNotFoundException {
    System.setIn(new FileInputStream("hello_utf-8.txt"));
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      System.out.println(scanner.nextLine());
    }
  }

  @Test
  public void testSystemStream2() throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
      String line = null;
      while ((line = reader.readLine()) != null) {
        if (line.equalsIgnoreCase("E") || line.equalsIgnoreCase("EXIT")) {
          System.out.println("bye~");
          break;
        }

        System.out.println("-->" + line.toUpperCase());
      }
    }
  }

  @Test
  public void testPrintStream() throws IOException{
    PrintStream printStream = new PrintStream(new FileOutputStream("print.txt"), true );
    printStream.println("hi");
    printStream.println("hi");
    printStream.println("exited");

    System.setOut(printStream);

    System.out.println("This is message from System.out");

    printStream.close();
  }

  @Test
   public void testCommonUtils() throws IOException {
    FileUtils.copyFile(new File("hello.png"), new File("hello-common-copy.png"));
  }


}
