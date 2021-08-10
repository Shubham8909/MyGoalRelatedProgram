package com.goalOf3Month;

public class MiddleElementInLinkedList {

	public static void main(String[] args) {

	}
   // 1 2 3 4 5 6
	public static int MiddleEliment(Node2 n) {
		Node2 curr=n;
		Node2 prev=n;
		while(curr!=null && curr.next!=null) {
			prev=prev.next;
			curr=curr.next.next;
		}
		return prev.data;
	}
	
	// 1 2 3 4 5 6
	  public Node2 reverse(Node2 n) {
		  
		  Node2 curr=n;
		  Node2 next=null;
		  Node2 prev=null;
		  while(curr!=null) {
			  next=curr.next;
			  curr.next=prev;
			  prev=curr;
			  curr=next;
		  }
		  return prev;
	  }
	  // 1 2 3 4 5 6 7 8 
  public Node2 rotate(Node2 n, int k) {
		  
		  Node2 curr=n;
		  Node2 half=null;
		
		  for(int i=0;i<k;i++) {
			  if(curr== null) return null;
			  curr=curr.next;
		  }
		  
		  if(curr!=null) {
			  half=curr.next;
			  curr.next=null;
		  }
		  
		  Node2 first=n;
          
		  while(first.next!=null) {
			  first=first.next;
		  }
	     
		  first.next=half;
		  
		  return n;
	  }
   // 1 2 3 4 
  public void deleteWithoutPointer(Node2 n) {
	  Node2 temp=n.next;
	  n.data=temp.data;
	  n.next=temp.next;
	  
  }
	  
	  

}

class Node2 {
	int data;
	Node2 next;
}
