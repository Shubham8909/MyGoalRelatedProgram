package com.goalOf3Month;

import java.util.HashMap;
import java.util.Map;

public class WithoutSortingMethod {

	public static void main(String[] args) {
		
      int arr[]= {2,1,2,2,0,1,2,0};
      printArray(arr);
      sorting(arr);
      printArray(arr);
	}

	private static void printArray(int[] arr) {
		for(int a:arr) {
			System.out.print(a+" ");
		}
		System.out.println();
	}

	private static void sorting(int[] arr) {
		Map<Integer,Integer> map= new HashMap<Integer,Integer>();
		for(int i:arr) {
			if(map.containsKey(i)) {
				int x=map.get(i);
				map.put(i, x+1);
			}else map.put(i, 1);	
		}
		
		for(int i=0; i<arr.length;i++) {
			int count=map.get(0);
			if(i<count) {
				arr[i]=0;
			}else if(i<count+map.get(1)) {
				arr[i]=1;
			}else {
				arr[i]=2;
			}
		}
	}

}
