package month08.day0811;

/**
 * @hurusea
 * @create2020-08-11 20:21
 */
public class DoubleThread2 {
    static volatile int i = 0;

    public static void main(String[] args) {

        Object lock = new Object();

        new Thread(() -> {
            while (i < 10) {
                synchronized (lock) {
                    if (i % 3 == 0) {
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
                    if (i % 3 == 1) {
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

        new Thread(() -> {
            while (i < 10) {
                synchronized (lock) {
                    if (i % 3 == 2) {
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

        }, "thread3").start();
    }
}
