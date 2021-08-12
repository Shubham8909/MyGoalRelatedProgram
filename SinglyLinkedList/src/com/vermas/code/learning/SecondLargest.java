package com.vermas.code.learning;

public class SecondLargest {
	
	public static void main(String[] args) {
		int arr[]= {2,5,6,9,12,45,3};
		secondLarge(arr);
		
		int a=(4/4);
		System.out.println(a);
		
		
	}

	private static void secondLarge(int[] arr) {
		int secondLarge=arr[0];
		int firstlarge=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>firstlarge) {
				secondLarge=firstlarge;
				firstlarge=arr[i];
			}
		}
		System.out.println(" 2 large "+secondLarge);
		System.out.println(" 1 large "+firstlarge);
	}
}
