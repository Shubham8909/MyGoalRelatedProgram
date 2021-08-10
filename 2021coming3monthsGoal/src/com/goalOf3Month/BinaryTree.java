package com.goalOf3Month;

public class BinaryTree {
	
	int level=0;

	public static void main(String[] args) {

	}

	/*
	 * 4 / \ 2 6 / \ / \ 1 3 5 7
	 */

	// definition of BST :: BSTs can not contain duplicate Nodes or
	// left node will be lesser then the root node or right node will
	// be greater then the root node.

	boolean checkBST(Node n) {
		return utilBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean utilBST(Node n, int min, int max) {
		if (n == null) {
			return true;
		}
		if (n.data < min || n.data > max) {
			return false;
		}
		return (utilBST(n.left, min, n.data - 1) && utilBST(n.right, n.data + 1, max));
	}

	// Left/Right view of BST 
	void leftViewOfBST(Node n) {
	    
		UtilLeftViewOBST(n,1);
		UtilRightViewOBST(n,1);
	}

	private void UtilLeftViewOBST(Node n, int max_level) {
		if(n==null)return;
		
		if(level<max_level) {
			System.out.println(n.data+" ");
			level=max_level;
		}
		UtilLeftViewOBST(n.left,max_level+1);
		UtilLeftViewOBST(n.right,max_level+1);
		
	}
	
	private void UtilRightViewOBST(Node n, int max_level) {
		if(n==null)return;
		
		if(level<max_level) {
			System.out.println(n.data+" ");
			level=max_level;
		}
		UtilRightViewOBST(n.right,max_level+1);
		UtilRightViewOBST(n.left,max_level+1);
		
	}
}

class Node {

	Node left;
	Node right;
	int data;

}
