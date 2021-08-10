package com.binarysearchProgram;

public class MinimumDiffInSortedArray {

	public static void main(String[] args) {
		int arr[] = {4,6,10};
		int elm = 11;
		int minDiffElement = findMinimumDiff(arr, elm);
		System.out.println("minDiff " + minDiffElement);
	}

	private static int findMinimumDiff(int[] arr, int elm) {
		int l = 0;
		int h = arr.length-1;
	
		while (l < h) {
			int mid = l + (h - l) / 2;
			if (arr[mid] == elm) {
				return arr[mid];
			}
			if (arr[mid] < elm) {
	             l=mid+1;
			} else {
				h = mid - 1;
			}
		}
		System.out.println("l "+l+" h "+h);
	    int res=Math.abs(arr[l]-elm)<Math.abs(arr[h]-elm)?arr[h]:arr[l];
		return res;
	}

}
