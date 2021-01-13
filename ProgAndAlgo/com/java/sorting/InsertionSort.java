package com.java.sorting;

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
