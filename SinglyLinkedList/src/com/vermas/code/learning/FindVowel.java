package com.vermas.code.learning;

public class FindVowel {
	
	
	public static void main(String[] args) {
		
		
		String s="abcduvjsdgfshdfgkvhsdg";
		
		int [] arr = {2,4,2,3,9,3,7};
		findLargestSmall(arr);
		
		//findVowel(s);
	}

	private static void findLargestSmall(int[] arr) {
		int large=arr[0];
		int small=arr[0];
		for(int i=1; i<arr.length;i++) {
			if(arr[i]>large) {
				large=arr[i];
			}
			if(arr[i]<small) {
				small=arr[i];
			}
		}
		
		System.out.println("Small "+small+"---large "+large);
		
	}

	private static void findVowel(String s) {
	 int countV= 0;
	 int  countO=0;
	 String Vowel ="aeiou";
	 for(int i=0; i<s.length();i++) {
		 if(Vowel.contains(String.valueOf(s.charAt(i)).toLowerCase())) {
			 countV++;
		 }else {
			 countO++;
		 } 
	 }
		System.out.println("Vowel in String "+countV);
		System.out.println("Other then Vowel in String "+countO);
	}

}
