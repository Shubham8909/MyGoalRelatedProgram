package com.goalOf3Month;

public class RemoveDuplicate {
	
	public static void main(String[] args) {
		
		int arr[]= {1,2,2,4,4,6,7,7,8,9,10,10};
		printArray(arr);
		RemoveDuplicate1(arr);
		System.out.println();
		printArray(arr);
	}

	private static void printArray(int[] arr) {
		for(int a:arr)System.out.print(a+" ");
	}

	private static void RemoveDuplicate1(int[] arr1) {
		int res1 = 1;
		for (int i = 1; i < arr1.length; i++)
		{
			if (arr1[i] != arr1[res1 - 1])
			{
				arr1[res1] = arr1[i];
				res1++;
			}
		}
		
		System.out.println(res1+" is the value. ");
		
	}

}
