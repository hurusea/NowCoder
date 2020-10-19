package month10.day10;

/**
 * @hurusea
 * @create2020-10-13 16:26
 */
public class ThreadTest implements Runnable {
    public static void main(String[] args) {
        new ThreadTest();
    }

    public ThreadTest() {
        ThreadTest task = new ThreadTest();
        new Thread(task).start();
    }

    @Override

    public void run() {
        System.out.println("test");
    }
}
