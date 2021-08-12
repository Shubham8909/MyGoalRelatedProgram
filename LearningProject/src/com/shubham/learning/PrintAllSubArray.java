package com.shubham.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PrintAllSubArray {
	
	public static void main(String[] args) {
		int [] arr = new int[] {4,2,5,3,6};
		
		Arrays.stream(arr).forEach(e->System.out.print(e + " "));
		System.out.println();
		List<List<Integer>> solution=findSubArrayIntoGivenArrayIfMultipleOfThesubArrayIsLessThenOfGivenNumber(arr,45);
		
		System.out.println(solution);
	}

	private static List<List<Integer>> findSubArrayIntoGivenArrayIfMultipleOfThesubArrayIsLessThenOfGivenNumber(int[] arr, int val) {
		int start=0;
		int multiple=1;
		List<List<Integer>> solution= new ArrayList<>();
		
		for(int i=0; i<arr.length; i++) {
			multiple= multiple*arr[i];
			while(multiple>=val) {
				multiple=multiple/(arr[start]);
				start++;
			}
			List<Integer> list=  new ArrayList<>();
			for(int j=i; j>=start; j--) {
				list.add(0, arr[j]);
				solution.add(new ArrayList<Integer>(list));
			}
			
		}
		
		return solution;
		
		
	}

}
