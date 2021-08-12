package com.vermas.code.learning;

public class PrintPyramid {

	public static void main(String[] args) {

		printPyrmid(5);
	}

	private static void printPyrmid(int i) {

		for (int a = i; a > 0; a--) {
			for (int b = 1; b <= a; b++) {
				System.out.print(b + " ");
			}
			System.out.println();
		}

	}

}
