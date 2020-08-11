package day0811;

import java.util.concurrent.locks.Lock;

/**
 * @hurusea
 * @create2020-08-11 20:21
 */
public class DoubleThread3 {
    static Object lock = new Object();

    public static void main(String[] args) {
        Print printOdd = new Print();
        Print printEven = new Print();
        printOdd.setName("打印奇数");
        printEven.setName("打印偶数");
        printOdd.start();
        printEven.start();

    }
}
class Print extends Thread{
    static int r = 1;

    @Override
    public void run() {
        synchronized (Print.class) {
            for (int i = 0; i < 5; i++) {
                Print.class.notify();
                System.out.println(Thread.currentThread().getName()+"==="+ r++);
                try {
                    Print.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}