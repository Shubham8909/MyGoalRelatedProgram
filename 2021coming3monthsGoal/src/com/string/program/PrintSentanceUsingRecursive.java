package com.string.program;

public class PrintSentanceUsingRecursive {
	
	public static void main(String[] args) {
		
		 String [][]  arr  = {{"you", "we", ""},
                            {"have", "are", ""},
                            {"sleep", "eat", "drink"},
                            {"night", "yeaterday", "Today"}};
		 printSentenceRes(arr);
		
	}

	private static void printSentenceRes(String[][] arr) {
	   
		String result[]= new String[arr.length];
		
		for(int i=0; i<arr[0].length;i++) {
			if(arr[0][i]!="") {
				printSentence(arr,0,i,result);
			}
		}
		
	}

	private static void printSentence(String[][] arr, int m, int n, String[] result) {
		
		result[m]=arr[m][n];
		
		if(m==arr.length-1) {
			for(int i=0; i<arr.length; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
          return;
		}
		
		for(int i=0; i<arr[0].length; i++) {
			if(arr[m+1][i]!="") {
				printSentence(arr,m+1,i,result);
			}
		}
		
	}

}
