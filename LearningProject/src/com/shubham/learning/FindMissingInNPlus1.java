package com.shubham.learning;

public class FindMissingInNPlus1 {
	
	public static void main(String[] args) {
		
		int [] arr =new int [] {1,7,2,4,3}; //length=7
		System.out.print("Before -->");
		arrayPrint(arr);
		System.out.print("After -->");
		cycleSortedNumber(arr);
		arrayPrint(arr);
		missingNumber(arr);
	}
	
	private static void missingNumber(int[] arr) {
		String missingNumber="";
		for(int i=0; i<arr.length;i++) {
			if(arr[i]>arr.length && arr[i]==arr.length+1) {
			}else if(arr[i]>arr.length+1) {
				missingNumber=missingNumber+(arr.length+1)+" ";
			}
			if(arr[i]!=i+1) {
				missingNumber=missingNumber+(i+1)+" ";
			}
		}
		
		System.out.println("missingNumber "+missingNumber);
		
	}

	private static void cycleSortedNumber(int[] arr) {
		int i=0;
		while(i<arr.length) {
			if(arr[i]>arr.length) {
				i++;
				continue;
			}
			if(arr[i]!=arr[arr[i]-1]) {
				int newIndex=arr[i]-1;
				int x=arr[i];
				arr[i]=arr[newIndex];
				arr[newIndex]=x;
			}else {
				i++;
			}
		}
		
	}

	public static void arrayPrint(int [] array) {
		System.out.print("{ ");
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.print("}");
	}
	

}
