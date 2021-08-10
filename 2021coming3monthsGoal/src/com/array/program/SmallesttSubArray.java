package com.array.program;

import java.util.Arrays;

/**
 * @author shubhamverma
 * 
 * Smallest Subarray with sum   than a given value
 *
 */
public class SmallesttSubArray {

	public static void main(String[] args) {
		int arr[] = {1, 4, 45, 6, 0, 19};
		
		int arr2[]= new int[arr.length];
	    int x =51;
	    
	    int i=0,j=0,minCount=99999999,curr=0,sum=0;
	    
	    while(i<arr.length && j<arr.length) {
	    	if(arr[j]>x) {
	    		System.out.println(" find {"+ arr[j]+" }");
	    		break;
	    	}else if(sum<=x) {
	    		sum+=arr[j];
	    		curr++;
	    		j++;
	    	}else{
	    		if (curr < minCount) {
					minCount=curr;
				}
	    		sum=sum-arr[i];
	    		curr--;
	    		i++;
	    	}
	    	System.out.println("Value i is: "+ i +" value of j : "+ j+" value of sum "+sum+" curr:  "+curr);
	    	
	    }
	    
	    System.out.println("Array  after: "+Arrays.toString(arr));
	    System.out.println("Array : "+Arrays.toString(arr2)+" count "+minCount);
	    
	    

	}

}
