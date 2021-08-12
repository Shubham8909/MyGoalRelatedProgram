package com.grab;

public class Node {
	
	int key;
	int value;
	Node next;

	public Node() {
		
	}
	public Node(int key, int value) {
		this.key=key;
		this.value=value;
		this.next= null;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	

}
