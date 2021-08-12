package com.shubham.learning.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class SlidingWindow {

	public static void main(String[] args) {

		int[] arr = { 2, 3, 5, 7, 8, 9, 5, 6,4 };
		// here
		int k = 4;

		//findMaxSumOfSlidingWindow(arr, k);
		
		findMaxSumOfSlidingWindow1(arr, k);

	}
	// 2 3 4 5 6 7 8 9

	private static void findMaxSumOfSlidingWindow1(int[] arr, int k) {
		int i = 0;
		int maxSu = 0;
		int sum = 0;
		/*
		 * while (i <= arr.length - k) {
		 * 
		 * if(i==0) { for (int j = i; j < k + i; j++) { sum += arr[j]; } }else {
		 * sum=sum-arr[i-1]+arr[k+i-1]; }
		 * 
		 * System.out.println(i + " sum " + sum); if (sum > maxSu) maxSu = sum; i++; }
		 */
	
		// 2 3 4 5 6 7 8 9
	    int j1=0;
		while(i<arr.length-k) {
			if(j1<k) {
				sum+=arr[j1];
				j1++;
			}else {
				sum=sum-arr[i]+arr[j1];
				if (sum > maxSu)
					maxSu = sum;
				i++;
				j1++;
			}
			System.out.println(i+" sum "+sum);
			
		}
		
		System.out.println(" Max Sum " + maxSu);
	}
	
	private static void findMaxSumOfSlidingWindow(int[] arr, int k) {
		
		Res res= new Res();
		res.value=0;
		recursion(0,arr,k,res);
		System.out.println("max "+res.value);
	}
	

	
	static void recursion(int i, int [] arr, int k,Res res) {
		if(i>arr.length - k) {
			return;
		}
		int sum=0;
		for (int j = i; j < k + i; j++) {
			sum += arr[j];
		}
		if (sum > res.value)
			res.value = sum;
		System.out.println(i + " sum " + sum);
		recursion(i+1,arr,k, res);
	}

}

class Res{
	int value;
}
