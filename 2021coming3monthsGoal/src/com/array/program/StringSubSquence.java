package com.array.program;

import java.util.ArrayList;
import java.util.List;

public class StringSubSquence {

	public static void main(String[] args) {
		String s = "abc";
		List<String> list = stringSubSequence(s);

		System.out.println(list);

	}

	private static List<String> stringSubSequence(String s) {
         if(s.length()==0) {
        	 List<String> nlist = new ArrayList<>();
        	 nlist.add("");
        	 return nlist;
         }
		char ch = s.charAt(0);
		String res = s.substring(1);
		List<String> list = stringSubSequence(res); 
		List<String> nlist = new ArrayList<>();
		for (String c : list) {
			nlist.add(""+c);
		}
		for (String c : list) {
			nlist.add(ch+c);
		}
		return nlist;
	}

}
