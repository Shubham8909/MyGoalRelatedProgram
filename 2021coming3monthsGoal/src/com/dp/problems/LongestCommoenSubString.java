package com.dp.problems;

public class LongestCommoenSubString {

	public static void main(String[] args) {
		String s1 = "JAVACODE";
		String s2 = "JAVACDE";
		int lcs = recursion(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length(), 0);
		System.out.println("length of  lcs ->" + lcs);

	}

	private static int recursion(char[] ch1, char[] ch2, int n, int m, int lcsConst) {
		if (n <= 0 || m <= 0) {
			return lcsConst;
		}
		int lcs1 = lcsConst;
		// If Both index value are Same..
		if (ch1[n - 1] == ch2[m - 1]) {
			lcs1 = recursion(ch1, ch2, n - 1, m - 1, lcsConst+1);
		}
		int lcs2 = recursion(ch1, ch2, n, m - 1, 0);
		int lcs3 = recursion(ch1, ch2, n - 1, m, 0);
		return Math.max(lcs1, Math.max(lcs2, lcs3));
	//	return maxFunctions(lcs1, lcs2, lcs3);
	}

	private static String maxFunctions(String s1, String s2, String s3) {
		String a = "";
		if (s2.length() > s3.length())
			a = s2;
		else
			a = s3;
		
		String b = "";
		if (s1.length() > a.length())
			b = s1;
		else
			b = a;
		return b;

	}
}
