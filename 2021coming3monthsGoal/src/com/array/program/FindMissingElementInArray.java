package com.array.program;

import java.util.Arrays;

public class FindMissingElementInArray {

	public static void main(String[] args) {
		
		int arr[]= {-3,-4,-7,-1};
		for(int i=0; i<arr.length; i++) {
			while(arr[i]>0 && arr[i]<=arr.length && arr[i]!=i+1) {
				int index=arr[i]-1;
				int value=arr[i];
				arr[i]=arr[index];
				arr[index]=value;
			}
		}
		for(int i=0; i<arr.length; i++) {
			if(arr[i]!=i+1) {
				System.out.println("Missing "+(i+1));
				break;
			}
		}
       

	}

}
