package com.shubham.binary;

public class CheckBST {
	
	Node root;
	
	public CheckBST() {
		root=null;
	}

	/*
	 *  2 
	 * / \
	 *1   3
	 */
	public static boolean checkBST(com.shubham.binary.BinarySearchTree.Node root2) {
		return utilBST(root2,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	private static boolean utilBST(com.shubham.binary.BinarySearchTree.Node root, int minValue, int maxValue) {
		if(root==null) {
			return true;
		}
		if(root.key<minValue || root.key>maxValue) {
			return false;
		}
		
		return (utilBST(root.left,minValue,root.key-1) && utilBST(root.right, root.key+1 ,maxValue));
	}

	class Node{
		int key;
		Node left;
		Node right;
		public Node(int item)
		{
			key = item;
			left = right = null;
		}
	}
	
	
	
	public static void main(String[] args) {
		
	}

}
