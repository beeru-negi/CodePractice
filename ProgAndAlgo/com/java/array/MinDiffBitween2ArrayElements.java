package com.java.array;

import java.util.Arrays;

/* Write a function that takes in 2 non empty integer arrays,  find the pair if numbers( one from each array) whose absolute difference 
 * is closest to zero and return an array containing those 2 elements
 * EX- {"arrayOne": [-1, 5, 10, 20, 28, 3], "arrayTwo": [26, 134, 135, 15, 17]}
 * output- [28,26]
 *  **/

public class MinDiffBitween2ArrayElements {

	// Efficient solution
	public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
		// Write your code here.
		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		int min = Integer.MAX_VALUE;
		int ind1 = 0;
		int ind2 = 0;
		int i = 0, j = 0;
		while (i < arrayOne.length && j < arrayTwo.length) {
			if (Math.abs(arrayOne[i] - arrayTwo[j]) < min) {
				min = Math.abs(arrayOne[i] - arrayTwo[j]);
				ind1 = arrayOne[i];
				ind2 = arrayTwo[j];
			}

			if (arrayOne[i] > arrayTwo[j]) {
				j++;
			} else {
				i++;
			}
			// }
		}

		return new int[] { ind1, ind2 };
	}

	public static int[] smallestDifference1(int[] arrayOne, int[] arrayTwo) {
		// Write your code here.
		int min = Integer.MAX_VALUE;
		int ind1 = 0;
		int ind2 = 0;
		for (int i = 0; i < arrayOne.length; i++) {
			for (int j = 0; j < arrayTwo.length; j++) {
				if (Math.abs(arrayOne[i] - arrayTwo[j]) < min) {
					ind1 = arrayOne[i];
					ind2 = arrayTwo[j];
					min = Math.abs(arrayOne[i] - arrayTwo[j]);
				}
			}
		}

		return new int[] { ind1, ind2 };
	}
}
