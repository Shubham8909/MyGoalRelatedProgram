package com.vermas.code.learning;

public class PrintEvenPosition {

	public static void main(String[] args) {

		int[] arr = { 10, 24, 28, 4, 6, 27,45 };
		printEvenPostion(arr);
		
		int x=1234567;
		

	}

	private static void printEvenPostion(int[] arr) {
		for (int i = 1; i <=arr.length; i++) {
			if (i % 2 == 0) {
				System.out.println(arr[i-1]);
			}
		}

	}

}
