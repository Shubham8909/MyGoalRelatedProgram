package com.goalOf3Month;
public class Solution {
	
	public static void main(String[] args) {
		String s="1102021222";
		System.out.println(perfectSubstring(s,2));
	
	}
	
	public static boolean check(int[] arr, int k) {
		for(int val : arr) {
			System.out.println( val +" chaeck value ");
			if(val != 0 && val != k) return false;
		}
		return true;
	}
	
	public static int perfectSubstring(String s, int k) {
		int res = 0;
		for(int i=0; i<s.length(); i++) {
			int[] arr = new int[10];
			for(int j = i; j<s.length(); j++) {
				if(j > i + (10*k)) break;
				char ch = s.charAt(j);
				arr[ch-'0']++;
				if(check(arr, k)) {
					res++;
				}
			}
		}
		return res;
	}
	
}