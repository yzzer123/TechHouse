package com.yzzer.sort;

import java.util.Comparator;

public class BubbleSorter<T> extends BaseSorter<T> {

    // 默认从小到大
    @Override
    public void sort(T[] data, Comparator<T> comparator) {
      for (int i = 0; i < data.length - 1; i++) {
        for (int j = data.length - 1;  j > i; j--) {
          if (comparator.compare(data[j], data[j - 1]) < 0) {
            swap(data, j, j - 1);
          }
        }
      }
    }
}
