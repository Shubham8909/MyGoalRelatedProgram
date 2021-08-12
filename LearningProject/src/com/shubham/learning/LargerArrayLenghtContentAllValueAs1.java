package com.shubham.learning;

public class LargerArrayLenghtContentAllValueAs1 {
  public static void main(String[] args) {
	  int [] arr =new int [] {0,0,1,0,1}; // 9 length
	  System.out.print("Given Array -->");
	  arrayPrint(arr);
	  int k=2; ///You can replace 2 value of 'O' with '1' then we have to find the max length of Array where all content values are '1'.
	  int length= replaceAndFindMaxLenth(arr,k);
	  System.out.println();
	  System.out.println("length  is -->" +length);
}
  
  
	private static int replaceAndFindMaxLenth(int[] arr, int k) {
		int maxLenght = 0;
		int currentLength = 0;
		int replaceValueWith0 = 0;
		int IndexPlaceOf0 = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0 && replaceValueWith0 < k) {
				replaceValueWith0++;
				currentLength++;
				if (replaceValueWith0 == 1)
					IndexPlaceOf0 = i + 1;
			} else if (replaceValueWith0 == k && arr[i] == 0) {
				currentLength = currentLength - IndexPlaceOf0;
				IndexPlaceOf0 = i + 1;
				currentLength++;
			} else {
				currentLength++;
			}
			if (currentLength > maxLenght) {
				maxLenght = currentLength;
			}
		}

		return maxLenght;
}


	public static void arrayPrint(int [] array) {
		System.out.print("{ ");
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.print("}");
	}
}
