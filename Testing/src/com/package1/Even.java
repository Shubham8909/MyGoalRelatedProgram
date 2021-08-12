package com.package1;

public class Even implements Runnable {
	
	private Driver d;
	
	public Even(Driver d) {
		super();
		this.d = d;
	}



	@Override
	public void run() {
  	      d.printEven();
	}

}
