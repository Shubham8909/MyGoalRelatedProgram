package com.shubham.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Find1PositiveMissingNumber {

	public static void main(String[] args) {
		Integer [] arr= new Integer[] {2,3,1,2,3};
		
        System.out.println("Array print");
        printArray(arr);
       // missingNumber(arr);
		/*
		 * firstPositiveMissingNumber(arr); System.out.println();
		 * System.out.println("After the sort Array print"); printArray(arr);
		 * missingPositiveNumber(arr);
		 */
        ArrayList<Integer> list=duplicates(arr,arr.length);
        
        System.out.println(list);
        
	}
	
    public static ArrayList<Integer> duplicates(Integer[] arr, int n) {
        
        
        ArrayList<Integer> list =new ArrayList<Integer>();
    
      for (int i = 0; i < n; i++) 
        {
            int index = arr[i] % n;
            System.out.println("index "+i+" : "+index);
            arr[index] = arr[index]+ n;
            System.out.println("index "+i+" : "+index+" value "+arr[index]);
        }
 
        // Now check which value exists more
        // than once by dividing with the size
        // of array
        for (int i = 0; i < n; i++) 
        {
            if ((arr[i] / n) >= 2)
                 list.add(i);
        }
        if(list.isEmpty()){
            list.add(-1);
        }
        
        return list;
        
    }

	private static void missingPositiveNumber(Integer[] arr) {
		System.out.println();
		for(int i=0; i<arr.length;i++) {
			if(arr[i]!=i+1) {
				System.out.println("frist positive missing number is--> "+(i+1));
				break;
			}
		}
		
	}

	private static void firstPositiveMissingNumber(Integer[] arr) {
		int i = 0;
		while (i < arr.length) {
          if(arr[i]>0 && arr[i]<=arr.length && arr[i]!=arr[arr[i]-1]) {
        	  int otherIndex = arr[i]-1;
        	  int x = arr[i];
        	  arr[i]=arr[otherIndex];
        	  arr[otherIndex]=x;
          }else {
        	  i++;
          }
		}

	}

	private static void missingNumber(Integer[] arr) {
       int firstPositive=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>0) {
				if(firstPositive>arr[i] || firstPositive==0) {
					firstPositive=arr[i];
				}
			}
		}
		System.out.println("firstPositive -> "+firstPositive );
		
	}

	private static void printArray(Integer[] arr) {
		List<Integer> array= Arrays.asList(arr);
		array.stream().forEach(p -> System.out.print(p+" "));
	}
}
