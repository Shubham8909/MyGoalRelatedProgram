package com.hackerRank.problem;

import java.util.Arrays;
import java.util.List;

/*
 * It is New Year's Day and people are in line for the Wonderland rollercoaster ride.
 *  Each person wears a sticker indicating their initial position in the queue from  to .
 *   Any person can bribe the person directly in front of them to swap positions, but they
 *   still wear their original sticker. One person can bribe at most two others.
Determine the minimum number of bribes that took place to get to a given queue order.
 Print the number of bribes, or, if anyone has bribed more than two people,
  print Too chaotic.

Example

If person  bribes person , the queue will look like this: .
 Only  bribe is required. Print 1.
Person  had to bribe  people to get to the current position. Print Too chaotic.
 * 
 * 
 */

public class NewYearChosProblem {
	public static void main(String[] args) {
		Integer arr[]= {1, 2, 5, 3, 7, 8, 6, 4};
		minimumBribes(Arrays.asList(arr));
	
	}

	public static void minimumBribes(List<Integer> q) {
		// Write your code here
		// [2, 5, 1, 3, 4]
		int count = 0;
		for (int i = q.size() - 1; i >= 0; i--) {
			if (q.get(i) != i + 1) {
				if (q.get(i - 1) == i + 1) {
					count++;
					swap(q, i, i - 1);
				} else if (q.get(i - 2) == i + 1) {
					count += 2;
					swap(q, i - 2, i - 1);
					swap(q, i - 1, i);
				} else {
					System.out.println("Too chaotic");
					return;
				}
			}
		}
		System.out.println(count);
	}

	static void swap(List<Integer> q, int i, int j) {
		int x = q.get(i);
		q.set(i, q.get(j));
		q.set(j, x);
	}

}
