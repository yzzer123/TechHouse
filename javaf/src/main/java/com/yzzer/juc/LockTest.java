package com.yzzer.juc;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest extends Thread{

    static int ticket = 100;

    final public static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    System.out.println(this + "\t" + ticket--);
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    @Test
    public void testLock1() throws InterruptedException {

        for (int i = 0; i < 100; i++) {
            new LockTest().start();
        }

        TimeUnit.MILLISECONDS.sleep(2000);
    }

}
