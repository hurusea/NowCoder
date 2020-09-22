package month09.day0919;

/**
 * @hurusea
 * @create2020-09-20 12:51
 */
public class P1 {

    private long b = 0;

    public void set1() {
        b = 0;
    }

    public void set2() {
        b = -1;
    }

    public void check() {
        System.out.println(b);

        if (0 != b && -1 != b) {
            System.err.println("Error");
        }
    }
}

class Demo {

    public static void main(final String[] args) {
        final P1 v = new P1();
        final Thread t1 = new Thread() {
            public void run() {
                while (true) {
                    v.set1();
                }
            }
        };
        t1.start();
        final Thread t2 = new Thread() {
            public void run() {
                while (true) {
                    v.set2();
                }
            }
        };
        t2.start();
        final Thread t3 = new Thread() {
            public void run() {
                while (true) {
                    v.check();
                }
            }
        };
        t3.start();
    }
}