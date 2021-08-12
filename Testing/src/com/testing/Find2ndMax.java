package com.testing;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Find2ndMax {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String arr[] = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.next();
		}
		System.out.println(Arrays.toString(arr));
		String secondMax=findSecondMaxFromArray(arr,n);
		System.out.println(secondMax);
	    sc.close();

	}

	private static String findSecondMaxFromArray(String[] arr, int n) {
		if(n==0) return "-1";
		//Created HashSet to remove Duplicate.
		HashSet<String> hs= new HashSet<>();
		//Holding last minimum value.
		BigInteger min=new BigInteger(arr[0]);
		for(int i=0; i<n; i++) {
			BigInteger val= new BigInteger(arr[i]);
			if(val.compareTo(min)<0) {
				min=val;
			}
			hs.add(arr[i]);
		}
		//To handle minimum last corner case 
		//Added -1 so its 
		BigInteger minVal=min.add(new BigInteger("-1"));
		BigInteger firstMax=minVal;
		BigInteger secMax=minVal;
		System.out.println(hs);
		//Its for Find secondsMax value
		for(String sVal: hs) {
			BigInteger val= new BigInteger(sVal);
			if(val.compareTo(firstMax)>0) {
				secMax=firstMax;
				firstMax=val;
			}else if(val.compareTo(secMax)>0) 
	            secMax=val;
		}
		if(!secMax.toString().equalsIgnoreCase(minVal.toString())) return secMax.toString();
		return "-1";
	}

}
