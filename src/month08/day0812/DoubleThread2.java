package month08.day0812;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @hurusea
 * @create2020-08-12 10:43
 */
public class DoubleThread2 {

    private static Lock lock = new ReentrantLock();// 通过JDK5中的Lock锁来保证线程的访问的互斥
    private static int state = 0;//通过state的值来确定是否打印


    static class PrintTaskA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5;) {
                try {
                    lock.lock();
                    while (state % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + "===A");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class PrintTaskB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5;) {
                try {
                    lock.lock();
                    while (state % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + "===B");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }



    public static void main(String[] args) {
        new PrintTaskA().start();
        new PrintTaskB().start();
    }
}
