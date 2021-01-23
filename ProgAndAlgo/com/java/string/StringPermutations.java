package com.java.string;

import java.util.ArrayList;

public class StringPermutations {
	public static void main(String[] str) {
		String name = "bire";
		ArrayList<String> possiblePermutations = new StringPermutations().permutationOfString(name);
		possiblePermutations.forEach(a->System.out.println(a));

	}
	public ArrayList<String> permutationOfString(String name) {
	    // Write your code here.
			ArrayList<String> mList = new ArrayList<String>();
			char[] charArr =name.toCharArray();
			permutationOfString(charArr, "", 0, mList);
			return mList;
	  }
		
		private void permutationOfString(char[] name, String permStr, int index, ArrayList<String> mList) {
				if (index >= name.length) {
						return ;
				}

				for(int i=0; i <name.length; i++)
				{
					if(permStr.contains(""+name[i]))
						continue;
					permutationOfString(name, permStr+name[i], index+1, mList);			
					if(index == name.length -1)
					{
						//System.out.println(menmStr+s);
							mList.add(permStr+name[i]);
					}
				}
			
		}	
}
