package com.java.tree;

/** Algo Expert- Program return sum of defth of each node **/
public class SumOfTreeNodeDefth {

	public static int nodeDepths(BinaryTree root) {
		// Write your code here.

		if (root == null) {
			return 0;
		}
		return nodeDefth(root, 0);
	}

	public static int nodeDefth(BinaryTree root, int defth) {
		// Write your code here.

		if (root.left == null && root.right == null) {
			return defth;
		}

		return defth + (root.left != null ? nodeDefth(root.left, defth + 1) : 0)
				+ (root.right != null ? nodeDefth(root.right, defth + 1) : 0);

	}

	static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
			left = null;
			right = null;
		}
	}
}
