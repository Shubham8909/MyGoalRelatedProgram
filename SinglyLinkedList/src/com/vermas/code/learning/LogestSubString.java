package com.vermas.code.learning;

public class LogestSubString {
	
	public static void main(String[] args) {
		
		String str="abcaefgdab";
		longest(str);
	}

	private static void longest(String str) {
		
		String longestStringTillNow="";
		String longestString="";
		for (int i = 0; i < str.length(); i++) {
			if (longestStringTillNow.contains(String.valueOf(str.charAt(i)))) {
							longestStringTillNow = "";
			} 
			longestStringTillNow += str.charAt(i);
			if (longestStringTillNow.length() > longestString.length()) {
				longestString = longestStringTillNow;
			}
		}
		System.out.println("longestString  "+longestString);
	}

}
