package com.java.string.problems;

public class ReverserWords {
	public static void main(String[] str)
	{
		String string ="AlgoExpert is the best!";
		//String string ="a ab a";
		System.out.println("Original string :" + string);
		System.out.println("Reverse string :" + reverseWordsInString(string));
	}
	public static String reverseWordsInString(String string) {
		// Write your code here.
		String reverse = "";
		int size = string.length();
		if (size == 1) {
			return string;
		}

		int start = 0;
		for (int i = 1; i < size; i++) {


			if (string.charAt(i - 1) != ' ' && string.charAt(i) == ' ') {
				reverse = string.substring(start, i) + reverse;
				start = i;
			}

			if (string.charAt(i - 1) == ' ' && string.charAt(i) != ' ') {
				reverse = string.substring(start, i) + reverse;
				start = i;
			}
			if (i == size - 1) {
				reverse = string.substring(start, size) + reverse;
			}

		}
		return reverse;

	}
}
