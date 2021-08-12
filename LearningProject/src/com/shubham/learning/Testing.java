package com.shubham.learning;

public class Testing {
	public static void main(String[] args) {

		
	System.out.println("method "+method(-5));
	String str= method1(3,6,7);
	System.out.println("method1 "+str);
	
	}
	
	
	public static int method(Integer i) {
		
		int a=i<0?-i:i;
		
		return a;
	}

	
	public static String method1(int i, int j, int k) {

		StringBuilder sf = new StringBuilder();
		
		int first=i>j?i:j;
		first=first>k?first:k;
	 
		

		return sf.toString();
	}
}
