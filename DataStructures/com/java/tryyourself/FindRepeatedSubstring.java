package com.java.tryyourself;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
.Given an input string S write a function which returns true if it satisfies S = nT. Basically you have to find if a given string can be represented from a substring by iterating it �n� times. n >= 2 
An example would suffice  
Function should return true if 
1) S = abab 
2) S = abcdabcd 
3) S = abcabcabc 
4) S = zzxzzxzzx 
 
Function should return false if 
1) S = abac 
2) S = abcdabbd 
3) S = abcabcefg 
4) S = zzxzzyzzx 
 */
public class FindRepeatedSubstring {
	public static void main(String[] arg)
	{
		String s = "abcabchabcabch";//"birendrabir";//"abcdabcdabcdabcd";
		String sub="";
		boolean isRepeat=false;
		
		for(int i=1; i < s.length()/2; i++)
		{
			sub = s.substring(0, i);
			if(isRepeating(sub,s.substring(sub.length(),s.length())))
			{
				isRepeat=true;
				break;
			}
		}
		List<char[]> charL = Arrays.asList(s.toCharArray());
		
		//List<Character> list = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		
		if(isRepeat)
		{
			System.out.println("Repeated string-"+sub);
		} else{
			System.out.println("No Repeated string");
		}
		
		System.out.println("is valid string "+isValid("{{[[(())]]}}"));
	}
	
	static boolean isValid(String s)
	{
		Stack<Character> st = new Stack<>();
		List<Character> list = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		list.stream().forEach(
					p->{
						if(p=='{')
						{
							st.push('}');
						} else if(p=='(')
						{
							st.push(')');
						} else if(p=='[')
						{
							st.push(']');
						} else if(st.empty() || st.pop()!=p)
						{
							st.push(p);
						}
					}
				
				);
		return st.empty();
	}
	static boolean isRepeating(String sub, String s)
	{
		int l=sub.length();
		int j=s.length();
		if(l == j && sub.equals(s))
		{
			return true;
		}
		
		if(l < j)
		{
			String temp = s.substring(0,sub.length());
			if(sub.equals(temp))
			{
				return isRepeating(sub,s.substring(l,j));
			}
		} else {
			return false;
		}
		
		return false;

	}

}
