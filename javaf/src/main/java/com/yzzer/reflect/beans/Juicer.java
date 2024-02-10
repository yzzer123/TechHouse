package com.yzzer.reflect.beans;

import javax.annotation.Nonnull;

public class Juicer {
  public void run(@Nonnull Fruit fruit) {
    fruit.squeeze();
  }
}
