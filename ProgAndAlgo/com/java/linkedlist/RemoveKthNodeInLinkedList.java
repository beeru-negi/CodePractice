package com.java.linkedlist;

/* Remove Kth node from end of a linked list*/
public class RemoveKthNodeInLinkedList {

	public static void removeKthNodeFromEnd(LinkedList head, int k) {
		// Write your code here.

		LinkedList prev = head, forward = head, prevP = null;
		int i = 1;
		while (forward.next != null) {
			if (i >= k) {
				prevP = prev;
				prev = prev.next;
			}

			forward = forward.next;
			i++;

		}
		// System.out.println(prev.value + " "+prevP+ " "+head.value);
		if (prevP == null) {
			head.value = head.next.value;
			head.next = head.next.next;
		} else {
			prevP.next = prev.next;
		}
		// System.out.println(prev.value + " "+prevP+ " "+head.value);
	}

	static class LinkedList {
		int value;
		LinkedList next = null;

		public LinkedList(int value) {
			this.value = value;
		}
	}
}
