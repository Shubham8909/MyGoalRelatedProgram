package com.shubham.learning;

public class CirculurArray {
	
	public static void main(String[] args) {
		int [] arr= new int[] {4,1,1,1};
		System.out.println(checkIfArraycirculurORnot(arr));
	}
	private static boolean checkIfArraycirculurORnot(int[] arr) {
		int slow,fast;
		for(int i=0;i<arr.length;i++) {
			slow=i;
			fast=i;
			boolean forword=arr[i]>0;
			
			System.out.println(" i ---"+i);
			while(true) {
				
				slow=generateNextIndex(arr,slow,forword);
				System.out.println( "slow -"+slow);
				if(slow ==-1) {
					break;
				}
				fast=generateNextIndex(arr,fast,forword);
				System.out.println( "fast -"+fast);
				if(fast ==-1) {
					break;
				}
				fast=generateNextIndex(arr,fast,forword);
				System.out.println( "fast -"+fast);
				if(fast ==-1) {
					break;
				}
				if(fast==slow) {
					return true;
				}
			}
		}

		return false;
	}
	private static int generateNextIndex(int[] arr, int index, boolean forword) {
		
		boolean direction=arr[index]>0;
		
		if(direction !=forword) {
			return -1;
		}
		int nextIndex= (index + arr[index] ) % arr.length;
		
		if(nextIndex<0) {
			nextIndex=nextIndex+arr.length;
		}
		
		if(nextIndex==index) {
			return -1;
		}
		return nextIndex;
	}

}
