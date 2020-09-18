package month08.day0820;

/**
 * @hurusea
 * @create2020-08-20 14:59
 */
public class ThreadLocalSingleton {

    // ThreadLocal 线程局部变量,将单例instance线程私有化
    private static ThreadLocal<ThreadLocalSingleton> threadLocal = new ThreadLocal<ThreadLocalSingleton>();

    private static ThreadLocalSingleton instance;

    private ThreadLocalSingleton() {
    }

    private static ThreadLocalSingleton getInstance() {
        if (threadLocal.get() == null) {
            synchronized (ThreadLocalSingleton.class) {
                if (instance == null) {
                    instance = new ThreadLocalSingleton();
                }
            }
            threadLocal.set(instance);
        }
        return threadLocal.get();
    }

}
