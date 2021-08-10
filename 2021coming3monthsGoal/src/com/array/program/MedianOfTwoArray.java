package com.array.program;

import java.util.Arrays;

public class MedianOfTwoArray {
	
	public static void main(String[] args) {
		
		int  ar1[] = {-5, 3, 6, 12, 15};
		int   ar2[] = {-12, -10, -6, -3, 4,10};
		
		
		
		int first=ar1.length;
		int second=ar2.length;
		
		int [] ar3=new int[first+second];
		int i=0,j=0,k=0;
	   while(i<first && j<second) {
		if(ar1[i]>ar2[j]) 
			ar3[k++]=ar2[j++];
		else 
			ar3[k++]=ar1[i++];
		
	  }
	  while(i<first) 
		  ar3[k++]=ar1[i++];
	  
	  while(j<second) 
		  ar3[k++]=ar2[j++];
	  
	  System.out.println("Array :-"+Arrays.toString(ar1));
	  System.out.println("Array :-"+Arrays.toString(ar2));
	  System.out.println("Array :-"+Arrays.toString(ar3));
	  
	    ;
	  
	  System.out.println("Array 3 medien : "+(ar3.length % 2==0 ?(ar3[(ar3.length/2)]+ar3[(ar3.length/2-1)])/2: ar3[(ar3.length/2)]));
		
	}

}
