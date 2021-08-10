package com.binarysearchProgram;

public class NextAlphabate {
	
	public static void main(String[] args) {
		
		char [] arr= {'a','c','f','h'};
	    char ele='a';
	    char next=NextElement(arr,ele);
	    System.out.println("Next Element "+next);
	}

	private static char NextElement(char[] arr, char ele) {
	    int l=0;
	    int h=arr.length-1;
	    char ch='#';
	    while(l<=h) {
	      int mid= l+(h-l)/2;
	    	if(arr[mid]==ele) {
	    		l=mid+1;
	    	}else if(arr[mid]<ele) {
	    		l=mid+1;
	    	}else {
	    		ch=arr[mid];
	    		h=mid-1;
	    	}
	    }
		return ch;
	}

}
