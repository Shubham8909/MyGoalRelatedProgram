package com.backtracking.program;

import java.util.Scanner;

public class SumOfSubSet {

	public static void main(String[] args) {
		 Scanner sc= new Scanner(System.in);
		 int n=sc.nextInt();
		 int wArr[]= new int [n];
		 int totalSum=0;
		 for(int i=0; i<n; i++) {
			 wArr[i]=sc.nextInt();
			 totalSum+=wArr[i];
		 }
		 int sum=sc.nextInt();
		 //Recursion
		 long start=System.nanoTime();
		 solutions(sum,wArr,0,"",0);
		 long last=System.nanoTime();
		 
		 System.out.println("time "+(last-start));
		 //BackTracking..
		 long start1=System.nanoTime();
		 solutions1(sum,wArr,0,"",0,totalSum);
		 long last1=System.nanoTime();
		 System.out.println("time1 "+(last1-start1));
		 sc.close();

	}

	private static void solutions1(int sum, int[] wArr, int i, String string, int res, int totalSum) {
		if(i>=wArr.length) {
			if(sum==res)
				System.out.println(string);
			return;
		}
		if(res+wArr[i]<=sum || totalSum>0) {
			 totalSum=totalSum-wArr[i];
			 solutions1(sum,wArr,i+1,string!=""?string+","+wArr[i]:wArr[i]+"",res+wArr[i],totalSum);
			 totalSum=totalSum+wArr[i];
			 solutions1(sum,wArr,i+1,string,res,totalSum);
		}
		
	}

	private static void solutions(int sum, int[] wArr, int i, String string, int res) {
		if(i==wArr.length) {
			if(sum==res)
			System.out.println(string);
			return;
		}
		 solutions(sum,wArr,i+1,string!=""?string+","+wArr[i]:wArr[i]+"",res+wArr[i]);
		 solutions(sum,wArr,i+1,string,res);
	}


}
