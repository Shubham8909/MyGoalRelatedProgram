package com.goalOf3Month;

public class NegativeANDPsotionOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
	    printArray(arr);
       solution(arr);
       printArray(arr);
	}
	
	private static void printArray(int[] arr) {
		for(int a:arr) {
			System.out.print(a+" ");
		}
		System.out.println();
	}

	private static void solution(int[] arr) {
		int i=0;
		boolean flag=false;
		while(i<arr.length ) {
			if(flag==false) {
				if(arr[i]<0) {
					i++;
				 flag=true;
				}else {
					int j=i;
					while(j<arr.length-1 && arr[j]>=0) j++;
					int temp=arr[j];
					arr[j]=arr[i];
					arr[i]=temp;
					i++;
					flag=true;
				}
			}else if(flag==true) {
				if(arr[i]>0) {
				  i++;
				 flag=false;
				}else {
					int  j=i;
					while( j<arr.length-1 && arr[j]<0) j++;
					int temp=arr[j];
					arr[j]=arr[i];
					arr[i]=temp;
					i++;
					flag=false;
				}
				
			}
		}
		
	}



}
