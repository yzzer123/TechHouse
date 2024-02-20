package com.yzzer.sort;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.Stack;

public class MergeSorter<T> extends BaseSorter<T> {
    T[] buffer;

    static class StackStatus {
      int start;
      int end;
      boolean isVisited;
      public StackStatus(int s, int e) {
        start = s;
        end = e;
        isVisited = false;
      }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void sort(T[] data, Comparator<T> comparator) {
      buffer = (T[]) new Object[data.length];
      Deque<StackStatus> stack = new ArrayDeque<>();
      stack.push(new StackStatus(0, data.length - 1));
      while (!stack.isEmpty()) {
        StackStatus top = stack.peek();
        int mid = ((top.end - top.start) >> 1) + top.start;

        if (top.isVisited) {
          merge(data, top.start, mid, mid + 1, top.end, comparator);
          stack.pop();
        } else {
          if (top.end <= top.start) {
            stack.pop();
            continue;
          }
          top.isVisited = true;
          stack.push(new StackStatus(top.start, mid));
          stack.push(new StackStatus(mid + 1, top.end));
        }
      }
    }

    public void merge(T[] data, int start1, int end1, int start2, int end2, Comparator<T> comparator) {
      int p = start1;
      int bufferStartIndex = p;
      while (start1 <= end1 && start2 <= end2) {
        if (comparator.compare(data[start1], data[start2]) < 0) {
          buffer[p++] = data[start1++];
        } else {
          buffer[p++] = data[start2++];
        }
      }

      while (start1 <= end1) {
        buffer[p++] = data[start1++];
      }

      while (start2 <= end2) {
        buffer[p++] = data[start2++];
      }

      if (end2 + 1 - bufferStartIndex >= 0)
        System.arraycopy(buffer, bufferStartIndex, data, bufferStartIndex, end2 + 1 - bufferStartIndex);
    }
}
