package com.dp.problems;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		
		String s= "bbbwbeab";
		int start=0;
		int last=s.length()-1;
	    int longest=findLongestPS(s,start,last);

	    
	    System.out.println(" longest "+ longest);

	}

	private static int findLongestPS(String s, int start, int last) {
		
		if(start==last) {
			return 1;
		}
		if(s.charAt(start)==s.charAt(last) && start+1==last ) {
			return 2;
		}
		int temp=0;
		if(s.charAt(start)==s.charAt(last)) {
			temp=findLongestPS(s,start+1,last-1)+2;
		}else {
		  temp = Math.max(findLongestPS(s,start+1,last), findLongestPS(s,start,last-1));
		}
		
		return temp;
	}

}
