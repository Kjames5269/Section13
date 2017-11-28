/**
Anon

Assignment 6 – MyQuickSort, CSC 210, Fall 2017

Purpose: This program executes a QuickSort algotrithm by way of the Lomuto-partition scheme. The pivot during each
iteration is the first index, and the singular tracking index is the one immediately to the right of the pivot. The
elements to be sorted are collected from standard input; after completion, the elements are printed one-per-line in
order to standard output.

Inherits From: None

Instance Variables: None

Constructors: None
**/

import java.util.*;
import java.io.*;

public class QuickSort {

     /**
     Method Name: main

     Purpose: The numbers to be sorted are collected one-by-one from System.in; the first integer that is collected
     specifies the capacity of the array the will be used for QuickSort. A check is performed to ensure that this
     capacity is a non-negative integer (n). Next, a check is performed to ensure that the proper number of inputs
     is collected (n) and that they are integers. Finally, if these checks are passed, the numbers are sorted and
     printed in order, one-per-line.

     Parameters: This main method does not collect input from the command line so the String[] args parameter is not
     utilized.

     Calls On: sort

     Returns: None
     **/

     public static void main(String[] args) {

          /* ensure that specified capacity is a non-negative integer */
          Scanner input = new Scanner(System.in); int capacity;
          try { capacity = input.nextInt(); }
          catch (NoSuchElementException error) {
               System.err.println("capacity must be an integer");
               System.exit(1); capacity = 0;
          }
          if (capacity<0) {
               System.err.println("capacity must be non-negative");
               System.exit(1);
          }

          /* place elements into array; check for input mismatches */
          int[] array = new int[capacity];
          for (int i = 0; i < capacity; i++) {
               try { array[i] = input.nextInt(); }
               catch (NoSuchElementException error)
                    { System.err.println("error: input mismatch detected");
                    System.exit(1); }
          }

          /* perform sorting algorithm, and exit normally */
          array = QuickSort.sort(array);
          for (int i = 0; i < capacity; i++) {
               System.out.println(array[i]);
          }
          System.exit(0);

     }

     /**
     Method Name: partition

     Purpose: This method executes the Lomuto-parition scheme.

     Parameters:
          array – an int[] that holds the numbers to be sorted
          start – an int that specifies the index where the parition should begin
          stop – an int that specifies the index where the parition should end

     Returns: int – the index at which the pivot value resides after the partition
     **/
     private static int partition(int[] array, int start, int stop) {

          int pivot = array[start]; int leftIndex = start; int temporary;
          for (int i = leftIndex+1; i < stop; i++) {
               if (array[i] < pivot) {
                    leftIndex++; temporary = array[leftIndex];
                    array[leftIndex] = array[i];
                    array[i] = temporary;
               }
          }
          temporary = array[leftIndex];
          array[leftIndex] = array[start];
          array[start] = temporary;
          return leftIndex;
     }

     /**
     Method Name: sortHelper

     Purpose: This method is applied recursively to an array to parition and sort it. It serves as the helper for the
     sort() method that only takes an int[] array as its parameter.

     Parameters:
          array – an int[] that holds the numbers to be sorted
          start – an int that specifies the index where the parition should begin
          stop – an int that specifies the index where the parition should end

     Calls On: parition, itself

     Returns: int[] – the same array passed to it that is now sorted
     **/
     private static int[] sortHelper(int[] array, int start, int stop) {

          if (start<stop) {
               int pivotIndex = QuickSort.partition(array,start,stop);
               QuickSort.sortHelper(array,pivotIndex+1,stop);
               QuickSort.sortHelper(array,start,pivotIndex);
          }
          return array;

     }

     /**
     Method Name: sort

     Purpose: This method is used in main() to perform the sorting.

     Parameters:
          array – an int[] that holds the numbers to be sorted

     Calls On: sortHelper

     Returns: int[] – the same array passed to it that is now sorted
     **/
     public static int[] sort(int[] array) {
          array = sortHelper(array,0,array.length);
          return array;
     }
}
