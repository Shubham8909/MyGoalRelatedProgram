package com.vermas.code.learning;

public class ReversString {
	
	public static void main(String[] args) {
		
		int arr [] = {10,20,30,5,70,35};
		
		String str="shubham";
		char ch[]=str.toCharArray();
		recursionreverse(ch);
		for(char c: ch) {
			System.out.print(c);
		}
		arrayPrint(arr);
		//reverseString(arr);
		
		recursionreverse(arr);
		System.out.println("-----------------------");
		arrayPrint(arr);
	}

	private static void recursionreverse(int[] arr) {
		int low=0,high=arr.length-1;
		recursuionMethod(arr,low,high);
		
	}
	

	private static void recursionreverse(char[] arr) {
		int low=0,high=arr.length-1;
		recursuionMethod(arr,low,high);
		
	}
	
	private static void recursuionMethod(char[] arr, int low, int high) {
        if(low>high) {
        	return;
        }
        char swap=arr[low];
        arr[low]=arr[high];
        arr[high]=swap;
        low++;
        high --;
        recursuionMethod(arr,low,high);
}

	private static void recursuionMethod(int[] arr, int low, int high) {
	        if(low>high) {
	        	return;
	        }
	        int swap=arr[low];
	        arr[low]=arr[high];
	        arr[high]=swap;
	        low++;
	        high --;
	        recursuionMethod(arr,low,high);
	}

	private static void reverseString(int[] arr) {
		int low=0,high=arr.length-1;
		while(low<high) {
			int value=arr[low];
			arr[low]=arr[high];
			arr[high]=value;
			low++;
			high--;
		}
		
	}

	public static void arrayPrint(int [] array) {
		System.out.print("{ ");
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println("}");
	}
}
