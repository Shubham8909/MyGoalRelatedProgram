package com.backtracking.program;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class CombinationSum {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]= new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		int sum= sc.nextInt();
		List<List<Integer>> res= new ArrayList<>();
		solution(arr,sum,n,0,res,new ArrayList<>());
		System.out.println(res);
		sc.close();
	}

	private static void solution(int[] arr, int sum, int n,int x, List<List<Integer>> res,List<Integer> list) {
		if(sum==0) {
			res.add(new ArrayList<>(list));
			return;
		}
		if(sum<0) {
			return;
		}
       for(int i=x; i<n; i++) {
    	   int curr= arr[i];
    	   int rem= sum-curr;
    	   list.add(curr);
    	   solution(arr,rem,n,i,res,list);
    	   list.remove(list.size()-1);
       }
		
	}

}
