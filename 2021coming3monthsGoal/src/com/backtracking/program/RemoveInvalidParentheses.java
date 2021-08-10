package com.backtracking.program;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class RemoveInvalidParentheses {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String str=sc.nextLine();
		//invalid  Parentheses count
		int minc=RIP(str);
		System.out.println(" RemoveInvalidParentheses "+minc);
		HashSet<String> hs= new HashSet<>();
		//valid combination...
		validCombination(str,minc,hs);
		System.out.println(hs);
		sc.close();
	}

	private static void validCombination(String str, int minc, HashSet<String> hs) {
	   if(minc==0) {
		   int nowminC=RIP(str);
		   System.out.println(nowminC);
		   if(nowminC==0) {
			   hs.add(str);
		   }
		   return;
	   }
		for(int i=0;i<str.length(); i++) {
			String left=str.substring(0,i);
			String right=str.substring(i+1);
			validCombination(left+right,minc-1,hs);
		}
	}
	private static int RIP(String str) {
		Stack<Character> st= new Stack<>();
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) =='(') {
				st.push(str.charAt(i));
			}else if(str.charAt(i) ==')' && (st.isEmpty() || st.peek()== ')') ){
				st.push(str.charAt(i));
			}else if(str.charAt(i) ==')' && !st.isEmpty() && st.peek()== '(' ){
				st.pop();
			}
		}
		return st.size();
	}

}
