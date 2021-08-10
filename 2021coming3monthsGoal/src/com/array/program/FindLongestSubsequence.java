package com.array.program;

import java.util.Arrays;
import java.util.Comparator;

public class FindLongestSubsequence {

	public static void main(String[] args) {
		
	     int arr[] = { 1, 9, 3, 10, 4, 20, 2 };
	     
	     int arr1[][] = { {1,4},{0,4} };
	     
	     System.out.println(Arrays.toString(arr1[0]));
		   System.out.println(Arrays.toString(arr1[1]));
	     
	   Arrays.sort(arr1,(a,b)->{
		   if(a[0]>b[0]) {
			   return 1;
		   }else if(a[0]<b[0]) {
			   return -1;
		   }else {
			   return 0;
		   }
	   });
	   
	   System.out.println(Arrays.toString(arr1[0]));
	   System.out.println(Arrays.toString(arr1[1]));
	   
	     Arrays.sort(arr);
	   //[1, 2, 3, 4, 9, 10, 20]
	     System.out.println(Arrays.toString(arr));
	     int count=0;
	     for(int i=1;i<arr.length;i++) {
	    	 if(arr[i-1]==arr[i]-1) {
	    		 count++;
	    		 System.out.print(arr[i-1]+" ");
	    	 }else {
	    		 if(count==0) continue;
	    		 System.out.print(arr[i-1]+" ");
	    		 break;
	    	 }
	     }
	     
	     //Ans 1 2 3 4
	}

}
