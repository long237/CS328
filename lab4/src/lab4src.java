import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class lab4src {
    public static void main(String[] args) {
        int[] ta1 = new int[6];
        ta1[0] = 2;
        ta1[1] = 0;
        ta1[2] = 5;
        ta1[3] = 6;
        ta1[4] = 100;
        ta1[5] = -50;

        int[] ta2 = new int[5];
        ta2[0] = 10;
        ta2[1] = 4;
        ta2[2] = 2;
        ta2[3] = 15;
        ta2[4] = 18;

        int[] ta3 = new int[7];
        ta3[0] = 25;
        ta3[1] = 3;
        ta3[2] = 1;
        ta3[3] = 8;
        ta3[4] = 7;
        ta3[5] = 2;
        ta3[6] = 32;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input an n value: ");
        int n = scanner.nextInt();

        int[] inputAr = new int[ThreadLocalRandom.current().nextInt(1, n)];
        for (int i = 0; i < inputAr.length; i++){
            inputAr[i] = ThreadLocalRandom.current().nextInt(-100, 101);
        }
        System.out.println("Input array: " + Arrays.toString(inputAr));
        System.out.println("Enter a k value: ");
        int k = scanner.nextInt();

        int[] result = ClosetK(inputAr, k);
        System.out.println("Result value in main: " + Arrays.toString(result));

        //System.out.println("Value of k: " + k);
//        int median = Quick_Select(inputAr, 0, inputAr.length - 1, (inputAr.length / 2) + 1, 0);
//        System.out.println("Array after QS: " + Arrays.toString(inputAr));
//        System.out.println("Median index: " + median);
//        System.out.println("Median value: " + inputAr[median]);
//        System.out.println();
    }

    public static int[] ClosetK (int[] a, int k) {
        //Find median of the array
        int median = Quick_Select(a, 0, a.length -1, (a.length / 2) + 1,0);
        System.out.println("Array after QS: " + Arrays.toString(a));
        System.out.println("Median index: " + median);
        System.out.println("Median value: " + a[median]);

        //Calculate the distance between all values relative to the median
        int[] diff = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            diff[i] = a[i] - a[median];
        }
        System.out.println();
        System.out.println("Diff array: " + Arrays.toString(diff));

        //Find the k + 1 smallest element in the difference array.
        int lastCloset = Quick_Select(diff, 0, diff.length - 1, k + 1, 1);
        System.out.println("Last closet: " + lastCloset);

        //Save all value to the left of the k + 1 element to an array and add the median value to readjust
        int[] closetNum = new int[k + 1];
        ArrayList<Integer> closeDi = new ArrayList<Integer>();
        for(int i = 0; i <= lastCloset; i++) {
            closetNum[i] = diff[i];
        }
        System.out.println("Closet num diff: " + Arrays.toString(closetNum));
        for(int i = 0; i <= lastCloset; i++) {
            closetNum[i] = diff[i] + a[median];
        }
        for(int i = 0; i <= lastCloset; i++) {              //Arrays list to not include the median
            if(diff[i] != 0){
                closeDi.add(diff[i] + a[median]);
            }
        }
        //System.out.println("Closet numbers: " + Arrays.toString(closetNum));
        System.out.println("No pivot: " + closeDi);
        return closetNum;
    }

    public static int partition(int[] a, int leftBound, int rightBound, int flag) {      //return the index of the pivot
        int pivot = a[leftBound];           //Pick the first element of the given array using which is left bound
        int left = leftBound;
        int right = rightBound;
        //Swapping pivot with last element
        if(flag == 0) {         //Partition array normally
            while (left <= right) {
                if (a[left] <= pivot) {
                    left++;
                } else if (a[right] > pivot) {
                    right--;
                } else {           //swap if can't move
                    int prevLeft = a[left];
                    a[left] = a[right];
                    a[right] = prevLeft;
                }
            }
        }
        else if(flag == 1){         //Partition array while making taking the absolute value of all elements
            while (left <= right) {
                if (Math.abs(a[left]) <= Math.abs(pivot)) {
                    left++;
                }
                else if (Math.abs(a[right]) > Math.abs(pivot)) {
                    right--;
                } else {           //swap if can't move
                    int prevLeft = a[left];
                    a[left] = a[right];
                    a[right] = prevLeft;
                }
            }
        }
        if (a.length == 1) {
            System.out.println("Array of size 1: ");
            return 0;
        }
        else if (a.length > 1) {            //Swap the elements with each other if the 2 pointers stop
            a[leftBound] = a[left -1];
            a[left -1] = pivot;
            return (left -1);
        }
        System.out.println("Encounter error");
        return -1;
    }

    public static int Quick_Select(int[] a, int left_idx, int right_idx, int k, int flag) {
        int pivIndex = partition(a, left_idx, right_idx, flag);

        if(pivIndex + 1 == k) {     //if the the size of the left array + 1 is the same as k stop running
            return pivIndex;        //return the index of the selected number
        }

        else if(pivIndex + 1 > k) {         //Call the function on the left size from beginning to pivot
            return Quick_Select(a, left_idx, pivIndex - 1, k, flag);
        }

        //else {
        else if(pivIndex + 1 < k) {         //Call the function on the right size from pivot to the end
            return Quick_Select(a, pivIndex + 1, right_idx, k, flag);
        }
        //System.out.println("Quick Select return error");
        return -1;
    }
}
