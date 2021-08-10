package com.array.program;

import java.util.Arrays;

// Java program to find number of operations

// to make an array palindrome

public class FindMinimumMergeTofindPalidromInArray {
	// Returns minimum number of count operations
	// required to make arr[] palindrome
	static int findMinOps(int[] arr, int n) {
		int ans = 0; // Initialize result

		// Start from two corners
		for (int i = 0, j = n - 1; i <= j;) {
			if (arr[i] == arr[j]) {
				i++;
				j--;
			} else if (arr[i] > arr[j]) {
				// need to merge from tail.
				j--;
				arr[j] += arr[j + 1];
				ans++;
			}else {
				i++;
				arr[i] += arr[i - 1];
				ans++;
			}
		}
		System.out.println("After Array -- : " + Arrays.toString(arr));

		return ans;
	}

	// Driver method to test the above function
	public static void main(String[] args) {
		int arr[] = new int[] { 11, 14, 15, 11 };
		System.out.println("Befor Array -- : " + Arrays.toString(arr));
		System.out.println("Count of minimum operations is " + findMinOps(arr, arr.length));

	}
}
