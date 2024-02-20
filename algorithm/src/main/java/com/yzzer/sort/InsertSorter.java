package com.yzzer.sort;

import java.util.Comparator;

/**
 * 插入排序
 * @author youzhangzheng
 */
public class InsertSorter<T> extends BaseSorter<T> {

    /**
     * move element from i to  i + 1
     * @param data target data need to sort
     * @param start inclusive
     * @param end exclusive
     */
    public void move(T[] data, int start, int end) {
        for (int i = end; i > start; i--) {
            data[i] = data[i - 1];
        }
    }

    public int findPosToInsert(T[] data, int eleIndex, Comparator<T> comparator) {
      T tmp = data[eleIndex];
      for (int i = eleIndex - 1; i > -1; i--) {
        if (comparator.compare(data[i], tmp) <= 0) {
          return  i + 1;
        }
      }
      return 0;
    }

    @Override
    public void sort(T[] data, Comparator<T> comparator) {
      for (int i = 1; i < data.length; i++) {
        T tmp = data[i];
        int posToInsert = findPosToInsert(data, i, comparator);
        move(data, posToInsert, i);
        data[posToInsert] = tmp;
      }
    }
}
