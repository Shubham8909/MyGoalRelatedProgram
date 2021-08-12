package com.testing;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapSortedByvalue {
	
	/*
	 * Input: a[] = { 16, 19, 10, 12, 18 } Output: 31 Start from 19 and then move to
	 * 12.
	 * 
	 * Input: a[] = {2, 5, 3, 1, 7, 3, 4} Output: 9 2->3->1->3
	 * 
	 * 
	 * 
	 * 
	 * 6 [ 0 1 2 3 4 5]
	 * 
	 *   31 31 22 12 18
	 */
	
	public static void main(String[] args) {
		
      int a[] = { 16, 19, 10, 12, 18 };
      
      int dp[] = new int[a.length];
   
      for(int i=a.length-1; i>=0;i--) {
    	  if(i==a.length-1) {
    		  dp[i]=a[i]; 
    	  }else if(i==0) {
    		  dp[i]= Math.min(dp[i+1],  dp[i+2]+a[i]);
    	  }else{
    		  if (i+2<a.length) {
    			  dp[i]=a[i]+Math.min(dp[i+1], dp[i+2]);
    		  }else {
    			  dp[i]=Math.min(a[i], dp[i+1]) ;
    		  }
    	  } 
    	  
      }
      
      System.out.println(dp[0]);
		
		
	}

}
