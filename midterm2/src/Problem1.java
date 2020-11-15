import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

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

        int[] ta5 = new int[9];
        ta5[0] = 60;
        ta5[1] = 50;
        ta5[2] = 55;
        ta5[3] = 45;
        ta5[4] = 20;
        ta5[5] = 10;
        ta5[6] = 2;
        ta5[7] = 5;
        ta5[8] = 36;

        int ranSize = ThreadLocalRandom.current().nextInt(1,20);
        int[] ranAr = new int[ranSize];
        for (int i = 0; i < ranAr.length; i++){
            ranAr[i] =ThreadLocalRandom.current().nextInt(-100, 101);
        }
        System.out.println("Random array: " + Arrays.toString(ranAr));
        System.out.println("");

        int[] inputar = ranAr;
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
            if (!result){
                return false;
            }
        }
        return true;
    }
}
