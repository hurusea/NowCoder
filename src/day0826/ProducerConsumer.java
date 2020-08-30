package day0826;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @hurusea
 * @create2020-08-26 9:15
 */
public class ProducerConsumer {
    private static BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(2);

    private static class Producer extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                blockingQueue.put("product");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("producing..");

        }
    }

    private static class  Consumer  extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("consuming..");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            Producer producer = new Producer();
//            Thread producer = new Thread(new Producer());
            producer.start();
        }
        for (int i = 0; i < 5; i++) {
            Consumer consumer = new Consumer();
            consumer.start();
        }
        for (int i = 0; i < 3; i++) {
            Producer producer = new Producer();
            producer.start();
        }


    }

}
