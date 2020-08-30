package zzz;

/**
 * @hurusea
 * @create2020-08-28 13:00
 */
public class Singleton3 {

    public Singleton3() {
    }
    private static class Singleton3Holder{
        private static final Singleton3 SINGLETON_3 = new Singleton3();
    }

    public static Singleton3 getSingleton3() {
        return Singleton3Holder.SINGLETON_3;
    }


}
