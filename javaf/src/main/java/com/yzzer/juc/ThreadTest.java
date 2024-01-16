package com.yzzer.juc;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ThreadTest {

    public static void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread() + "\t" + i);
            }

            if (i % 1000 == 0) {
                // 主动释放CPU资源，调度其他线程
                Thread.yield();
            }
        }
    }


    // 1. 创建线程的方式一: 继承Thread 重写 run 方法
    @Test
    public void printNumberByExtendThread() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                ThreadTest.run();
            }
        };

        // 一个线程对象只能start一次，想要启动多个必须创建多个线程对象
        thread.start();

        // 没有启动线程 属于单并发
        // thread.run();

        ThreadTest.run();
    }

    // 2. 创建线程方式二: 创建 runnable 对象
    @Test
    public void printNumberByImplementRunnable() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                ThreadTest.run();
            }
        };

        Thread thread = new Thread(runnable);

        thread.start();

        // 虚拟线程和平台线程
        Thread.ofVirtual().start(runnable);
        Thread.ofPlatform().start(runnable);
    }

    // 测试虚拟线程池
    @Test
    public void testVirtualThreadPool() {
        Set<String> threadSet = ConcurrentHashMap.newKeySet();

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 10_000_000).forEach(i -> {
                executor.submit(() -> {
                    String platformThreadName = Thread.currentThread().toString().split("@")[1];
                    threadSet.add(platformThreadName);
                });
            });
            System.out.println(System.currentTimeMillis() + "\ttasks submitted");
        }
        // 用 try-resource 会等待所有线程执行完成

        System.out.println(System.currentTimeMillis() + "\tPlatform Thread Number: " + threadSet.size());
    }

}
