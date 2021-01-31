package com.java.array;

import java.util.ArrayList;
import java.util.List;

/** A 2 dimensional integer array is given. Code should print array elements in zig-zag fashion.
 * arr[][]= {
 * 			1,2,3,4
 * 			8,7,6,5
 * 			9,10,11,12
 * 			16,15,14,13
 * }
 * 
 * output should be [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16]
 *
 */
public class PrintArrayElementsSpiral {
	public static List<Integer> spiralTraverse(int[][] array) {
	    // Write your code here.
			List<Integer> spiral = new ArrayList<Integer>();
			int length = array.length;
			int start =0;
			int end = array[0].length;
			for(int i =0 ; i< length; i++)
			{
				start=0;
				end = array[0].length;
				
				while(start < end )
				{
					 if(i%2 == 0)
						{
							spiral.add(array[i][start]);
							start++;
						} else{
							spiral.add(array[i][end-1]);
						 end --;
						}
				}			
				
			}
	    return spiral;
	  }
}
