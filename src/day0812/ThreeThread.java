package day0812;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @hurusea
 * @create2020-08-12 11:03
 */
public class ThreeThread {
    private static Lock lock = new ReentrantLock();// 通过JDK5中的Lock锁来保证线程的访问的互斥
    private static int state = 0;//通过state的值来确定是否打印

    static class PrintTaskA extends Thread {
        @Override
        public void run() {
            super.run();
            lock.lock();
            try {
                while (state < 10) {
                    if (state % 3 == 0) {
                        System.out.println(Thread.currentThread().getName() + "===A");
                    }
                    state++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    static class PrintTaskB extends Thread {
        @Override
        public void run() {
            super.run();
            lock.lock();
            try {
                while (state < 10) {
                    if (state % 3 == 1) {
                        System.out.println(Thread.currentThread().getName() + "===B");
                    }
                    state++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    static class PrintTaskC extends Thread {
        @Override
        public void run() {
            super.run();
            lock.lock();
            try {
                while (state < 10) {
                    if (state % 3 == 2) {
                        System.out.println(Thread.currentThread().getName() + "===C");
                    }
                    state++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new PrintTaskA(), "ThreadA").start();
        new Thread(new PrintTaskB(), "ThreadB").start();
        new Thread(new PrintTaskC(), "ThreadC").start();
    }
}
