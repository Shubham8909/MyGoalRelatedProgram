package com.slidingwindow.problem;

import java.util.Scanner;

public class KthsubArraymaxSum {
    //array=[2,1,5,1,3,2], k=3
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		//Array Size
		int n= sc.nextInt();
		int arr[]= new int [n];
		//fill the array
		for(int i=0; i<n;i++) {
			arr[i]=sc.nextInt();
		}
		//sub-array Size
		int k=sc.nextInt();
		int maxSum=kthsubArrayMaxSum(arr,n,k);
		System.out.println(maxSum);
		
		int maxSum1=usingWisndowMethods(arr,n,k);
		System.out.println(maxSum1);
		sc.close();
	}
	
	private static int usingWisndowMethods(int[] arr, int n, int k) {
		int maxSum=Integer.MIN_VALUE;
		int windowSum=0;
		
		for(int j=0; j<k;j++) {
			windowSum+=arr[j];
		}
	   maxSum=Math.max(maxSum, windowSum);
		for(int i=k; i<n; i++) {
			windowSum+=arr[i]-arr[i-k];
			maxSum=Math.max(maxSum, windowSum);
		}
		return maxSum;
	}

	private static int kthsubArrayMaxSum(int[] arr, int n, int k) {
		int j=0;
		int sum=0;
		int max=Integer.MIN_VALUE;
		for(int i=0; i<n;i++) {
			sum+=arr[i];
			if(j==k-1) {
				max=Math.max(max, sum);
				j--;
				sum=sum-arr[i-(k-1)];
			}
			j++;
		}
		return max;
	}

}
