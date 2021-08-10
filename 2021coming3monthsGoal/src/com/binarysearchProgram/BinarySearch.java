package com.binarysearchProgram;

public class BinarySearch {

	public static void main(String[] args) {

		int arr1[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int elm1 = 4;
		int index = findIndexOfGivenDESCArray(arr1, elm1);
		System.out.println("find index is :" + index);
    
		
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int elm = 4;

		int index1 = findIndexOfGivenASEArray(arr, elm);
		System.out.println("find index is :" + index1);
		
		//Agnostic Binary Search..
		int arr2[] = { 2 };
		int elm2=1;
		if(arr2.length==1 && arr2[0]==elm2) {
			System.out.println("find index is :" + 0);
		}else if( arr2.length==1 && arr2[0]!=elm2) {
			System.out.println("find index is :" + -1);
		}else if(arr2.length>1) {
			if(arr2[0]>arr2[1]) {
				int index2 = findIndexOfGivenDESCArray(arr2, elm2);
				System.out.println("find  DESC index is :" + index2);
			}else {
				int index3 = findIndexOfGivenASEArray(arr2, elm2);
				System.out.println("find ASC index is :" + index3);
			}
			
		}else {
			System.out.println("find  index is :" + -1);
		}

	}

	private static int findIndexOfGivenASEArray(int[] arr, int elm) {
		int l = 0;
		int h = arr.length - 1;
		while (l <= h) {
			int mid = l + (h - l) / 2;
			if (arr[mid] == elm) {
				return mid;
			} else if (arr[mid] > elm) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}

	private static int findIndexOfGivenDESCArray(int[] arr1, int elm1) {
		int l1 = 0;
		int h1 = arr1.length - 1;
		while (l1 <= h1) {
			int mid = l1 + (h1 - l1) / 2;
			if (arr1[mid] == elm1) {
				return mid;
			} else if (arr1[mid] > elm1) {
				l1 = mid + 1;
			} else {
				h1 = mid - 1;
			}
		}
		return -1;
	}

}
