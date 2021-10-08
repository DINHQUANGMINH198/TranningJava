package Test3.main;
import  Test3.entities.*;
import java.util.*;
import java.util.concurrent.*;


public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10); //hàng đợi giới hạn

        Thread producer = new Thread(new Producer(queue));
        Thread consumer0 = new Thread(new Consumer(queue));
        Thread consumer1 = new Thread(new Consumer(queue));
        Thread consumer2 = new Thread(new Consumer(queue));
        Thread consumer3 = new Thread(new Consumer(queue));
        producer.start();
        consumer0.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();

    }
}