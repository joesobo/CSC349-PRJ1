import java.util.Random;
import java.util.Arrays;

public class SortCounts {
    public static void main(String[] args){
        Random r = new Random();
        int[] arr1 = new int[12800];
        int[] arr2 = new int[12800];
        int[] arr3 = new int[12800];

        long avgM = 0;
        long avgS = 0;
        long avgQ = 0;

        //counting with different N's
        for (int N=100; N<=12800; N *= 2 ) {

            //test sorting arrays 100 times
            for (int j = 0; j<100; j++){
                //initialize array with randoms
                for(int i = 0; i < N; i++){
                    arr1[i] = r.nextInt();
                    arr2[i] = r.nextInt();
                    arr3[i] = r.nextInt();
                }

                avgM = (Sorts1.mergeSort(arr1, N));
                avgS = (Sorts1.selectionSort(arr2, N));
                avgQ = (Sorts1.quickSort(arr3, N));
            }

            avgM /= 100;
            avgS /= 100;
            avgQ /= 100;
            
            System.out.println("N=" + N + ": C_SS=" + avgS + ", C_MS=" + avgM +
            ", C_QS=" + avgQ);
        }
        System.out.println("\nEnd of output");
    }

}
