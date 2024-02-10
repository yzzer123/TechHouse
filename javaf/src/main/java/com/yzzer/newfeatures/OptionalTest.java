package com.yzzer.newfeatures;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

  @Test
  public void test1() {
    String star = "迪丽热巴";
    Optional<String> optional = Optional.ofNullable(star);
    String aNull = optional.orElse("null");
    String orElseGet = optional.orElseGet(() -> String.join("\n", "&", "*"));
  }

}
