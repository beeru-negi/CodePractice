package com.java.string.problems;

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
