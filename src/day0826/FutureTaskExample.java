package day0826;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @hurusea
 * @create2020-08-26 8:48
 */
public class FutureTaskExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Callable<>() {
            @Override
            public Integer call() throws Exception {
                int res = 0;
                for (int i = 0; i < 5; i++) {
                    System.out.println("callable里的输出" + i);
                    res += i;
                }
                return res;
            }
        };

        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();

        Thread otherThread = new Thread(()->{
            System.out.println("other Thread is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        otherThread.start();
        Integer res = futureTask.get();
        System.out.println(res);
    }
}
