package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public class TryYourself {
	public static void main(String[] str)
	{
		Integer[] inte = {2,5,7,8,1};
		List<Integer> intl = Arrays.asList(inte);
		Collections.sort(intl);
		int i = Collections.binarySearch(intl,7);
		Arrays.sort(inte);
		int j = Arrays.binarySearch(inte, 2);
		
		System.out.println(i+ " "+ j);
		SortedSet<String> s;
		Set<String> m = new TreeSet<>(Collections.reverseOrder());
		Queue q = new PriorityQueue<>();
		
		new LinkedList<>();
		char[] a = {'a','b','c'};
		Arrays.toString(a);
		
		List list = new ArrayList<>();
		list.add(new Object());
		
		Queue<String> qu = new LinkedList<>();
		Stack<String> st = new Stack<>();
		
		String s1="sdsdsdg";
		s1.toCharArray();
		
		Arrays.stream(inte).forEach(x-> System.out.print(x));
		
		String d ="birendra";
		d.toCharArray();
		

	
	}

}
