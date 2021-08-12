package com.vermas.code.queue;

public class Queue {
	
	private Integer [] queue;
	private int size;
	private int front;
	private int rear;
	private int total;
	
	public Queue() {
		this.size=10;
		this.total=0;
		this.queue= new Integer [size];
		this.front=0;
		this.rear=0;
	}
	
	public Queue(int a) {
		this.size=a;
		this.total=0;
		this.queue= new Integer [size];
		this.front=0;
		this.rear=0;
	}
	
	public boolean isEmpty() {
		return total==0;
	}
	
	public boolean isFull() {
		return total==size;
	}
	
	public boolean inQueue(int a) {
		if(isFull()) {
			increaseSize();
		}
			total++;
			queue[rear]=a;
			rear++;
			return true;
	
	}
	
	private void increaseSize() {
		Integer[] q= new Integer[20];
		this.size=20;
		for(int i=0; i<queue.length; i++) {
			q[i]=queue[i];
		}
		this.queue=q;
		System.out.println("length -:"+queue.length);
		
	}

	public int deQueue() {
		if(!isEmpty()) {
			int item=queue[front];
			front=(front+1) % size;
			total--;
			return item;
		}else {
			return -1;
		}
	}
	
	public void display() {
		if(!isEmpty()) {
			for(int i=rear-1; i>=front; i--) {
				System.out.println("DATA -"+queue[i]);
			}
		}
	}

}
