package com.goalOf3Month;

public class FindBinaryOfDecimalNumber {

	public static void main(String[] args) {
		
		String str=findBinaryOfDecimal(10);
        System.out.println("Decimal to Binary : "+str);
	}

	private static String findBinaryOfDecimal(int i) {
		 int x=i;
		String s="";
		while(i>0) {
			s+=i%2;
			i=i/2;
		}
		int count=0;
		for(int j=s.length()-1;j>=0;j--) {
			if(s.charAt(j)=='1') {
				count++;
			}
		}
		
		System.out.println("Numbers of 1s is :"+(x >> 1));
		System.out.println("Numbers of 1s is :"+count);
		return s;
	}

}
