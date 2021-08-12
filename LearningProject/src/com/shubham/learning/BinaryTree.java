package com.shubham.learning;
// Java implementation to find leaf count of a given Binary tree 

/* Class containing left and right child of current 
node and key value*/
class Node1
{ 
	int data; 
	Node1 left, right; 

	public Node1(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

public class BinaryTree 
{ 
	//Root of the Binary Tree 
	Node1 root; 
	
	/* Function to get the count of leaf nodes in a binary tree*/
	int getLeafCount() 
	{ 
		return getLeafCount(root); 
	} 

	int getLeafCount(Node1 node) 
	{ 
		if (node == null) 
			return 0; 
		if (node.left == null && node.right == null) 
			return 1; 
		else
			return getLeafCount(node.left) + getLeafCount(node.right); 
	} 

	/* Driver program to test above functions */
	public static void main(String args[]) 
	{ 
		/* create a tree */
		BinaryTree tree = new BinaryTree(); 
		tree.root = new Node1(1); 
		tree.root.left = new Node1(2); 
		tree.root.right = new Node1(3); 
		tree.root.left.left = new Node1(4); 
		tree.root.left.right = new Node1(5); 
		
		/* get leaf count of the abve tree */
		System.out.println("The leaf count of binary tree is : "
							+ tree.getLeafCount()); 
	} 
} 

// This code has been contributed by Mayank Jaiswal(mayank_24) 
