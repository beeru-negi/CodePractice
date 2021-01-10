package com.java.array;
/** for a given target find 2 elements in given array who's sum is equal to target **/
public class FindTargetSumFor2Element {
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

}
