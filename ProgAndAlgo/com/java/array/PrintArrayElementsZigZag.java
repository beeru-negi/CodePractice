package com.java.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2 dimensional integer array is, print array elements in zig-zag
 * fashion. arr[][]= { 1, 3 ,4, 10 2, 5, 9, 11 6, 8, 12,15 7, 13,14,16 }
 * 
 * output should be [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16]
 */
public class PrintArrayElementsZigZag {
	public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
		// Write your code here.
		int m = array.size();
		int n = array.get(0).size();
		List<Integer> result = new ArrayList<Integer>();
		int down = 0;
		int left = 0;
		int dstart = 0;
		int lstart = 0;
		int loop = 1;
		int j = 0;
		int i = 0;
		int isEven;

		while (loop <= m + n - 1) {
			isEven = loop % 2;
			if (isEven == 0) {
				i = lstart;
				j = down;
				while (i <= left && j >= 0) {
					// System.out.print(" "+ array.get(j).get(i)+" ");
					result.add(array.get(j).get(i));
					i++;
					j--;
				}
			} else {
				i = left;
				j = dstart;

				while (i >= 0 && j <= down) {
					// System.out.print(" "+ array.get(j).get(i)+" ");
					result.add(array.get(j).get(i));
					i--;
					j++;
				}
			}
			
			if (left < n - 1) {
				left++;
			} else {
				dstart++;
			}
			if (down < m - 1) {
				down++;
			} else {
				lstart++;
			}
			loop++;
		}
		return result;
	}
}
