package com.java.tree.problems;

public class BSTMaxHeight {
	public static void main(String[] str) {
		BuildSimpleBinaryTree instance = new BuildSimpleBinaryTree();
		Integer[] nodes = { 3, 2, 1, 5, 4, 6, 7,12,8,9,0 };
		TreeNode root = instance.build(nodes);

		System.out.println("Height of tree=" + height(root));
	}

	static int height(TreeNode root) {
		return height(root, 0, 0);
	}

	static int height(TreeNode root, int height, int maxheight) {
		if (root != null && root.rightNode == null && root.leftNode == null) {
			if (height > maxheight) {
				maxheight = height;
			}
			height = 0;
			return maxheight;
		}
		if (root != null) {
			maxheight = height(root.leftNode, height + 1, maxheight);
			maxheight = height(root.rightNode, height + 1, maxheight);
		}

		return maxheight;
	}
}
