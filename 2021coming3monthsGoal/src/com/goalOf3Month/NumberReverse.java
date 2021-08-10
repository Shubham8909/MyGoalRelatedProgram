package com.goalOf3Month;

import java.util.ArrayList;
import java.util.List;

public class NumberReverse {

	public static void main(String[] args) {
		
		int s=2534;
		System.out.println(reverse(s));
	}

	private static int reverse(int s) {
		
		 List<Long> area= new ArrayList<>();
	  String rev="";
	   while(s>0) {
		   rev+=s%10;
		   s=s/10;
	   }
		return Integer.parseInt(rev);
	}

}
