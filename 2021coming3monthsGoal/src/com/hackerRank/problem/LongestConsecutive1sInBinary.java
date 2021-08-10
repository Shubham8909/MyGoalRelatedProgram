package com.hackerRank.problem;

public class LongestConsecutive1sInBinary {

	public static void main(String[] args) {
		
		int number=211184;
		int count=consecutive1sInBinary(number);
		System.out.println("Count "+count);

	}

	private static int consecutive1sInBinary(int number) {
		int count=0;
		while(number>0) {
			number=number & (number<<1);
			count++;
		}
		return count;
	}

}
