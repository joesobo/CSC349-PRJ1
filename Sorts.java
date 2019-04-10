public class Sorts{
    //Sorts the list of Nelements contained in arr[0..N-1]using the selectionsortalgorithm.
    public static void  selectionSort(int[] arr, int N){
        int min = Integer.MAX_VALUE;
        int pos = 0;
        int save;
        for(int i = 0; i < N-1; i++){

            //find min
            min = arr[i];
            pos = i;
            for(int j = i+1; j < N; j++){
                if(arr[j] < min){
                    min = arr[j];
                    pos = j;
                }
            }

            //swap
            save = min;
            arr[pos] = arr[i];
            arr[i] = save;
        }

        //return arr;
    }
    //Sorts the list of N elements contained in arr[0..N-1]using the mergesort algorithm.
    public static void mergeSort(int[] arr, int N){
        MergeSort(arr, 0, N-1);
    }

    //behind the scenes work for mergesort
    //rearranges the list using mergesort
    private static void mergeSortedHalves (int[] list, int first, int middle, int last) {
        int len1 = middle - first + 1;
        int len2 = last - middle;

        int[] left = new int[len1];
        int[] right = new int[len2];

        for (int i=0; i<len1; i++) {
            left[i] = list[first + i];
        }
        for (int j = 0; j<len2; j++) {
            right[j] = list[middle + 1 + j];
        }

        int i=0;
        int j = 0;
        int k = first;
        while (i < len1 && j < len2) {
            if (left[i] <= right[j]) {
                list[k] = left[i];
                i++;
            }
            else {
                list[k] = right[j];
                j++;
            }
            k++;
        }

        while (i <len1) {
            list[k] = left[i];
            i++;
            k++;
        }

        while (j < len2) {
            list[k] = right[j];
            j++;
            k++;
        }
    }

    private static void MergeSort(int arr[], int first , int last) {
        if (first < last) {
            int mid = (first+last)/2;
            MergeSort(arr, first, mid);
            MergeSort(arr, mid+1, last);
            mergeSortedHalves(arr, first, mid, last);
        }
    }

    //Sorts the list of N elements contained in arr[0..N-1]
    public static void quickSort(int[] arr, int N){
        sort(arr, 0, N-1);
        //return arr;
    }

    //sorts
    static void sort(int[] arr, int low, int high){
        if(low < high){
            int pi = partition(arr, low, high);

            //recursive call sort on either partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    //rearranges pivot and elements on either side
    static int partition(int[] arr, int low, int high){
        int piv = arr[high];
        int i = low-1;
        for(int j = low; j < high; j++){
            if(arr[j] <= piv){
                i++;

                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        //swap again
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    

    // public static void main(String[] args){
    //     int[] arr = {1,3,5,2,9};
    //     System.out.println("Selection Sort");
    //     printOut(arr);
    //     arr = selectionSort(arr, arr.length);
    //     System.out.println("");
    //     printOut(arr);

    //     System.out.println("Quick sort");
    //     printOut(arr2);
    //     arr2 = quickSort(arr2, arr2.length);
    //     System.out.println("");
    //     printOut(arr2);
    // }

    // public static void printOut(int[] arr){
    //     for(int i = 0; i < arr.length; i++){
    //         System.out.println(arr[i]);
    //     }
    // }
}
