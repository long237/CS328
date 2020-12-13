import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class lab5src {
    public static void main(String[] args) {

        int[] ta1 = new int[9];     //for building and sorting
        ta1[0] = 21;
        ta1[1] = 0;
        ta1[2] = 1;
        ta1[3] = -1;
        ta1[4] = -3;
        ta1[5] = 10;
        ta1[6] = 21;
        ta1[7] = 25;
        ta1[8] = 31;

        int[] ta2 = new int[10];
        ta2[0] = 100;
        ta2[1] = 50;
        ta2[2] = 60;
        ta2[3] = 45;
        ta2[4] = 20;
        ta2[5] = 10;
        ta2[6] = 55;
        ta2[7] = 5;
        ta2[8] = 36;
        ta2[9] = 2;

        int[] ta3 = new int[9];
        ta3[0] = 60;
        ta3[1] = 50;
        ta3[2] = 55;
        ta3[3] = 45;
        ta3[4] = 20;
        ta3[5] = 10;
        ta3[6] = 2;
        ta3[7] = 5;
        ta3[8] = 36;

        int[] ta4 = new int[10];        //for building sorting
        ta4[0] = 87;
        ta4[1] = 21;
        ta4[2] = 0;
        ta4[3] = -1;
        ta4[4] = -22;
        ta4[5] = 10;
        ta4[6] = 17;
        ta4[7] = 11;
        ta4[8] = -3;
        ta4[9] = 10;

        int[] ta5 = new int[10];    //for building
        ta5[0] = 0;
        ta5[1] = 20;
        ta5[2] = 11;
        ta5[3] = 10;
        ta5[4] = 2;
        ta5[5] = -2;
        ta5[6] = 16;
        ta5[7] = 5;
        ta5[8] = 18;
        ta5[9] = 19;


        int[] ta6 = new int[5];
        ta6[0] = 5;
        ta6[1] = 2;
        ta6[2] = 1;
        ta6[3] = 6;
        ta6[4] = 4;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an arrays size: ");
        int n = scanner.nextInt();

        int[] user_ar = new int[n];
        for (int i = 0; i < n; i++){
            user_ar[i] = ThreadLocalRandom.current().nextInt(-100, 101);
        }

        int[] inputAr = ta1;

        //Part A:
        //Heap sort run time section
        long startTime = System.nanoTime();
        System.out.println("Input Array: " + Arrays.toString(inputAr));
        heap_Sort(inputAr);;
        System.out.println("After heap sort: " + Arrays.toString(inputAr));
        long endTime = System.nanoTime();
        long heapSortTime = endTime - startTime;
        System.out.println("Average run time heap sort: " + heapSortTime + " nanosecond");

        //Selection sort run time
        for (int i = 0; i < n; i++){
            user_ar[i] = ThreadLocalRandom.current().nextInt(-100, 101);
        }
        startTime = System.nanoTime();
        selection_Sort(inputAr);
        endTime = System.nanoTime();
        long selectionTime = endTime - startTime;
        System.out.println("Average run time selection: " + selectionTime + " nanosecond");

        if (heapSortTime < selectionTime) {
            System.out.println("Heap sort runs faster");
        }
        else {
            System.out.println("Selection sort runs faster");
        }

        //Part B:
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++){
            a[i] = ThreadLocalRandom.current().nextInt(-100, 101);
        }
        System.out.println("Before sort: " + Arrays.toString(a));
        heap_Sort(a);
        System.out.println("After sort: " + Arrays.toString(a));
    }

    public static void max_heapify(int[] a, int i, int rightBound){
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        //Check to see if left child exist and compare with max value
        if((left < rightBound) && (a[max] < a[left])){
            max = left;
        }
        if((right < rightBound) && (a[max] < a[right])){
            max = right;
        }
        if(max != i) {
            swap(a, i, max);
            max_heapify(a, max, rightBound);            //Call new heapify on the new position
        }
    }

    public static void build_MaxHeap(int[]a){
        int lastInter = (a.length / 2) - 1;
        for(int i = lastInter; i >= 0; i--){
            max_heapify(a, i, a.length);
        }
    }

    public static void heap_Sort(int[] a){
        build_MaxHeap(a);
        System.out.println("Array after build: " + Arrays.toString(a));
        for(int i = a.length - 1; i > 0; i--){          //Only call sort on the unsorted part of the array
            swap(a, 0, i);
            max_heapify(a, 0, i);       //Keep calling max heapify on the root to sort
        }
    }

    public static void selection_Sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;                            //The index of the smallest number
            for(int j = i; j < a.length; j++){
                if( a[j] <= a[min]){
                    min = j;
                }
            }
            swap(a, i, min);
        }
    }

    public static void swap(int[] a, int e1, int e2) {
        int prevE1 = a[e1];
        a[e1] = a[e2];
        a[e2] = prevE1;
    }
}
