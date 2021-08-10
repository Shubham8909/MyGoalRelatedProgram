package com.array.program;

import java.util.ArrayList;
import java.util.List;

public class StringSubString {

	public static void main(String[] args) {
		String s = "abc";
		List<String> list = stringSubString(s);

		System.out.println(list);

	}

	private static List<String> stringSubString(String s) {
		if (s.length() == 0) {
			List<String> nlist = new ArrayList<>();
			return nlist;
		}
		char ch = s.charAt(0);
		String res = s.substring(1);
		System.out.println("res "+res);
		List<String> list = stringSubString(res);
        
		List<String> nlist = new ArrayList<>();
		nlist.add("" + ch);

		if (list.size() == 1) {
			for (int i = 0; i < list.size(); i++) {
				nlist.add(ch + list.get(i));
			}
			nlist.add(list.get(0));
		} else if (list.size() > 1) {

			for (int i = 0; i < list.size()-1; i++) {
				nlist.add(ch + list.get(i));
			}
			nlist.add(list.get(list.size()-1));
		}

		return nlist;
	}

}
