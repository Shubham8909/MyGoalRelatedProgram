package com.binarysearchProgram;

public class FlorElementInArray {

	public static void main(String[] args) {
		int arr[]= {1,2,3,4,8,10,10,12,19};
        int elm=5;
        int floreOfElement=findFloreOfElement(arr,elm);
        System.out.println(floreOfElement);
        
        int cielOfElement=findCielOfElement(arr,elm);
        System.out.println(cielOfElement);
	}

	private static int findCielOfElement(int[] arr, int elm) {
		int l=0;
		int h=arr.length-1;
		int ans=0;
		while(l<=h) {
			int mid= l+(h-l)/2;
			if(arr[mid]==elm) {
				return arr[mid];
			}
			if(arr[mid]<elm) {
				l=mid+1;
			}else {
				ans=arr[mid];
				h=mid-1;
			}
		}
		return ans;
	}

	private static int findFloreOfElement(int[] arr,int elm) {
		int l=0;
		int h=arr.length-1;
		int ans=0;
		while(l<=h) {
			int mid= l+(h-l)/2;
			if(arr[mid]==elm) {
				return arr[mid];
			}
			if(arr[mid]<elm) {
				ans=arr[mid];
				l=mid+1;
			}else {
				h=mid-1;
			}
		}
		return ans;
	}

}
