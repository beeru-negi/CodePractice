package com.java.string.problems;

import java.util.Arrays;

/**
 * Maximum Subarray Sum (Kadane's Algorithm).
 *
 * <p>Finds the contiguous subarray with the largest sum within a given integer
 * array. Negative running sums are reset to zero so only positive-contributing
 * prefixes are carried forward.
 *
 * <p>Example: {@code [2, -8, 3, -2, 4, -10]} → max sum {@code 5} (subarray {@code [3,-2,4]}).
 *
 * <p>Time Complexity: O(n). Space Complexity: O(n) for the index-tracking array.
 */
public class MaxSumInArray {
	public static void main(String[] str)
	{
		int [] a = {2, -8, 3, -2, 4, -10};
		int[] seq = new int[a.length];
		int sum=0, maxSum=0;
		int j=0;
		for(int i=0; i <a.length; i++)
		{
			sum=sum+a[i];
			if(maxSum < sum)
			{
				maxSum=sum;
				seq[j++]=i;
			} else if (sum < 0)
			{
				sum=0;
				//seq = new int[a.length];
				//j=0;
			} else {
				seq[j++]=i;
			}
		}
		
		System.out.println("Sum and seq=" + maxSum +" "+Arrays.toString(seq));
		
	}
	
}
