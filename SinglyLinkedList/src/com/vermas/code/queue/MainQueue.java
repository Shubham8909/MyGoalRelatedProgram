package com.vermas.code.queue;

public class MainQueue {
	
	public static void main(String[] args) {
		
		Queue q= new Queue();
		q.inQueue(3);
		q.inQueue(5);
		q.inQueue(6);
		q.inQueue(7);
		q.inQueue(31);
		q.inQueue(1);
		q.inQueue(2);
		q.inQueue(72);
		q.inQueue(32);
		q.inQueue(54);
		q.inQueue(61);
		q.inQueue(9);
		
		q.display();
		
		System.out.println();
		System.out.println(q.deQueue());
		
		q.display();
		
		
		
		
	}

}
