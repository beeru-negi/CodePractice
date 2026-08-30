package com.java.array;

import java.util.Arrays;
import java.util.HashMap;

/** for a given target find 2 elements in given array who's sum is equal to target **/
public class FindTargetSumFor2Element {
	public static void main( String [] str) {
		int[] numbers = {2, 5, 6, 10, 14, 6};
		System.out.println("Index are -" + Arrays.toString(twoNumberSum1(numbers, 19)));
	}
	 public static int[] twoNumberSum(int[] array, int targetSum) {
		    // Write your code here.
				int [] ansPair = new int[0];
				int next;
				for(int i=0; i < array.length; i++)
				{
					next = targetSum - array[i];
					for(int j = i+1; j < array.length; j++)
					{
						if(array[j] == next)
						{
							ansPair = new int[2];
							ansPair[0] = array[i];
							ansPair[1] = next;
							break;
						}
					}
					
				}
		    return ansPair;
	}

	public static int[] twoNumberSum1(int[] numbers, int targetSum) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[0];
		for (int i = 0; i < numbers.length; i++) {
			int diff = targetSum - numbers[i];
			if (map.containsKey(diff)) {
				result = new int[]{map.get(diff), i};
				break;
			}
			map.put(numbers[i], i);

		}
		return result;
	}

}
