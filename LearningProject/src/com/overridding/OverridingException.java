package com.overridding;

import java.io.IOException;

public  class OverridingException {
	public void m1() {
		System.out.println(" m1 from super");
	}
	public static void main(String[] args) throws Exception {
		OverridingException o= new OverridingException();
		o.m1();
	}
}
class child extends OverridingException{
	
	///uncomment and check it will throw compile time error.
	@Override
	  public void m1(){
		  System.out.println(" m1 from child.");
	  }
	  
	  
	 
}
