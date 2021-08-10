package com.java8.program;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {

	public static void main(String[] args) {
		
		int arr[]= {1,2,3,4,5,6};
		
		
		// sum
		int sum1= Arrays.stream(arr).sum();
		System.out.println(" sum "+sum1);
		
		//Print array value
		 Arrays.stream(arr).forEach(x ->System.out.print(x+" "));;
		 
		 System.out.println();
		//check greater then 2
		boolean flag= Arrays.stream(arr).anyMatch(x-> x>2);
		System.out.println("greater then 2 "+flag);
		
		//Sum on filter
		int sum= Arrays.stream(arr).filter(x->x>4).map(y->y*y).sum();
		System.out.println("sum square of greater then 4 "+sum);
		
		//print via on filter
		 Arrays.stream(arr).filter(x->x>4).map(y->y*y).forEach(x ->System.out.print(x+" "));
		 

			//print via on filter
		 Arrays.stream(arr).filter(x->x>4).map(y->y*y);
		 
		 System.out.println();
		 //
		 Stream<Integer> stream= Stream.of(10,12,24,15);
		 
		/*
		 * List<Integer> list=
		 * stream.filter(i->i>12).map(i->i*2).collect(Collectors.toList());
		 * list.stream().forEach(x ->System.out.print(x+" "));
		 */
		 
		 long count=stream.filter(i->i>12).count();
		 System.out.println(count);
	}

}
