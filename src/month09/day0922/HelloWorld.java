package month09.day0922;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @hurusea
 * @create2020-09-22 14:18
 */
public class HelloWorld {

    private volatile boolean flag = true;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void sub(){
        try {
            lock.lock();
            while (!flag){
                try{
                    condition.await();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            System.out.println("hello");
            flag = false;
            condition.signal();
        }finally {
            lock.unlock();
        }
    }

    public void main(){
        try{
            lock.lock();
            while (flag){
                try{
                    condition.await();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            System.out.println("world");
            flag = true;
            condition.signal();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        HelloWorld task = new HelloWorld();
        new Thread(() -> {
            task.sub();
        }).start();

        task.main();
    }
}
