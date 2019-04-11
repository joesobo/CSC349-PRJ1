import java.util.Arrays;

public class Sorts1 {
    private static long countM = 0;
    private static long countS = 0;
    private static long countQ = 0;


    public static long selectionSort(int[] arr, int N) {
        int minIndex;
        int save;
        for (int i = 0; i < N - 1; i++) {

            //find min
            minIndex = i;
            for (int j = i + 1; j < N; j++) {
                countS++;
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            //swap
            save = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = save;
        }
        return countS;
    }
    //Sorts the list of N elements contained in arr[0..N-1]using the mergesort algorithm.
    public static long mergeSort(int[] arr, int N){
        MergeSort(arr, 0, N-1);
        return countM;
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
            countM++;
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

        while (i < len1) {
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
    public static long quickSort(int[] arr, int N){
        quickSort(arr, 0, N-1);
        return countQ;
    }

    //Sorts list from first to last
    public static void quickSort(int[] arr, int first, int last){
        if(first < last){
            setPivotToEnd(arr, first, last);
            int pivotIndex = splitList(arr, first, last);
            quickSort(arr, first, pivotIndex-1);
            quickSort(arr, pivotIndex+1, last);
        }
    }

    //Chooses pivot value and places at last index
    //ensures arr[right] has pivot
    static void setPivotToEnd(int[] arr, int low, int high){
        //choose pivot
        int middle = (low+high)/2;
        int temp = 0;

        //compare first and center element for smaller
        countQ++;
        if(arr[low] > arr[middle]){
            temp = arr[low];
            arr[low] = arr[middle];
            arr[middle] = temp;
        }
        
        //compare first and last element for smaller
        countQ++;
        if(arr[low] > arr[high]){
            temp=arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
        }
        
        //compare center and last element for larger
        countQ++;
        if(arr[middle] < arr[high]){
            temp=arr[middle];
            arr[middle] = arr[high];
            arr[high] = temp;
        }
    }
    //rearranges pivot and elements on either side
    //requires arr[right] as pivot
    static int splitList (int[] arr, int left, int right){
        int indexL = left;
        int indexR = right-1;
        int pivot = arr[right];

        //check for cross over
        while(indexL < indexR){
            
            //move indexL to the right
            while(arr[indexL] < pivot){
                indexL++;
                countQ++;
            }

            //move indexR to the left
            while(arr[indexR] > pivot && indexL < indexR){
                indexR--;
                countQ++;
            }

            //check for cross over
            if(indexL < indexR){
                //swap elements at indexs
                int temp = arr[indexL];
                arr[indexL] = arr[indexR];
                arr[indexR] = temp;
                //move both indexs
                indexL++;
                indexR--;
            }
        }
        //swap element indexL with pivot
        int temp = arr[indexL];
        arr[indexL] = arr[right];
        arr[right] = temp;
        //returns index of pivot
        return indexL;
    }

    public static void main(String[] args){
        int[] arr = {1,1,1,2,3,5,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,24,100,14,17,124,23,43,243,64,2,2,2,2,2,2,2,2200,2,2,2,2,2,2,2,9,4,8,7,6,11};
        System.out.println("Selection Sort");
        printOut(arr);
        long cs = selectionSort(arr, arr.length);
        System.out.println("count: " + cs);
        printOut(arr);

        int[] arr2 = {1,1,1,2,3,5,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,24,100,14,17,124,23,43,243,64,2,2,2,2,2,2,2,2200,2,2,2,2,2,2,2,9,4,8,7,6,11};
        //int[] arr2 = {1,5,15,4,2,17,7,12,0,13,3,9,8,6};
        //int[] arr2 = {1,8,2,10,4,5,9,11,3,12,15,7};
        System.out.println("Quick sort");
        printOut(arr2);
        long cq = quickSort(arr2, arr2.length);
        System.out.println("count: " + cq);
        printOut(arr2);

        // int[] arr4 = {7,5,2,3};
        // System.out.println("Merge sort");
        // printOut(arr4);long count = mergeSort(arr4, arr4.length);
        // System.out.println("count: " + count);
        // printOut(arr4);
    }

    public static void printOut(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

}
