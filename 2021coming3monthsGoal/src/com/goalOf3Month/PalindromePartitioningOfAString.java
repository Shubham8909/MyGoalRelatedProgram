package com.goalOf3Month;

import java.util.Scanner;

public class PalindromePartitioningOfAString {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String input=sc.nextLine();
		String result="";
	    partitioning(input,result);	
		sc.close();
	}

	private static void partitioning(String input, String result) {
       if(input.length()==0) {
    	   System.out.println(result);
    	   return ;
       }
		for(int i=0; i<input.length(); i++) {
			String prefix=input.substring(0,i+1);
			String sufix=input.substring(i+1);
			if(isPalindrome(prefix)) {
				partitioning(sufix,result+"("+prefix+")");
			}
		}
	}

	private static boolean isPalindrome(String prefix) {
		int s=0;
		int l=prefix.length()-1;
		while(s<l) {
			if(prefix.charAt(s)!=prefix.charAt(l)) {
				return false;
			}
			s++;
			l--;
		}
		return true;
	}

}
