package com.java.tree;

/*
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

	Return the number of good nodes in the binary tree.
	Input: root = [3,1,4,3,null,1,5]
Output: 4
Explanation: Nodes in blue are good.
Root Node (3) is always a good node.
Node 4 -> (3,4) is the maximum value in the path starting from the root.
Node 5 -> (3,4,5) is the maximum value in the path
Node 3 -> (3,1,3) is the maximum value in the path.
 */
public class CountGoodNodesInBT {
	public int goodNodes(TreeNode root) {
		return processGoodNodes(root, root.val);
	}

	int processGoodNodes(TreeNode node, int lastMax) {
		if (node == null) {
			return 0;
		}

		return (node.val < lastMax ? 0 : 1) + processGoodNodes(node.left, node.val < lastMax ? lastMax : node.val)
				+ processGoodNodes(node.right, node.val < lastMax ? lastMax : node.val);
	}

	public class TreeNode {
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
