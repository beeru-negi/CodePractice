package com.java.linkedlist;

/* Find if a given integer value linked list is palindrome
 * Ex-  head->0->1->2->2->1->0->null. Return true if linked list is palindrome otherwise return false.
 *  */
public class LinkedListPalindrome {
	  // This is an input class. Do not edit.
	  public static class LinkedList {
	    public int value;
	    public LinkedList next;

	    public LinkedList(int value) {
	      this.value = value;
	      this.next = null;
	    }
	  }

	  public boolean linkedListPalindrome(LinkedList head) {
	    // Write your code here.
				LinkedList prev=null,temp = head;
			  StringBuffer s1 = new StringBuffer("");
			  StringBuffer s2 = new StringBuffer("");
			 if(head.next == null)
			 {
					return true;
			 }
			while(head != null)
				{
					//System.out.print(" "+ head.value+" ");
					  s1.append(Integer.toString(head.value));
					  temp = head.next;
					  head.next = prev;
					  prev=head;
					  head=temp;
				}
			 
			while(prev != null)
				{
					//System.out.print("\n "+ prev.value+" ");
					  s2.append(Integer.toString(prev.value));
					  prev=prev.next;
				}
			// System.out.println(s1+""+s1.length());
			// System.out.println(s2+""+s2.length());
	    return s1.toString().equals(s2.toString());
	  }

}
