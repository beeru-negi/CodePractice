package com.java.tree;

/*
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * A valid BST is defined as follows:
 *  - The left subtree of a node contains only nodes with keys less than the node's key.
 *  - The right subtree of a node contains only nodes with keys greater than the node's key.
 *  - Both the left and right subtrees must also be binary search trees.
 * 
 * Example:
 * Input: root = [2,1,3]  -> Output: true
 * Input: root = [5,1,4,null,null,3,6] -> Output: false
 *         (root node's value is 5 but its right child's value is 4)
 */
public class ValidateBST {

	public boolean isValidBST(TreeNode root) {
		return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean validate(TreeNode node, long min, long max) {
		if (node == null) {
			return true;
		}
		if (node.val <= min || node.val >= max) {
			return false;
		}
		return validate(node.left, min, node.val) && validate(node.right, node.val, max);
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
