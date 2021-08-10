package com.array.program;

import java.util.Arrays;

/**
 * @author shubhamverma
 * Minimum swaps required bring elements less equal K together
 *
 */
public class MinimumSwap {

	public static void main(String[] args) {
		
		int arr[] = {2, 1, 5, 6, 3};
	    int k = 3;
	    int count=0;
	    int i=0,j=0;
	    while(i<arr.length && j<arr.length) {
	    	if(arr[j]<=k) {
	    		if(i!=j) {
	    			int temp=arr[i];
	    			arr[i]=arr[j];
	    			arr[j]=temp;
	    			count++;
	    		}
	    		i++;
	    		j++;
	    	}else {
	    		j++;
	    	}
	    }
	    
	    System.out.println("Array : "+Arrays.toString(arr)+" minimum number to swap is "+count);

	}

}
