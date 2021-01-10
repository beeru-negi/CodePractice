package com.java.array;

import java.util.Arrays;

//given three int array a1, a2, a3, merger all three into sorted array s
public class Merge3SortedArray {

	public static void main(String[] str) {
		int[] a1 = { 2, 8 };
		int[] a2 = { 4, 9, 13, 33 };
		int[] a3 = { 11, 16, 17, 21, 24, 29 };

		int[] s = solution(a1, a2, a3);

		System.out.print(Arrays.toString(s));
	}

	static int[] solution(int[] a1, int[] a2, int[] a3) {
		int size = a1.length + a2.length + a3.length;
		int[] s = new int[size];
		int x1 = 0, x2 = 0, x3 = 0;
		int j = 0, k = 0, l = 0;

		for (int i = 0; i < size; i++) {
			x1 = j < a1.length ? a1[j] : x1;
			x2 = k < a2.length ? a2[k] : x2;
			x3 = l < a3.length ? a3[l] : x3;

			if (x1 <= x2 && x1 <= x3) {
				j++;
				s[i] = x1;
				x1 = 10000;
			} else if (x2 < x1 && x2 <= x3) {
				k++;
				s[i] = x2;
				x2 = 10000;
			} else {
				l++;
				s[i] = x3;
				x3 = 10000;
			}
		}

		return s;

	}

}
