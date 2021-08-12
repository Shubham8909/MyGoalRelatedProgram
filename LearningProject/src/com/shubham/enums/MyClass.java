package com.shubham.enums;

public class MyClass<T> {
	void add(T t) {
		System.out.println("added");
	}
	
	public static void main(String[] args) {
		
		MyClass<Number> myc=new MyClass<>();
		
		myc.add(new Integer(4));
		myc.add(new Double(4.0));
		myc.add(4.24);
	}
}
