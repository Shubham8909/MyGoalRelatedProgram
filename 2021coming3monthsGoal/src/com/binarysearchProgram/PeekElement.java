package com.binarysearchProgram;

//Also called Max element in bitonic array
public class PeekElement {

	public static void main(String[] args) {
		 int arr[]= {35,10,20,30};
		// int arr1[]= {5,10,20,15};
		 
		 int ans=peekValue(arr);
		 System.out.println("peck ement ans "+ans);
	}

	private static int peekValue(int[] arr) {
	    int l=0;
	    int h=arr.length-1;
	    while(l<=h) {
	    	int mid= l+(h-l)/2;
	    	if(mid>0 && mid<arr.length-1) {
	    		if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) {
	    			return arr[mid];
	    		}
	    		if(arr[mid-1]>arr[mid]) {
	    			h=mid-1;
	    		}else if(arr[mid+1]>arr[mid]) {
	    			l=mid+1;
	    		}
	    	}else if(mid==0) {
	    		if(arr[0]<arr[1]) {
	    			return arr[1];
	    		}else {
	    			return arr[0];
	    		}
	    	}else if(mid==arr.length-1) {
	    		if(arr[arr.length-1]>arr[arr.length-2]) {
	    			return arr[arr.length-1];
	    		}else {
	    			return arr[arr.length-2];
	    		}
	    	}
	    }
	    
	    System.out.println("l "+l+" h "+h);
		return -1;
	}

}
