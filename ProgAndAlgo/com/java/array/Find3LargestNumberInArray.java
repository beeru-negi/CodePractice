package com.java.array;

/** find 3 largest number in a given integer array with minimum 3 elements. Return the result in an array **/
public class Find3LargestNumberInArray {
	  public static int[] findThreeLargestNumbers(int[] array) {
		    // Write your code here.		
				int [] result = new int[3];
				int max0=array[0];
				int max1=array[1];
				int max2=array[2];
				int t;
				if(max2 > max1 && max2 > max0){
					if(max1 < max0)	{
						t = max0;
						max0 = max1;
						max1=t;
					}
				}		
				if(max1 > max2 && max1 > max0){
					  t = max1;
						max1 = max2;
						max2=t;
					if(max1 < max0)	{
						t = max0;
						max0 = max1;
						max1=t;
					}
				}
				if(max0 > max2 && max0 > max1){
					  t = max0;
						max0 = max2;
						max2=t;
					if(max1 < max0)	{
						t = max0;
						max0 = max1;
						max1=t;
					}
				}
				for(int i=3 ; i < array.length; i ++)	{
					 if(array[i] > max2) {
						 max0=max1;
						 max1=max2;
						 max2= array[i];
						 continue;
					 }			
					if(array[i] > max1)	{
						max0=max1;
						max1=array[i];
						continue;
					}
					if(array[i] > max0)	{
						max0= array[i];
					}
				}
				result[2] = max2;		result[1] = max1;		result[0] = max0;
		    return result;
		  }
}
