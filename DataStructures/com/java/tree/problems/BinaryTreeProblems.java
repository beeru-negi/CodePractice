
package com.java.tree.problems;

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
