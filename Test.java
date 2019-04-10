import java.util.Random;
import java.util.Arrays;

public class Test{
    public static void main(String[] args){
        int N = 50;
        int inc = 50;
        int[] arr;
        int[] compareArr;

        // SelectionSort
        System.out.println("Selection Sort Testing: ");
        for(int i = 1; i < 10; i++){
            arr = fillRand(N);
            compareArr = arr;

            Arrays.sort(compareArr);
            Sorts.selectionSort(arr, N);
            
            if(arr.equals(compareArr)){
                System.out.println("SS"+i+": True with N="+N);
            }else{
                System.out.println("SS"+i+": False with N="+N);
            }
            N+=inc;
        }
        N=50;

        // MergeSort
        System.out.println("\nMerge Sort Testing: ");
        for(int i = 1; i < 10; i++){
            arr = fillRand(N);
            compareArr = arr;
            Arrays.sort(compareArr);
            Sorts.mergeSort(arr, N);

            if(arr.equals(compareArr)){
                System.out.println("MS"+i+": True with N="+N);
            }else{
                System.out.println("MS"+i+": False with N="+N);
            }
            N+=inc;
        }
        N=50;

        // QuickSort
        System.out.println("\nQuick Sort Testing: ");
        for(int i = 1; i < 10; i++){
            arr = fillRand(N * i);
            compareArr = arr;
            Arrays.sort(compareArr);
            Sorts.quickSort(arr, N);

            if(arr.equals(compareArr)){
                System.out.println("QS"+i+": True with N="+N);
            }else{
                System.out.println("QS"+i+": False with N="+N);
            }
            N+=inc;
        }
    }

    public static int[] fillRand(int num){
        Random r = new Random();
        int[] arr = new int[num];

        for(int i = 0; i < num; i++){
            arr[i] = r.nextInt(num-1);
        }

        return arr;
    }
}