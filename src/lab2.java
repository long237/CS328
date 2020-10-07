import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class lab2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number: ");

        int n = scanner.nextInt();
        int result = squareRoot2(n);
        System.out.println("This is the square root: " + result);

        /**The start of part 2 **/

//        int arraySize = 10;
//        int m = 15;
        System.out.println("Enter an m to generate array: ");
        int m = scanner.nextInt();              // m = 15
        int arraySize = ThreadLocalRandom.current().nextInt(0, m);
        int[] array = new int[arraySize];



        Set<Integer> set = new LinkedHashSet<Integer>();
        while (set.size() < arraySize) {
            set.add(ThreadLocalRandom.current().nextInt(0,m));
        }
        System.out.println(set);

        Iterator value = set.iterator();
        for (int i = 0; i < arraySize; i++) {
            array[i] = (int)(value.next());
        }
        //Sort the array
        Arrays.sort(array);
        System.out.println("this is the sorted array: " + Arrays.toString(array));

        /** Test arrays **/
        int[] ta1 = new int[10];
        ta1[0] = 0;
        ta1[1] = 1;
        ta1[2] = 2;
        ta1[3] = 4;
        ta1[4] = 6;
        ta1[5] = 8;
        ta1[6] = 10;
        ta1[7] = 11;
        ta1[8] = 12;
        ta1[9] = 14;

        int[] ta2 = new int[6];
        ta2[0] = 0;
        ta2[1] = 1;
        ta2[2] = 3;
        ta2[3] = 6;
        ta2[4] = 8;
        ta2[5] = 9;

        int[] ta3 = new int[4];
        ta3[0] = 2;
        ta3[1] = 5;
        ta3[2] = 7;
        ta3[3] = 11;

        int[] ta4 = new int[5];
        ta4[0] = 0;
        ta4[1] = 1;
        ta4[2] = 2;
        ta4[3] = 3;
        ta4[4] = 4;

        int[] ta5 = new int[1];
        ta5[0] = 12;

        /**Being testing of finding smallest missing number **/
        System.out.println("");
        System.out.println("Input array: " + Arrays.toString(array));
        int missingNumber = findMissing(array);
        System.out.println("This is the missing number: " + missingNumber);
    }

    public static int squareRoot(int number){
        int guessNum = number / 2;
        int rightBound = number;
        int leftBound = 0;

        if (number == 0){
            return 0;
        }
        for (int i = 0; i < number; i++) {
            int largerNum = guessNum + 1;
            int smallerNum = guessNum - 1;
            if ((guessNum * guessNum) >= number){
                //if guessNum square is > n then generate a random num leftBound to current guess
                //Move to the left
                if((smallerNum * smallerNum) < number) {
                    return guessNum;            //return if n is sandwich in between the two numbers
                }
                rightBound = guessNum;
                guessNum = ThreadLocalRandom.current().nextInt(leftBound, rightBound);
            }

            else if (((guessNum * guessNum) < number)) {
                //if guessNum square is < n generate a random value from current guess to rightBound
                //Move to the right but not pass the previous wrong guess
                if ((largerNum * largerNum) >= number) {
                    return  largerNum;          //return if n is sandwich in between the two numbers
                }
                leftBound = guessNum;
                guessNum = ThreadLocalRandom.current().nextInt(leftBound, rightBound);
            }
        }
        return -1;      //return -1 if error
    }

    public static int squareRoot2(int number) {
        int guessNum = number / 2;
        int rightBound = number;
        int leftBound = 0;
        //int guessNum = 0;
        int guessSq;

        while (leftBound < rightBound) {
            guessSq = guessNum * guessNum;
            if (guessSq > number) {             //update right bound if guess ^ 2 > number
                rightBound = guessNum - 1;
            }
            else if (guessSq < number) {        //Update left bound if guess ^ 2 < number
                leftBound = guessNum + 1;
            }
            else {
                return guessNum;                //Exact value of square root
            }
            guessNum = ((rightBound - leftBound) / 2) + leftBound;      //Find the middle value in the range
        }

        guessSq = guessNum * guessNum;          //Calculate the square of the very last value in  the range
        if (guessSq >= number) {
            System.out.println("Larger number statement execute");
            return  guessNum;
        }
        else if (guessSq < number){
            System.out.println("Smaller number statement execute");
            return guessNum + 1;
        }
        //return -1 if run into an error
        return -1;
    }

    public static int findMissing(int[] sortedArray) {
        int leftBound = 0;
        int rightBound = sortedArray.length - 1;        // array of size n has n - 1 indexes
        int mid = rightBound / 2;           //mid represent the index of the middle number

        while (leftBound < rightBound) {
            if ( sortedArray[mid] > mid) {
                rightBound = mid - 1;
            }
            else if (sortedArray[mid] == mid) {
                leftBound = mid + 1;
            }

            mid = ((rightBound - leftBound) / 2) + leftBound;
        }

        if (sortedArray[mid] == mid) {      //If missing number is in mid or at the end
            System.out.println("same line execute");
            return mid + 1;
        }
        else if (leftBound == 0) {          //if missing number is at the begining
            System.out.println("Zero line execute");
            return 0;
        }
        else if (sortedArray[mid] != mid) {
            System.out.println("different line execute");
            return mid;
        }

        System.out.println("Error line execute");
        return -1;                          //return -1 for error
    }

}
