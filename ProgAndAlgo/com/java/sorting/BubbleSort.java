package com.java.sorting;

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
