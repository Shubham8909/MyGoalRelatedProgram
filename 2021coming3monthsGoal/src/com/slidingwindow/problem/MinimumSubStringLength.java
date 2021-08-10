package com.slidingwindow.problem;

import java.util.HashMap;
import java.util.Map;

//Find the smallest window in a string containing all characters of another string
public class MinimumSubStringLength {

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		String ans = minimumSubStringWiindowFromString(s, t);
		System.out.println("Ans " + ans);
	}

	private static String minimumSubStringWiindowFromString(String s, String t) {

		String ans = "";
		// Get FrequencyOf t character..
		Map<Character, Integer> mapFort = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			char ch = t.charAt(i);
			mapFort.put(ch, mapFort.getOrDefault(ch, 0) + 1);
		}

		int mcs = 0;
		int dmcs = t.length();
		Map<Character, Integer> mapFors = new HashMap<Character, Integer>();
		int i = -1, j = -1;

		while (true) {
			boolean acqFlag = false;
			boolean relFalg = false;
			// acquire the character
			while (i < s.length() - 1 && mcs < dmcs) {
				i++;
				char ch = s.charAt(i);
				mapFors.put(ch, mapFors.getOrDefault(ch, 0) + 1);

				if (mapFors.getOrDefault(ch, 0) <= mapFort.getOrDefault(ch, 0)) {
					mcs++;
				}
				acqFlag = true;
			}

			// update ans and release the char
			while (j < i && mcs == dmcs) {
				String pans = s.substring(j + 1, i + 1);
				if (ans.length() == 0 || pans.length() < ans.length()) {
					ans = pans;
				}
				j++;
				char ch = s.charAt(j);

				if (mapFors.get(ch) == 1) {
					mapFors.remove(ch);
				} else {
					mapFors.put(ch, mapFors.get(ch) - 1);
				}
                
				if (mapFors.getOrDefault(ch, 0) < mapFort.getOrDefault(ch, 0)) {
					mcs--;
				}
				relFalg = true;
			}

			if (relFalg == false && acqFlag == false) {
				break;
			}

		}

		return ans;
	}

}
