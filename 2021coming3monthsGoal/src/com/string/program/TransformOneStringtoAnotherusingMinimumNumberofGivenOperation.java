package com.string.program;

public class TransformOneStringtoAnotherusingMinimumNumberofGivenOperation {

	public static void main(String[] args) {

		String A = "ABC";
		String B = "ACB";
		int minimumOperation = transform(A, B);
		System.out.println("minimumOperation -> " + minimumOperation);
	}

	private static int transform(String a, String b) {
		if (a.length() != b.length()) {
			return -1;
		}
		int charFrequency[] = new int[256];

		for (int i = 0; i < a.length(); i++) {
			charFrequency[a.charAt(i)]++;
			charFrequency[b.charAt(i)]--;
		}

		for (int i = 0; i < 256; i++) {
			if (charFrequency[i] != 0) {
				return -1;
			}
		}
		int res1 = getMinResFromEnd(a, b);
		int res2 = getMinResFromStart(a, b);

		return Math.min(res1, res2);
	}

	private static int getMinResFromStart(String a, String b) {

		int res = 0;
		int i = 0, j = 0;
		while (i < a.length()) {
			if (a.charAt(i) != b.charAt(j))
				res++;
			else
				j++;

			i++;
		}
		return res;
	}

	private static int getMinResFromEnd(String a, String b) {
		int i = a.length() - 1;
		int j = b.length() - 1;
		int res = 0;

		while (i >= 0) {
			if (a.charAt(i) != b.charAt(j))
				res++;
			else
				j--;

			i--;
		}
		return res;
	}

}
