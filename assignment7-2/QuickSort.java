/*
* Anon
*
* Assignment #7 - QuickSort, CSc 210, Spring 2017
* This class sorts a given integer array in place from least to greatest value.
* The array is received as input from the user over stdin.
*/
import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        if (!input.hasNext()) {
            // print an error and exit if no size is given
            System.err.println("Invalid input.");
            System.exit(1);
        }
        int size = 0;
        try {
            size = input.nextInt();
        } catch (InputMismatchException exception) {
            // print an error and exit if the size entered is not an integer
            System.err.println("Invalid input.");
            System.exit(1);
        }
        if (size < 0) {
            // print an error and exit if the size entered is negative
            System.err.println("Invalid input.");
            System.exit(1);
        }
        int[] array = new int[size];
        int data = 0;
        for (int i = 0; i < size; i++) {
            if (!input.hasNext()) {
                // print an error and exit if there are too few integers
                // provided
                System.err.println("Invalid input.");
                System.exit(1);
            }
            try {
                data = input.nextInt();
            } catch (InputMismatchException exception) {
                // print an error and exit if the data entered is not an integer
                System.err.println("Invalid input.");
                System.exit(1);
            }
            array[i] = data;
        }
        array = sort(array);
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
        System.exit(0);
    }

    /*
    * sort
    * Sorts the given integer array in place from least to greatest value.
    *
    * Arguments:
    * int[] toSort - the array to be sorted
    *
    * Return Value - returns the sorted array
    */
    public static int[] sort(int[] toSort) {
        sortHelper(toSort, 0, toSort.length - 1);
        return toSort;
    }

    /*
    * sortHelper
    * Helper method for the sort method.
    *
    * Arguments:
    * int[] toSort - the array to be sorted
    * int start - the starting index of the array
    * int end - the ending index of the array
    *
    * Return Value - does not return a value
    */
    private static void sortHelper(int[] toSort, int start, int end) {
        // keep recursing until the start and the end cross/meet
        if (start < end) {
            int part = partition(toSort, start, end);
            // recurse on the left partition
            sortHelper(toSort, start, part - 1);
            // recurse on the right partition
            sortHelper(toSort, part + 1, end);
        }
    }

    /*
    * partition
    * Helper method for the sortHelper method.
    *
    * Arguments:
    * int[] toSort - the array to be sorted
    * int start - the starting index of the array
    * int end - the ending index of the array
    *
    * Return Value - returns the index of where to partition the array
    */
    private static int partition(int[] toSort, int start, int end) {
        // start the pivot at the end of the array
        int pivot = toSort[end];
        int j = start - 1; // all values before j are guaranteed to be less than
        int temp = 0;      // the current pivot
        for (int i = start; i < end; i++) {
            // if the value at the given index is less than the pivot then
            // it will get swapped with the larger value at j and j will get
            // moved up
            if (toSort[i] < pivot) {
                j++;
                temp = toSort[j];
                toSort[j] = toSort[i];
                toSort[i] = temp;
            }
        }
        // if the value of the end of the array (the pivot) is smaller than the
        // value directly after j then the two should get swapped
        if (toSort[end] < toSort[j + 1]) {
            temp = toSort[j + 1];
            toSort[j + 1] = toSort[end];
            toSort[end] = temp;
        }
        // return the index the array should partition at (one after j)
        return j + 1;
    }
}
