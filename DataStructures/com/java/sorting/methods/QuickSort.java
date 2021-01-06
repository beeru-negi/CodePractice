package com.java.sorting.methods;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] str) {
		int arr[] = {100, 10, 80, 30, 90, 40, 50, 70 };
		
		quicksort(arr, 0, arr.length -1);
		System.out.println(Arrays.toString(arr));
	}

public static void quicksort(int [] arr, int first, int last)
{
	if(first < last){
		int pivotIndex = partition(arr, first,last );
		
		quicksort(arr, first, pivotIndex-1);
		quicksort(arr, pivotIndex+1, last);
		
	}
}

	public static int partition(int[] arr, int start, int end) {

		int pivot = arr[end];
		int i = start - 1;

		for (int j = start; j < end; j++) {
			if (arr[j] <= pivot) {
				i++;
				int k = arr[j];
				arr[j] = arr[i];
				arr[i] = k;

			}

		}
		i++;
		arr[end] = arr[i];
		arr[i] = pivot;
		
		return i;

	}
}
