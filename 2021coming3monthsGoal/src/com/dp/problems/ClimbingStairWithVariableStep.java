package com.dp.problems;

import java.util.Arrays;
import java.util.Scanner;

public class ClimbingStairWithVariableStep {
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int step[]=new int[n];
		for(int i=0; i<n;i++) {
			step[i]=sc.nextInt();
		}
		//Recursive Approch..
		int count=recursionTotalCount(step,n);
		System.out.println("count "+count);
		sc.close();
	}

	private static int recursionTotalCount(int step[],int n) {
      	int dp[]=new int[n+1];
      	dp[n]=1;
      	for(int i=n-1;i>=0; i--) {
      		for(int j=1; j<=step[i] && i+j<dp.length; j++) {
      			dp[i]+=dp[i+j];
      		}
      	}
      	System.out.println(Arrays.toString(dp));
	  return dp[0]; 
	  
	}

}
