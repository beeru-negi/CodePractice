package com.java.string.problems;

/**
 * Is Unique Characters in String.
 *
 * <p>Checks whether all characters in a given string are unique (no character
 * appears more than once). Uses a boolean lookup array of size 256 (ASCII)
 * for O(1) per-character lookup.
 *
 * <p>Example: {@code "abcde"} → {@code true}, {@code "abcda"} → {@code false}.
 *
 * <p>Time Complexity: O(n). Space Complexity: O(1) (fixed 256-entry array).
 */
public class IsUniqueCharInString {
	
	public static void main(String[] str)
	{
		String strg = "biendrab";
		
		System.out.println("Is Unique char in String" + strg +"->" + isUniqueChar(strg));
	}
	
	static boolean isUniqueChar(String str)
	{
		boolean[] chr_arr = new boolean[256];
		for(int i=0 ; i < str.length();i++)
		{
			char chr = str.charAt(i);
			if(chr_arr[chr]) return false;
			
			chr_arr[chr]= true;
		}
		
		return true;
	}

}
