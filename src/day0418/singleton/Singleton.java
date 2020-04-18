package day0418.singleton;

/**
 * @hurusea
 * @create2020-04-18 19:18
 */

/**
 * 懒汉式-线程不安全
 */
public class Singleton {
    private static Singleton newinstance;

    Singleton() {
    }

    public static Singleton getNewinstance() {
        if (newinstance == null) {
            newinstance = new Singleton();
        }
        return newinstance;
    }
}

/**
 * 饿汉式-线程安全
 */
class Singleton1 {
    private static Singleton1 newinstance = new Singleton1();

    private Singleton1() {
    }

}

/**
 * 懒汉式-线程安全
 */
class Singleton2 {
    private static Singleton2 newinstance2;

    private Singleton2() {
    }

    public static synchronized Singleton2 getnewinstance2() {
        if (newinstance2 == null) {
            newinstance2 = new Singleton2();
        }
        return newinstance2;
    }
}

class Singleton3 {
    private volatile static Singleton3 newinstance3;

    public Singleton3() {
    }

    public Singleton3 getNewinstance3() {
        if (newinstance3 == null) {
            synchronized (Singleton3.class) {
                if (newinstance3 == null) {
                    newinstance3 = new Singleton3();
                }
            }
        }
        return newinstance3;
    }
}
