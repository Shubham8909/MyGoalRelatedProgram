package com.shubham.learning;

public class SubArrayMinimumSortLength {
	
	public static void main(String[] args) {
		
		int [] arr = new int [] {1,2,5,3,0,12,13,8,15,18};
		int length = findLengthInArray(arr);
		System.out.println("Sorted length "+length);
	}

	private static int findLengthInArray(int[] arr) {
		
		if(arr.length<=1) {
			return -1;
		}
		int start =0;
		int end =arr.length -1;
		
		while(start< arr.length-1 && arr[start]<arr[start+1]) {
			start++;
		}
		
		if(start==arr.length -1) {
			return 0;
		}
		
		while(end>0 && arr[end]>arr[end-1]) {
			end--;
		}
		
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		
		for(int i=start+1; i<=end; i++) {
			min=Math.min(min, arr[i]);
			max=Math.max(max, arr[i]);
		}
		
		while(start>=0 && arr[start]>min) {
			start--;
		}
		
		while(end<arr.length && arr[end]<max) {
			end++;
		}
		
		return end-start-1;
	}

}
