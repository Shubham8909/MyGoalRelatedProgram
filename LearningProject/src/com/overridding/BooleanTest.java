package com.overridding;

public class BooleanTest {

	public static void main(String[] args) {
		Boolean a=new Boolean(true);
		Boolean b=new Boolean(true);
		System.out.println(a==b);
		boolean value=a.booleanValue();
		System.out.println(!value);
		
		System.out.println(a && b);

	}

}
