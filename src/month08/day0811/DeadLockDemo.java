package month08.day0811;

/**
 * @hurusea
 * @create2020-08-11 14:53
 */
public class DeadLockDemo {
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "持有resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "等待resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "持有resource2");
                }
            }
        }, "t1").start();

        new Thread(()->{
            synchronized (resource2) {
                System.out.println(Thread.currentThread() + "持有resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "等待resource1");
                synchronized (resource1) {
                    System.out.println(Thread.currentThread() + "持有resource1");
                }
            }
        },"t2").start();
    }
}
