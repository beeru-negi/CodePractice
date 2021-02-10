package com.java.linkedlist;
/*
 * Removing duplicate values from linked list
 * Ex- 1 -> 1 -> 3 -> 4-> 4->4 ->5 -> -> 6
 * Output 1->3->4->5->6
 * 
 */
public class RemovingDuplicatesFromLinkedLlist {
	// This is an input class. Do not edit.
	  public static class LinkedList {
	    public int value;
	    public LinkedList next;

	    public LinkedList(int value) {
	      this.value = value;
	      this.next = null;
	    }
	  }

	  public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
	    // Write your code here.
			if(linkedList == null || linkedList.next == null)
			{
				return linkedList;
			}
			LinkedList head=linkedList;
			while(head.next != null)
			{
	       if( head.value == head.next.value)
				 {	
					 
					 head.next=head.next.next;
					 continue;
					 
				 }
				head=head.next;
			}
			return linkedList;
	  }
}
