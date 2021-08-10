package com.recurion.program;

public class Permutations {

	public static void main(String[] args) {
		String str = "abc";
		printPermutations(str,"");
	}

	private static void printPermutations(String str,String ans) {
		
		if(str.length()==0) {
			System.out.println(ans);
			return;
		}
		for(int i=0; i<str.length(); i++) {
			char ch=str.charAt(i);
			String prev=str.substring(0,i);
			String last=str.substring(i+1);
			printPermutations(prev+last,ans+ch);
		}

	}
}
