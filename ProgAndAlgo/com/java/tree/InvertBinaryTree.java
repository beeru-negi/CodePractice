package com.java.tree;

/*
 * Given the root of a binary tree, invert the tree, and return its root.
 * 
 * Example:
 * Input:      4             Output:     4
 *            / \                       / \
 *           2   7                     7   2
 *          / \ / \                   / \ / \
 *         1  3 6  9                 9  6 3  1
 */
public class InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode temp = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(temp);

		return root;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
