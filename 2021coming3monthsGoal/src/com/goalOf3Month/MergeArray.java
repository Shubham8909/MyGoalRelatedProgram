package com.goalOf3Month;

import java.util.Arrays;

public class MergeArray {
	
	public static void main(String[] args) {
		
		int arr1[]= {2, 3, 8, 13};
		int arr2[]=  {1, 5, 9, 10, 15, 20};
		printArray(arr1);
		printArray(arr2);
		merge(arr1, arr2);
		printArray(arr1);
		printArray(arr2);
	}
	
	private static void printArray(int[] arr) {
		for(int a:arr) {
			System.out.print(a+" ");
		}
		System.out.println();
	}
	private static void merge(int[] arr1, int[] arr2) {
             int i=0,j=0,k=arr1.length-1;
    		  while(i<=k && j<arr2.length) {
    				if(arr1[i]<arr2[j]) i++;
    				else{
    					int temp=arr2[j];
    					arr2[j]=arr1[k];
    					arr1[k]=temp;
    					k--;
    					j++;
    				}
    			}
    		  Arrays.sort(arr1);
    	      Arrays.sort(arr2);
	}

}