package com.package1;

public class Odd implements Runnable {
	
	private Driver d;

	public Odd(Driver d) {
		super();
		this.d = d;
	}

	@Override
	public void run() {
         d.printOdd();
	}

}