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

        int[] ta7 = new int[6];
        ta7[0] = 4;
        ta7[1] = 2;
        ta7[2] = 0;
        ta7[3] = 10;
        ta7[4] = 1;
        ta7[5] = 6;


        int[] inArray = ta5;
        int k = 1;
        Scanner scanner = new Scanner(System.in);
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
        int maxNum = 5;
        int prevIndex = userAr.length - maxNum;
        int eleIdx = Quick_Select(userAr, 0, userAr.length - 1, prevIndex);
        ArrayList<Integer> maxNumAr = new ArrayList<Integer>();

//        System.out.println("After second QS: " + Arrays.toString(userAr));
//        for(int i = (eleIdx + 1); i < userAr.length; i++ ){
//            System.out.println(userAr[i]);
//        }

        System.out.println("After second QS: " + Arrays.toString(userAr));
        for(int i = (eleIdx + 1); i < userAr.length; i++ ){
            maxNumAr.add(userAr[i]);
        }

        System.out.println("Max " + maxNum + " numbers");
        System.out.println("Max num arrays: ");
        System.out.println(maxNumAr);


//        System.out.println("Input Array: " + Arrays.toString(inArray));
//        int piv_idx = partition(inArray, 0, inArray.length - 1);
//        System.out.println();
//        System.out.println("Array after partition: " + Arrays.toString(inArray));
//        System.out.println();
//        System.out.println("Pivot Index: " + piv_idx);

//        System.out.println("Input Array: " + Arrays.toString(inArray));
//        System.out.println("K value: " + k);
//        int pivIdx = Quick_Select(inArray, 0, inArray.length - 1, k);
//
//        System.out.println("Array after partition: " + Arrays.toString(inArray));
//        System.out.println();
//        System.out.println("K element Index: " + pivIdx);
//        System.out.println();
//        System.out.println("Value of element k: " + inArray[pivIdx]);




    }

    public static void test(int[] a) {
        a[2] = -5;
    }

    public static int partition(int[] a, int leftBound, int rightBound) {      //return the index of the pivot
        int pivot = a[leftBound];           //Pick the first element of the given array using which is left bound
        int left = leftBound;
        int right = rightBound;
//        System.out.println("Pivot: " + pivot);
//        System.out.println("Part left bound: " + left);
//        System.out.println("Part right bound: " + right);

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
            //System.out.println("left bound: " + left);
            //System.out.println("right bound: " +right);
        }
        if (a.length == 1) {
            System.out.println("Array of size 1: ");
            return 0;
        }
        else if (a.length > 1) {
            a[leftBound] = a[left -1];
            a[left -1] = pivot;
//            System.out.println("Pivot index: " + (left -1));
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
//            System.out.println("Input array to left: " + Arrays.toString(a));
//            //System.out.println("Pivot Index left: " + pivIndex);
//            System.out.println("Checking left with bounds: (" + left + "," + (pivIndex - 1) + ")");
//            System.out.println();
            return Quick_Select(a, left, pivIndex - 1, k);
        }

        //else {
        else if(pivIndex + 1 < k) {         //Call the function on the right size from pivot to the end
//            System.out.println("Input array to right: " + Arrays.toString(a));
//            //System.out.println("Pivot Index right: " + pivIndex);
//            System.out.println("Checking right with bounds: (" + (pivIndex + 1) + "," + right + ")");
//            System.out.println();
            return Quick_Select(a, pivIndex + 1, right, k);
        }
        System.out.println("Quick Select return error");
        return -1;
    }
}
