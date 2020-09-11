package zzz;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @hurusea
 * @create2020-08-28 12:58
 */
public class Singleton2 {
    private static Singleton2 singleton2;

    private Singleton2() {

    }

    public synchronized Singleton2 getSingleton2() {
        if (singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}

class Singleton4 {
    static ReentrantLock lock = new ReentrantLock();

    private static Singleton4 singleton4;

    private Singleton4() {

    }

    public Singleton4 getSingleton() {
        lock.lock();
        try {
            if (singleton4 == null) {
                singleton4 = new Singleton4();
                return singleton4;
            }
        } finally {
            lock.unlock();
        }
        return singleton4;
    }
}
