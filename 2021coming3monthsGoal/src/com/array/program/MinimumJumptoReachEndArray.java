package com.array.program;

import java.util.Arrays;

public class MinimumJumptoReachEndArray {
	
	public static void main(String[] args) {
		int arr[]= {1,3,5,8,9,2,6,7,6,8,9};
		//Simple O(n) approach
		System.out.println("Minimum Jumps :: "+minimumJump(arr, arr.length));
		
		//Dp approach..O(n^2)
		System.out.println("Minimum Jumps dp :: "+minimumJumpDp(arr, arr.length));
	}

	private static int minimumJumpDp(int[] arr, int n) {
		int jumps[]=new int[n];
		Arrays.fill(jumps, Integer.MAX_VALUE);
		System.out.println(Arrays.toString(jumps));
		jumps[0]=0;
		if(n==1) return 0;
		if(arr[0]==0) return -1;
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(i<=(j+arr[j])) {
					jumps[i]=Math.min(jumps[i], jumps[j]+1);
				}
			}
		}
		return jumps[n-1];
	}

	private static int minimumJump(int[] arr, int n) {
		int step=arr[0];
		int mRange=arr[0];
		int jump=1;
		if(arr[0]==0) {
			return -1;
		}else if(n==1) {
			return 0;
		}else {
			for(int i=1; i<n; i++) {
				if(i==n-1) {
					return jump;
				}
				mRange=Math.max(mRange, arr[i]+i);
				step--;
				if(step==0) {
					jump++;
					if(i>=mRange) {
						return -1;
					}
					step=mRange-i;
				}
			}
		}
		return -1;
	}
	
}
