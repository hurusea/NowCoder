package day0811;

import java.util.Date;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @hurusea
 * @create2020-08-11 16:47
 */
public class MyRunnable implements Runnable{
    private String command;
    public MyRunnable(String s) {
        this.command = s;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
                processCommand();
        System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
    }
    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String toString() {
        return this.command;
    }
}
