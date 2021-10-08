package Test2.generator;
import java.util.Random;
import Test2.entities.ArrayInt;

public class GenArray {
    public ArrayInt randomArray(int n) {
        ArrayInt myarr = new ArrayInt();
        myarr.setLength(n);
        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = i + 1;
//        }
        Random random = new Random();
        for (int i=0;i<n;i++){
            arr[i] = random.nextInt(n); //random value cho mang
        }
        myarr.setArray(arr);
        return myarr;
    }

    public static void main(String[] args) {
        ArrayInt array = new GenArray().randomArray(10000);
        for(int i=0;i<10000;i++){
            System.out.print(array.getArray()[i]+" ");
        }
//        array.printArray();
    }
}
