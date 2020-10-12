import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class problem3 {
    public static void main(String[] args) {

        int n = ThreadLocalRandom.current().nextInt(0, 25);
        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = ThreadLocalRandom.current().nextInt(0, n);
        }

//        System.out.println("This is the random array: ");
//        System.out.println(Arrays.toString(a));

        int[] a1 = new int[8];
        a1[0] = 6;
        a1[1] = 0;
        a1[2] = 1;
        a1[3] = 5;
        a1[4] = 1;
        a1[5] = 1;
        a1[6] = 4;
        a1[7] = 5;

        int[] a2 = new int[9];
        a2[0] = 0;
        a2[1] = 2;
        a2[2] = 4;
        a2[3] = 2;
        a2[4] = 2;
        a2[5] = 0;
        a2[6] = 0;
        a2[7] = 5;
        a2[8] = 4;

        int[] a3 = new int[10];
        a3[0] = 0;
        a3[1] = 2;
        a3[2] = 4;
        a3[3] = 2;
        a3[4] = 2;
        a3[5] = 0;
        a3[6] = 0;
        a3[7] = 5;
        a3[8] = 4;
        a3[9] = 4;

        int[] a4 = new int[5];
        a4[0] = 0;
        a4[1] = 1;
        a4[2] = 2;
        a4[3] = 3;
        a4[4] = 4;

        int[] a5 = new int[1];
        a5[0] = 2;

        int[] tarray = a;
        int arraySize = tarray.length;
        int[] repa = new int[n];
        ArrayList<Integer> posMode = new ArrayList<Integer>();

        System.out.println("Test array value: ");
        System.out.println(Arrays.toString(tarray) + "\n");

        /**Count the number of duplicates and increment the approriate index by 1 **/
        for (int i = 0; i < tarray.length; i++) {
            repa[tarray[i]]++;
        }
        System.out.println("This is the repeated array: " + Arrays.toString(repa));

        /**Find the mode of the array **/
        int cmode = 0;              //Take the first value as the mode
        if (repa[cmode] > 1) {      //add the temporary mode to the possible mode only if it is repeated more than once
            posMode.add(cmode);
        }
        for (int j = 1; j < repa.length; j++) {
            //System.out.println("Current mode: " + cmode);
            if((repa[cmode] < repa[j]) && (repa[j] > 1)){       //Add the new element only if it is larger then the
                cmode = j;                                      //current one and the has more than 1 repitition
                posMode.clear();
                posMode.add(j);
            }
            else if( (repa[cmode] == repa[j]) && (repa[j] > 1)){
                posMode.add(j);
            }
            //System.out.println("Mode in for loop: " + posMode);
        }


        System.out.println("Mode Array: " + posMode);

        /**print the mode of array from the Array List **/


        if (posMode.size() == 0) {
            System.out.println("There is no repition is the given array");
        }
        else {
            System.out.print("These are the mode for the array: ");
            for (int i = 0; i < posMode.size(); i++) {
                System.out.print(posMode.get(i));
                System.out.print(" ,");
            }
        }
        System.out.println();

        /**Print repeated elements **/
        for (int i = 0; i < repa.length; i++) {
            if (repa[i] > 1) {
                System.out.println(i + " repeated " + repa[i] + " times");
            }
        }

    }
}
