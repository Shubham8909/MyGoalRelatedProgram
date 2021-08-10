package com.array.program;

public class MaximumProduct {

	public static void main(String[] args) {
     // int arr[] = {6, 3, 10, 3, 2};
      int arr[] = {-1, -2, 3, 4};
      long max=arr[0];
      long min=arr[0];
      long prod=arr[0];
      
      for(int i=1; i<arr.length;i++){
          if(arr[i]<0){
              long tmp=max;
              max=min;
              min=tmp;
          }
          
          max=Math.max(arr[i],max*arr[i]);
          min=Math.min(arr[i],min*arr[i]);
          
          if(prod<max)
             prod=max;
      }
      
     System.out.println("product "+prod);
      
	}

}
