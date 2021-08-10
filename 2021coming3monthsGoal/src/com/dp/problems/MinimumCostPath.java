package com.dp.problems;

import java.util.Scanner;

public class MinimumCostPath {
	
	static int []row= {1,-1,-1,-1,1,0,1,0} ;
	static int []col= {1,-1,0,1,-1,-1,0,1} ;

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int [][] dp= new int[n][n];
		for(int i=0; i<n;i++) {
			for(int j=0; j<n;j++) {
				dp[i][j]=sc.nextInt();
			}
		}
		sc.close();
		int count=0;
		//imp..
		for(int i=0; i<n;i++) {
			for(int j=0; j<n;j++) {
				count+=rec(dp,i,j,n);
			}
		}
		
		System.out.println(count);

	}

	private static int rec(int[][] dp, int i, int j, int n) {
		int min=Integer.MAX_VALUE;
		int x=dp[i][j];
		if(i>=0 && j>=0 && i<n && j<n && dp[i][j]!=-1) {
			for(int k=0; k<8;k++) {
				if(i+row[k]>=0 && j+col[k]>=0 && i+row[k]<n && j+col[k]<n) {
					dp[i][j]=-1;
					if(i+row[k]!=n-1 && j+col[k]!=n-1)
					min=Math.min(min, rec(dp,i+row[k],j+col[k],n));
					else {
						min=dp[n-1][n-1];
					}
				}
			}
		}
		return x+min;
		
	}

}
