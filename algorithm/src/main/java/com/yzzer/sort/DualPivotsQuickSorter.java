package com.yzzer.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DualPivotsQuickSorter<T> extends OnePivotQuickSorter<T> {

  @Override
  protected StackStatus[] process(T[] data, int start, int end, Comparator<T> comparator) {
    if (end - start + 1 < 10) return super.process(data, start, end, comparator);
    int[] pivotsIndexes = getPivotsIndex(data, start, end, comparator);
    swap(data, pivotsIndexes[0], start);
    swap(data, pivotsIndexes[1], end);
    T pivot1 = data[start];
    T pivot2 = data[end];

    int l = start + 1, r = end - 1, i = start + 1;
    while (i <= r) {
        if (comparator.compare(pivot1, data[i]) > 0) {
          swap(data, l++, i++);
        } else if (comparator.compare(pivot2, data[i]) < 0) {
          while (i < r && comparator.compare(data[r], pivot2) > 0) {
            r--;
          }
          swap(data, r--, i);
        } else i++;
    }
    PriorityQueue
    swap(data, l - 1, start);
    swap(data, r + 1, end);
    return new StackStatus[]{
            new StackStatus(start, l - 2),
            new StackStatus(l, r),
            new StackStatus(r + 2, end)
    };
  }

  public int[] getPivotsIndex(T[] data, int start, int end, Comparator<T> comparator) {
    int tmp, step = (end - start) >> 2;
    int e1 = start + 1;
    int e2 = start + step;
    int e3 = e2 + step;
    int e4 = e3 + step;
    int e5 = end - 1;



    if (comparator.compare(data[e1], data[e2]) > 0) {tmp = e1; e1 = e2; e2 = tmp;}
    if (comparator.compare(data[e2], data[e3]) > 0) {tmp = e2; e2 = e3; e3 = tmp;}
    if (comparator.compare(data[e3], data[e4]) > 0) {tmp = e3; e3 = e4; e4 = tmp;}
    if (comparator.compare(data[e4], data[e5]) > 0) {tmp = e4; e4 = e5; e5 = tmp;}

    if (comparator.compare(data[e1], data[e2]) > 0) {tmp = e1; e1 = e2; e2 = tmp;}
    if (comparator.compare(data[e2], data[e3]) > 0) {tmp = e2; e2 = e3; e3 = tmp;}
    if (comparator.compare(data[e3], data[e4]) > 0) {tmp = e3; e3 = e4; e4 = tmp;}

    if (comparator.compare(data[e1], data[e2]) > 0) {tmp = e1; e1 = e2; e2 = tmp;}
    if (comparator.compare(data[e2], data[e3]) > 0) {tmp = e2; e2 = e3; e3 = tmp;}

    if (comparator.compare(data[e1], data[e2]) > 0) {tmp = e1; e1 = e2; e2 = tmp;}
    return new int[] {e2, e4};
  }
}
