package Test2.entities;


public class MergeSort extends Thread implements SortAlgorithm{

        private int[] array;
        private int begin;
        private int end;

        public MergeSort() {
        }

        public MergeSort(int[] array,int begin, int end) {
            this.array = array;
            this.begin = begin;
            this.end = end;
        }

        public void run(){
            sort(array,begin,end);
        }

        @Override
        public void sort() {
            sort(array,begin,end);
        }
    // mergeSort(arr[], l,  r)
// if r > l
//      1. Tìm chỉ số nằm giữa mảng để chia mảng thành 2 nửa:
//              middle m = (l+r)/2
//      2. Gọi đệ quy hàm mergeSort cho nửa đầu tiên:
//              mergeSort(arr, l, m)
//      3. Gọi đệ quy hàm mergeSort cho nửa thứ hai:
//              mergeSort(arr, m+1, r)
//      4. Gộp 2 nửa mảng đã sắp xếp ở (2) và (3):
//              merge(arr, 1, m, r)
        void merge(int[] arr, int l, int m, int r)
        {
            // Tìm kích thước của 2 mảng con để merged
            int n1 = m - l + 1;
            int n2 = r - m;

            // Tạo mảng tạm
            int[] L = new int[n1];
            int[] R = new int[n2];

            // Tạo mảng tạm
//            for (int i = 0; i < n1; ++i)
//                L[i] = arr[l + i];
            System.arraycopy(arr, l, L, 0, n1);
            for (int j = 0; j < n2; ++j)
                R[j] = arr[m + 1 + j];
            // Merge các mảng tạm lại

            // Chỉ mục ban đầu của 2 mảng con
            int i = 0, j = 0;

            // Initial index of merged subarry array
            int k = l;
            while (i < n1 && j < n2) {
                if (L[i] <= R[j]) {
                    arr[k] = L[i];
                    i++;
                }
                else {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }

            // Sao chép các phần tử còn lại của L[] nếu có
            while (i < n1) {
                arr[k] = L[i];
                i++;
                k++;
            }

            /* Copy remaining elements of R[] if any */
            while (j < n2) {
                arr[k] = R[j];
                j++;
                k++;
            }
        }

        // merge()
        void sort(int[] arr, int l, int r)
        {
            if (l < r) {
                // Find the middle point
                int m =l+ (r-l)/2;

                // Sort first and second halves
                sort(arr, l, m);
                sort(arr, m + 1, r);

                // Merge the sorted halves
                merge(arr, l, m, r);
            }
        }
        static void printArray(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n; ++i)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
        public static void main(String[] args) {
            int[] arr = { 25, 30, 45, 6, 11, 90, 15 };

            System.out.println("Mảng ban đầu:");
            printArray(arr);

            MergeSort ob = new MergeSort();
            ob.sort(arr, 0, arr.length - 1);

            System.out.println("Mảng sau khi sắp xếp:");
            printArray(arr);
        }

}
