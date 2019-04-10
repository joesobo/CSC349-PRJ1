import java.text.ParseException;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Arrays;
public class SortTimes{

    public static void main(String[] args) {
        int N = 5000;

        int[] arr = new int[160000];
        int[] arr2 = new int[160000];
        int[] arr3 = new int[160000];
        Arrays.fill(arr, 0);
        Arrays.fill(arr2, 0);
        Arrays.fill(arr3, 0);

        System.out.println("Running Times of three sorting algorithms\n");

        while(N <= 160000){
            for(int i = 0; i < 5; i++){
                randArr(arr);
                randArr(arr2);
                randArr(arr3);
                int time1, time2, time3 = 0;
                long startTime, endTime = 0;

                //ss
                startTime = System.nanoTime();
                Sorts.selectionSort(arr, N);
                endTime = System.nanoTime();
                time1 = (int)((endTime-startTime)/1000000);

                //ms
                startTime = System.nanoTime();
                Sorts.mergeSort(arr2, N);
                endTime = System.nanoTime();
                time2 = (int)(Math.abs(endTime-startTime)/1000000);

                //qs
                startTime = System.nanoTime();
                Sorts.quickSort(arr3, N);
                endTime = System.nanoTime();
                time3 = (int)(Math.abs(endTime-startTime)/1000000);

                System.out.format("N=%4d: T_ss=%3d, T_ms=%3d, T_qs=%3d", N, time1, time2, time3);
                System.out.println();
            }
            System.out.println("");
            N*=2;
        }
        System.out.println("End of output");
    }

    public static void randArr(int[] arr){
        Random r = new Random();
        for(int i = 0; i < arr.length; i++){
            arr[i] = r.nextInt(arr.length-1);
        }
    }
}