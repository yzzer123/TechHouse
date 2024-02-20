package com.yzzer.sort;

import java.util.Comparator;

public class SelectSorter<T> extends BaseSorter<T> {

    public int findMinElementIndex(T[] data, int start, int end, Comparator<T> comparator) {
      T minElem = data[start];
      int minIndex = start;
      for (int i = start + 1; i < end; i++) {
        if (comparator.compare(minElem, data[i]) > 0) {
          minElem = data[i];
          minIndex = i;
        }
      }
      return minIndex;
    }

    @Override
    public void sort(T[] data, Comparator<T> comparator) {
      sort(data, 0, data.length, comparator);
    }

    public void sort(T[] data, int start, int end, Comparator<T> comparator) {

      for (int i = 0; i < end - 1; i++) {
        int minIndex = findMinElementIndex(data, i, data.length, comparator);
        swap(data, minIndex, i);
      }
    }
}
