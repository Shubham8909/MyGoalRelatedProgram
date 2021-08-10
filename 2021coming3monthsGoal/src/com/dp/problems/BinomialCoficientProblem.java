package com.dp.problems;

/**
 * @author shubhamverma
 * 
 *         You do not need to take input or print anything. Your task is to
 *         complete the function nCr() which takes n and r as input parameters
 *         and returns nCr modulo 109+7.
 *
 */
public class BinomialCoficientProblem {

	static int nCr(int n, int r) {

		if (n < r) {
			return 0;
		}
		if ((n - r) < r)
			r = n - r;
		// returns nCr modulo 109+7.
		int mode = 1000000007;

		int dp[] = new int[r + 1];

		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = Math.min(i, r); j > 0; j--) {
				dp[j] = (dp[j] + dp[j - 1]) % mode;
			}
		}

		return dp[r];
	}
	
	public static void main(String[] args) {
		System.out.println("combination : "+nCr(5, 2));
	}

}
