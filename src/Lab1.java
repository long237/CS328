import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Lab1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a positive integer");
        int n = scanner.nextInt();
        int rand_int = ThreadLocalRandom.current().nextInt(-1000, 1001);
        int numExperiment = 100;
        //double numInput = 100000;

        System.out.println("This is user input: " + n);
        System.out.println("This is a random number: " + rand_int);
        int[] a = new int[n];

        //Generate n random numbers
        for (int i = 0; i < n; i++) {
            a[i] = ThreadLocalRandom.current().nextInt(-1000, 1001);
        }

        //Sort the array
        //System.out.println("this is the array: ");
        Arrays.sort(a);
        //System.out.println(Arrays.toString(a));

        //Linear Search experiment
        long startTime = System.nanoTime();
        for (int i = 0; i < numExperiment; i++) {
            int key = a[ThreadLocalRandom.current().nextInt(0, n)];     //Pick a random key
            //System.out.println("this is the random key: " + key);

            int index = linearSearch(a, key);       //Search using linearSearch
            //System.out.println("this is the index for search: " + index);
        }
        long endTime = System.nanoTime();
        long linearTime = endTime - startTime;

        //System.out.println("Linear Search time: " + linearTime);
        System.out.printf("Linear Search time for %d experiments is: %d \n", numExperiment, linearTime);

        //Binary Search experiment
        startTime = System.nanoTime();
        for (int i = 0; i < numExperiment; i++) {
            int key = a[ThreadLocalRandom.current().nextInt(0, n)];     //Pick a random key
            //System.out.println("this is the random key: " + key);

            int index = Arrays.binarySearch(a, key);       //Search using linearSearch
            //System.out.println("this is the index for search: " + index);
        }
        endTime = System.nanoTime();
        long binaryTime = endTime - startTime;

        System.out.printf("Linear Search time for %d experiments is: %d \n", numExperiment, binaryTime);
        System.out.println("Linear Search average time: " + (linearTime / numExperiment));
        System.out.println("Binary Search average time: " + (binaryTime / numExperiment));


        /**Part B **/
        System.out.println("Enter a positive integer for Part B: ");
        n = scanner.nextInt();

        //Generate a random array of size n
        for (int i = 0; i < n; i++) {
            a[i] = ThreadLocalRandom.current().nextInt(-1000, 1001);
        }

        Arrays.sort(a);     //Sort the array
        int key = 5000;

        //Calling the linear search function
        startTime = System.nanoTime();
        linearSearch(a, key);
        endTime = System.nanoTime();
        long linearWorst = endTime - startTime;

        //Binary Search worst case
        startTime = System.nanoTime();
        Arrays.binarySearch(a, key);
        endTime = System.nanoTime();
        long binaryWorst = endTime - startTime;


        System.out.println("Linear search worst-case running time: "  + linearWorst);
        System.out.println("Binary search worst-case running time: " + binaryWorst);

        long binaryOneLine = (long)(binaryWorst / Math.log(n));
        System.out.println("Run time for one line: " + binaryOneLine);

        double largeInput = Math.pow(10, 15);
        //double input = 1_000_000_000_000_000;
        //long input = 1000000000000000;
        long largeBinary = (long)(binaryOneLine * Math.log(largeInput));
        long largeLinear = (long)(binaryOneLine * largeInput);
        System.out.println("Worst case running time with large number for Linear: " + largeLinear);
        System.out.println("Worst case running time with large number for Binary: " + largeBinary);


    }


        //Linear search function
        public static int linearSearch(int[] array, int key) {
            for (int i = 0; i < array.length; i++){
                if (array[i] == key) {
                    return i;
                }
            }
            return -1;
        }

}
