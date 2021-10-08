package Test2.entities;
import java.util.Arrays;
public class ArrayInt {
    private int[] array;
    private int length;

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public ArrayInt(int[] array, int length) {
        this.array = array;
        this.length = length;
    }
    public ArrayInt() {
    }
    public void printArray(){ //in mang so nguyen moi dong 10 so
        System.out.print(array[0] + " ");
        for (int i = 1; i < length;i++){
            if(i%10==0){
                System.out.println();
            }
            System.out.print(array[i] + " ");
        }
    }
    public int checkOrdered(){
        for (int i = 0; i < length; i++){
            if(array[i] != i + 1){
                return i;
            }
        }
        return -1;
    }


}
