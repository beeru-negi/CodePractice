package com.java.linkedlist;

/** reversing a linked list. Given head node of a linked list, reverse a list and return last node as head */
public class ReverseLinkedList {
	public static LinkedList reverseLinkedList(LinkedList head) {
		// Write your code here.
		LinkedList prev = null, temp = head;
		if (head.next == null) {
			return head;
		}
		while (head != null) {
			// System.out.print(" "+ head.value+" ");
			// s1.append(""+head.value);
			temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}

		return prev;
	}

	static class LinkedList {
		int value;
		LinkedList next = null;

		public LinkedList(int value) {
			this.value = value;
		}
	}
}
