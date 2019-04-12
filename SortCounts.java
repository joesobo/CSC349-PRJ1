import java.util.Random;
import java.util.Arrays;

public class SortCounts {
    public static void main(String[] args){
        //counting with different N's
        for (int N=100; N<=12800; N *= 2 ) {
            calcAvg(N);
        }
        System.out.println("\nEnd of output");
    }

    private static void calcAvg(int size){
        long[] avgM = new long[100];
        long[] avgS = new long[100];
        long[] avgQ = new long[100];

        //test sorting arrays 100 times
        for (int j = 0; j<100; j++){
            int[] template = randArr(size);
            int[] arr1 = Arrays.copyOf(template, size);
            int[] arr2 = Arrays.copyOf(template, size);
            int[] arr3 = Arrays.copyOf(template, size);

            avgM[j] = Sorts1.mergeSort(arr1, size);
            avgS[j] = Sorts1.selectionSort(arr2, size);
            avgQ[j] = Sorts1.quickSort(arr3, size);
        }
        long m = avgArr(avgM);
        long s = avgArr(avgS);
        long q = avgArr(avgQ);  
        
        System.out.print("N=" + size + 
                        ": C_SS=" + s + 
                        ", C_MS=" + m +
                        ", C_QS=" + q + "\n");
    }

    private static int[] randArr(int size){
        Random r = new Random();
        int[] temp = new int[size];
        //initialize array with randoms
        for(int i = 0; i < size; i++){
            temp[i] = r.nextInt();
        }
        return temp;
    }

    private static long avgArr(long[] arr){
        long total = 0;
        for(int i = 0; i < arr.length; i++){
            total += arr[i];
        }
        return (long)total/arr.length;
    }
}
