package com.dp.problems;

public class ChangeCoin {

	public static void main(String[] args) {
		int arr[] = {1, 2, 3};
		int sum=5;
		System.out.println("count "+changeCoinPossibliity(arr,sum,arr.length));
	}
	
	private static int changeCoinPossibliity(int[] arr, int sum, int l) {
		int dp[][]=new int[l][sum+1];
		for(int i=0;i<l;i++) {
			for(int j=0;j<=sum;j++) {
				dp[i][j]=-1;
			}
		}
		int count= countOfchanges(dp,arr,l-1,sum);
		return count;
	}

	private static int countOfchanges(int[][] dp, int[] arr, int l, int n) {
		
		if(l==-1 && n>0 ) {
			return 0;
		}
		if(n==0) {
			return 1;
		}
		if(n<0) {
		  return 0;
		}
		if(dp[l][n]!=-1) return dp[l][n];
		return dp[l][n]=countOfchanges(dp,arr,l,n-arr[l]) + countOfchanges(dp,arr,l-1,n);
	}

}
