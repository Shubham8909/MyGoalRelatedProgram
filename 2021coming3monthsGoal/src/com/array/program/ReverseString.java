package com.array.program;

import java.util.Arrays;

public class ReverseString {

	public static void main(String[] args) {
		String str="Shubham";
		System.out.println("new Str "+ str);
		
		//method one..
		String nStr="";
		for(int i=str.length()-1 ; i>=0; i--) {
			nStr+=str.charAt(i);
		}
		System.out.println("new Str "+ nStr);
      
		
		//method 2..
		String cStr="";
		char ch[]=str.toCharArray();
		for(int i=ch.length-1 ; i>=0; i--) {
			cStr+=ch[i];
		}
		System.out.println("new cStr "+ cStr);
		
		//rescursive
		String n1Str="";
		System.out.println("recursive "+ resursive(str,n1Str,str.length()-1));
		
		//using two pointer...
		char ch1[]=str.toCharArray();
		int s=0;
		int l=ch1.length-1;
		while(s<l) {
			char c=ch1[s];
			ch1[s]=ch1[l];
			ch1[l]=c;
			s++;
			l--;
		}
       System.out.println("charactor "+new String(ch1));
	}

	private static String resursive(String str,String n1Str,int n) {
		if(n<0) {
			return "";
		}
		n1Str+=str.charAt(n)+resursive(str,n1Str,n-1);
		return n1Str;
	}

}
