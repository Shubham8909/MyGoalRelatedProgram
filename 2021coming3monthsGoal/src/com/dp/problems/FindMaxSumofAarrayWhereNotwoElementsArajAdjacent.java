package com.dp.problems;

//Find Max Sum in a array such no two elements are adjacent

public class FindMaxSumofAarrayWhereNotwoElementsArajAdjacent {

	public static void main(String[] args) {
		
		int arr[]= {10,5,1,9,20};
		int max=recursuion(arr,arr.length-1);
		System.out.println("max "+max);
		
		int dp[]=new int[arr.length];
		int max1=recursuionWithMemo(arr,arr.length-1,dp);
		System.out.println("max1 "+max1);
		
		int max2=BottomUpApproach(arr,arr.length-1);
		System.out.println("max2 "+max2);
		
		int max3  =BottomUpEfficientApproach(arr,arr.length-1);
		System.out.println("max3 "+max3);
	}
	//dp bottom up  effient approach..

	private static int BottomUpEfficientApproach(int[] arr, int n) {
		int prev2=arr[0];
		int prev1=Math.max(arr[0], arr[1]);
		for(int i=2; i<=n; i++) {
			int temp=prev1;
			prev1=Math.max(prev2+arr[i], prev1);
			prev2=temp;
		}
		return prev1;
	}
	//dp bottom up approach..
	private static int BottomUpApproach(int[] arr, int n) {
		int dp[]=new int[arr.length];
		
		dp[0]=arr[0];
		dp[1]=Math.max(arr[0], arr[1]);
		for(int i=2; i<=n; i++) {
			dp[i]=Math.max(dp[i-2]+arr[i], dp[i-1]);
		}
		return dp[n];
	}

	//top-down o(n) time and space as well
	private static int recursuionWithMemo(int[] arr, int n, int[] dp) {
		if(n<0) {
			return 0;
		}
		
		if(dp[n]!=0) return dp[n];
		//take the element on the current n index and call recursively on n-2
		int a=recursuionWithMemo(arr,n-2,dp)+arr[n];
		// call recursively on n-2
		int b=recursuionWithMemo(arr,n-1,dp);
		return dp[n]=Math.max(a, b);
	}

	private static int recursuion(int[] arr, int n) {
		if(n<0) {
			return 0;
		}
		//take the element on the current n index and call recursively on n-2
		int a=recursuion(arr,n-2)+arr[n];
		// call recursively on n-2
		int b=recursuion(arr,n-1);
		return Math.max(a, b);
	}


}
