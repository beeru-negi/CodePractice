package com.java.sorting;

/**
 * Selection Sort implementation.
 *
 * <p>Divides the array into a sorted and an unsorted region. On each iteration it
 * selects the minimum element from the unsorted region and swaps it with the
 * first element of that region, growing the sorted portion by one.
 * An already-sorted flag skips the swap when no smaller element was found.
 *
 * <p>Time Complexity: O(n²) in all cases.
 * Space Complexity: O(1) in-place.
 */
public class SelectionSort {
	  public static int[] selectionSort(int[] array) {
		    // Write your code here.
				int min = array[0];
				int minIndex =0;
				boolean isAlreadySort = true;
				
				for(int i =0 ; i < array.length; i++)
				{
					min = array[i];
					isAlreadySort = true;
					 for(int j = i; j < array.length; j++)
					 {
						   if( array[j] < min)
							 {
								  min = array[j];
								 minIndex = j;
								 isAlreadySort = false;
							 }
					 }
					if( !isAlreadySort)
					{
						array[minIndex] = array[i];
						array[i] = min;
					}
				}
		    return array;
		  }
}
