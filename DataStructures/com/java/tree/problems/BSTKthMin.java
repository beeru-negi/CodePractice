package com.java.tree.problems;

import java.util.Stack;

public class BSTKthMin {
	static int k = 4;
	static int j = 3;

	public static void main(String[] str) {

		BuildSimpleBinaryTree instance = new BuildSimpleBinaryTree();
		Integer[] nodes = { 20, 8, 22, 4, 12, 10, 14 };
		TreeNode root = instance.build(nodes);
		TreeNode minNode = new TreeNode(0);
		kThMin(root, minNode);
		System.out.println("Kth min of tree with recursion=" + minNode.value);
		System.out.println("Kth min of tree with stack=" + kThMinNode(root,j).value);
	}

	// Recursive
	static void kThMin(TreeNode node, TreeNode minNode) {
		if (node != null && node.rightNode == null && node.leftNode == null) {
			if (k == 1) {
				minNode.value = node.value;
				return;
			}
			k--;
			return;
		}
		if (node != null) {
			kThMin(node.leftNode, minNode);
			if (k == 1) {
				if (minNode.value == 0) {

					minNode.value = node.value;
					return;
				} else {
					return;
				}
			} else {
				k--;
			}
			kThMin(node.rightNode, minNode);
		}
	}

	// Using stack

	static TreeNode kThMinNode(TreeNode root, int k) {
		Stack<TreeNode> stc = new Stack<TreeNode>();
		TreeNode tNode = root;
		TreeNode currNode = null;
		while (tNode != null) {

			stc.push(tNode);
			tNode = tNode.leftNode;

		}

		while (!stc.isEmpty()) {
			currNode = stc.pop();
			
			if(k==1)				
			{
				break;
			}
			k--;
			if (currNode.rightNode != null) {
				tNode = currNode.rightNode;
				while (tNode != null) {

					stc.push(tNode);
					tNode = tNode.leftNode;

				}
			}
		}

		return currNode;
	}

}
