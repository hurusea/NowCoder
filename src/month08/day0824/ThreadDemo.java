package month08.day0824;

/**
 * @hurusea
 * @create2020-08-24 16:55
 */
public class ThreadDemo {

    static int num = 0;

    public static void main(String[] args) {

        Object lock = new Object();
        new Thread(() -> {
            while (num < 10) {
                synchronized (lock) {
                    if (num % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + "=====" + num++);
                    }
                    lock.notifyAll();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "线程A").start();

        new Thread(() -> {
            while (num < 10) {
                synchronized (lock) {
                    if (num % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + "=====" + num++);
                    }
                    lock.notifyAll();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "线程B").start();
    }
}
