package day0812;

/**
 * @hurusea
 * @create2020-08-12 10:43
 */
public class DoubleThread {


    static class PrintThread extends Thread {
        static int flag = 0;

        @Override
        public void run() {
            super.run();
            while (flag < 10) {
                synchronized (PrintThread.class) {
                    if (flag % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + "===A");
                        flag++;
                    } else {
                        System.out.println(Thread.currentThread().getName() + "===B");
                        flag++;
                    }
                    PrintThread.class.notifyAll();
                    try {
                        PrintThread.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        new Thread(new PrintThread(), "ThreadA").start();
        new Thread(new PrintThread(), "ThreadB").start();
    }
}
