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
    //Sorts the list of Nelements contained in arr[0..N-1]usingthemergesortalgorithm.
    public static void mergeSort(int[] arr, int N){
         
    }
    //Sorts the list of N elements contained in arr[0..N-1]
    public static void quickSort(int[] arr, int N){
        setPivotToEnd(arr, 0, N-1);
        //return arr;
    }

    //sorts
    static void setPivotToEnd(int[] arr, int low, int high){
        if(low < high){
            int pi = splitList (arr, low, high);

            //recursive call sort on either partition
            setPivotToEnd(arr, low, pi-1);
            setPivotToEnd(arr, pi+1, high);
        }
    }

    //rearranges pivot and elements on either side
    static int splitList (int[] arr, int low, int high){
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