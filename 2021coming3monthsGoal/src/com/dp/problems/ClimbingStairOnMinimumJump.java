package com.dp.problems;

import java.util.Arrays;
import java.util.Scanner;

public class ClimbingStairOnMinimumJump {
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int step[]=new int[n];
		for(int i=0; i<n;i++) {
			step[i]=sc.nextInt();
		}
		int minJump=reachedSRCtoDESInminimumjump(step,n);
		System.out.println("Minimum Step "+minJump);
		int maxJump=reachedSRCtoDESInMaxjump(step,n);
		System.out.println("Maximum Step "+maxJump);
		sc.close();
	}

	private static int reachedSRCtoDESInMaxjump(int[] step, int n) {
		Integer[] dp= new Integer[n+1];
		dp[n]=0;

		for (int i = n - 1; i >= 0; i--) {
			if (step[i] > 0) {
				int max = Integer.MIN_VALUE;
				for (int j = 1; j <= step[i] && i + j < dp.length; j++) {
					if (dp[i + j] != null)
						max = Math.max(max, dp[i + j]);
				}
				if (max != Integer.MIN_VALUE) {
					dp[i] = max + 1;
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[0];
	}

	private static int reachedSRCtoDESInminimumjump(int[] step, int n) {
		Integer[] dp= new Integer[n+1];
		dp[n]=0;
		for (int i = n - 1; i >= 0; i--) {
			if (step[i] > 0) {
				int min = Integer.MAX_VALUE;
				for (int j = 1; j <= step[i] && i + j < dp.length; j++) {
					if (dp[i + j] != null)
						min = Math.min(min, dp[i + j]);
				}
				if (min != Integer.MAX_VALUE) {
					dp[i] = min + 1;
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[0];
	}

}
