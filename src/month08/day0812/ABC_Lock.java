package month08.day0812;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class ABC_Lock {
    private static Lock lock = new ReentrantLock();// 通过JDK5中的Lock锁来保证线程的访问的互斥
    private static int state = 0;//通过state的值来确定是否打印
    static class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5;) {
                try {
                    lock.lock();
                    while (state % 3 == 0) {// 多线程并发，不能用if，必须用循环测试等待条件，避免虚假唤醒
                        System.out.println(Thread.currentThread().getName()+"===========A"+"  第"+i+"次循环");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();// unlock()操作必须放在finally块中
                }
            }
        }
    }
    static class ThreadB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5;) {
                try {
                    lock.lock();
                    while (state % 3 == 1) {
                        System.out.println(Thread.currentThread().getName()+"===========B"+"  第"+i+"次循环");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();// unlock()操作必须放在finally块中
                }
            }
        }
    }
    static class ThreadC extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5;) {
                try {
                    lock.lock();
                    while (state % 3 == 2) {
                        System.out.println(Thread.currentThread().getName()+"===========C"+"  第"+i+"次循环");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();// unlock()操作必须放在finally块中
                }
            }
        }
    }
    public static void main(String[] args) {
        new Thread(new ThreadA(),"ThreadA").start();
        new Thread(new ThreadB(),"ThreadB").start();
        new Thread(new ThreadC(),"ThreadC").start();
    }
}