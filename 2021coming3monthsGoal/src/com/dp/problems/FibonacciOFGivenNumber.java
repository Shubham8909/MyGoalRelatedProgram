package com.dp.problems;

import java.util.Scanner;

public class FibonacciOFGivenNumber {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter number : ");
		int n=sc.nextInt();
		
		//recursive
		long start=System.nanoTime();
        int ValueOfn=recursiveApproch(n);
        long end=System.nanoTime();
        System.out.println(" value :"+ValueOfn+" Time taken : "+ (end-start));
       
        //memo
        
        int dp[]= new int[n+1];
        long start1=System.nanoTime();
        int ValueOfn1=memoApproch(n,dp);
        long end1=System.nanoTime();
        System.out.println(" value1 :"+ValueOfn1+" Time taken : "+ (end1-start1));
        
        
        //tabular
        long start2=System.nanoTime();
        int ValueOfn2=tabularApproch(n);
        long end2=System.nanoTime();
        System.out.println(" value2 :"+ValueOfn2+" Time taken : "+ (end2-start2));
        
		sc.close();
	}

	private static int tabularApproch(int n) {
		if(n<0) return 0;
		int dp[]= new int[n+1];
		dp[0]=0;
		dp[1]=1;
		for(int i=2; i<=n; i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		return dp[n];
	}

	private static int memoApproch(int n, int[] dp) {
		if(n<=0) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		if(dp[n]!=0) {
			return dp[n];
		}
		return dp[n]=memoApproch(n-1,dp)+memoApproch(n-2,dp);
		
	}

	private static int recursiveApproch(int n) {
		if(n<=0) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		return recursiveApproch(n-1)+recursiveApproch(n-2);
	}

}
