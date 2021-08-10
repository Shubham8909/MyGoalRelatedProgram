package com.hackerRank.problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TripleSum {
	
	public static void main(String[] args) {
		
		int arr1[]= {1,3,5,7};
		int arr2[]= {5,7,9};
	    int arr3[]= {7,9,11,13};
	    int possibleCount=tripleSum(arr1,arr2,arr3);
	    
	    System.out.println(" possibleCount : "+possibleCount);
	    
	    
	}

	private static int tripleSum(int[] arr1, int[] arr2, int[] arr3) {
		
		int possibleCount=0;
		int removeDeuplicateArr1[]=dupliacatRemove(arr1);
		int removeDeuplicateArr2[]=dupliacatRemove(arr2);
		int removeDeuplicateArr3[]=dupliacatRemove(arr3);
		
		Arrays.sort(removeDeuplicateArr1);
		Arrays.sort(removeDeuplicateArr2);
		Arrays.sort(removeDeuplicateArr3);
		
		for(int q:removeDeuplicateArr2) {
			int p=findMinimumNumberCount(removeDeuplicateArr1,q)+1;
			int r=findMinimumNumberCount(removeDeuplicateArr3,q)+1;
			possibleCount+=p*r;
		}
		
		
		return possibleCount;
	}

	//1 3 5 7 9
	private static int findMinimumNumberCount(int[] arr, int key) {
	     int start=0;
	     int last=arr.length-1;
	     int count=-1;
	     while(last>=start) {
	    	 int mid =start +(last-start)/2;
	    	 if(arr[mid]<=key) {
	    		 count=mid;
	    		 start=mid+1;
	    	 }else {
	    		 last=mid-1;
	    	 }
	     }
		return count;
	}

	private static int[] dupliacatRemove(int[] arr) {
		Set<Integer> s= new HashSet<>();
		for(int a:arr) {
			s.add(a);
		}
		int a[]=new int[s.size()];
		int i=0;
		for(int item : s) {
			a[i++]=item;
		}
		return a;
	}

}
