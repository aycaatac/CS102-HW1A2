import java.util.Random;
import java.util.Scanner;

/**
 * This is a class designed to operate as specified in the
 * Github Assignment 2 section of <a href="https://docs.google.com/document/d/13vvs3OA0rPBhGPJAFB2V8SVXIBuswMsqTi13ueEshJo">this</a>
 * document
 */

public class HW1A2 {

    //Constants
    private static final int RANGE_MIN = 0; //Inclusive
    private static final int RANGE_MAX = 100; //Inclusive

    //Variables
    private final Random random;
    private final Scanner consoleIn;
    private final int[] integers;
    private int evenIndexSum;
    private int oddIndexSum;
    private boolean running = true;

    public HW1A2() {
        //region Initialize variables
        random = new Random();
        consoleIn = new Scanner(System.in);

        int size = RANGE_MAX - RANGE_MIN + 1;
        integers = new int[size];
        //endregion

        //region Fill the integers array
        //Fill even indexes and add the numbers
        for(int i = 0; i < size; i+= 2) {
            int number = random.nextInt(RANGE_MIN, RANGE_MAX + 1);
            evenIndexSum += number;
            integers[i] = number;
        }
        //Fill odd indexes and add the numbers
        for(int i = 1; i < size; i+= 2) {
            int number = random.nextInt(RANGE_MIN, RANGE_MAX + 1);
            oddIndexSum += number;
            integers[i] = number;
        }
        //endregion
    }

    public void start() {
        while(running) {
            //TODO: Implement the menu
            System.out.println("Not implemented yet.");
            running = false;
        }
    }
    
    public static void averageArray(int[] values) {
        double sum = 0;
        double[] result = new double[values.length];

        //find the sum of array elements
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }

        //find the average of array elements
        double arrayAverage = sum / values.length;

        //fill the result array with differences between array elements and average
        for (int k = 0; k < values.length; k++) {
            result[k] = values[k] - arrayAverage;
        }

        //display the result array
        System.out.println(Arrays.toString(result));
    }

    public static void min(int[] inputArray) {
        int min = Integer.MAX_VALUE;

        //find the minimum of the array elements
        for(int i = 0; i< inputArray.length; i++){
            if(inputArray[i]<min){
                min = inputArray[i];
            }
        }

        //display the minimum element
        System.out.println("The element with the minimum value is: " + min);            
    }
    public static void max(int[] inputArray) {
        int max = Integer.MIN_VALUE;

        //find the maximum of the array elements
        for(int i = 0; i< inputArray.length; i++){
            if(inputArray[i]>max){
                max = inputArray[i];
            }
        }
         
        //display the maximum element
        System.out.println("The element with the maximum value is: " + max);            
    }

    private int nextValidInteger() {
        int ret = Integer.MIN_VALUE;
        boolean found = false;

        //region Loop until a valid integer is entered
        while(!found) {
            //
            if(consoleIn.hasNextInt()) {
                found = true;
                ret = consoleIn.nextInt();
                consoleIn.nextLine();
            }
            else {
                System.out.println("Please enter a valid integer.");
                consoleIn.nextLine();
            }
        }
        //endregion
        return ret;
    }

}
