package com.array.program;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthMaxValueFromArray {
	
	public static void main(String[] args) {
		int arr[]= {4};
		int k=2;
		//using MaxHeap Solution..
		long start=System.nanoTime();
		int value=maxPriorityQueueSolution(arr,k);
		long last=System.nanoTime();
		System.out.println("Kth max elements1 :: "+value+" timing taken "+(last-start));
		long start1=System.nanoTime();
		int value1=minPriorityQueeuSolution(arr,k);
		long last1=System.nanoTime();
		System.out.println("Kth max elements2 :: "+value1+" timing taken "+(last1-start1));
	}

	private static int minPriorityQueeuSolution(int[] arr, int k) {
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for(int i=0; i<k; i++) {
			pq.add(arr[i]);
		}
		for(int i=k; i<arr.length; i++) {
			if(arr[i]>pq.peek()) {
				pq.poll();
				pq.add(arr[i]);
			}
		}
		
		return pq.peek();
	}

	private static int maxPriorityQueueSolution(int[] arr, int k) {
		PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<arr.length; i++) {
			pq.add(arr[i]);
		}
		for(int i=0; i<k-1; i++) {
			pq.poll();
		}
		return pq.peek();
	}

}
