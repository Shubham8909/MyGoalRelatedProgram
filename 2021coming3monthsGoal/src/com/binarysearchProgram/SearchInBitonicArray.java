package com.binarysearchProgram;

public class SearchInBitonicArray {
	public static void main(String[] args) {

	      int arr[]= {7,8,9,10,12,4,2};
	      int elm=2;
	      int indexElmt=findElmentFrom(arr,elm);
	      System.out.println("index : "+indexElmt);
	}

	private static int findElmentFrom(int[] arr, int elm) {
	    int peekIndex=findPeelIndexformArray(arr);
	    System.out.println("peek "+peekIndex);
	    int index1= BSASC(arr,elm,0,peekIndex-1);
	    System.out.println("index1 "+index1);
	    int index2= BSDESC(arr,elm,peekIndex,arr.length-1);
	    System.out.println("index2 "+index2);
		return index1!=-1?index1:index2;
	}
	
	

	private static int BSDESC(int[] arr, int elm, int l, int h) {
		while(l<=h) {
			int mid=l+(h-l)/2;
			if(arr[mid]==elm) {
				return mid;
			}
			if(arr[mid]>elm) {
				l=mid+1;
			}else {
				h=mid-1;
			}
		}
		return -1;
	}

	private static int BSASC(int[] arr, int elm, int l, int h) {
		while(l<=h) {
			int mid=l+(h-l)/2;
			if(arr[mid]==elm) {
				return mid;
			}
			if(arr[mid]>elm) {
				h=mid-1;
			}else {
				l=mid+1;
			}
		}
		return -1;
	}

	private static int findPeelIndexformArray(int[] arr) {
		int l=0;
		int h=arr.length-1;
		
		while(l<=h) {
			int mid=l+(h-l)/2;
			if(mid>0 && mid<arr.length-1) {
				if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) {
					return mid;
				}
				if(arr[mid-1]>arr[mid]) {
					h=mid-1;
				}else if(arr[mid+1]>arr[mid]) {
					l=mid+1;
				}
			}else if(mid==0) {
				if(arr[0]>arr[1]) 
					return 0;
				else 
					return 1;
			}else if(mid==arr.length-1) {
				if(arr[arr.length-1]>arr[arr.length-2]) 
					return arr.length-1;
				else 
					return arr.length-2;
			}
		}
		return -1;
	}
}
