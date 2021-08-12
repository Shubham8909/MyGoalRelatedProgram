package com.rain;

import java.util.ArrayList;
import java.util.List;

public class WaterTrap {

	public static void main(String[] args) {

		/*
		 * Scanner sc = new Scanner(System.in); int n= sc.nextInt(); int input[]= new
		 * int[n];
		 * for(int i=0;i<n; i++) { input[i]=sc.nextInt(); }
		 */
		int input[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int n = 12;
		int maxStore = maxStoreWaterafromInput(input, n);
		System.out.println("max " + maxStore);

	}

	// arr[] = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
	private static int maxStoreWaterafromInput(int[] arr, int n) {

		List<List<Integer>> listofList = new ArrayList<>();

		int i = 0;
		int j = i + 1;
		while (i < n && j < n) {
			if (arr[i] <= arr[j]) {
				List<Integer> list = chunksCreated(arr, i, j, n);
				listofList.add(list);
				i = j;
				j = i + 1;
			} else {
				j++;
				// spec
				while (i < n && j == n - 1) {
					int jNewIndex = specFun(i, arr, n);
					List<Integer> list = chunksCreated(arr, i, jNewIndex, n);
					listofList.add(list);
					i = jNewIndex;
					j = i + 1;
				}
			}
		}
		
		List<Integer> minFronlist = new ArrayList<>();
		
		for (int k = 0; k < listofList.size(); k++) {
			List<Integer> currList = listofList.get(k);
			minFronlist.add(Math.min(currList.get(0), currList.get(currList.size() - 1)));
		}

		int store = 0;

		for (int k = 0; k < listofList.size(); k++) {
			List<Integer> currList = listofList.get(k);
			int min = minFronlist.get(k);
			currList.remove(0);
			currList.remove(currList.size() - 1);

			for (int z = 0; z < currList.size(); z++) {
				store += min - currList.get(z);
			}
		}

		return store;
	}
 

	private static List<Integer> chunksCreated(int[] arr, int i, int j, int n) {
		List<Integer> list = new ArrayList<>();
		list.add(arr[i]);
		int index = i + 1;
		
		/// i=0
	//	j=i+1;
		while (index < n && index <= j - 1) {
			list.add(arr[index]);
			index++;
		}
		list.add(arr[j]);
		return list;
	}

	private static int specFun(int i, int[] arr, int n) {
		int newIndex = i + 1;
		int max = -1;
		int minIndex = -1;
		while (newIndex < n) {
			if (arr[newIndex] > max) {
				max = arr[newIndex];
				minIndex = newIndex;
			}
			newIndex++;
		}
		return minIndex;
	}

}
