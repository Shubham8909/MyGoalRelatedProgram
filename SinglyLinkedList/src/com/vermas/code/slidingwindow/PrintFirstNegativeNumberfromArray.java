package com.vermas.code.slidingwindow;

public class PrintFirstNegativeNumberfromArray {
	
	public static void main(String[] args) {
	
		int arr[] = {12,-1,-7,8,-18,30,16,28};
		int k=3;
		printForstNegativeNumber(arr,arr.length,k);
		
	}

	private static void printForstNegativeNumber(int[] arr, int length,int k) {

		int j=0;
		int i=0;
		for(i=0;i<length;i++) {
			int count=0;
			for(j=i;j<i+k && j<length;j++) {
				count++;
				int current=arr[j];
				if(current<0) {
					System.out.println("--->"+current);
					break;
				}
				if(count==k) {
					System.out.println("--->"+0);
				}
				
			}
		}
		/*
		 * while(j<length) { int current=arr[j]; if(current<0 && firstNegativenumber==0)
		 * firstNegativenumber=current; if(j-i+1==k) {
		 * System.out.println("firstNegativenumber ->"+firstNegativenumber);
		 * firstNegativenumber=0; i++; } j++; }
		 */
	}

}
