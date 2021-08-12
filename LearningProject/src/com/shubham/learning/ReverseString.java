package com.shubham.learning;

public class ReverseString {

	public static void main(String[] args) {
		String s="Shubham";
		System.out.println("s --"+s);
		s=reverseString(s,s.length());
	    System.out.println("After s --"+s);
	}

	private static String reverseString(String s,int n) {
		if(n==0) {
			return "";
		}
		String str="";
		str+=s.charAt(n-1)+reverseString(s,n-1);
		return str;
	}

}
