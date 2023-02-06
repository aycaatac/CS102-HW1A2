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
    private int[] integers;
    private int evenIndexSum;
    private int oddIndexSum;
    private double arrayAverage;
    private boolean running = true;

    public HW1A2() {
        //Initialize variables
        random = new Random();
        consoleIn = new Scanner(System.in);
    }

    private void initArray(int size) {
        integers = new int[size];

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
        int choice = -1;
        System.out.println("Please enter the array size: ");
        int arraySize = consoleIn.nextInt();
        initArray(arraySize);
        System.out.println(Arrays.toString(integers));
        while(running) {
            printActions();
            if(consoleIn.hasNextInt())
            {
                choice = consoleIn.nextInt();
                consoleIn.nextLine();
                switch(choice)
                {
                    case 0:
                        System.out.println("Exiting the program...");
                        running = false;
                        break;
                    case 1:
                        System.out.println("Minimum of the array: " + min());
                        break;
                    case 2:
                        System.out.println("Maximum of the array: " + max());
                        break;
                    case 3:
                        System.out.println("\nDifferences: " + Arrays.toString(averageArray()) +" Average of the array: " + arrayAverage); 
                        break;
                    case 4:
                        System.out.println("Sum of odd elements: " + oddIndexSum + "\nSum of even elements: " + evenIndexSum);
                        break;
                    default:
                        running = false;
                        break;
                }
            }
            else 
            {
                running = false;
            }
           System.out.println("-----------------------------"); 
        }
    }
    
    public void printActions() {
        String textBlock = """
                Available actions:
                                
                0 - to exit the program
      
                1 - to find the minimum of the array

                2 - to find the maximum of the array

                3 - to display the average of the array and how each element differs from it

                4 - to find the sum of odd and even elements
                                
                Enter a number for which action you want to do:""";
        System.out.print(textBlock + " ");
    }

    private double[] averageArray() {
        double[] result = new double[integers.length];

        double sum = evenIndexSum + oddIndexSum;

        //find the average of array elements
        arrayAverage = sum / integers.length;

        //fill the result array with differences between array elements and average
        for (int i = 0; i < integers.length; i++) {
            result[i] = integers[i] - arrayAverage;
        }

        //return the array
        return result;
    }

    private int min() {
        int min = Integer.MAX_VALUE;

        //find the minimum of the array elements
        for(int i = 0; i < integers.length; i++){
            if(integers[i] < min){
                min = integers[i];
            }
        }

        //return the minimum element
        return min;
    }
    private int max() {
        int max = Integer.MIN_VALUE;

        //find the maximum of the array elements
        for(int i = 0; i < integers.length; i++){
            if(integers[i] > max){
                max = integers[i];
            }
        }

        //return the maximum element
        return max;
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
