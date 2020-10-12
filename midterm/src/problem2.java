import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class problem2 {
    public static void main(String[] args) {

        //Random double array and a random key to run the program. 
        int n = ThreadLocalRandom.current().nextInt(1, 15);
        double[] a = new double[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = Math.round(ThreadLocalRandom.current().nextDouble(-15.0, 15.0) * 100.0) / 100.0;
        }
        int randomIndex = ThreadLocalRandom.current().nextInt(0, a.length);
        double randomKey = a[randomIndex];
        System.out.println("Random double array: " );
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("Array after sort: " );
        System.out.println(Arrays.toString(a));

        double[] tar1 = new double[9];
        tar1[0] = 0;
        tar1[1] = 1;
        tar1[2] = 1;
        tar1[3] = 2;
        tar1[4] = 2;
        tar1[5] = 2;
        tar1[6] = 3;
        tar1[7] = 3;
        tar1[8] = 6;

        double[] tar2 = new double[9];
        tar2[0] = 0;
        tar2[1] = 0;
        tar2[2] = 2;
        tar2[3] = 2;
        tar2[4] = 3;
        tar2[5] = 9;
        tar2[6] = 10;
        tar2[7] = 12;
        tar2[8] = 15;

        double[] tar3 = new double[5];
        tar3[0] = 0;
        tar3[1] = 1;
        tar3[2] = 3;
        tar3[3] = 8;
        tar3[4] = 12;

        double[] tar4 = new double[8];
        tar4[0] = -10.12;
        tar4[1] = -5;
        tar4[2] = -2.88;
        tar4[3] = -2.88;
        tar4[4] = 5;
        tar4[5] = 7;
        tar4[6] = 9;
        tar4[7] = 12;

        double[] tar5 = new double[5];
        tar5[0] = 2;
        tar5[1] = 2;
        tar5[2] = 2;
        tar5[3] = 2;
        tar5[4] = 2;




        double key = -2.88;
        double[] ar = tar4;
        int keyIndex = binarySearch(ar, key);         //Call binary search function
        System.out.println("The index of the key is: " + keyIndex);

        if(keyIndex == -1) {
            System.out.println("The key: " + key + " is repeated: 0 times");
        }
        else {
            int count = 1;
            int temp = keyIndex + 1;
            while( (temp < ar.length) && (ar[temp] == key)) {
                count++;
                temp++;
            }

            temp = keyIndex - 1;
            while((temp >= 0) && (ar[temp] == key)) {
                count++;
                temp--;
            }
            System.out.println("The key: " + key + " is repeated: " + count);
        }

    }

    public static int binarySearch(double[] ar, double key) {     //Return the index of the key
        int start = 0;
        int end = ar.length;
        int mid =(start + end) / 2;

        while (start <= end) {
            if (ar[mid] == key) {
                System.out.println("Found the index line execute \n");
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
        System.out.println("Error Line execute \n");
        return -1;      /** Elements is not found **/
    }
}
