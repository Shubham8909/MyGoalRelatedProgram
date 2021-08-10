package com.goalOf3Month;



public class Printallnodesthatdonthavesibling {

	public static void main(String[] args) {
		

	}

	  
	public void DontHavingSibling(Node3 root) {
		utilDontHavingSibling(root);
	}


	private void utilDontHavingSibling(Node3 root) {
		if(root==null) return;
		if(root.left!=null && root.right!=null) {
			utilDontHavingSibling(root.left);
			utilDontHavingSibling(root.right);
		}
		else if(root.left!=null) {
			System.out.println(root.left.data);
			utilDontHavingSibling(root.left);
		}
		else if(root.right!=null) {
			System.out.println(root.right.data);
			utilDontHavingSibling(root.right);
		}
	}
	
}

class Node3{
	int data;
	Node3 left;
	Node3 right;
}
