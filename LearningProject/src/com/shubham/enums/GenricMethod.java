package com.shubham.enums;

public class GenricMethod {
	
	
	static  <T> void getOutput(T element) {
		System.out.println(" element --"+ element.getClass().getName()+"  "+element);
	}

	public static void main(String[] args) {
		getOutput("Shubham");
		getOutput(2.03f);
		getOutput(2.03d);
	}
}
