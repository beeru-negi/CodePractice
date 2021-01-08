package com.java.recursion;

import java.util.ArrayList;
import java.util.List;

/** List contain values as integer and special list. Special list means it can have multiple level of list
 * We have to take the sum of values as per different level.
 * Ex= [x, [y,z,[a,b,c]],d]  = x + 2*(y+z+ 3*(a+b+c)) + d 
 * **/
public class ProductSumInList {

	 // Tip: You can use `element instanceof ArrayList` to check whether an item
	  // is an array or an integer.
	  public static int productSum(List<Object> array) {

			return productSum(array, 1);
	  }
		
		@SuppressWarnings("unchecked")
		public static int productSum(List<Object> array, int level) {
			
			int prodResult = 0;
			
			for( int i = 0; i < array.size(); i++)
			{
				if(array.get(i) instanceof ArrayList)
				{
					prodResult = prodResult + (level + 1) * productSum((List<Object>)array.get(i), level +1);
				} else {
					
					//System.out.print(""+level * ((Integer)array.get(i)) + "+");
					prodResult = prodResult + ((Integer)array.get(i));
				}
			}
			return prodResult;
	  }
}
