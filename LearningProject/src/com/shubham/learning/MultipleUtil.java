package com.shubham.learning;

public class MultipleUtil {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4 };
		arrayPrint(arr);
		// output will be {24,12,8,6};
		int out[] = new int[arr.length];
		long start = System.currentTimeMillis();

		UtilofMulti(arr, 0, out);
		long end = System.currentTimeMillis();
		arrayPrint(out);
		System.out.println("time taking " + (end - start));
	}

	private static void UtilofMulti(int[] arr, int count, int out[]) {
		// base case
		if (count >= arr.length) {
			return;
		}
		int multi = 1;
		for (int i = 0; i < arr.length; i++) {
			if (count == i) {
				continue;
			}
			multi *= arr[i];
		}
		out[count] = multi;
		UtilofMulti(arr, count + 1, out);
	}

	public static void arrayPrint(int[] array) {
		System.out.print("{ ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.print("}");
	}

}
