package com.array.program;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shubhamverma
 *
 *         Find a triplet that sum to a given value
 */
public class TripletSum {
	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		int arr[] = { 12, 3, 3, 9, 9, 12 };
		int sum = 24;
		boolean flag=false;
		Arrays.sort(arr);
		// 1,3,4,6,9,12
		for (int i = 0; i < arr.length; i++) {
			int j = i + 1;
			if(arr[i]==arr[j]) {
				continue;
			}
			int k = arr.length - 1;
			while (j < k) {
				if(k>j && arr[k]==arr[k-1]) {
					k--;
					continue;
				}
				System.out.println(i + " " + j + " " + k);
				if (arr[i] + arr[j] + arr[k] == sum) {
					flag=true;
					System.out.println(" array value " + arr[i] + " " + arr[j] + " " + arr[k]);
					break;
				} else if (arr[i] + arr[j] + arr[k] > sum) {
					k--;
				} else {
					j++;
				}
			}
			if(flag) {
				break;
			}
		}
	}

}
