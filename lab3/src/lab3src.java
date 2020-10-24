import java.lang.reflect.Array;
import java.util.Arrays;

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

        int[] inArray = ta2;
        System.out.println("Input Array: " + Arrays.toString(inArray));
        int piv_idx = partition(inArray);
        System.out.println();
        System.out.println("Array after partition: " + Arrays.toString(inArray));
        System.out.println();
        System.out.println("Pivot Index: " + piv_idx);
    }

    public static void test(int[] a) {
        a[2] = -5;
    }

    public static int partition(int[] a) {
        int pivot = a[0];           //
        int left = 0;
        int right = a.length -1;
        System.out.println("Pivot: " + pivot);

        //Swapping pivot with last element

        while (left < right) {
            if (a[left] <= pivot) {
                left++;
            }
            else if(a[right] > pivot) {
                right--;
            }
            else{           //swap if can't move
                int prevLeft = a[left];
                a[left] = a[right];
                a[right] = prevLeft;
            }
            System.out.println("left bound: " + left);
            System.out.println("right bound: " +right);
        }
        if (a.length == 1) {
            System.out.println("Array of size 1: ");
            return 0;
        }
        else if (a.length > 1) {
            a[0] = a[left -1];
            a[left -1] = pivot;
            return (left -1);
        }
        System.out.println("Encounter error");
        return -1;
    }

    public static int Quick_Select(int[] a, int left, int right, int k) {
        int pivIndex = partition(a);

        if(pivIndex + 1 == k) {     //if the the size of the left array + 1 is the same as k stop running
            return a[pivIndex];
        }

        else if(pivIndex + 1 > k) {         //Call the function on the left size from beginning to pivot
            return Quick_Select(a, left, pivIndex, k);
        }

        //else {
        else if(pivIndex + 1 < k) {         //Call the function on the right size from pivot to the end
            return Quick_Select(a, pivIndex + 1, right, k - pivIndex - 1);
        }
        System.out.println("Quick Select return error");
        return -1;
    }
}
