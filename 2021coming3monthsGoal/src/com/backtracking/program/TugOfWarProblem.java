package com.backtracking.program;

import java.util.ArrayList;
import java.util.Scanner;

public class TugOfWarProblem {
	static int min=Integer.MAX_VALUE;
	static String ans="";
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0; i<n;i++) {
			arr[i]=sc.nextInt();
		}
		ArrayList<Integer> list1= new ArrayList<>();
		ArrayList<Integer> list2= new ArrayList<>();
		solution(arr,0,list1,list2,0,0,n);
		System.out.println(ans);
		sc.close();
	}

	private static void solution(int[] arr,int index, ArrayList<Integer> list1, ArrayList<Integer> list2, int list1Sum, int list2Sum, int n) {
		if(index==n) {
			int diff= Math.abs(list1Sum-list2Sum);
			if(min>diff) {
				min=diff;
				ans=list1+" "+list2;
				System.out.println("=> "+ans);
			}
			return;
		}
		
		if(list1.size()< (n+1)/2) {
			list1.add(arr[index]);
			solution(arr,index+1,list1,list2,list1Sum+arr[index],list2Sum,n);
			list1.remove(list1.size()-1);
		}
		
		if(list2.size()< (n+1)/2) {
			list2.add(arr[index]);
			solution(arr,index+1,list1,list2,list1Sum,list2Sum+arr[index],n);
			list2.remove(list2.size()-1);
		}
		
	}

}
