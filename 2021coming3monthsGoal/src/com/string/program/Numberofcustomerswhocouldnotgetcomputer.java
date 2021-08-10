package com.string.program;

import java.util.HashMap;
import java.util.Map;

public class Numberofcustomerswhocouldnotgetcomputer {

	public static void main(String[] args) {
		int c = 3;
		String str = "GACCBDDBAGEE";
		// Time and space complexity O(n).
		int numberOfC = dontgetComputerUsingMap(c, str);
		System.out.println(" numberOfC " + numberOfC);

		int numberOfC1 = dontgetComputerUsingAsIIC(c, str);
		System.out.println(" numberOfC1 " + numberOfC1);
		

	}

	private static int dontgetComputerUsingAsIIC(int c, String str) {
		int charFre[] = new int[26];
		int count = 0;
		int customerDontGetChances = 0;
		for (int i = 0; i < str.length(); i++) {
			if (count > c) {
				customerDontGetChances++;
			}
			if (charFre[str.charAt(i)-'A'] > 0) {
				count--;
				charFre[str.charAt(i)-'A']--;
			} else if (charFre[str.charAt(i)-'A'] == 0) {
				count++;
				charFre[str.charAt(i)-'A']++;
			}
		}

		return customerDontGetChances;
	}

	private static int dontgetComputerUsingMap(int c, String str) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int count = 0;
		int customerDontGetChances = 0;
		for (int i = 0; i < str.length(); i++) {
			if (count > c) {
				customerDontGetChances++;
			}
			if (map.containsKey(str.charAt(i)) && map.get(str.charAt(i)) > 0) {
				count--;
				map.put(str.charAt(i), map.get(str.charAt(i)) - 1);
			} else {
				count++;
				map.put(str.charAt(i), 1);
			}
		}
		return customerDontGetChances;
	}

}
