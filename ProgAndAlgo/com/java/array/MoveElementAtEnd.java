package com.java.array;

import java.util.List;

/*
 * Move a given element in an integer array at the end of the array.
 * Example - "array": [2, 1, 2, 2, 2, 3, 4, 2], "toMove": 2
 * Output- [4, 1, 3, 2, 2, 2, 2, 2]
 */
public class MoveElementAtEnd {

	public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
		// Write your code here.
		int temp;
		int i = 0;
		int j = array.size() - 1;
		while (i < j) {
			if (array.get(i) == toMove && array.get(j) != toMove) {
				temp = array.get(j);
				array.set(j, array.get(i));
				array.set(i, temp);
				j--;
				i++;
			} else if (array.get(i) == toMove && array.get(j) == toMove) {
				j--;
			} else if (array.get(i) != toMove && array.get(j) != toMove) {
				i++;
			} else {
				j--;
				i++;
			}
		}
		return array;
	}
}
