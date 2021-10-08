package Test3.entities;
import java.util.*;
import java.util.concurrent.*;
 // 1 Producer - nhieu Consumer
public class Consumer implements Runnable {
    private BlockingQueue<Integer> queue;
    private String threadId;
    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        threadId = "Consumer-" + Thread.currentThread().getId();
        try {
            while (true) {
//              Integer number = queue.take();
                Integer number = queue.poll(5, TimeUnit.SECONDS);

                if (number == null || number == -1) {
                    break;
                }

                consume(number);

                Thread.sleep(1000);
            }

            System.out.println("Consumer STOPPED.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void consume(Integer number) {

        System.out.println(threadId +": Consuming number receive :" + number);

    }
}