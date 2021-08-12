package com.shubham.learning;

public class Reverse {

	public static void main(String[] args) {
		String s="Shubham";
		String str=reverse(s);
		System.out.println(str);
	}

	private static String reverse(String s) {
		String str="";
		for(int i=s.length()-1;i>=0;i--) {
			char c=s.charAt(i);
			str=str+c;
		}
		return str;
	}

}
