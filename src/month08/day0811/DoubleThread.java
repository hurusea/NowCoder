package month08.day0811;

/**
 * @hurusea
 * @create2020-08-11 16:08
 */
public class DoubleThread {

    static class SoulutionTask implements Runnable{
        static int value = 0;
        @Override
        public void run() {
            while (value <= 10){
                synchronized (SoulutionTask.class){
                    System.out.println(Thread.currentThread().getName() + ":" + value++);
                    SoulutionTask.class.notify();
                    try {
                        SoulutionTask.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        new Thread(new SoulutionTask(), "偶数").start();
        new Thread(new SoulutionTask(), "奇数").start();
    }


}




