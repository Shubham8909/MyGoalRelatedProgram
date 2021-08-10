package com.array.program;

import java.util.Arrays;

public class RainTrap {

	public static void main(String[] args) {
		
		  // TODO Auto-generated method stub 
		int arr[] = {3,0,0,2,0,4};
		int a1[] = new int[arr.length];
		int a2[] = new int[arr.length];

		int max = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				a1[i] = max;
			} else {
				a1[i] = max;
			}
		}
		System.out.println(Arrays.toString(a1));
		max = -1;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] > max) {
				max = arr[i];
				a2[i] = max;
			} else {
				a2[i] = max;
			}
		}
		System.out.println(Arrays.toString(a2));
		int store = 0;
		for (int i = 0; i < arr.length; i++) {
			store += Math.min(a1[i], a2[i]) - arr[i];
		}
		System.out.println("Water store Unit : " + store);
		 
        
        
        //   int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        
        int arr1[] = {3,0,0,2,0,4};
        
        int s=0;
        int l=arr1.length-1;
        int ans=0;
        int ms=0;
        int ml=0;
     
        while(s<=l) {
        	if(arr1[s]<arr1[l]) {
        		if(arr1[s]>ms) {
        			ms=arr1[s];
        		}else {
        			ans+=ms-arr1[s];
        		}
        	 s++;
        		
        	}else{
        		if(arr1[l]>ml) {
        			ml=arr1[l];
        		}else {
        			ans+=ml-arr1[l];
        		}
        		l--;
        	}
        	
        }
        
        System.out.println("Water store Unit : "+ ans);
        
        
        
        
        
	}

}
