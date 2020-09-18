package month08.day0812;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @hurusea
 * @create2020-08-12 10:29
 */
public class PrintfABC {
    private static Lock lock = new ReentrantLock();// 通过JDK5中的Lock锁来保证线程的访问的互斥
    private static int state = 0;//通过state的值来确定是否打印

    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    while (state % 3 == 0) {// 多线程并发，不能用if，必须用循环测试等待条件，避免虚假唤醒
                        System.out.print(Thread.currentThread().getName() + "=======A");
                        state++;
                    }
                } finally {
                    lock.unlock();// unlock()操作必须放在finally块中
                }
            }
        },"ThreadA").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    while (state % 3 == 0) {
                        System.out.print(Thread.currentThread().getName() + "=======B");
                        state++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        },"ThreadB").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    while (state % 3 == 0) {
                        System.out.print(Thread.currentThread().getName() + "=======C");
                        state++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        },"ThreadC").start();

    }
}
