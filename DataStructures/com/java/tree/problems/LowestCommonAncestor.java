package com.java.tree.problems;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {
	public static void main( String [] str)
	{
		BuildSimpleBinaryTree instance = new BuildSimpleBinaryTree();
		Integer[] nodes = {7,10,5,8,6,2,12,11,13};
		TreeNode root = instance.build(nodes);
		List<TreeNode> inonodes = new ArrayList<>(); 
		PreorderTraversal.PreorderTrav1(root, inonodes);
		System.out.println("\n Preorder Travarsal " +inonodes);
		//non recursive
		//TreeNode lcommAns= lowestCommAncester(inonodes,8,12);
		//Recursive
		TreeNode lcommAns=lowestCommAncesterRecu(root,8,13);
		System.out.println("common ancesstor =" +lcommAns);
		System.out.println("Defth difference ="  + Math.abs(defthFromCommonAncesstor(lcommAns,8)-defthFromCommonAncesstor(lcommAns,13)));
		System.out.println("Defth difference recur="  + Math.abs(defthFromCommonAncesstorRecu(lcommAns,8,0)-defthFromCommonAncesstorRecu(lcommAns,13,0)));

	}
	
	// Using post order traversal and then travere the returned list.
	static TreeNode lowestCommAncester( List<TreeNode>  inonodes, int a, int b)
	{
		TreeNode node = null;
		for( int i = 0; i < inonodes.size(); i ++)
		{
			node = inonodes.get(i);
			
			if(node.value > a && node.value > b)
			{
				continue;
			}
			
			if(node.value < a && node.value < b)
			{
				continue;
			}
			
			if(node.value == a || node.value == b)
			{
				break;
			}
			
			if(node.value > a && node.value < b)
			{
				break;
			}
			
			if(node.value < a && node.value > b)
			{
				break;
			}
		}
		
		return node;
	}
	
	static TreeNode lowestCommAncesterRecu( TreeNode  root, int a, int b)
	{
		if(root != null ) 
		{
			if(root.value == a || root.value == b){
				return root;
			}
			if(root.value > a && root.value < b)
			{
				return root;
			}
			
			if(root.value < a && root.value > b)
			{
				return root;
			}
			

		
		if(root.value > a && root.value > b)
		{
			root = lowestCommAncesterRecu(root.leftNode,a,b);
		}
		
		if(root.value < a && root.value < b)
		{
			root =lowestCommAncesterRecu(root.rightNode,a,b);
		}
	}
		return root;
	}
	
	static int defthFromCommonAncesstor(TreeNode root, Integer n)
	{ 
		TreeNode temp= root;
		int defth = 0;

		while( temp != null)
		{
			if(temp.value == n)
			{
				break;
			}
			if(temp.value > n)
			{
				temp = temp.leftNode;
				defth++;
				continue;
			}
			if(temp.value < n)
			{
				temp = temp.rightNode;
				defth++;
				continue;
			}
			
		}
		return defth;
	}
	
	static int defthFromCommonAncesstorRecu(TreeNode root, Integer n, Integer defth)
	{
		if (root != null) {
			if (root.value == n) {
				return defth;
			}
			if( root.value > n)
			{
				defth =defthFromCommonAncesstorRecu(root.leftNode,n, defth+1);
			}
			if( root.value < n)
			{
				defth =defthFromCommonAncesstorRecu(root.rightNode,n, defth+1);
			}
		}
		return defth;
	}

}
