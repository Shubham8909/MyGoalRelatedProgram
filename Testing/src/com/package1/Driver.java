package com.package1;

public class Driver {
	
	int max=10;
	boolean odd;
	int count=1;
	
	public void printOdd() {
		
		synchronized (this) {
			while(count<max) {
				System.out.println("In Odd thread ");
				if(!odd) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Odd :: "+count);
				count++;
				odd=false;
				notify();
			}
			
		}
		
	}
	
    public void printEven() {
    
    	synchronized (this) {
			while(count<max) {
				System.out.println("In Even thread ");
				if(odd) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Even :: "+count);
				count++;
				odd=true;
				notify();
			}
  
    	}
	}
	

	 public static void main(String[] args) {
		 
		 Driver d= new Driver();
		 d.odd=true;

		 Even e= new Even(d);
         Thread t1= new Thread(e);
         t1.start();

         Odd o= new Odd(d);
         Thread t2= new Thread(o);
         t2.start();
    
	}

}




