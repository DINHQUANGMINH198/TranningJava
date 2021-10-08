package Test2.services;
import java.util.*;
import Test2.entities.*;
public  class SortThreadProcess {
    private int threadCount = 1;
    private ArrayInt myArray;
    private List<Thread> threadList;
    public void setThreadCount(int threadCount) {
        int THREAD_LIMIT = 50;
        if(threadCount > THREAD_LIMIT){
            this.threadCount = THREAD_LIMIT;
        }else if(threadCount < 0){
            this.threadCount = 1;
        }else{
            this.threadCount = threadCount;
        }
    }
    public void setMyArray(ArrayInt myArray) {
        this.myArray = myArray;
    }
    public void implement(){
        int range = myArray.getLength() / threadCount;
        threadList = new ArrayList<>();
        int i = 0;
        for(; i < threadCount-1; i++){
            int begin = i * range;
            int end = (i+1) * range - 1;
            Thread sortThread = new QuickSort(myArray.getArray(),begin,end);
            threadList.add(sortThread);
        }
        Thread sortThread = new QuickSort(myArray.getArray(),i * range,myArray.getLength()-1);
        threadList.add(sortThread);
        for (Thread t : threadList){
            t.start();
        }
        for (Thread t : threadList){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(threadCount > 1){
            merge(threadCount);
        }
    }
    public void merge(int numberOfThread){ // tron cac mang o tat ca cac luong
        int range = myArray.getLength() / threadCount * (threadCount / numberOfThread);
        if(numberOfThread % 2 == 0){
            int i = 0;
            for(; i < numberOfThread-2; i += 2){
                int begin = i*range;
                int medium = (i+1)*range-1;
                int end =(i+2)*range-1;
                mergeArray(myArray.getArray(),begin,medium,end);
            }
            mergeArray(myArray.getArray(),i*range,(i+1)*range-1,myArray.getLength()-1);
            if (numberOfThread > 2){
                merge(numberOfThread/2);
            }
        }else{
            int i = 1;
            int begin = 0;
            for(; i < numberOfThread-1; i++){
                int medium = i*range-1;
                int end =(i+1)*range-1;
                mergeArray(myArray.getArray(),begin,medium,end);
            }
            mergeArray(myArray.getArray(),begin,i*range-1,myArray.getLength()-1);
        }
    }

    void mergeArray(int[] arr, int l, int m, int r){ // tron n mang da sap xep
        int[] newArray = myArray.getArray().clone();
        int n = m+1;
        int index = l;
        while (l <= m && n <= r){
            try{
                if(arr[l] < arr[n]){
                    newArray[index++] = arr[l++];
                }else{
                    newArray[index++] = arr[n++];
                }
            }catch (Exception ex){
                System.err.println(r);
                break;
            }
        }
        try{
            while (l <= m){
                newArray[index++] = arr[l++];
            }
            while (n <= r){
                newArray[index++] = arr[n++];
            }
        }catch (Exception ex){
            System.err.println(r + "," + n);
        }
        myArray.setArray(newArray);
    }

    public void shutDown(){
        threadList.forEach(Thread::stop);
    }
}
