package com.vermas.code.missingNduplicate1toN;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MissingAndDuplicate {
	
	public static void main(String[] args) {
		
		Integer arr[]= {4, 3, 6, 2, 1, 1};
		//missingAndDuplicateSimpleAprroch(arr);
		missingAndDuplicateAdvance(arr);
	}

	private static void missingAndDuplicateAdvance(Integer[] arr) {
		printArray(arr);
		int i=0;
		while(i<arr.length) {
			if(arr[i]!=arr[arr[i]-1]) {
				int otherIndex=arr[i]-1;
				int x=arr[i];
				arr[i]=arr[otherIndex];
				arr[otherIndex]=x;
			}else {
				i++;
			}
		}
		System.out.println();
		printArray(arr);
		System.out.println();
		
		for(int j=0;j<arr.length;j++) {
			if(j+1!=arr[j]) {
			  int missing=j+1;
			 System.out.println("Missing Number "+missing );
			 System.out.println("Duplicate Number "+arr[j] );
			}
		}
		
	}
	
	private static void printArray(Integer[] arr) {
		List<Integer> array= Arrays.asList(arr);
		array.stream().forEach(p -> System.out.print(p+" "));
	}

	private static void swap(int i, int j) {
		int x=0;
		x=i;
		i=j;
		j=x;
	}

	private static void missingAndDuplicateSimpleAprroch(Integer[] arr) {
		
		Map<Integer,Integer> map= new HashMap<Integer,Integer>();
		for(int i=0; i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				int count=map.get(arr[i]);
				count++;
				map.put(arr[i],count);
			}else {
				map.put(arr[i],1);
			}	
		}
		for(Map.Entry<Integer,Integer> entry:map.entrySet()) {
			if(entry.getValue()>1) {
				System.out.println("Duplicate Number is :"+entry.getKey());
			}
		}
		for(int i=0;i<arr.length;i++) {
			int missing =i+1;
			if(!map.containsKey(missing)) {
				System.out.println("Missing Number is :"+missing);
			}
		}
	}

}
