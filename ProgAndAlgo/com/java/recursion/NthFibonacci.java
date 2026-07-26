package com.java.recursion;

/**
 * Nth Fibonacci Number (recursive).
 *
 * <p>Returns the N-th number in the Fibonacci sequence using pure recursion.
 * The sequence is 0-indexed: F(0)=0, F(1)=0, F(2)=1, F(3)=1, F(4)=2, …
 *
 * <p>Note: this naïve implementation has exponential time complexity.
 * Time Complexity: O(2^n). Space Complexity: O(n) call stack.
 */
public class NthFibonacci {

	public static int getNthFib(int n) {
		// Write your code here.
		if (n == 1 || n == 0) {
			return 0;
		}
		if (n == 2) {
			return 1;
		}

		return getNthFib(n - 2) + getNthFib(n - 1);
	}
}
