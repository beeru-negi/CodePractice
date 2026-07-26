package com.java.string;

/**
 * Palindrome Check.
 *
 * <p>Determines whether a given string reads the same forwards and backwards
 * using a two-pointer approach that closes in from both ends.
 *
 * <p>Example: {@code "abcba"} → {@code true}, {@code "hello"} → {@code false}.
 *
 * <p>Time Complexity: O(n). Space Complexity: O(1).
 */
public class PalindromeCheck {
	public static boolean isPalindrome(String str) {
	    // Write your code here.
			int left = 0;
			int right = str.length()-1;
			while( left <= right )
			{
				 if(str.charAt(left) != str.charAt(right))
				 {
					 return false;
				 }
				left++;
				right--;
			}
	    return true;
	  }
}
