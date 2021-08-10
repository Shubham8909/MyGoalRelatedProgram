package com.array.program;

import java.util.ArrayList;
import java.util.List;

public class CountNumberOfNiceSubArrray {

	public static void main(String[] args) {
		
		int arr[]= {1,1,2,1,1,1};
		int k=3;
		List<List<Integer>> listOfList=niceArray(arr,k);
        System.out.println(listOfList);
	}

	private static List<List<Integer>> niceArray(int[] arr, int k) {
		List<List<Integer>> listofList=new ArrayList<>();
		List<Integer> list= new ArrayList<>();
		int k1=k;
        int i=0;
	    while(k1>0 && k1<arr.length) {
	    	if(arr[i]%2!=0) {
	    		k1--;
	    	}
	    	list.add(arr[i]);
	    	i++;
	    }
	    listofList.add(list);
	    int z=0;
	    for(int j=i; j<arr.length; j++) {
	    	if(arr[j]%2!=0) {
	    		List<Integer> list1= new ArrayList<>();
	    		list1.addAll(list);
	    		list1.remove(z);
	    		list1.add(arr[j]);
	    		list=list1;
	    		listofList.add(list1);
	    	}
	    }
		
		return listofList;
	}

}
