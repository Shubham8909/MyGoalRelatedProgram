package com.array.program;

import java.util.Arrays;
import java.util.Stack;

public class MergeIntervals {

	public static void main(String[] args) {
     int arr[][]= {{1,4},{0,2},{5,6}};
		/*
		 * int res[][]=merge(arr); for(int []r:res) {
		 * System.out.print(" "+Arrays.toString(r)); }
		 */
       int res2[][]=merge2(arr);
       
       for(int []r:res2) {
    	   System.out.print(" "+Arrays.toString(r));
       }
	}

	private static int[][] merge2(int[][] intervals) {
		if (intervals.length == 1) {
			return intervals;
		}
		Arrays.sort(intervals, (a, b) -> {
			if (a[0] > b[0]) {
				return 1;
			} else if (a[0] < b[0]) {
				return -1;
			} else {
				return 0;
			}
		});
	    int idx=0;
	    int i=1;
		while(i<intervals.length) {
			if(intervals[idx][1]<intervals[i][0]) {
				idx++;
				intervals[idx][0]=intervals[i][0];
				intervals[idx][1]=intervals[i][1];
				i++;
			}else {
				intervals[idx][1]=Math.max(intervals[idx][1],intervals[i][1]);
				i++;
			}
		}
		
		return Arrays.copyOfRange(intervals, 0, idx+1); 
	}

	public static int[][] merge(int[][] intervals) {

		if (intervals.length == 1) {
			return intervals;
		}
		Arrays.sort(intervals, (a, b) -> {
			if (a[0] > b[0]) {
				return 1;
			} else if (a[0] < b[0]) {
				return -1;
			} else {
				return 0;
			}
		});
		
		Stack<int[]> stack= new Stack<>();
		stack.push(new int []{intervals[0][0],intervals[0][1]});
		
		for(int i=1; i<intervals.length;i++) {
			int first=stack.peek()[0];
			int end=stack.peek()[1];
			int first2=intervals[i][0];
			int end2=intervals[i][1];
			if(end<first2) {
				stack.push(new int []{intervals[i][0],intervals[i][1]});
			}else {
				stack.pop();
				int currEnd=Math.max(end, end2);
				stack.push(new int []{first,currEnd});
			}
		}
		return stack.toArray(new int[0][]);
	}

}
