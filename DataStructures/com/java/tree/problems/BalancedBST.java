package com.java.tree.problems;

/**
 * Check if a Binary Search Tree is Balanced.
 *
 * <p>A BST is considered balanced if the difference between its maximum depth
 * and minimum depth is at most 1. This is checked by recursively computing
 * both the max depth (longest root-to-leaf path) and min depth (shortest
 * root-to-leaf path) and comparing them.
 *
 * <p>Example: A balanced BST with nodes [20, 8, 22, 4, 12, 10, 14] → {@code true}.
 *
 * <p>Time Complexity: O(n). Space Complexity: O(h) where h is the tree height.
 */
public class BalancedBST {
	public static void main(String[] str) {

		BuildSimpleBinaryTree instance = new BuildSimpleBinaryTree();
		Integer[] nodes = { 20, 8, 22, 4, 12, 10, 14 };
		Integer[] nodes1 = { 20, 8, 22, 4,1, 12,21,23 };
		TreeNode root = instance.build(nodes);
		System.out.println("\n");
		TreeNode root1 = instance.build(nodes1);
		System.out.println("\nIs balanced BST ="+(maxDefth(root)-minDefth(root) <=1));
		System.out.print("Is balanced BST ="+(maxDefth(root1)-minDefth(root1) <=1));
		
	}
	
	static int maxDefth(TreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		return 1+ Math.max(maxDefth(root.leftNode), maxDefth(root.rightNode));
	}
	
	static int minDefth(TreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		return 1+ Math.min(minDefth(root.leftNode), minDefth(root.rightNode));
	}
}
