package com.java.array;


import java.util.List;



// A given integer array, print the elements diagonally. 
/*
 *array= {
 *			{ 1, 3, 6, 10 }, 
 *			{ 2, 5, 9, 13 }, 
 *			{ 4, 8, 12, 15 }, 
 *			{ 7, 11, 14, 16 } 
 *};
 *
 *Output- 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16
 */
public class PrintArrayDiagonally {

	public static void main(String[] srg) {
		int arr[][] = new int[][] { { 1, 3, 6, 10 }, { 2, 5, 9, 13 }, { 4, 8, 12, 15 }, { 7, 11, 14, 16 } };
		printDiagonally(arr);
	}

	
	static void printDiagonally(int[][] arr) {

		int n = arr[0].length;
		int i = 0, j = 0;
		int k = 1;
		int m = 0;
		int lim;
		int l;

		while (m < 2 * n - 1) {
			if (m < n) {
				lim = m;
				i = 0;
				j = lim;
				l = 0;
				k = 0;

			} else {
				// k = 1;
				i = k;
				lim = n - 1;
				j = n - 1;
				l = k;

			}

			while (i <= lim && j >= l) {
				System.out.print(" " + arr[j][i] + " ");

				i++;
				j--;
			}

			k++;
			m++;

		}

	}

	static void printDiagonally1(int[][] arr) {

		int n = arr[0].length;
		int i = 0, j = 0;
		int k = 1;
		int m = 0;
		int lim;
		int l;

		while (m < 2 * n - 1) {
			if (m < n) {
				lim = m;
				i = 0;
				j = lim;
				l = 0;
				k = 0;

			} else {
				// k = 1;
				i = k;
				lim = n - 1;
				j = n - 1;
				l = k;

			}

			while (i <= lim && j >= l) {
				System.out.print(" " + arr[i][j] + " ");

				i++;
				j--;
			}

			k++;
			m++;

		}

	}
}
