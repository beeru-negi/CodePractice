package com.java.array;

import java.util.Arrays;

/*You are given a not empty array of positive number represents the time taken to execute a specific query. Only 1 query can be executed at a time
 , but can execute in any order.
 A query waiting time is the time query has to wait before execution starts. find total minimum time that total queries take to execute
 EX- q =[3,2,1,2,6]. output minimum time -> 1 + (1+2) + (1+2+2) + (1+2+2+3) = 17 */

public class MinimumWaitingTime {

	public static void main(String[] str) {
		int[] queries = new int[] { 3, 2, 1, 2, 6 };
		int totalTime = minimumWaitingTime(queries);
		System.out.println("Total Minium time -" + totalTime);

	}

	public static int minimumWaitingTime(int[] queries) {
		// Write your code here.
		Arrays.sort(queries);
		System.out.println(Arrays.toString(queries));
		int totalSum = 0;
		int temp = 0;
		for (int i = 1; i < queries.length; i++) {
			temp = temp + queries[i - 1];
			totalSum = totalSum + temp;

		}

		return totalSum;
	}
}
