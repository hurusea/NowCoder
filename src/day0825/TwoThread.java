package day0825;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @hurusea
 * @create2020-08-25 22:59
 */
public class TwoThread {
    static int state = 0;
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition A = lock.newCondition();
        Condition B = lock.newCondition();
        new Thread(()->{
            lock.lock();
            try {
                for (int i = 0; i < 5; i++) {
                    while (state % 2 != 0) {
                        A.await();
                    }
                    System.out.println(Thread.currentThread().getName()+"==偶数==="+state++);
                    B.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"Thread1").start();

        new Thread(()->{
            lock.lock();
            try {
                for (int i = 0; i < 5; i++) {
                    while (state % 2 == 0) {
                        B.await();
                    }
                    System.out.println(Thread.currentThread().getName()+"==奇数==="+state++);
                    A.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"Thread2").start();
    }
}
