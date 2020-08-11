package day0811;

/**
 * @hurusea
 * @create2020-08-11 20:21
 */
public class DoubleThread4 {
    static Object lock = new Object();

    public static void main(String[] args) {
        Print print1 = new Print();
        Print print2 = new Print();
        Print print3 = new Print();
        print1.setName("打印1");
        print2.setName("打印2");
        print3.setName("打印3");
        print1.start();
        print2.start();
        print3.start();
    }
}

class PrintNum extends Thread{
    static int r = 1;

    @Override
    public void run() {
        synchronized (PrintNum.class) {
            for (int i = 0; i < 8; i++) {
                Print.class.notifyAll();
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