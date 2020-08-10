package day0808;

/**
 * @hurusea
 * @create2020-08-09 16:31
 */
public class Singleton {
    private static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            singleton = new Singleton();
        }
        return singleton;
    }
}
