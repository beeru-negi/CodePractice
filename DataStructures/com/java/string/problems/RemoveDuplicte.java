package com.java.string.problems;

import java.util.Arrays;

public class RemoveDuplicte {

	public static void main(String[] str)
	{
		String strg = "birebbndra";
		
		System.out.println("Final string String" + strg +"->" + removeDuplicatesEff(strg.toCharArray()));
	}
	public static String removeDuplicatesEff(char[] str) {
		if (str == null)
			return null;
		int len = str.length;
		if (len < 2)
			return Arrays.toString(str);
		boolean[] hit = new boolean[256];
		for (int i = 0; i < 256; ++i) {
			hit[i] = false;
		}
		hit[str[0]] = true;
		int tail = 1;
		for (int i = 1; i < len; ++i) {
			if (!hit[str[i]]) {
				str[tail] = str[i];
				++tail;
				hit[str[i]] = true;
			}
		}
		//str[tail] = 0;
		//return (Arrays.toString(str)).substring(0,tail);
		return String.valueOf(str).substring(0, tail);
	}
}
