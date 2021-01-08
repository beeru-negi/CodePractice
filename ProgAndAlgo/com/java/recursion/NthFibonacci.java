package com.java.recursion;

public class NthFibonacci {

	 public static int getNthFib(int n) {
		    // Write your code here.
				if(n==1 || n==0)
				{
					return 0;
				}
				if(n==2)
				{
					return 1;
				}
				
				return getNthFib(n-2) + getNthFib(n-1);
		  }
}
