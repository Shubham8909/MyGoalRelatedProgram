package com.dp.problems;

public class KnapsackProblem {
	
	public static void main(String[] args) {
		int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println("Max -: "+knapSackMemoiZation(W, wt, val, n));
        System.out.println("Max -: "+knapSackTabular(W, wt, val, n));
        
	}
	
	private static int knapSackTabular(int w, int[] wt, int[] val, int n) {
		int dp[][]=new int[n+1][w+1];
		return maxValuePossiblilityBYTabular(dp,w, wt, val);
	}

	private static int maxValuePossiblilityBYTabular(int[][] dp, int w, int[] wt, int[] val) {
		
		for(int i=1; i<dp.length; i++) {
			for(int j=1; j<dp[0].length; j++) {
				if(j>=wt[i-1]) {
					int rCap=j-wt[i-1];
					if(dp[i-1][rCap]+val[i-1]>dp[i-1][j]) {
						dp[i][j]=dp[i-1][rCap]+val[i-1];
					}else {
						dp[i][j]=dp[i-1][j];
					}
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}

	private static int knapSackMemoiZation(int w, int[] wt, int[] val, int n) {
		int dp[][]=new int[n][w+1];
		for(int i=0;i<n;i++) {
			for(int j=0;j<=w;j++) {
				dp[i][j]=-1;
			}
		}
		return maxValuePossiblility(dp,w, wt, val, n-1);
	}

	private static int maxValuePossiblility(int[][] dp, int w, int[] wt, int[] val, int n) {
		if(w==0 || n<0 ) {
			return 0;
		}
		if(dp[n][w]!=-1) return dp[n][w];
		
		if(wt[n]>w) {
			return dp[n][w]=maxValuePossiblility(dp,w, wt, val, n-1);
		}
		int a,b;
		a=val[n]+ maxValuePossiblility(dp,w-wt[n], wt, val, n-1);
		b=maxValuePossiblility(dp,w, wt, val, n-1);
		
		return Math.max(a, b) ;
	}

}
