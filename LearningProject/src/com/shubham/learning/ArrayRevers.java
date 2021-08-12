package com.shubham.learning;
public class ArrayRevers {
	public static void main(String[] args) {
		int [] arr =new int [] {8,2,3,5,7,9,1,4}; //length=7
		System.out.print("Before -->");
		arrayPrint(arr);
		int [] array=reverseArray(arr);
		System.out.println("");
		System.out.print("After -->");
		arrayPrint(array);
	}
	public static int [] reverseArray(int [] array) {
		for(int i=0; i<(array.length)/2; i++) {
			int tmp=array[i];
			array[i]=array[array.length-1-i];
			array[array.length-1-i]=tmp;
		}
		return array;
	}
	public static void arrayPrint(int [] array) {
		System.out.print("{ ");
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.print("}");
	}
}
