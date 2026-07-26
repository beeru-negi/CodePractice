package com.java.sorting;

/**
 * Insertion Sort implementation.
 *
 * <p>Builds the sorted array one element at a time by inserting each new element
 * into its correct position among the already-sorted elements to its left.
 *
 * <p>Time Complexity: O(n²) average/worst, O(n) best (already sorted).
 * Space Complexity: O(1) in-place.
 */
public class InsertionSort {
	public static int[] insertionSort(int[] array) {
	    // Write your code here.
			int temp;
			for(int i = 1 ; i < array.length; i++)
			{
				 for( int j = 0; j < i; j++)
				 {
					  if(array[j] > array[i])
						{
							temp = array[i];
							array[i] = array[j];
							array[j] = temp;
						}
				 }
			}
	    return array;
	  }
}
