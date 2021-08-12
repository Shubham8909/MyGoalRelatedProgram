package com.shubham.learning;

public class MissingAndDuplicate {

	public static void main(String[] args) {
		int [] arr =new int [] {4,3,4,3,2}; //length=6
		System.out.print("Before -->");
		arrayPrint(arr);		
		System.out.println();
		int [] array=new int [] {1,2,3,4,5,6}; //length=6
        //findMissingAndDuplicate(arr,array);
        
        sortingArray(arr);
        arrayPrint(arr);
	}
	
	private static void sortingArray1(int[] arr) {
         int i;
        for (i = 0; i < arr.length; i++) 
        { 
        	System.out.println("value coming -->"+arr[ abs(arr[i])] );
            if (arr[ abs(arr[i])] >= 0) {
                arr[ abs(arr[i])] = -arr[abs(arr[i])]; 
            } else
                System.out.println(abs(arr[i]) + " "); 
        } 
		
	}
	
	 public static int abs(int a) {
	        return (a < 0) ? -a : a;
	    }
 
	private static void sortingArray(int[] arr) {
		int i=0;
		while(i<arr.length) {
			if(arr[i]!=arr[arr[i]-1]) {
				int otherIndex=arr[i]-1;
				int x=arr[i];
				arr[i]=arr[otherIndex];
				arr[otherIndex]=x;
			}else {
				i++;
			}
		}
		
	}

	private static void findMissingAndDuplicate(int[] arr, int[] array) {
		String duplicate="";
		String missing="";
		for(int i=0; i<array.length; i++) {
			int coutDuplicate=0;
			for(int j=0; j<arr.length; j++) {
				if(array[i]==arr[j]) {
					coutDuplicate++;
					if(coutDuplicate==2) {
						duplicate = duplicate+arr[j]+" ";
					}
				}
			}
			if(coutDuplicate==0) {
				missing= missing+array[i]+" ";
			}
		}
		System.out.println("Duplicate --"+ duplicate);
		System.out.println("Missing--"+ missing);
		
	}
	

	public static void arrayPrint(int [] array) {
		System.out.print("{ ");
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.print("}");
	}

}
