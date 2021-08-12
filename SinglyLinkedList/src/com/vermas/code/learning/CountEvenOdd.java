package com.vermas.code.learning;

public class CountEvenOdd {
	
	public static void main(String[] args) {
		int num=2458;
		//printEvenOddCount(num);
		anotherMethod(num);
	}

	private static void anotherMethod(int num) {
		int evenCount=0;
		int oddcount=0;
		while(num!=0) {
			int lastOfnum=num%10;
			if (lastOfnum%2==0) {
				evenCount++;
			}else {
				oddcount++;
			}
			num=num/10;
		}
		System.out.println("Even count of number "+evenCount);
		System.out.println("odd count of number "+oddcount);
	}

	private static void printEvenOddCount(int num) {
		String newStr=String.valueOf(num);
		int evenCount=0;
		int oddcount=0;
		for(int i=0;i<newStr.length();i++) {
			if(newStr.charAt(i)%2==0) {
				evenCount++;
			}else {
				oddcount++;
			}
		}
		
		System.out.println("Even count of number "+evenCount);
		System.out.println("odd count of number "+oddcount);
		
	}

}
