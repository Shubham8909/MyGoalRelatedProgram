package com.goalOf3Month;

public class MergeSort {
	static int count=0;
	
	public static void main(String[] args) {
        int[] arr = { 468,335,1,170,225,479,359,463,465,206,146,282,328,462,492,496,443,328,437,392,105,403,154,293,383,422,217,219,396,448,227,272,39,370,413,168,300,36 ,395, 204, 312, 323 };
		printArray(arr);
		int l=0;
		int h=arr.length-1;
		mergeSort(arr,l,h);
		printArray(arr);
		System.out.println(" count -> "+count);
	}
	
	private static void mergeSort(int[] arr, int l, int h) {
		
		if(l<h) {
			int mid=(l+h)/2;
			mergeSort(arr,l,mid);
			mergeSort(arr,mid+1,h);
			merge(arr,l,mid,h);
		}
	}
	

	private static void merge(int[] arr, int l, int mid, int h) {
		
		int n=mid-l+1;
		int m=h-mid;
	
		int a[] = new int[n];
		int b[] = new int[m];
		
		for(int i=0;i<n;i++) a[i]=arr[l+i];
		for(int i=0;i<m;i++) b[i]=arr[mid+1+i];
		
		int i=0,j=0,k=l;
		
		while(i<n && j<m) {
			if(a[i]<b[j]) arr[k++]=a[i++];
			else {
				arr[k++]=b[j++];
			}
		}
		///if i having elements
		while(i<n) arr[k++]=a[i++];
		///if j having elements
		while(j<m) arr[k++]=b[j++];
	
	}

	private static void printArray(int[] arr) {
		for(int a:arr) {
			System.out.print(a+" ");
		}
		System.out.println();
	}

}
