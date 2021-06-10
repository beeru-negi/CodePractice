package com.java.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/* Given an array of integers. Perform some number k of operation. Each operation considering removing an elements from
 *  the array dividing it by 2 and inserting the ceiling of that result  back into the array. Minimize the sum of elements in the final array
 * ex- nums= [10,20,7], k=4
 * result sum of final array.
 *  */
public class MinSum {
	
	public static void main( String[] str)
	{
		int[] nums = new int[] {10,20,7};
		int k=4;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(nums.length, (a,b)-> Integer.compare(b, a));
		Arrays.stream(nums).forEach(a-> pq.add(a));
		
		for ( int i =0; i < k ; i++)
		{
			pq.add((int)Math.ceil((double)pq.poll()/2));
			
		}
		
		pq.stream().forEach(x->System.out.println(x));
		
	}

}
