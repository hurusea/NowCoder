package day0811;

import java.util.Objects;

/**
 * @hurusea
 * @create2020-08-11 14:49
 */
public class JUCDemo {

    static volatile int i = 0;

    public static void main(String[] args) {

        Object lock = new Object();

        new Thread(() -> {
            while (i < 10) {
                synchronized (lock) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + "=====" + i++);
                    }
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }, "thread1").start();

        new Thread(() -> {
            while (i < 10) {
                synchronized (lock) {
                    if (i % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + "=====" + i++);
                    }
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }, "thread2").start();

    }
}
