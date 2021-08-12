package com.overridding;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang.ArrayUtils;

public class ArraySorting {
	
	public static void main(String[] args) {
		
		int arr[]= {90123,20034,12145,22234,12245};
	    List<Integer> list=Arrays.stream(arr).boxed().collect(Collectors.toList());
	    
		Comparator<Integer> comparator= new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				System.out.println(String.valueOf(o1).charAt((5/2))+"---"+String.valueOf(o2).charAt((5/2)));
			    if(middle(o1)> middle(o2)) {
			    	return 1;
			    }else if(middle(o1)< middle(o2)) {
			    	return -1;
			    }else {
			    	return 0;
			    }
			}
		};
	    
	    final int[] data = new int[] { 5, 4, 2, 1, 3 };
	    final Integer[] sorted = ArrayUtils.toObject(arr);
	    Arrays.sort(sorted, comparator);
	    

		
		List<Integer> list2=list.stream().sorted((o1,o2)-> {
		    if(middle(o1)> middle(o2)) {
		    	return 1;
		    }else if(middle(o1)< middle(o2)) {
		    	return -1;
		    }else {
		    	return 0;
		    }
		}).collect(Collectors.toList());
		
		System.out.println(list2);
		
	}
	
	static int middle(int i) {
		return String.valueOf(i).charAt((5/2));
	}
	
	

}
