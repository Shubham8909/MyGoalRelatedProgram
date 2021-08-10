package com.binarysearchProgram;

public class InfiniteBinarySortedArray {
	
	public static void main(String[] args) {
		
		int arr[]= {0,0,0,0,0,0,0,1,1,1,1};
		int ele=1;
		//find first occurrence of 1..
		int index=findFirstOccurrence(arr,ele);
		System.out.println(index);
		
	}

	private static int findFirstOccurrence(int[] arr, int ele) {
		int l=0;
		int h=arr.length-1; 
		int res=0;
		while(l<=h) {
			int mid=l+(h-l)/2;
			if(arr[mid]==ele) {
				res=mid;
				h=mid-1;
			}else if(arr[mid]<ele) {
				l=mid+1;
			}
		}
		return res;
	}

}
