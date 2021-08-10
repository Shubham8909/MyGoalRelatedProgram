package com.dp.problems;

import java.util.Scanner;

public class ClimbingStair {

	/// we can reach source to destination vai 1 2 3 step..
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter climb Stair ");
		int n = sc.nextInt();
		// Recursion
		long start = System.nanoTime();
		int numberOfCount = recursionTotalCount(n);
		long end = System.nanoTime();
		System.out.println("Count recr : " + numberOfCount + " Time taken : " + (end - start));

		// Memoization

		long start1 = System.nanoTime();
		int dp[] = new int[n + 1];
		int numberOfCount1 = memoizationTotalCount(n, dp);
		long end1 = System.nanoTime();
		System.out.println("Count memo : " + numberOfCount1 + " Time taken : " + (end1 - start1));

		// tabulor..
		long start2 = System.nanoTime();
		int numberOfCount2 = tabularTotalCount(n);
		long end2 = System.nanoTime();
		System.out.println("Count tabulor : " + numberOfCount2 + " Time taken : " + (end2 - start2));

		sc.close();
	}

	private static int tabularTotalCount(int n) {

		int dp[] = new int[n + 1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			if (i == 1) {
				dp[i] = dp[i - 1];
			} else if (i == 2) {
				dp[i] = dp[i - 1] + dp[i - 2];
			} else {
				dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
			}
		}
		return dp[n];
	}

	private static int memoizationTotalCount(int n, int[] dp) {
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			return 0;
		}
		if (dp[n] != 0) {
			return dp[n];
		}
		int n1 = recursionTotalCount(n - 1);
		int n2 = recursionTotalCount(n - 2);
		int n3 = recursionTotalCount(n - 3);
		return dp[n] = n1 + n2 + n3;
	}

	private static int recursionTotalCount(int n) {
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			return 0;
		}
		int n1 = recursionTotalCount(n - 1);
		int n2 = recursionTotalCount(n - 2);
		int n3 = recursionTotalCount(n - 3);

		return n1 + n2 + n3;
	}

}
