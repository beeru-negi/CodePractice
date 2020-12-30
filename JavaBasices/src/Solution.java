package src;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.TooManyListenersException;
import java.util.stream.Collectors;
//Find the smallest positive integer that does not occur in a given sequence.
public class Solution {
	public static void main(String[] str) {
		Solution s = new Solution();
		int[] a = { -2,-4,1, 3, 6, 5,4, 1, 2 };
		System.out.print(s.solution1(a));
	}
	
	public int solution1(int[] A) {
		// write your code in Java SE 8
		Arrays.sort(A);
		int min = A[0];
		int max = A[A.length-1];
		
		if(min < 1 )
		{

			int result = Arrays.binarySearch(A, 1);
			if(result < 0)
			{
			return 1;
			} else {
				int start =2;
				while ( start < max)
				{
					result = Arrays.binarySearch(A, start);
					if(result < 0)
					{
						return start;
					} else {
						start++;
					}
				}
			}
		}
		 int start= 1;
		 int result;
		 while(start < max)
		 {
				result = Arrays.binarySearch(A, start);
				if(result < 0)
				{
					return start;
				} else {
					start++;
				}
				 
		 }

		return max+1;

	}

	public int solution(int[] A) {
		// write your code in Java SE 8

		List<Integer> arrList = Arrays.stream(A).boxed().filter(a -> a > 0).collect(Collectors.toList());
		Optional<Integer> op = arrList.parallelStream().min((a, b) -> a.compareTo(b));
		Optional<Integer> max = arrList.parallelStream().max((a, b) -> a.compareTo(b));
		int min;
		try {
			min = op.get();
		} catch (NoSuchElementException e) {
			return 1;
		}
		if (min != 1)
			return 1;
		int intNotPresent = min + 1;
		while (intNotPresent <= max.get()) {
			if (arrList.contains(intNotPresent)) {
				intNotPresent++;
			} else {
				return intNotPresent;
			}
		}

		return arrList.get(arrList.size() - 1) + 1;

	}

}
