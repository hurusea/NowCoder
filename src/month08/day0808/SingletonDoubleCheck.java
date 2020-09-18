package month08.day0808;

/**
 * @hurusea
 * @create2020-08-09 16:39
 */
public class SingletonDoubleCheck {
    private static volatile SingletonDoubleCheck singleton;

    private SingletonDoubleCheck() {

    }

    public static SingletonDoubleCheck getSingleton() {
        if (singleton == null) {
            synchronized (SingletonDoubleCheck.class) {
                if (singleton == null) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    singleton = new SingletonDoubleCheck();
                }
            }
        }
        return singleton;
    }
}
