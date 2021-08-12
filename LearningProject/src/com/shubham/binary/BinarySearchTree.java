package com.shubham.binary;
// Java program to demonstrate
// insert operation in binary
// search tree
public class BinarySearchTree {

	/* Class containing left
	and right child of current node
	* and key value*/
	class Node
	{
		int key;
		Node left, right;

		public Node(int item)
		{
			key = item;
			left = right = null;
		}
	}

	// Root of BST
	static Node root;

	// Constructor
	BinarySearchTree()
	{
		root = null;
	}

	// This method mainly calls insertRec()
	void insert(int key)
	{
		root = insertRec(root, key);
	}

	/* A recursive function to
	insert a new key in BST */
	Node insertRec(Node root, int key)
	{

		/* If the tree is empty,
		return a new node */
		if (root == null)
		{
			root = new Node(key);
			return root;
		}

		/* Otherwise, recur down the tree */
		if (key < root.key)
			root.left = insertRec(root.left, key);
		else if (key > root.key)
			root.right = insertRec(root.right, key);

		/* return the (unchanged) node pointer */
		return root;
	}
	
	void insertInBinaryTree(int key) {
		root= inserUtil(root,key);
	}


	private Node inserUtil(Node root2, int key) {
		if(root2==null) {
			root2= new Node(key);
			return root2;
		}
		if(key<root2.key) {
			root2.left=inserUtil(root2.left,key);
		}else if(key>root2.key) {
			root2.right=inserUtil(root2.right,key);
		}
		return root2;
	}

	// This method mainly calls InorderRec()
	void inorder()
	{
		inorderRec(root);
	}

	// A utility function to
	// do inorder traversal of BST
	void inorderRec(Node root)
	{
		if (root != null) {
			inorderRec(root.left);
			System.out.println(root.key);
			inorderRec(root.right);
		}
	}

	// Driver Code
	public static void main(String[] args)
	{
		BinarySearchTree tree = new BinarySearchTree();

		/* Let us create following BST
		   50
		  /	  \
		30	   70
	   /  \    / \
	  20  40  60 80 */
		tree.insertInBinaryTree(50);
		tree.insertInBinaryTree(30);
		tree.insertInBinaryTree(20);
		tree.insertInBinaryTree(40);
		tree.insertInBinaryTree(70);
		tree.insertInBinaryTree(60);
		tree.insertInBinaryTree(80);

		// print inorder traversal of the BST
		tree.inorder();
	
		System.out.println("--");
		tree.inorder();
		System.out.println("-check BST-"+CheckBST.checkBST(root));
		
		
		
		
	}

	private void delete(int key) {
		root=deleteRec(root,key);
	}

	  Node deleteRec(Node root, int key)
	    {
	        /* Base Case: If the tree is empty */
	        if (root == null)
	            return root;
	 
	        /* Otherwise, recur down the tree */
	        if (key < root.key) {
	            root.left = deleteRec(root.left, key);
	        }else if (key > root.key)
	            root.right = deleteRec(root.right, key);
	 
	        // if key is same as root's
	        // key, then This is the
	        // node to be deleted
	        else {
	            // node with only one child or no child
	            if (root.left == null) {
	                return root.right;
	            } else if (root.right == null)
	                return root.left;
	            // node with two children: Get the inorder
	            // successor (smallest in the right subtree)
	            root.key = minValue(root.right);
	            // Delete the inorder successor
	            root.right = deleteRec(root.right, root.key);
	        }
	 
	        return root;
	    }
	 
	    int minValue(Node root)
	    {
	        int minv = root.key;
	        while (root.left != null)
	        {
	            minv = root.left.key;
	            root = root.left;
	        }
	        return minv;
	    }
}
// This code is contributed by Ankur Narain Verma
