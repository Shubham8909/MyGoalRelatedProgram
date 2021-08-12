package com.shubham.test;

import java.util.HashSet;

public class ArrayClass {

	public static void main(String[] args) {
		int [] arr = {3,3,3};
	
		HashSet<Integer> hs= new HashSet<>();
		
		for(int i=0;i<arr.length; i++) {
			int x=arr[i];
			hs.add(x);
		}
      int max1=Integer.MIN_VALUE;
      int max2=Integer.MIN_VALUE;
      int max3=Integer.MIN_VALUE;
      
      for(Integer i: hs) {
    	 if(i>max1) {
    		 max3=max2;
    		 max2=max1;
    		 max1=i;
    	 }
      }
      
      if(max3==Integer.MIN_VALUE) {
    	  System.out.println( "Max value "+max1);
      }else {
    	  System.out.println( "Max3 value "+max3);
      }
		
		

	}

}
