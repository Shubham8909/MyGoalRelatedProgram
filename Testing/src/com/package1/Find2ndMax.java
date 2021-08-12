package com.package1;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Find2ndMax {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String arr[] = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.next();
		}
		System.out.println(Arrays.toString(arr));
		// Solved in O(n) time complexity by using BigInteger
		String secondMax = findSecondMaxFromArray(arr, n);
		System.out.println("Second Max Value =: " + secondMax);
		sc.close();

	}

	private static String findSecondMaxFromArray(String[] arr, int n) {
		// Array empty
		if (n == 0)
			return "-1";

		// Holding last minimum value from given array
		BigInteger min = new BigInteger(arr[0]);
		BigInteger firstMax = min;
		BigInteger secMax = min;
		for (int i = 1; i < n; i++) {
			BigInteger val = new BigInteger(arr[i]);
			if (val.compareTo(min) < 0) {
				min = val;
			}
			if (val.compareTo(firstMax) > 0) {
				secMax = firstMax;
				firstMax = val;
			} else if (val.compareTo(firstMax) == 0)
				continue;
			else if (secMax.compareTo(firstMax) == 0)
				secMax = val;
			else if (val.compareTo(secMax) > 0)
				secMax = val;
		}
		// Added -1 in the min value because If Second max value is equal to min value
		BigInteger minVal = min.add(new BigInteger("-1"));

		if (!secMax.toString().equalsIgnoreCase(firstMax.toString())
				&& !secMax.toString().equalsIgnoreCase(minVal.toString()))
			return secMax.toString();

		return "-1";
	}

}
