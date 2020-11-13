import java.util.Arrays;

public class Problem1 {

    public static void main(String[] args) {
        int[] ta1 = new int[7];
        ta1[0] = 6;
        ta1[1] = 0;
        ta1[2] = 2;
        ta1[3] = 4;
        ta1[4] = 6;
        ta1[5] = 1;
        ta1[6] = 0;

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

        int[] ta3 = new int[6];
        ta3[0] = 10;
        ta3[1] = 8;
        ta3[2] = 7;
        ta3[3] = 5;
        ta3[4] = 2;
        ta3[5] = 1;

        int[] inputar = ta2;
        System.out.println("Input arrays: " + Arrays.toString(inputar));
        System.out.println("Compare " + inputar[1]);
        boolean result = parent_comp(inputar, 1);
        System.out.println("Result: " + result);
        boolean check = Is_MaxHeap(inputar);
        System.out.println("Max heap check result: " + check);

    }

    public static boolean parent_comp(int[] a, int i){
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        System.out.println("Left ele: " + left);
        System.out.println("Right ele: " + right);
        if ((left < a.length) && (a[max] < a[left])){
            return false;
        }

        if((right < a.length) && (a[max] < a[right])){
            return false;
        }
        return true;
    }

    public static boolean Is_MaxHeap(int[] a){
        int last_Intern = (a.length) / 2 - 1;
        for (int i = last_Intern; i >= 0; i--) {
            boolean result = parent_comp(a, i);
            if (result == false){
                return false;
            }
        }
        return true;
    }
}
