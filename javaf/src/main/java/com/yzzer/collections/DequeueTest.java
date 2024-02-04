package com.yzzer.collections;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeueTest {

    // stack usage
    @Test
    public void test1() {
      Deque<Integer> stack = new ArrayDeque<>();
      stack.push(123); // 入栈
      assert stack.peek() == 123;
      assert stack.pop() == 123;
      assert stack.isEmpty() == true;
      System.out.println(Math.ceilDiv(3, 2));
    }

    // dequeue
    @Test
    public void test2() {
      Deque<String> deque = new LinkedList<>();
      deque.pollFirst(); //  弹出第一个 没有则返回null
      deque.pollLast(); // 弹出最后一个 没有则返回null
      deque.removeFirst(); // 没有则报错
      deque.removeLast(); // 没有则报错
    }

}
