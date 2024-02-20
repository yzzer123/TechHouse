package com.yzzer.sort;

import java.util.Comparator;

public class HeapSorter<T> extends BaseSorter<T> {
    @Override
    public void sort(T[] data, Comparator<T> comparator) {
      if (data.length == 0) return;
      buildHeap(data, comparator);
      for (int i = data.length - 1; i > 0; i--) {
        swap(data, 0, i);
        justifyHeap(data, 0, i, comparator);
      }
    }

    public void buildHeap(T[] data, Comparator<T> comparator) {
      int heapSize = data.length;
      for (int i = heapSize / 2; i >= 0; i--) {
        justifyHeap(data, i, heapSize, comparator);
      }
    }

    // 默认大根堆
    public void justifyHeap(T[] data, int i, int heapSize, Comparator<T> comparator) {
      int maxPos = i, r, l;
      while (i < heapSize) {
        l = (i << 1) + 1;
        r = (i << 1) + 2;
        maxPos = i;
        if (l < heapSize && comparator.compare(data[maxPos], data[l]) < 0) {
          maxPos = l;
        }
        if (r < heapSize && comparator.compare(data[maxPos], data[r]) < 0) {
          maxPos = r;
        }
        if (maxPos == i) break;
        swap(data, i, maxPos);
        i = maxPos;
      }
    }
}
