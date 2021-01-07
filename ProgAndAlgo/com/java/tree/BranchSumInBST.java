package com.java.tree;

import java.util.ArrayList;
import java.util.List;

/** Algo expert problem. This program return the List which consist sum of node values for each branch in BST  **/
public class BranchSumInBST {
	// This is the class of the input root. Do not edit it.
	  public static class BinaryTree {
	    int value;
	    BinaryTree left;
	    BinaryTree right;

	    BinaryTree(int value) {
	      this.value = value;
	      this.left = null;
	      this.right = null;
	    }
	  }

	  public static List<Integer> branchSums(BinaryTree root) {
	    // Write your code here.
			List<Integer> branchSum = new ArrayList<Integer>();
			if(root == null)
				return null;
			sumBranchNodes(root, 0, branchSum);		
			
	    return branchSum;
	  }
		static void sumBranchNodes( BinaryTree root, int nodeSum, List<Integer> branchSum)
		{
			 if(root.left == null && root.right == null)
			 {
				 branchSum.add(nodeSum + root.value);
			 }
			 
			if(root.left != null)
			{
			 sumBranchNodes(root.left, nodeSum + root.value, branchSum);
			}
			
			if(root.right != null)
			{
				sumBranchNodes(root.right, nodeSum + root.value, branchSum);
			}
		}
}
