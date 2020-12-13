import java.lang.reflect.Array;
import java.util.Arrays;

public class minHeap {

    public static void main(String[] args) {
        int[] ta1 = new int[8];     //for building and sorting
        ta1[0] = 100;
        ta1[1] = 25;
        ta1[2] = 65;
        ta1[3] = 55;
        ta1[4] = 50;
        ta1[5] = 5;
        ta1[6] = 10;
        ta1[7] = 20;

        int[] inputAr = ta1;
        System.out.println("input array: " + Arrays.toString(inputAr));
        build_MinHeap(inputAr);
        System.out.println("After build min_heap: " + Arrays.toString(inputAr));
    }

    public static void min_heapify(int[] a, int i, int rightBound){
        int min = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        //Check to see if left child exist and compare with max value
        if((left < rightBound) && (a[min] > a[left])){
            min = left;
        }
        if((right < rightBound) && (a[min] > a[right])){
            min = right;
        }
        if(min != i) {
            swap(a, i, min);
            min_heapify(a, min, rightBound);            //Call new heapify on the new position
        }
    }

    public static void build_MinHeap(int[]a){
        int lastInter = (a.length / 2) - 1;
        for(int i = lastInter; i >= 0; i--){
            min_heapify(a, i, a.length);
        }
    }

    public static void swap(int[] a, int e1, int e2) {
        int prevE1 = a[e1];
        a[e1] = a[e2];
        a[e2] = prevE1;
    }
}
