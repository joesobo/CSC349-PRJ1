//Sorts class
//By Joseph Soboleski (jsoboles) and Salman Wajahat (swajahat)
//Main sorting methods with no return for timer class

public class Sorts{
    public static void selectionSort(int[] arr, int N) {
        int minIndex;
        for (int i = 0; i < N - 1; i++) {

            //find min
            minIndex = i;
            for (int j = i+1; j < N; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
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
    public static void quickSort(int[] arr, int N){
        quickSort(arr, 0, N-1);
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

        //compare first and center element for smaller
        if(arr[low] > arr[middle]){
            swap(arr, low, middle);
        }
        
        //compare first and last element for smaller
        if(arr[low] > arr[high]){
            swap(arr, low, high);
        }
        
        //compare center and last element for larger
        if(arr[middle] < arr[high]){
            swap(arr, middle, high);
        }
    }
    
    //rearranges pivot and elements on either side
    //requires arr[right] as pivot
    static int splitList(int[] arr, int left, int right){
        int indexL = left;
        int indexR = right-1;
        int pivot = arr[right];

        //check for cross over
        while(indexL <= indexR){

            //move indexL to the right
            while(arr[indexL] < pivot){
                indexL++;
            }

            //move indexR to the left
            while(indexL <= indexR && arr[indexR] > pivot){
                indexR--;
            }

            //check for cross over
            if(indexL <= indexR){
                //swap elements at indexs
                swap(arr, indexL, indexR);
                //move both indexs
                indexL++;
                indexR--;
            }
        }
        //swap element indexL with pivot
        swap(arr, indexL, right);
        //returns index of pivot
        return indexL;
    }

    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
