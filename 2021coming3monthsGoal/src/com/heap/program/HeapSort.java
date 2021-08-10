package com.heap.program;

public class HeapSort {

	public static void main(String[] args) {
		
		int arr[] = {12, 11, 13, 5, 6, 7};
		printArray(arr);
        int n = arr.length;
        heapSort(arr,n);
        System.out.println("Sorted array is");
        printArray(arr);
	}
    
	//In Heap sort(Min/Max) : we know that Its follow complete balance tree dependent on its level.
	private static void heapSort(int[] arr, int n) {
		//doing -1 bcs we are taking value from 0 index
		for(int i=(n/2)-1; i>=0;i--) {
			maxHeapify(arr,n,i);
		}
		//remove element from starting and swap with last elements
		for(int i=n-1;i>=0;i--) {
			
			int first=arr[0];
			arr[0]=arr[i];
			arr[i]=first;
			//max heapify... after removed first element to restructured the max heap.
			maxHeapify(arr,i,0);
		}
		
	}
   //Sorting throw using max heapify..
	private static void maxHeapify(int[] arr, int n, int i) {
		// 
		int largest= i;
		int l=2*i+1;
		int r=2*i+2;
		//If left is large from root element
		if(l<n && arr[l]>arr[largest]) {
			largest=l;
		}
		//If left is large from root element
		if(r<n && arr[r]>arr[largest]) {
			largest=r;
		}
		//if swap the elements while find larger element from root..
		if(largest!=i) {
			int swap=arr[i];
			arr[i]=arr[largest];
			arr[largest]=swap;
			maxHeapify(arr,n,largest);
		}
		
	}

	private static void printArray(int[] arr) {
		for(int a:arr)System.out.print(a+" ");
		System.out.println();
	}

}
