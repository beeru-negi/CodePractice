package com.java.tree.problems;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
	
	public static void main( String [] str)
	{
		BuildSimpleBinaryTree instance = new BuildSimpleBinaryTree();
		Integer[] nodes = {20,8,22,4,12,10,14};
		TreeNode root = instance.build(nodes);
		List<Integer> inonodes = new ArrayList<>(); 
		inorderTrav(root, inonodes);
		System.out.println(inonodes);
	}
	public static void inorderTrav(TreeNode root, List<Integer> orderList)
	{
		if(root != null && root.leftNode == null && root.rightNode == null)
		{
			orderList.add(root.value);
			return;
		}
		if(root != null)
		{
		inorderTrav(root.leftNode, orderList);
		orderList.add(root.value);
		inorderTrav(root.rightNode, orderList);
		}
		
	}

}
