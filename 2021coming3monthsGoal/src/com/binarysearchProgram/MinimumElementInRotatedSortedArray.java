package com.binarysearchProgram;

public class MinimumElementInRotatedSortedArray {

	public static void main(String[] args) {
		
		int arr[]= {7,8,9,10,11,2,3,4,5};
		int minElm=findMin(arr);
        System.out.println("Min element "+minElm);
        
        int arr1[]= {3,2,7,6,5,4};
		int minElm1=findMinDESC(arr1);
        System.out.println("Min element "+minElm1);
        
	}

	private static int findMin(int[] arr) {
	   int l=0;
	   int h=arr.length-1;
	   while(l<=h) {
		   int mid= l +(h-l)/2;
		   int next=(mid+1)%(arr.length);
		   int prev=(mid+arr.length-1) % (arr.length);
		   if(arr[mid]<=arr[next] && arr[mid]<=arr[prev]) {
			   return arr[mid];
		   }
		   if(arr[l]<=arr[mid]) {
			   l=mid;
		   }else if(arr[mid]<=arr[h]) {
			   h=mid;
		   }
	   }
	   return -1;
	}
	
	
	private static int findMinDESC(int[] arr) {
		   int l=0;
		   int h=arr.length-1;
		   while(l<=h) {
			   int mid=l +(h-l)/2;
			   int next=(mid+1)%(arr.length);
			   int prev=(mid+arr.length-1) % (arr.length);
			   if(arr[mid]<=arr[next] && arr[mid]<=arr[prev]) {
				   return arr[mid];
			   }
			   if(arr[l]>=arr[mid]) {
				   l=mid+1;
			   }else if(arr[mid]>=arr[h]) {
				   h=mid-1;
			   }
		   }
		   return -1;
		}

}
