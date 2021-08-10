package com.binarysearchProgram;

public class FindElementINRotatedAarray {
	
	public static void main(String[] args) {
		
		int arr[]= {7,8,9,10,11,2,3,4,5};
		int elm=4;
		int findIndex=findElementFormarr(arr,elm);
		System.out.println(findIndex);
	}

	private static int findElementFormarr(int[] arr,int elm) {
		int minIndex=findMin(arr);
		System.out.println("min element Index "+minIndex);
		System.out.println("max element index "+(minIndex-1)%arr.length);
		int firstSortedarr=BS(arr,0,minIndex-1,elm);
		int secSortedarr=BS(arr,minIndex,arr.length-1,elm);
		return firstSortedarr!=-1?firstSortedarr:secSortedarr;
	}

	private static int BS(int[] arr, int l, int h,int elm) {
		while(l<=h) {
			int mid=l+(h-l)/2;
			if(arr[mid]==elm) {
				return mid;
			}else if(arr[mid]>=elm) {
				h=mid-1;
			}else {
				l=mid+1;
			}
		}
		return -1;
	}

	private static int findMin(int[] arr) {
		   int l=0;
		   int h=arr.length-1;
		   while(l<=h) {
			   System.out.println("l "+l+" h "+h);
			   
			   int mid= l +(h-l)/2;
			   System.out.println("mid "+mid+" alvae "+arr[mid]);
			   int next=(mid+1)%(arr.length);
			   int prev=(mid+arr.length-1) % (arr.length);
			   if(arr[mid]<arr[next] && arr[mid]<arr[prev]) {
				   return mid;
			   }
			   if(arr[l]<arr[mid]) {
				   l=mid;
			   }else if(arr[mid]<arr[h]) {
				   h=mid;
			   }
			   
		   }
		   
		   System.out.println("l "+l+" h "+h);
		   
		   return -1;
		}

}
