package com.java.tree.problems;

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
