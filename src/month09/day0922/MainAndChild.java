package month09.day0922;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @hurusea
 * @create2020-09-22 14:48
 */
public class MainAndChild {
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
            for(int i=0;i<2;i++){
                System.out.println("sub run"+i);
            }
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
            for(int i=0;i<2;i++){
                System.out.println("main run"+i);
            }
            flag = true;
            condition.signal();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        MainAndChild mainandchild = new MainAndChild();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    mainandchild.sub();
                }
            }
        }).start();
        for(int i=0;i<10;i++){
            mainandchild.main();
        }
    }
}
