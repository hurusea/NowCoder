package zzz;

/**
 * @hurusea
 * @create2020-08-28 12:55
 */
public class Singleton1 {
    private static volatile Singleton1 singleton1;

    private Singleton1() {}

    public static Singleton1 getSingleton1() {
        if (singleton1 == null) {
            synchronized (Singleton1.class) {
                if (singleton1 == null) {
                    singleton1 = new Singleton1();
                }
            }
        }
        return singleton1;
    }
}
