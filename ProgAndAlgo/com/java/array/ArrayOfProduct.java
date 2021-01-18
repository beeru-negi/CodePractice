package com.java.array;

import java.util.Arrays;

/*
 * Write a function that take a non empty array of integers and returns a array of same length , where each elements in the output array is equal of
 * of the product of every other number in the array.
 * Example : "array": [5, 1, 4, 2]. output - [8, 40, 10, 20].
 */
public class ArrayOfProduct {
	
	  public int[] arrayOfProducts(int[] array) {
		    // Write your code here.
				int [] result = new int[array.length];
				int productFromLeft = 1;
				int productFromRight = 1;
				
				result[0] = 1;
				for(int i=1; i < array.length; i++)
				{
					productFromLeft = productFromLeft * array[i-1];
					result[i] = productFromLeft;
				}
				System.out.println(Arrays.toString(result));
				int j = array.length -1;
				for(int i = result.length -2; i >= 0; i--)
				{
					productFromRight = productFromRight * array[j--];
					result[i] = result[i] * productFromRight;
				}
		    return result;
		  }

}
