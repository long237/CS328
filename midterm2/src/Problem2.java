import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Problem2 {
    public static void main(String[] args) {
        double[] ta1 = new double[7];
        ta1[0] = 2;
        ta1[1] = 3;
        ta1[2] = 5;
        ta1[3] = 7;
        ta1[4] = 8;
        ta1[5] = 10;
        ta1[6] = 15;

        double[] ta2 = new double[9];
        ta2[0] = 0;
        ta2[1] = 2;
        ta2[2] = 4;
        ta2[3] = 8;
        ta2[4] = 9;
        ta2[5] = 12;
        ta2[6] = 13;
        ta2[7] = 15;
        ta2[8] = 24;


        double[] arb1 = new double[3];
        arb1[0] = 2;
        arb1[1] = 10;
        arb1[2] = 5;

        double[] arb2 = new double[5];
        arb2[0] = 12;
        arb2[1] = 0;
        arb2[2] = 4;
        arb2[3] = 2;
        arb2[4] = 24;

        double key = 11;
//        System.out.println("Input array: " + Arrays.toString(inputar));
//        System.out.println("Element to search: " + key);
//        System.out.println("Index of key: " + binarySearch(inputar, key));
        int n = ThreadLocalRandom.current().nextInt(1, 25);
        int k = ThreadLocalRandom.current().nextInt(0, n);
        double[] ara = new double[n];
        double[] arb = new double[k];
        for (int i = 0; i < ara.length; i++){
            ara[i] = (double) Math.round(ThreadLocalRandom.current().nextDouble(-100, 101) * 100.0) / 100.0;
        }
        for (int i = 0; i < arb.length; i++){
            arb[i] = (double) Math.round(ThreadLocalRandom.current().nextDouble(-100, 101) * 100.0) / 100.0;
        }

        double[] inputar = ara;
        double[] inputb = arb;

        System.out.println("n: " + n);
        System.out.println("k: " + k);
        Arrays.sort(ara);
        System.out.println("Array a: " + Arrays.toString(ara));
        System.out.println("Array b: " + Arrays.toString(arb ));
        System.out.println("");
        System.out.println("Input array a: " + Arrays.toString(inputar));
        System.out.println("Input array b: " + Arrays.toString(inputb));
        boolean result = is_Subset(inputar, inputb);
        System.out.println("");

        if (result) {
            System.out.println("Array b is a subset of a");
        }
        else{
            System.out.println("Arrays b is not a subset of a");
        }

    }

    public static boolean is_Subset(double[] a, double[] b) {
        for (int i = 0; i < b.length; i++){
            int result = binarySearch(a, b[i]);
            if (result == -1){
                return false;
            }
        }
        return true;
    }

    public static int binarySearch(double[] ar, double key) {     //Return the index of the key
        int start = 0;
        int end = ar.length - 1;
        int mid =(start + end) / 2;

        while (start <= end) {
            if (ar[mid] == key) {
                //System.out.println("Found the index line execute \n");
                return mid;
            }
            else if(ar[mid] > key) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }
        //System.out.println("Error Line execute \n");
        return -1;      /** Elements is not found **/
    }
}
