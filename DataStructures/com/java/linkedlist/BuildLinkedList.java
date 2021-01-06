package com.java.linkedlist;

public class BuildLinkedList {
public static void main(String [] str)
{
	Integer[] nodes = {7,9,5,8,6,2,10};
	Node node = buildLinkedList(nodes);
	while(node!= null)
	{
		System.out.println(node.data);
		node=node.next;
	}

}

public static Node buildLinkedList(Integer[] nodes)
{
	int i=0;
	Node node=null;
	while(i<nodes.length)
	{
		node = addNode(node, nodes[i]);
		i++;
	}
	return node;
}

public static Node addNode(Node node, Integer data)
{
	Node temp;
	if(node==null)
	{
		node = new Node(data);
		node.next = null;
		return node;
	}
	temp = node;
		while(temp.next!=null)
		{
			temp = temp.next;
		}
		
		temp.next = new Node(data);
		temp.next.next = null;
		
		return node;
	
}
}
