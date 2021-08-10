package com.string.program;

public class Stringmatchingwhereonestringcontainswildcardcharacters {

//	* --> Matches with 0 or more instances of any character or set of characters.
//	? --> Matches with any one character.

	public static void main(String[] args) {

		String s1 = "abc*bcd";
		String s2 = "abcdhghgbcd";

		int n = s1.length() - 1;
		int m = s2.length() - 1;
		boolean dp[][] = new boolean[ s1.length()][s2.length()];

		boolean match = isMatch(s1, s2, n, m, dp);
		System.out.println(match);

	}

	private static boolean isMatch(String s1, String s2, int n, int m, boolean[][] dp) {
		if(n==-1 && m==-1) {
			return true;
		}
		if(m==-1) {
			for(int i=0; i<n; i++) {
				if(s1.charAt(i)!='*') {
					return false;
				}
			}
			return true;
		}
		
		if(n==-1) return false;
		if(dp[n][m]) return dp[n][m];
		if(s1.charAt(n)==s2.charAt(m) || s1.charAt(n)=='?' ) {
			return dp[n][m]=isMatch(s1, s2, n-1, m-1, dp);
		}
		if(s1.charAt(n)=='*') {
			boolean first=isMatch(s1, s2, n, m-1, dp);
			boolean second=isMatch(s1, s2, n-1, m, dp);
			return dp[n][m]==(second || first);
		}
	
		return dp[n][m]=false;
	}

}
