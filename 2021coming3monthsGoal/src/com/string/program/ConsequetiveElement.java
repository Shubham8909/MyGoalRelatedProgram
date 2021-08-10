package com.string.program;

public class ConsequetiveElement {

	
	public static void main(String[] args) {
		
		
		String str="aababbccd";
		String finalStr= removeDuplicate(str);
		System.out.println(" final "+finalStr);
	}

	private static String removeDuplicate(String str) {
		
		int i=0,j=1;
		String finalStr=""+str.charAt(0);
		
		while(j<str.length()) {
			if(str.charAt(i)!=str.charAt(j)) {
				finalStr+=str.charAt(j);
				i=j;
				j++;
			}else {
				j++;
			}
		}
		return finalStr;
	}
}
