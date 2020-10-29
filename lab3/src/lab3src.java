import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class lab3src {
    public static void main(String[] args) {
        int[] ta1 = new int[5];
        ta1[0] = 2;
        ta1[1] = 3;
        ta1[2] = 7;
        ta1[3] = 4;
        ta1[4] = 0;

        int[] ta2 = new int[6];
        ta2[0] = 3;
        ta2[1] = 2;
        ta2[2] = 4;
        ta2[3] = 6;
        ta2[4] = 0;
        ta2[5] = 1;

        int[] ta3 = new int[10];
        ta3[0] = 8;
        ta3[1] = 3;
        ta3[2] = 0;
        ta3[3] = 10;
        ta3[4] = 6;
        ta3[5] = 7;
        ta3[6] = 4;
        ta3[7] = 12;
        ta3[8] = 1;
        ta3[9] = 15;

        int[] ta4 = new int[1];
        ta4[0] = 4;

        int[] ta5 = new int[2];
        ta5[0] = 7;
        ta5[1] = 5;

        int[] ta6 = new int[3];
        ta6[0] = 8;
        ta6[1] = 2;
        ta6[2] = 6;

        int[] ta7 = new int[8];
        ta7[0] = 2;
        ta7[1] = 6;
        ta7[2] = 8;
        ta7[3] = -5;
        ta7[4] = -1;
        ta7[5] = 0;
        ta7[6] = 9;
        ta7[7] = 10;


        int[] inArray = ta7;
        int k = 7;
        Scanner scanner = new Scanner(System.in);

        /**Part A**/
        System.out.println("Enter a number to generate the array size: ");
        int n = scanner.nextInt();
        int[] userAr = new int[n];

        for (int i = 0; i < n; i++){
            userAr[i] = ThreadLocalRandom.current().nextInt(-100,101);
        }
        System.out.println("Random Array: ");
        System.out.println(Arrays.toString(userAr));
        System.out.println();

        System.out.println("Enter a k number: ");
        int userK = scanner.nextInt();
        int pivIdx = Quick_Select(userAr, 0, userAr.length - 1, userK);

        System.out.println();
        System.out.println("Array after partition: " + Arrays.toString(userAr));
        System.out.println("K element Index: " + pivIdx);
        System.out.println("Value of element k: " + userAr[pivIdx]);
        System.out.println();

        /**Part B**/
        //int maxNum = 5;
        System.out.println("Input a number to find max k numbers: ");
        int maxNum = scanner.nextInt();
        int prevIndex = userAr.length - maxNum;
        int eleIdx = Quick_Select(userAr, 0, userAr.length - 1, prevIndex);
        ArrayList<Integer> maxNumAr = new ArrayList<Integer>();

        System.out.println("After second QS: " + Arrays.toString(userAr));
        for(int i = (eleIdx + 1); i < userAr.length; i++ ){
            maxNumAr.add(userAr[i]);
        }

        System.out.println("Max " + maxNum + " numbers");
        System.out.println("Max num arrays: ");
        System.out.println(maxNumAr);

    }

    public static void test(int[] a) {
        a[2] = -5;
    }

    public static int partition(int[] a, int leftBound, int rightBound) {      //return the index of the pivot
        int pivot = a[leftBound];           //Pick the first element of the given array using which is left bound
        int left = leftBound;
        int right = rightBound;
        //Swapping pivot with last element

        while (left <= right) {
            if (a[left] <= pivot) {
                left++;
            }
            else if(a[right] > pivot) {
                right--;
            }
            else {           //swap if can't move
                int prevLeft = a[left];
                a[left] = a[right];
                a[right] = prevLeft;
            }
        }
        if (a.length == 1) {
            System.out.println("Array of size 1: ");
            return 0;
        }
        else if (a.length > 1) {
            a[leftBound] = a[left -1];
            a[left -1] = pivot;
            return (left -1);
        }
        System.out.println("Encounter error");
        return -1;
    }

    public static int Quick_Select(int[] a, int left, int right, int k) {
        int pivIndex = partition(a, left, right);

        if(pivIndex + 1 == k) {     //if the the size of the left array + 1 is the same as k stop running
            return pivIndex;        //return the index of the selected number
        }

        else if(pivIndex + 1 > k) {         //Call the function on the left size from beginning to pivot
            return Quick_Select(a, left, pivIndex - 1, k);
        }

        //else {
        else if(pivIndex + 1 < k) {         //Call the function on the right size from pivot to the end
            return Quick_Select(a, pivIndex + 1, right, k);
        }
        //System.out.println("Quick Select return error");
        return -1;
    }
}
