package com.yzzer.io;

import org.junit.Test;

import java.io.*;

public class DataInputOutputStream {

  @Test
  public void writeData() {
    try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("data_write.bin"))) {
      dataOutputStream.writeInt(123);
      dataOutputStream.writeUTF("hello");
      dataOutputStream.writeDouble(12.3);
      dataOutputStream.writeBoolean(false);
      dataOutputStream.writeShort(10);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  @Test
  public void readData() {
    try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("data_write.bin"))) {
      System.out.println(dataInputStream.readInt());
      System.out.println(dataInputStream.readUTF());
      System.out.println(dataInputStream.readDouble());
      System.out.println(dataInputStream.readBoolean());
      System.out.println(dataInputStream.readShort());
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
