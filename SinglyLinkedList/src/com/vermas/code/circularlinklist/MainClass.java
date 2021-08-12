package com.vermas.code.circularlinklist;

public class MainClass {
	
	public static void main(String[] args) {
		
		CircularLinkedList c=new CircularLinkedList();
		
		
		c.insertInLast(2);
		c.insertInLast(8);
		
		c.insertINStart(1);
		c.insertINStart(5);
		c.insertINStart(6);
		c.insertINStart(3);
		
		c.display();
		
		System.out.println(c.last.data);
		System.out.println(c.first.data);
		
	}

}
