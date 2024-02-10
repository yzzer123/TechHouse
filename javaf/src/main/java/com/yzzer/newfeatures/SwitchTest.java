package com.yzzer.newfeatures;

import org.junit.Test;

public class SwitchTest {

  @Test
  public void test1() {
    Integer age = 123;
    String type = switch (age) {
      case 12, 123 -> "hh";
      case 111, 555 -> "hhhh";
      case null -> "hhh";
      default -> throw new IllegalStateException("Unexpected value: " + age);
    };
    System.out.println(type);
  }

  @Test
  public void test2() {
    Integer age = 123;
    String type = switch (age) {
      case 12, 123 -> {
        yield "hh";
      }
      case 111, 555 -> "hhhh";
      case null -> "hhh";
      default -> throw new IllegalStateException("Unexpected value: " + age);
    };
    System.out.println(type);
  }

  @Test
  public void test3() {
    Integer age = 123;
    String type = switch (age) {
      case 12, 123:
        yield "hh";
      case 111, 555:
        yield "hhhh";
      case null:
        yield "111";
      default:
        throw new IllegalStateException("Unexpected value: " + age);
    };
    System.out.println(type);
  }


  // JDK17 预览特性 JDK21的正式特性
  static String formatted(Object obj) {
    String res = switch (obj) {
      case Integer i:
        yield "int: " + i;
      case Long l:
        yield "long: "  + l;
      default:
        yield "default";
    };
    return res;
  }
}
