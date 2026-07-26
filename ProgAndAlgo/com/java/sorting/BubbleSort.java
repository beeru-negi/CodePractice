package com.java.sorting;

/**
 * Bubble Sort implementation.
 *
 * <p>Repeatedly compares adjacent elements and swaps them if they are in the wrong order.
 * After each full pass the largest unsorted element bubbles to its correct position.
 * An early-exit flag stops the algorithm as soon as no swap occurs in a pass.
 *
 * <p>Time Complexity: O(n²) average/worst, O(n) best (already sorted).
 * Space Complexity: O(1) in-place.
 */
public class BubbleSort {
	 public static int[] bubbleSort(int[] array) {
		    // Write your code here.
				int temp;
				boolean isSwap = true;
				for(int j =0; j < array.length; j++)
				{
					isSwap = false;
						for(int i = 1; i < array.length - j; i++)
						{
							 if(array[i-1] > array[i])
							 {
								 temp = array[i];
								 array[i] = array[i-1];
								 array[i-1] =  temp;					 
								 isSwap = true;
							 }
						}
					
					if(!isSwap)
						break;
				}
		    return array;
		  }
}
