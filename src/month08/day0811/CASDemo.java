package month08.day0811;

/**
 * @hurusea
 * @create2020-08-11 19:27
 */
public class CASDemo {
    static final Object object = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    for (int i = 1; i < 10; i += 2) {
                        System.out.println(Thread.currentThread().getName() + "    " + i);
                        object.notify();
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    for (int i = 2; i < 10; i += 2) {
                        System.out.println(Thread.currentThread().getName() + "     " + i);
                        object.notify();
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "t2");
        t1.start();
        t2.start();
    }
}
