package com.java.string.problems;

public class MaxPalindrome {
	
	public static void main(String[] str)
	{
		StringBuffer palString = new StringBuffer("zsyvysradhahdarcy");
		StringBuffer revString= new StringBuffer("");
		int maxPal=0, temp=0;
		for(int i=0; i<palString.length(); i++)
		{
			for(int j=i+1; j<palString.length(); j++)
			{
				if(palString.charAt(i) == palString.charAt(j)){
					revString = new StringBuffer("");
					
					if(palString.substring(i, j+1).equals(revString.append(palString.substring(i, j+1)).reverse().toString()))
					{
						temp = palString.subSequence(i, j).toString().length();
						if(temp > maxPal)
						{
							maxPal = temp;
						}
					}
				}
			}
		}
		
		System.out.println("Max palindrome length is -" + maxPal);
	}

}
