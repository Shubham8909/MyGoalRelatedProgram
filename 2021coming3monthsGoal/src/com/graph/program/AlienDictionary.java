package com.graph.program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDictionary {

	public static void main(String[] args) {
		String arr[] = { "baa", "abcd", "abca", "cab", "cad" };
		System.out.println(findOrder(arr, 5, 4));
	}

	public static String findOrder(String[] dict, int N, int K) {

		Map<Character, List<Character>> adj = new HashMap<>();
		for (int i = 0; i < dict.length - 1; i++) {
			ArrayList<Character> l1 = compareAndReturn(dict[i], dict[i + 1]);
			if (l1.size() > 0) {
				if (adj.containsKey(l1.get(0))) {
					adj.get(l1.get(0)).add(l1.get(1));
				} else {
					ArrayList<Character> l2 = new ArrayList<>();
					l2.add(l1.get(1));
					adj.put(l1.get(0), l2);
				}

			}
		}

		// topological sorting ..
		String result = "";

		int[] in_degreee = new int[K];
		Queue<Character> q = new LinkedList<>();

		for (Map.Entry<Character, List<Character>> entry : adj.entrySet()) {
			for (char c : entry.getValue()) {
				in_degreee[c - 'a']++;
			}
		}
		for (int i = 0; i < K; i++) {
			if (in_degreee[i] == 0) {
				q.add((char) ('a' + i));
			}
		}
		
		while (!q.isEmpty()) {
			char uu = q.poll();
			result = result + uu;
			List<Character> listc = adj.get(uu);
			if (listc == null) {
				continue;
			}
			for (int i = 0; i < listc.size(); i++) {
				char x = listc.get(i);
				in_degreee[x - 'a']--;
				if (in_degreee[x - 'a'] == 0) {
					q.add(x);
				}
			}
		}

		System.out.println("result " + result);

		return result;
	}

	public static ArrayList<Character> compareAndReturn(String s1, String s2) {
		ArrayList<Character> l1 = new ArrayList<>();
		for (int i = 0; i < (s1.length() > s2.length() ? s2.length() : s1.length()); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				l1.add(s1.charAt(i));
				l1.add(s2.charAt(i));
				return l1;
			}
		}
		return l1;
	}
}