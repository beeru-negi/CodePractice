package com.java.linkedlist;

import java.util.List;
import java.util.Stack;

public class LinkedListProblems {
	public static void main(String[] str) {
		Integer[] nodes = { 7, 9, 5, 8, 6, 2, 10 };

		Node node = BuildLinkedList.buildLinkedList(nodes);
		Node temp = node;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

		System.out.print("\n");
		// Print list in reverse order
		temp = node;
		ReversePrint(temp);

	}

	static void ReversePrint(Node head) {
		// This is a "method-only" submission.
		// You only need to complete this method.
		head = reverse(head, null);
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;

		}

	}

	static Node reverse(Node head, Node priv) {
		Node temp;
		if (head != null && head.next == null) {
			head.next = priv;
			return head;
		}

		if (head != null) {
			// System.out.println(head.data);
			temp = head.next;
			head.next = priv;
			priv = head;
			head=temp;
			

			head = reverse(head, priv);

		}
		return head;
	}

	
	static Node reverse1(Node head, Node next) {

		Stack<Node> stc = new Stack<>();
		if (head != null) {
			while (head != null) {
				stc.push(head);
				head = head.next;
			}
		}
        head = stc.pop();
        Node temp = head;
		while (!stc.isEmpty()) {
			temp.next = stc.pop();
			temp = temp.next;
		}
		 temp.next = null;
		 
		 return head;
	}
	

}
