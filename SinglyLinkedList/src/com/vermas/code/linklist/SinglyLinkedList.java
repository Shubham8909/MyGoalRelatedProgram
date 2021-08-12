package com.vermas.code.linklist;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;

import com.vermas.code.stack.StackUsed;

public class SinglyLinkedList {
	
	private Node first;
	int size;
	
	public SinglyLinkedList() {
		
	}

	public boolean isEmpty() {
		return first==null;
	}
	 //4 3 2 1
	public void insertedFirst(int data) {
		Node newNode= new Node();
		newNode.data=data;
		newNode.next=first;
		first=newNode;
	}
	
	public void insertedlast(int data) {
		
		if(first==null) {
			size++;
			Node newNode= new Node();
			newNode.data=data;
			newNode.next=first;
			first=newNode;
		}else {
		Node current= first;
		
		while(current.next!=null) {
			current= current.next;
		}
		size++;
		//current get null here..
		Node newNode= new Node();
		newNode.data=data;
		current.next=newNode;
	}
}
///	123456
public void deleteFromLast() {
		Node current= first;
		while(current.next.next!=null) {
			current= current.next;
		}
		current.next=null;
		size--;
	}

// 1 ->2 ->3 ->null;
public void deleteFromLast2() {
	if(first==null)return ;
	Node current= first.next;
	Node prev=first;
	while(current.next!=null) {
		 prev=current;
		 current= current.next;
	}
	prev.next=current.next;
}

	public void deleteFirst() {
		first= first.next;
		size--;
	} 
	
	
	//(First---->End)
	public void displayList() {
		Node current= first;
		while(current!=null) {
			current.displayNode();
			current=current.next;
		}
		System.out.println();
	}
	
	//(First---->End)
	public void displayList(Node n) {
		Node current= n;
		while(current!=null) {
			current.displayNode();
			current=current.next;
		}
		System.out.println();
	}
	
	
	// 1 ->2 ->3 ->4->null;
	        
	public int findMiddleNumber() {
		int count =0;
		int midPostion=0;
		Node mid=first;Node curr=first;
		while(curr!=null) {
			if((count%2)==1) {
				midPostion++;
				mid=mid.next;
			}
			count++;
			curr=curr.next;
		}
		if(mid!=null) {
			return mid.data;
		}
		return -1;
	}
	
	
	// 1 ->2 ->3 ->4->null;
    
		public int findMiddleNumber2() {
			if(first == null) return -1;
			Node curr=first;
			Node forward=first.next;
			int frwdP=2;
			while(forward!=null) {
				  if(forward.next==null) break;
				  frwdP++;
				  if(forward.next.next==null) break;
				  frwdP++;
				  curr=curr.next;
				  forward=forward.next.next;
			}
		
			if(frwdP%2==0)  return curr.data;
			else return curr.next.data;
		}
	
	void removeCancellableNodes()
	{
		Node dummy= new Node();
		dummy.next=first;
		Map<Integer,Node> map = new Hashtable<Integer,Node>();
		int sum=0;
		map.put(sum, dummy);
	    while(first!=null) {
	    	sum+=first.data;
	    	if(map.containsKey(sum)) {
	    		Node nextNode=map.get(sum).next;
	    		int sumNode=sum;
	    		while(nextNode!=first) {
	    			sumNode+=nextNode.data;
	    			map.remove(sumNode);
	    			nextNode=nextNode.next;
	    		}
	    		map.get(sum).next=first.next;
	    	}else {
	    		map.put(sum, first);
	    	}
	    		first=first.next;
	    }
	    first=dummy.next;
	}
	
	
	public void removeDuplicated() {
		Map<Integer,Node> map = new Hashtable<Integer,Node>();
		Node dummy=first;
		Node prev=first;
		
		 while(dummy!=null) {
			 int key=dummy.data;
			 if(map.containsKey(key)) {
				 prev.next=dummy.next;
			 }else {
				 map.put(key, dummy);
				 prev=dummy;
			 }
			 dummy=dummy.next;
		 }
		 
	}
	
	//1 2 3 4  5 --null;
	public void deletMiddleNumber() {
		Node fast,slow,prev;
		slow=fast=prev=first;
		while(fast!=null) {
			fast=fast.next;
			if(fast==null)break;
			prev=slow;
			fast=fast.next;
			slow=slow.next;
		}
		prev.next=slow.next;
	}
	//(First---->End)
	public void displayListFromEnd() {
		Node current= first;
		StackUsed s=new StackUsed();
		while(current!=null) {
			s.push(current.data);
			current=current.next;
		}
		s.display();
		System.out.println();
	}
	
	//prv =
	 //prve=   2 -->1->prev
	//2 3 4 5 --> null
	
// curr =>  3 4 5
	public void reverse() {
		Node curr=first;
		Node prev=null;
		Node next=null;
		
	while(curr!=null) {
		next=curr.next;
		curr.next=prev;
		prev=curr;
		curr=next;
	}
	first=prev;
	}
	
	public void reversePrintVaiRecursion( ) {
		
		recursionPrint(first);
	}
	
	
	//check linked list is cyclic or not
	public boolean checkCyclic() {
		Node n=first;
		Map<Node,Integer> map= new HashMap<Node, Integer>();
		int count=0;
		while(n!=null) {
		n.displayNode();
		if(map.containsKey(n)) {
			int value=map.get(n);
			System.out.println("in condition..");
			n.displayNode();
			System.out.println("Loop size "+(count-value+1));
			return true;
		}
		 count++;
		 map.put(n, count);
		 n=n.next;
		}
		
		return false;
	}
	
private void recursionPrint(Node n) {
		if(n==null) return;
	     recursionPrint(n.next);
	     n.displayNode();
	}

public String recursionPrint1(Node n) {
	String s="";
	if(n==null) return "";
     s=recursionPrint1(n.next);
     s=s.concat(String.valueOf(n.data));
     
     return s;
}

//	1 2 3 4 5 6->null
	/////Write a function to find nth to last element of the list...
	
	public Node findNthTolastElement(int n) {
		Node curr=first;
		Node nthStartPosition=first;
		for(int i=0;i<n;i++) {
			if(curr==null) return null;
			curr=curr.next;
		}
		while(curr!=null) {
			curr=curr.next;
			nthStartPosition=nthStartPosition.next;
		}
		first=nthStartPosition;
		return first;
	}

	public Node getFirst() {
		return first;
	}
	
	
	
	
	
	//1 2 3 4 5 -> null
	
	///half of linklist
	public Node TwoPartOfLinkedList() {
		Node forward=first.next;
		Node curr=first;
		
		while(forward!=null) {
			forward=forward.next;
			if(forward==null) break;
			forward=forward.next;
			curr=curr.next;

		}
		Node half=curr.next;
		curr.next=null;
		
		displayList(half);
		
		return half;
		
	}
	
	  public Node rotate( int k) {
	        Node curr=first;
	        Node half=null;
	      
	        for(int i=1; i<k; i++){
	            if(curr==null) return null;
	            curr= curr.next;
	        }
	        if(curr!=null){
	          half=curr.next;
	          curr.next=null;
	        }else return null;
	        
	        return rotation(half,first);
	    }
	    
	    Node rotation(Node half,Node head){
	        Node n= half;
	        while (n.next!=null){
	            n=n.next;
	        }
	        n.next=head;
	        first=half;
	        return first;
	    }
	    
	    
	    
	
}

