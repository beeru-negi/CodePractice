package com.java.sorting;

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
