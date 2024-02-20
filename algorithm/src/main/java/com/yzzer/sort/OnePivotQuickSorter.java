package com.yzzer.sort;

import java.util.*;

public class OnePivotQuickSorter<T> extends BaseSorter<T> {

    SelectSorter<T> miniSorter = new SelectSorter<>();

    static class StackStatus {
      int start;
      int end;
      public StackStatus(int s, int e) {
        start = s;
        end = e;
      }
    }

    @Override
    public void sort(T[] data, Comparator<T> comparator) {
      if (data.length < 30) {
        miniSorter.sort(data, comparator);
        return;
      }
      Deque<StackStatus> stack = new ArrayDeque<>();
      stack.push(new StackStatus(0, data.length - 1));

      while (!stack.isEmpty()) {
        StackStatus top = stack.pop();
        if (top.end <= top.start) continue;

        StackStatus[] ranges = process(data, top.start, top.end, comparator);
        for (StackStatus range : ranges) {
          stack.push(range);
        }
      }
    }

    protected StackStatus[] process(T[] data, int start, int end, Comparator<T> comparator) {
      // 三数取中
      int mid = getMid(data, start, end, comparator);

      swap(data, start, mid);
      T pivot = data[start];
      int l = start, r = end, i = start + 1;
      // 将和pivot相同的数值存放在中间
      while (i <= r) {
        int cmp = comparator.compare(data[i], pivot);
        if (cmp < 0) swap(data, l++, i++);
        else if (cmp > 0) swap(data, r--, i);
        else i++;
      }
      data[l] = pivot;
      return new StackStatus[]{new StackStatus(start, l - 1), new StackStatus(r + 1, end)};
    }

    public int getMid(T[] data, int start, int end, Comparator<T> comparator) {
      int e1 = start + 1, e2 = end - 1, mid = ((end - start)>>1) + start;
      if (comparator.compare(data[e1], data[e2]) > 0) {
        return comparator.compare(data[e1], data[mid]) > 0 ?
          comparator.compare(data[e2], data[mid]) > 0 ? e2 : mid
        : e1;
      } else {
        return comparator.compare(data[e2], data[mid]) > 0 ?
                comparator.compare(data[e1], data[mid]) > 0 ? e1 : mid
                : e2;
      }
    }
}
