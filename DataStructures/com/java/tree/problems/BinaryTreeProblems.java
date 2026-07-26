
package com.java.tree.problems;

/**
 * Binary Tree Validation (BST property check).
 *
 * <p>Determines whether a given binary tree satisfies the Binary Search Tree
 * property: for every node, all values in the left subtree must be less than
 * the node's value, and all values in the right subtree must be greater.
 * The check is performed recursively in a pre-order traversal.
 *
 * <p>Example: A tree with root 7 and the right child's right subtree containing 3
 * (which violates BST order) → {@code false}.
 *
 * <p>Time Complexity: O(n). Space Complexity: O(h) where h is the tree height.
 */
public class BinaryTreeProblems {

	public static void main( String [] str)
	{
		BuildSimpleBinaryTree instance = new BuildSimpleBinaryTree();
		Integer[] nodes = {7,10,5,2,9,11};
		TreeNode root = instance.build(nodes);
		
		root.rightNode.rightNode.value = 3;
		
		System.out.println("Is Tree valid="+validateBST(root,true) );
	}
	
	static boolean validateBST(TreeNode root, boolean isValid)
	{

		if (isValid && root != null) {
			if ((root.leftNode != null && root.value < root.leftNode.value)
					|| (root.rightNode != null && root.value > root.rightNode.value)) {
				isValid = false;
			} else 
			{
				isValid = true;
			}
			if (isValid ) {
				isValid =validateBST(root.leftNode,isValid);
				isValid =validateBST(root.rightNode,isValid);
			}
		}
		return isValid;
	}
		
	
}
