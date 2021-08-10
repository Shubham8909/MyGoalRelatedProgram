package com.goalOf3Month;

import java.util.HashMap;
import java.util.Map;

public class FindMinimumSumOfArray {

	public static void main(String[] args) {
	  int arr[]= {2, 4, 6, 8, 9}; 
	  int minSum =10;
	  int countOfPair=FindPair1(arr,minSum);
       System.out.println("minimum pair count of 7 =>"+countOfPair);
	}

	/*
	 * private static int FindPair(int[] arr, int minSum) { Map<Integer,Integer>
	 * map= new HashMap<>();
	 * 
	 * for(int i=0; i<arr.length;i++) { int x=minSum-arr[i]>0?minSum-arr[i]:0; int
	 * j=0; while(j<x && arr[j]<x) { if(map.containsKey(arr[j]))
	 * map.put(arr[j],map.get(arr[j])+1); else map.put(arr[j],1); j++; } } int
	 * pair=0; for(Map.Entry<Integer,Integer> eMap:map.entrySet()) {
	 * System.out.println(eMap.getKey()+" = "+eMap.getValue());
	 * if(eMap.getValue()>=1) { pair+=1; }else { pair++; } } if(pair>=2) return
	 * pair/2; else return -1; }
	 */
	

	private static int FindPair1(int[] arr, int minSum) {
		int l=0,r=arr.length-1;
		int count=0;
		while(l<r) {
			if(arr[l]+arr[r]<minSum) {
				
				count+=r-l;
				l++;
			}else {
				r--;
			}
		}
		return count;
	}

}
