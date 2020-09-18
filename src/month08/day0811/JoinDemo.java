package month08.day0811;

/**
 * @hurusea
 * @create2020-08-11 19:52
 */
public class JoinDemo {
    static Thread aThread, bThread, cThread;

    public static void main(String[] args) {
        aThread = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("B");
                try {
                    bThread.start();
                    bThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        bThread = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("B");
                try {
                    cThread.start();
                    cThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        cThread = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("C");
            }
        });

        aThread.start();
    }

}
