package com.binarysearchProgram;

public class NearlySortedArray {

	public static void main(String[] args) {
		
		// Actual sorted 2 4 6 7 
		int arr[]= {2,4,7,6};
        int elm=6;
        int index=findIndex(arr,elm);
        System.out.println("index "+index);
	}

	private static int findIndex(int[] arr,int elm) {
		int l=0; 
		int h = arr.length-1;
		while(l<=h) {
			int mid= l+(h-l)/2;
			if(arr[mid]==elm) {
				return mid;
			}
			if(mid-1>=l&& arr[mid-1]==elm) {
				return mid-1;
			}
			if(mid+1<=h && arr[mid+1]==elm) {
				return mid+1;
			}
			if(arr[mid]<elm) {
				l=mid+2;
			}else {
				h=mid-2;
			}
		}
		return -1;
	}

}
