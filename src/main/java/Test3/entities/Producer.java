package Test3.entities;
import java.util.*;
import java.util.concurrent.*;
public class Producer implements Runnable {
    private BlockingQueue<Integer> queue;

    public Producer (BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                queue.put(produce());
                Thread.sleep(500);
            }

            queue.put(-1);  // indicates end of producing

            System.out.println("Producer STOPPED.");

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    private Integer produce() {
        Integer number = (int) (Math.random()*100);
        System.out.println("Producing number send " + number);
        return number;
    }
}

