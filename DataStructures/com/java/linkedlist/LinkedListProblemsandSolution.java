package com.java.linkedlist;

import java.util.Stack;

public class LinkedListProblemsandSolution {
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
        head = reverse1(head);
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;

		}

	}

    static Node reverse1(Node head) {

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
