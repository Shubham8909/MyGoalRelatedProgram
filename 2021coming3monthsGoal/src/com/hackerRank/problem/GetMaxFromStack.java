package com.hackerRank.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GetMaxFromStack {
	public static List<Integer> getMax(List<String> operations) {

		int max = 0;
		Stack<Integer> s1 = new Stack<>();
		List<Integer> list = new ArrayList<Integer>();
		for (String s : operations) {
			if (s.startsWith("1")) {
				s = s.replace("1 ", "");
				int value = Integer.parseInt(s);
				if (value > max) {
					int tmp = 2 * value - max;
					max = value;
					s1.push(tmp);
				} else
					s1.push(value);

			} else if (s.startsWith("2")) {
				if (!s1.isEmpty()) {
					int x = s1.peek();
					if (x > max) {
						max = 2 * max - x;
					}
					s1.pop();
				}
			} else if (s.startsWith("3")) {
				list.add(max);
			}
		}

		return list;
	}
}
