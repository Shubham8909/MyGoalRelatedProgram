package com.array.program;

import java.util.Arrays;

public class PartitionOfArrayOnGivenRange {

	public static void main(String[] args) {
		
		int arr[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32} ;
   
        int lowVal = 14,n=arr.length;
		int highVal = 20;
		
		int start=0;
		int end=n-1;
		
		System.out.println("Array : "+Arrays.toString(arr));
		int i=0;
		while(i<end) {
			if(arr[i]<lowVal) {
				int temp=arr[start];
				arr[start]=arr[i];
				arr[i]=temp;
				start++;
				i++;
			}else if(arr[i]>highVal) {
				int tmp=arr[end];
				arr[end]=arr[i];
				arr[i]=tmp;
				end--;
			}else {
				i++;
			}
		}
		
		System.out.println("Array : "+Arrays.toString(arr));
		

	}

}
