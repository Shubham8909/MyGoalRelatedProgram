package com.array.program;

import java.util.Arrays;
import java.util.HashSet;

/*Input:  [12 11 -13 -5 6 -7 5 -3 -6]
Output: [-13 -5 -7 -3 -6 12 11 6 5]*/
public class ArraySortingPositiveAndNegative {
	
	public static void main(String[] args) {
		int arr[]= {-12, 11, -13, -5, 6, -7, 5, -3, -6};
		System.out.println("Input :"+Arrays.toString(arr));
		reArrange(arr);
		System.out.println("Output :"+Arrays.toString(arr));
		reArrange2(arr);
		System.out.println("Output2 :"+Arrays.toString(arr));
	}

	private static void reArrange2(int[] arr) {
		int j=0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]<0) {
				if(i!=j) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
				j++;
			}
		}
		
	}

	private static void reArrange(int[] arr) {
		int i=0;
		int j=1;
		int count=0;
		while(i<arr.length && j<arr.length) {
			 count++;
		     if(arr[i]<0) {
		    	 i++;
		    	 j++;
		     }else if(arr[i]>0 && arr[j]<0) {
		    	 int temp=arr[j];
		    	 arr[j]=arr[i];
		    	 arr[i]=temp;
		    	 i++;
		    	 j++;
		     }else if(arr[i]>0 && arr[j]>0) {
		    	 j++;
		     }
		}
		System.out.println("size = "+count);
	}
	
	
	
}
