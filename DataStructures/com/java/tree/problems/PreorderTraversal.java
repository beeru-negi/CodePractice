package com.java.tree.problems;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
	public static void main( String [] str)
	{
		BuildSimpleBinaryTree instance = new BuildSimpleBinaryTree();
		Integer[] nodes = {7,9,5,8,6,2,10};
		TreeNode root = instance.build(nodes);
		List<Integer> inonodes = new ArrayList<>(); 
		PreorderTrav(root, inonodes);
		System.out.println("\n Preorder Travarsal " +inonodes);
		inonodes = new ArrayList<>(); 
		PostorderTrav(root, inonodes);
		System.out.println("Postorder Travarsal " +inonodes);
	}
	public static void PreorderTrav(TreeNode root, List<Integer> orderList)
	{
		if(root == null)
		{
			//orderList.add(root);
			return;
		}
		orderList.add(root.value);
		PreorderTrav(root.leftNode, orderList);		
		PreorderTrav(root.rightNode, orderList);
		
	}
	public static void PreorderTrav1(TreeNode root, List<TreeNode> orderList)
	{
		if(root == null)
		{
			//orderList.add(root);
			return;
		}
		orderList.add(root);
		PreorderTrav1(root.leftNode, orderList);		
		PreorderTrav1(root.rightNode, orderList);
		
	}
	public static void PostorderTrav(TreeNode root, List<Integer> orderList)
	{
		if(root.leftNode == null && root.rightNode == null)
		{
			orderList.add(root.value);
			return;
		}
		
		PostorderTrav(root.leftNode, orderList);		
		PostorderTrav(root.rightNode, orderList);
		orderList.add(root.value);
		
	}
}
