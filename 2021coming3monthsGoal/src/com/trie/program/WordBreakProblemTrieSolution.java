package com.trie.program;

import java.util.Arrays;
import java.util.Scanner;

// String i, like, sam, sung, samsung, mobile, ice, cream, icecream, man, go, mango
// input imango
//output true
public class WordBreakProblemTrieSolution {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String s=sc.nextLine();
		String B[]=s.split(",");
		
		//Input
		String input=sc.nextLine();
		Trie trie= new Trie();
		for(int i=0; i<B.length; i++) {
			trie.insert(B[i].trim());
		}
		boolean flag=utilsWordBreak(trie,input);
		System.out.println("--result "+flag);
		sc.close();
	}

	private static boolean utilsWordBreak(Trie trie, String input) {
	
		if(input.length()==0) {
			return true;
		}
		for(int i=1; i<=input.length();i++) {
			if(trie.search(input.substring(0,i)) && 
					utilsWordBreak(trie,input.substring(i,input.length()))) {
				return true;
			}
		}
	
		return false;
	}

}
