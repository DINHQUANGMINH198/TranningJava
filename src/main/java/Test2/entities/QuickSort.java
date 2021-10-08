package Test2.entities;

public class QuickSort extends Thread implements SortAlgorithm {
        private int[] array;
        private int begin;
        private int end;

        public QuickSort(int[] array, int begin, int end) {
            this.array = array;
            this.begin = begin;
            this.end = end;
        }

        @Override
        public void sort() {
            quickSort(array,begin,end);
        }

        public void run(){
            System.out.println("Thread " + Thread.currentThread().getId() + " start : " + System.nanoTime());
            sort();
            System.out.println("Thread " + Thread.currentThread().getId() + " end   : " + System.nanoTime());
        }

        private int partition(int[] arr, int begin, int end){
            int pivot = arr[end];
            int i = (begin-1);

            for (int j = begin; j < end; j++) {
                if (arr[j] <= pivot) {
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            int temp = arr[i+1];
            arr[i+1] = arr[end];
            arr[end] = temp;
            return i+1;
        }

        private void quickSort(int[] arr, int begin, int end) {
            if (begin < end) {
                int partitionIndex = partition(arr, begin, end);

                quickSort(arr, begin, partitionIndex-1);
                quickSort(arr, partitionIndex+1, end);
            }
        }

}
