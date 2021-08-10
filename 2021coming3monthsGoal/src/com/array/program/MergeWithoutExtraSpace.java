package com.array.program;
// Java program for the above approach
import java.util.Arrays;
import java.util.Collections;

public class MergeWithoutExtraSpace {
	static int arr1[] = new int[] { 1, 5, 9, 10, 15, 20 };
	static int arr2[] = new int[] { 2, 3, 8, 13 };

	// Function to merge two arrays
	static void merge(int n,int m)
	{
		int i = 0, j = 0, k = n - 1;
		while (i <= k && j < m) {
			if (arr1[i] < arr2[j])
				i++;
			else {
				int temp = arr2[j];
				arr2[j] = arr1[k];
				arr1[k] = temp;
				j++;
				k--;
			}
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);
	}

	public static void main(String[] args)
	{
		merge(arr1.length, arr2.length);
		System.out.print("After Merging \nFirst Array: ");
		System.out.println(Arrays.toString(arr1));
		System.out.print("Second Array: ");
		System.out.println(Arrays.toString(arr2));
	}
}
