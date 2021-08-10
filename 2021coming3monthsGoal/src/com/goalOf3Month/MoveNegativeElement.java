package com.goalOf3Month;

public class MoveNegativeElement {

	public static void main(String[] args) {
		int arr[]= {-1,5,4,-9,-8,3,4};
		printArray(arr);
		moveElementInBeginning(arr);
		printArray(arr);
		
	}
	private static void moveElementInBeginning(int[] arr) {
		int j=arr.length-1;
		for(int i=arr.length-1;i>=0;i--) {
			if(arr[i]<0 && i!=j) {
				int tmp=arr[i];
				arr[i]=arr[j];
				arr[j]=tmp;
				j--;
			}
		}
	}
	private static void printArray(int[] arr) {
		for(int a:arr) {
			System.out.print(a+" ");
		}
		System.out.println();
	}

}
