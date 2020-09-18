package month08.day0811;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @hurusea
 * @create2020-08-11 16:26
 */
public class ThreadTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread t1 = new t1();
        t1.start();
        Thread t2 = new t2();
        t2.start();
        FutureTask<Integer> futureTask = new FutureTask<>(new t5());
        FutureTask<Integer> task = new FutureTask<>(new t5());
        Thread taskThread = new Thread(task);
        new Thread(futureTask).start();
        Integer integer = futureTask.get();
        System.out.println(integer);
        new t3().run();

    }
}

class t1 extends Thread{
    @Override
    public void run() {
        System.out.println("t1");
    }
}

class t2 extends Thread{
    @Override
    public void run() {
        System.out.println("t2");
    }
}

class t3 implements Runnable{

    @Override
    public void run() {
        System.out.println("t3");
    }
}

class t4 implements Runnable{

    @Override
    public void run() {
        System.out.println("t4");
    }
}
class t5 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int res = 20 / 10;
        System.out.println("t5");
        return res;
    }
}
