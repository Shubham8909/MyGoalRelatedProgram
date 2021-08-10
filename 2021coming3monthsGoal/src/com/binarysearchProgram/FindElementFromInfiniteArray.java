package com.binarysearchProgram;

public class FindElementFromInfiniteArray {

	public static void main(String[] args) {
		int arr[]=new int[10000000];
		int ele=700;
		int elemetIndex=findElementFromInfiniteArray(arr,ele);
        System.out.println("index "+elemetIndex);
	}

	private static int findElementFromInfiniteArray(int[] arr, int ele) {
		int l=0;
		int h=1;
		while(ele>arr[h]) {
			l=h;
			h=h*2;
		}
		while(l<=h) {
			int mid=l+(h-l)/2;
			if(arr[mid]==ele) {
				return mid;
			}
			if(arr[mid]<ele) {
				l=mid+1;
			}else {
				h=mid-1;
			}
		}
		return -1;
	}

}
