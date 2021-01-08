package com.java.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** Print nodes of a tree using depth first search **/
public class DepthFirstSearchTree {
	  // Do not edit the class below except
	  // for the depthFirstSearch method.
	  // Feel free to add new properties
	  // and methods to the class.
	  static class Node {
	    String name;
	    List<Node> children = new ArrayList<Node>();

	    public Node(String name) {
	      this.name = name;
	    }

	    public List<String> depthFirstSearch(List<String> array) {
	      // Write your code here.
				 /*
				 									A
												/	|		\
											B		C			D
										/		\		 /		\
									E			 F 	G			 H
				  							/	\   \
											I		 J		K
					Should print A B E F I J C D G K H
					*/
				Stack<Node> dnodes = new Stack<Node>();
				Node tnode;
				
				dnodes.push(this);
				while(!dnodes.empty())
				{
					 tnode = dnodes.pop();
					 array.add(tnode.name);
					 for( int i = tnode.children.size()-1; i >=0 ; i--)
					 {
						 dnodes.push(tnode.children.get(i));
					 }
				}
				
				
	      return array;
	    }

	    public Node addChild(String name) {
	      Node child = new Node(name);
	      children.add(child);
	      return this;
	    }
	  }
}
