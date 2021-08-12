package com.vermas.code.linklist;

public class MainClass {
	
	public static void main(String[] args) {
		
		/*
		 * SinglyLinkedList sll=new SinglyLinkedList(); sll.insertedFirst(4);
		 * sll.insertedFirst(3); sll.insertedFirst(5); sll.insertedFirst(8);
		 * sll.insertedFirst(9);
		 * 
		 * sll.displayList();
		 * 
		 * System.out.println(); sll.deletMiddleNumber();
		 * 
		 * sll.displayList();
		 */
		
		///If for summing null removal from linked list
		/*
		 * SinglyLinkedList sl=new SinglyLinkedList(); sl.insertedlast(6);
		 * sl.insertedlast(-6); sl.insertedlast(8); sl.insertedlast(4);
		 * sl.insertedlast(-12); sl.insertedlast(9); sl.insertedlast(8);
		 * sl.insertedlast(-8);
		 * 
		 * sl.displayList();
		 * 
		 * sl.removeCancellableNodes(); System.out.println();
		 * 
		 * sl.displayList();
		 */
		
		SinglyLinkedList sl=new SinglyLinkedList();
	    sl.insertedlast(1);
		sl.insertedlast(3);
		sl.insertedlast(4);
		sl.insertedlast(6);
		sl.insertedlast(2);
		sl.insertedlast(8);
		sl.insertedlast(9);
		
		
		
		
		
		//sl.getFirst().next.next.next.next.next.next=sl.getFirst().next.next;
	
		
		sl.displayList();
		String s="";
		
		System.out.println(sl.recursionPrint1(sl.getFirst()));
		sl.displayList();
		
		
		
		//sl.TwoPartOfLinkedList();
		
	   //System.out.println(sl.checkCyclic());
	      //sl.reversePrintVaiRecursion();
		
	     // System.out.println();
		//sl.removeDuplicated();
		
		//sl.findNthTolastElement(3);
		//sl.displayList();
		//sl.deleteFirst();
		//sl.displayList();
		
		//sl.removeDuplicated();
		//System.out.println();
		
		//sl.displayList();
		
		
		/*
		 * System.out.println();
		 * System.out.println(" mid number "+sll.findMiddleNumber());
		 * 
		 * 
		 * System.out.println(); sll.displayList();
		 */
		 
		
		/*
		 * sll.deleteFirst(); System.out.println("After delete-"); sll.displayList();
		 * 
		 * sll.insertedlast(9);
		 * 
		 * System.out.println("After insertedlast-"); sll.displayList();
		 * 
		 * sll.deleteFromLast(); System.out.println("After delete from lastt-");
		 * sll.displayList();
		 * 
		 * sll.displayListFromEnd();
		 */
	}

}
