package com.array.program;

import java.util.Arrays;

/**
 * Chocolate Distribution Problem
 * 
 * Given an array of n integers where each value represents the number of chocolates in a packet
 * Each packet can have a variable number of chocolates. There are m students, the task is to 
 * distribute chocolate packets such that
 * 
 * Each student gets one packet.
   The difference between the number of chocolates in the packet with maximum chocolates
   and packet with minimum chocolates given to the students is minimum.
 *
 */
public class ChocolateProblem {

	public static void main(String[] args) {
		
		int arr[] = {3, 4, 1, 9, 56, 7, 9, 12} ;
		int m = 5 ;
		System.out.println(" "+Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println(" "+Arrays.toString(arr));
		int i=0,min=Integer.MAX_VALUE;
		while(i+m-1<arr.length) {
			int diff=arr[i+m-1]-arr[i];
			if(diff<min) {
				min=diff;
			}
			i++;
		}
		System.out.println("min diff is "+min);
	}

}
