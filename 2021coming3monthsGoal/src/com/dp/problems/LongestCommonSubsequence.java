package com.dp.problems;

public class LongestCommonSubsequence {
	
	static int dp[][];

	public static void main(String[] args) {
		String s1 = "JAVAAID";
		String s2 = "JAVAID";
		int n = s1.length();
		int m = s2.length();
		
		long start = System.nanoTime();
		int length = LCS1(s1.toCharArray(), s2.toCharArray(), n, m);
		long end = System.nanoTime();
		System.out.println("LCS1 : " + length + " Time taken : " + (end - start));
		dp= new int[n + 1][m + 1];
		initilize(dp);
		long start1 = System.nanoTime();
		int length1 = LCS2(s1.toCharArray(), s2.toCharArray(), n, m, dp);
		long end1 = System.nanoTime();
		System.out.println("LCS2 : " + length1 + " Time taken : " + (end1 - start1));
		long start3 = System.nanoTime();
		int length3 = LCS(s1.toCharArray(), s2.toCharArray(), n, m);
		long end3 = System.nanoTime();
		System.out.println("LCS : " + length3 + " Time taken : " + (end3 - start3));
	}
	
	private static void initilize(int[][] dp2) {
		for(int i=0;i<dp2.length;i++) {
			for(int j=0;j<dp2[i].length; j++) {
				dp2[i][j]=-1;
			}
		}
		
	}

	/// Recursive Approach.....
	private static int LCS1(char[] i, char[] j, int n, int m) {
		if (n <= 0 || m <= 0)
			return 0;
		else if (i[n - 1] == j[m - 1]) {
			return 1 + LCS1(i, j, n - 1, m - 1);
		} else {
			return Math.max(LCS1(i, j, n, m - 1), LCS1(i, j, n - 1, m));
		}
	}

	/// Recursive Approach..... with memoization
	private static int LCS2(char[] i, char[] j, int n, int m, int[][] dp) {
		if (n <= 0 || m <= 0)
			return 0;
		if (dp[n][m] != -1) {	
			return dp[n][m];
		}
		else if (i[n - 1] == j[m - 1]) {
			return dp[n][m]=(1 + LCS2(i, j, n - 1, m - 1,dp));
		} else {
			return dp[n][m] = Math.max(LCS2(i, j, n, m - 1,dp), LCS2(i, j, n - 1, m,dp));
		}
	}
	
    //Bottom Approach
    public  static int LCS(char[] x, char[] y, int n, int m) {
     int [] dp= new int[m+ 1];
     
     for(int i=1;i<=n;i++){
         int prev=0;
         for(int j=1; j<=m;j++){
             int temp=dp[j];
             if(x[i-1]==y[j-1]){
                 dp[j]=prev+1;
             }else{
                 dp[j]= Math.max(dp[j],dp[j-1]);
             }
             prev=temp;
         }
     }
  return dp[m];
}
}
