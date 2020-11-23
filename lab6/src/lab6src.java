import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class lab6src {
    public static void main(String[] args) {
        double[] ta4 = new double[10];        //for building sorting
        ta4[0] = 2;
        ta4[1] = -3;
        ta4[2] = 1;
        ta4[3] = 4;
        ta4[4] = -6;
        ta4[5] = 10;
        ta4[6] = -12;
        ta4[7] = 5.2;
        ta4[8] = 3.6;
        ta4[9] = -8;

        double[] ta1 = new double[8];        //for building sorting
        ta1[0] = -34;
        ta1[1] = 49;
        ta1[2] = -58;
        ta1[3] = 76;
        ta1[4] = 29;
        ta1[5] = -71;
        ta1[6] = -54;
        ta1[7] = 63;

        double[] ta2 = new double[4];        //for building sorting
        ta2[0] = 1.2;
        ta2[1] = -2;
        ta2[2] = 2.5;
        ta2[3] = 1;

        double[] ta3 = new double[2];
        ta3[0] = 2.5;
        ta3[1] = 1.0;

        double[] ta5 = new double[1];
        ta5[0] = 1;


        Scanner scanner = new Scanner(System.in);
        System.out.println("Input an array size: ");
        int user_size = scanner.nextInt();
        double[] user_ar = new double[user_size];

        for (int i = 0; i < user_ar.length; i++) {
            user_ar[i] = ThreadLocalRandom.current().nextDouble(-20, 20);
        }


        double[] inputar = user_ar;
        System.out.println("Input array: " + Arrays.toString(inputar));
        double MPSSvalue = MPSS(inputar, 0, inputar.length - 1);
        System.out.printf("MPSS value: %.2f", MPSSvalue);
    }

    public static double MPSS (double[] a, int start, int end) {
        if (start != end){
            int mid = (start + end) / 2;
            double MPSS_L = MPSS(a, start, mid);
            double MPSS_R = MPSS(a, mid + 1, end);
            double MPSS_mid = MPSS_mid(a, start, end);
            return Math.min(MPSS_mid, Math.min(MPSS_L, MPSS_R));
        }
        else if (start == end) {
            return a[0];
        }
        else {
            return -222;
        }
    }

    public static double MPSS_mid(double[] a, int start, int end) {
        int mid = (start + end) / 2;

        double[] Sleft = new double[mid - start + 1];
        double[] Sright = new double[end - (mid + 1) + 1];

        double temp = 0;
        int l_index = 0;
        for (int i = mid ; i >= start; i--) {
            temp += a[i];
            Sleft[l_index] = temp;
            l_index++;
        }

        temp = 0;
        int r_index = 0;
        for (int i = mid + 1; i <= end; i++) {
            temp += a[i];
            Sright[r_index] = temp;
            r_index++;
        }

        //Sort ascending order
        selection_Sort(Sleft, 0);
        //System.out.println("Sleft array: " + Arrays.toString(Sleft));
        //Sort descending order
        selection_Sort(Sright, 1);
        //System.out.println("Sright array: " + Arrays.toString(Sright));

        int i = 0;      //Sleft
        int j = 0;      //Sright
        double Smin = Double.POSITIVE_INFINITY;

        while (i < Sleft.length && j < Sright.length) {
            double s = Sleft[i] + Sright[j];
            if (s <= 0) {
                i++;
            }
            else if (s < Smin) {
                Smin = s;
                j++;
            }
            else if (s > Smin) {
                j++;
            }
        }

        return Smin;
    }

    public static void selection_Sort(double[] a, int order) {
        //Ascending order
        if (order == 0) {
            for (int i = 0; i < a.length; i++) {
                int min = i;                            //The index of the smallest number
                for (int j = i; j < a.length; j++) {
                    if (a[j] <= a[min]) {
                        min = j;
                    }
                }
                swap(a, i, min);
            }
        }
        //Descending order
        else if (order == 1) {
            for (int i = 0; i < a.length; i++) {
                int max = i;                            //The index of the smallest number
                for (int j = i; j < a.length; j++) {
                    if (a[j] >= a[max]) {
                        max = j;
                    }
                }
                swap(a, i, max);
            }
        }
    }

    public static void swap(double[] a, int e1, int e2) {
        double prevE1 = a[e1];
        a[e1] = a[e2];
        a[e2] = prevE1;
    }
}
