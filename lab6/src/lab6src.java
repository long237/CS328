import java.util.Arrays;

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

        double[] inputar = ta4;

        System.out.println("Input array: " + Arrays.toString(inputar));
        //selection_Sort(inputar, 0);
        //System.out.println("Array after sort: " + Arrays.toString(inputar));
        //selection_Sort(inputar, 1);
        //System.out.println("Descending: " + Arrays.toString(inputar));

        int start = 0;
        int end = inputar.length - 1;
        int mid = (start + end) / 2;

        double[] Sleft = new double[mid - start + 1];
        double[] Sright = new double[end - (mid + 1) + 1];

        double temp = 0;
        for (int i = mid; i >= 0; i--) {
            temp += inputar[i];
            Sleft[i] = temp;
        }
        selection_Sort(Sleft, 0);
        System.out.println("Sleft array: " + Arrays.toString(Sleft));

        temp = 0;
        int r_index = 0;
        for (int i = mid + 1; i < inputar.length; i++) {
            temp += inputar[i];
            Sright[r_index] = temp;
            r_index++;
        }
        selection_Sort(Sright, 1);
        System.out.println("Sright array: " + Arrays.toString(Sright));
    }

    public static double MPSS (double[] a, int start, int end) {
        if (a.length > 1){
            int mid = (start + end) / 2;
            double MPSS_L = MPSS(a, start, mid);
            double MPSS_R = MPSS(a, mid + 1, end);

        }
        return -1;
    }

    public static double MPSS_mid(double[] a, int start, int end) {
        int mid = (start + end) / 2;

        double[] Sleft = new double[mid - start + 1];
        double[] Sright = new double[end - (mid + 1) + 1];

        double temp = 0;
        for (int i = mid; i >= 0; i--) {
            temp += a[i];
            Sleft[i] = temp;
        }
        System.out.println("Sleft array: " + Arrays.toString(Sleft));

        temp = 0;
        int r_index = 0;
        for (int i = mid + 1; i < a.length; i++) {
            temp += a[i];
            Sright[r_index] = temp;
            r_index++;
        }
        System.out.println("Sright array: " + Arrays.toString(Sright));


        //Sort ascending order
        selection_Sort(Sleft, 0);
        //Sort descending order
        selection_Sort(Sright, 1);

        int i = 0;      //Sleft
        int j = 0;      //Sright
        double Smin = Double.POSITIVE_INFINITY;

        while (i < Sleft.length && j < Sright.length) {
            double s = Sleft[i] + Sright[j];
            if (s <= 0) {
                i++;
            } else if (s < Smin) {
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
