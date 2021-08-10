package com.goalOf3Month;

import java.util.LinkedList;
import java.util.Queue;

public class ShortedChainTOReachTarget {

	public static void main(String[] args) {
		String dic[] = { "POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN" };
		String start = "TOON";
		String target = "PLEA";
		int length = reachTarget(dic, start, target);
		System.out.println(" Chain to reach Target = " + length);
	}

	private static int reachTarget(String[] dic, String start, String target) {
		boolean visited[] = new boolean[dic.length];
		Queue<WordsProp> queue = new LinkedList<>();
		queue.add(new WordsProp(start, 1));
		while (queue.size() != 0) {
			WordsProp wordsProp = queue.poll();
			for (int i = 0; i < dic.length; i++) {
				if (!visited[i] && checkIf1WordDIff(wordsProp.s, dic[i])) {
					wordsProp.l = wordsProp.l + 1;
					wordsProp.s = dic[i];
					queue.add(wordsProp);
					visited[i] = true;
					if (dic[i].equals(target)) {
						return wordsProp.l;
					}
				}
			}
		}

		return 0;
	}

	public static boolean checkIf1WordDIff(String s1, String s2) {
		int count = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i))
				count++;
			if (count > 1)
				return false;
		}
		return true;
	}
}

class WordsProp {
	String s;
	int l;

	public WordsProp(String s, int l) {
		super();
		this.s = s;
		this.l = l;
	}
}
