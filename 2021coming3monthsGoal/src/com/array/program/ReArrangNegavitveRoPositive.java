package com.array.program;

import java.util.Arrays;

public class ReArrangNegavitveRoPositive {

	public static void main(String[] args) {
		//int arr []={ 5, 2, 5, 2,4,-7, 1, 8, 0, -8 } ;
		
		//int arr []={1, 2, 3, -4, -1, 4} ;
		
		int arr []= {-4, -1, 1, 2, 3, 4} ;
		
		
		
		
		
//		{-4, 2, 3, 1, -1, 4}
    System.out.println(Arrays.toString(arr));
		boolean flag=false;
		int i=0,j=1;
		while(i<arr.length && j<arr.length) {
			System.out.println("i "+i+" j "+j);
			if (!flag) {
				if (arr[i] < 0) {
					i++;
					j++;
					flag = true;
				} else if (arr[i] >= 0 && arr[j] < 0) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
					i++;
					j = i + 1;
					flag = true;
				} else if (arr[i] >= 0 && arr[j] >= 0) {
					j++;
				} 
				
			}else {
					if (arr[i] >= 0) {
						i++;
						j++;
						flag = false;
					} else if (arr[i] < 0 && arr[j] >= 0) {
						int tmp = arr[i];
						arr[i] = arr[j];
						arr[j] = tmp;
						i++;
						j = i + 1;
						flag = false;
					} else if (arr[i] < 0 && arr[j] < 0) {
						j++;
					}
				}
		}
		
		System.out.println(Arrays.toString(arr));
	}

}
