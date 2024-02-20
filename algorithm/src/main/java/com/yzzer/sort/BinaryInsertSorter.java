package com.yzzer.sort;

import java.util.Arrays;
import java.util.Comparator;

public class BinaryInsertSorter<T> extends InsertSorter<T>{

  @Override
  public int findPosToInsert(T[] data, int eleIndex, Comparator<T> comparator) {
    T tmp = data[eleIndex];
    int l = 0, r = eleIndex, mid;
    while (l < r) {
      mid = ((r - l) >> 1) + l;
      int cmp = comparator.compare(data[mid], tmp);
      if (cmp <= 0) {
        l = mid + 1;
      } else {
        r = mid;
      }
    }
    return l;
  }
}
