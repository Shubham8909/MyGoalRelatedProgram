package com.goalOf3Month;

import java.util.HashMap;
import java.util.Map;

public class FindSameFirstAndLastDigitInArray {

	public static void main(String[] args) {
		int arr[]= {27, 1,10, 39, 12, 52, 32, 67, 76};
		int sum=77;
		findSum(arr,sum);
         //FindSameLastDigit(arr);
	}

	private static void findSum(int[] arr, int sum) {
		Map<Integer,Integer> map= new HashMap<>();
		int i=0;
		while(i<arr.length) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i],map.get(arr[i])+1 );
			}else {
				map.put(arr[i],1 );
			}
			i++;
		}
		i=0;
		while(i<arr.length) {
			int x=sum-arr[i];
			if(map.containsKey(x)) {
				map.put(arr[i],map.get(x)+1 );
			}
			i++;
		}
		
		int pair=0;
		for(Map.Entry<Integer,Integer> eMap:map.entrySet()) {
			System.out.println(eMap.getKey()+" = "+eMap.getValue());
		}
	
		
	}

	private static void FindSameLastDigit(int[] arr) {
		int count=0,i=3;
		while(i<441) {
			if(String.valueOf(i).length()==1) 
				count++;
			else if(String.valueOf(i).length()==2) {
				String s=String.valueOf(i);
				if(s.charAt(0)==s.charAt(1)) {
					count++;
				}
			}else {
				String s=String.valueOf(i);
				if(s.charAt(0)==s.charAt(s.length()-1)) {
					count++;
				}
			}
			i++;
		}
		System.out.println("count --"+count);
	}

}
