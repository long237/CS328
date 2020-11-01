import java.util.Arrays;

public class lab5src {
    public static void main(String[] args) {

        int[] ta1 = new int[9];     //for building
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

        int[] ta4 = new int[10];
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

        int[] ta5 = new int[10];
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
        int[] inputAr = ta5;
//        System.out.println("Before max_heapify: " + Arrays.toString(inputAr));
//        swap(inputAr, 0, inputAr.length - 1);
//        max_heapify(inputAr, 0);
//        System.out.println("After max_heapify: " + Arrays.toString(inputAr));

        //System.out.println("");
        System.out.println("Before build: " + Arrays.toString(inputAr));
        build_MaxHeap(inputAr);
        System.out.println("After build: " + Arrays.toString(inputAr));

//        System.out.println("Before swap: " + Arrays.toString(ta2));
//        swap(ta2, 1, 3);
//        System.out.println("After swap: " + Arrays.toString(ta2));

    }

    public static void max_heapify(int[] a, int i){
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        System.out.println("Max: " + max);
        System.out.println("left: " + left);
        System.out.println("right: " + right);
        //Check to see if left child exist and compare with max value
        if((left < a.length) && (a[max] < a[left])){
            max = left;
        }
        if((right < a.length) && (a[max] < a[right])){
            max = right;
        }
        if(max != i) {
            swap(a, i, max);
            max_heapify(a, max);            //Call new heapify on the new position
        }
    }

    public static void build_MaxHeap(int[]a){
        int lastInter = (a.length / 2) - 1;
        for(int i = lastInter; i >= 0; i--){
            max_heapify(a, i);
        }
    }

    public static void swap(int[] a, int e1, int e2) {
        int prevE1 = a[e1];
        a[e1] = a[e2];
        a[e2] = prevE1;
    }
}
