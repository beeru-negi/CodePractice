package com.java.tree.problems;

public class BuildSimpleBinaryTree {
	public static void main(String [] str)
	{
		BuildSimpleBinaryTree instance = new BuildSimpleBinaryTree();
		
		Integer[] nodes = {7,9,5,8,6,2,10};
		instance.build(nodes);
		
	}
	public TreeNode build(Integer[] nodes)
	{
		//7,9,5,9,3,2,10
		TreeNode root = new TreeNode(nodes[0]);
		System.out.print(root.value+ " ");
		int i = 1;
		while(i<nodes.length)
		{
			buildTree(root, nodes[i]);
			i++;
		}
		return root;
	}
	
	void buildTree(TreeNode root, Integer value)
	{
		if(root.value >= value)
		{
			if(root.leftNode == null)
			{
				root.leftNode = new TreeNode(value);
				System.out.print(value+ " ");
			} else {
				buildTree( root.leftNode, value);
			}
		}
		
		if(root.value < value)
		{
			if(root.rightNode == null)
			{
				root.rightNode = new TreeNode(value);
				System.out.print(value+ " ");
			} else {
				buildTree( root.rightNode, value);
			}
			
		}
		
	}

}
