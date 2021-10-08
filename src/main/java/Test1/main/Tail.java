package Test1.main;

import Test1.services.FileProcess;

import java.io.File;

public class Tail {
    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        File file = new File("src/main/java/Test1/data/input.txt");
        FileProcess tail = new FileProcess(file,5);
//        System.out.println("Read file :" + tail.getFile());
//        System.out.println("In ra " +tail.getLines() +" dong cuoi file");
        tail.readFromLast();
        long endTime = System.nanoTime();
        System.out.print("Execution time is " + (endTime - startTime)/1000 +"ms");
    }

}