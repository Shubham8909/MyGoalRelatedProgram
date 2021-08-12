package com.vermas.code.learning;

public class InsertInArray {
	
	public static void main(String[] args) {
		
		int arr [] = {10,20,30,5,0};
		arrayPrint(arr);
		insertOnpositionTwo(arr,2,100);
	}

	private static void insertOnpositionTwo(int[] arr, int x,int value) {
		
		if(arr[arr.length-1]==0) {
			for(int i=arr.length-1; i>x;i-- ) {
				int last=arr[i];
				int privious=arr[i-1];
				arr[i-1]=last;
				arr[i]=privious;
			}
		}else
			System.out.println("Not space to insert new element ");
		arr[x]=value;
		
		arrayPrint(arr);
		
	}

	


public static void arrayPrint(int [] array) {
	System.out.print("{ ");
	for(int i=0; i<array.length; i++) {
		System.out.print(array[i]+" ");
	}
	System.out.print("}");
}
}