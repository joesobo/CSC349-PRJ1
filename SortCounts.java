import java.util.Random;
import java.util.Arrays;

public class SortCounts {
    public static void main(String[] args){
        int[] arr1 = new int[12800];
        int[] arr2 = new int[12800];
        int[] arr3 = new int[12800];


        long avgM;
        long avgS;
        long avgQ;


        for (int i=100; i<=12800; i = i * 2 ) {
            Random r = new Random();
            for (int j = 0; j<i; j++){
                arr1[j] = r.nextInt();
            }
            avgM = (Sorts1.mergeSort(arr1, i)) / i;
            avgS = (Sorts1.mergeSort(arr2, i)) / i;
            avgQ = (Sorts1.mergeSort(arr3, i)) / i;
            System.out.print("N=" + i + ": C_SS=" + avgS + ", C_MS=" + avgM +
            ", C_QS=" + avgQ);
            System.out.println();
        }
            System.out.println();
            System.out.println("End of output");
    }

}
