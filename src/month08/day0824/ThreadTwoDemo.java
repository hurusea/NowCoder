package month08.day0824;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @hurusea
 * @create2020-08-24 18:33
 */
public class ThreadTwoDemo {
    private static Lock lock = new ReentrantLock();
    private static Condition A = lock.newCondition();
    private static Condition B = lock.newCondition();
    private static Condition C = lock.newCondition();
    private static int state = 0;

    static class ThreadA extends Thread {
        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 5; i++) {
                    while (state % 2 != 0) {
                        A.await();
                    }
                    System.out.println(Thread.currentThread().getName() + "=====" + state++);
                    B.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 5; i++) {
                    while (state % 2 != 1) {
                        B.await();
                    }
                    System.out.println(Thread.currentThread().getName() + "=====" + state++);
                    A.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
//        new Thread(new ThreadA(), "ThreadA").start();
//        new Thread(new ThreadB(), "ThreadB").start();
        ThreadA threadA = new ThreadA();
        threadA.start();
        ThreadB threadB = new ThreadB();
        threadB.start();



    }
}
