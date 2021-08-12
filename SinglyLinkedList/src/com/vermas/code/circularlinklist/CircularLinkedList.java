package com.vermas.code.circularlinklist;

public class CircularLinkedList {
	
	public Node first;
	public Node last;
	
	public CircularLinkedList() {
	}
	
	public void insertINStart(int data) {
		Node newNode = new Node();
		newNode.data=data;
		if(first==null) {
			last=newNode;
		}
		newNode.next=first;
		first = newNode;
		
	}
	
	public void insertInLast(int data) {
		Node newNode = new Node();
		newNode.data=data;
		
		if(first==null) {
			first=newNode;
		}
		if(last==null) {
			last=newNode;
		}else {
			last.next=newNode;
			last=newNode;
		}
	}
	
	
	
	public void display() {
		Node curr=first;
		while (curr!=null) {
			curr.display();
			curr= curr.next;
		}
	}
	
	

}
