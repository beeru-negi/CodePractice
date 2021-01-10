package com.java.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Validate Sequence.Write code to find that if second array is the sub-sequence if first array
 * Ex- [1,3,4] is subsequence of [1,2,3,4]. [3] is also sub sequence of it.
 */
public class ValidateSequence {

	public static void main(String[] str) {
		// List array = Arrays.asList(new int[] { 5, 1, 22, 25, 6, -1, 8, 10 });
		List<Integer> array = new ArrayList<>(Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10));
		List<Integer> sequence = new ArrayList<>(Arrays.asList(1, 6, -1, 10));

		if (isValidSubsequence(array, sequence)) {
			System.out.println("Second array is in sequence with first array");
		} else {
			System.out.println("Second array is <b> NOT</b> in sequence with first array");
		}
	}

	public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
		// Write your code here.
		int left1 = 0, right1 = array.size() - 1;
		int left2 = 0, right2 = sequence.size() - 1;
		if (right1 < right2) {
			return false;
		}
		while (left1 <= right1) {
			if (array.get(left1) == sequence.get(left2)) {
				left1++;
				left2++;
			} else {
				left1++;
			}
			if (left2 > right2) {
				break;
			}
		}

		if (left2 > right2) {
			return true;
		}
		return false;
	}

}
