package com.java.array;

/* Given a integer array. Need to find first duplicate value starting from start of and array. Return -1 if not duplicate found
 Example- array[2,1,5,3,3,2,4]. Output is- 3
 Example- array[2,1,5,2,3,3,4]. Output is- 2
 */
public class FirstDuplicateValue {

	public static void main(String[] str) {
		int[] array = new int[] { 2, 1, 5, 2, 3, 3, 4 };
		System.out.print("Output-" + firstDuplicateValue(array));
	}

	public static int firstDuplicateValue(int[] array) {
		// Write your code here.
		int[] temp = new int[array.length];
		int i = 0;
		while (i < array.length) {
			if (temp[array[i] - 1] == array[i]) {
				return array[i];
			} else {
				temp[array[i] - 1] = array[i];
			}
			i++;
		}
		return -1;
	}
}
