package com.testing.acceseModifier;

public interface A {
	
final static int value =10;
	
	default void m1() {
		System.out.println("Its default methods");
	}
	
	static void m2() {
		System.out.println("Its Static method methods");
	}
	
}

class B implements A{

}

class Main{
	
	public static void main(String[] args) {
	    B b= new B();
	   
	}
}
