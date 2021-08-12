package com.vermas.code.learning;

import java.util.Arrays;

public class ReverseWord {

	public static void main(String[] args) {

		String word = "Hello word in JAVA Program";
		String[] wordArray = word.split(" ");
		
		int low = 0, high = wordArray.length - 1;
		Arrays.sort(wordArray);
		recursiveReverse(wordArray, low, high);
		for(String s:wordArray) {
			System.out.print(s);
			System.out.print(" ");
		}

	}

	private static void recursiveReverse(String[] wordArray, int low, int high) {
		if (low > high) {
			return;
		}
		String s = wordArray[low];
		wordArray[low] = wordArray[high];
		wordArray[high] = s;
		low++;
		high--;
		recursiveReverse(wordArray, low, high);
	}
}
