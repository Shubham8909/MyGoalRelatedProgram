package com.goalOf3Month;

public class ArrayInversions {

	public static void main(String[] args) {
		long arr[] = {3, 1, 2};
		long n=arr.length;
		System.out.println(innversion(arr,n));
		}

	private static int innversion(long[] arr, long n) {
		int count=0;
		for(int i=0;i<n-1; i++) {
			for(int j=i+1;j<n; j++) {
				if(arr[i]>arr[j]) {
				System.out.println("("+arr[i]+", "+arr[j]+")");
				count++;
				}
			}
		}
		return count;
		
	}

	

}