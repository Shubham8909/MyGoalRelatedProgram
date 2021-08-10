package com.array.program;

import java.util.HashSet;

public class SubarrayWith0Sum {

	public static void main(String[] args) {
		int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
		int sum = 0;
		int j = 1,x=1;
		boolean flag = false;
		int result = arr[0];
		while ( j < arr.length) {
			System.out.println( " j " + j);
			result += arr[j];
			if (result == sum) {
				flag = true;
				break;
			} else if (j == arr.length - 1 && x<j) {
				      x++;
				      result = arr[x];
			           j=x;
			} else {
				j++;
			}
		}

		System.out.println("sub Array with sum  is " + flag);

	}
	
	
	static boolean findsum1(int arr[], int n) {
	    HashSet<Integer> set= new HashSet<Integer>();
	    int sum=0;
	    for(int i=0; i<n;i++){
	        sum+=arr[i];
	        if(sum==0 || arr[i]==0 || set.contains(sum)){
	            return true;
	        }
	        set.add(sum);
	    }
	    
	    return false;
		}

	static boolean findsum(int arr[], int n) {
		int i = 0;
		int j = 1;
		boolean flag = false;
		int result = arr[i];
		while (i < n && j < n) {
			result += arr[j];
			if (result == n) {
				flag = true;
				break;
			} else if (j == n - 1) {
				i++;
				j = i + 1;
				result = arr[i];
			} else {
				j++;
			}
		}
		

		return flag;
	}

}
