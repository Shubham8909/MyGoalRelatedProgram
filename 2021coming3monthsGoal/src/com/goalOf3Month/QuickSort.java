package com.goalOf3Month;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int arr[]= {10,2,5,9,7,4,8,11};
		printArray(arr);
		int l=0;
		int h=arr.length-1;
		quickSort(arr,l,h);
		printArray(arr);
	}
	
	private static void printArray(int[] arr) {
		for(int a:arr) {
			System.out.print(a+" ");
		}
		System.out.println();
	}

	private static void quickSort(int[] arr,int l,int h) {
		if(l<h) {
			int i=partition2(arr,l,h);
			System.out.println( "pivot "+ i);
			quickSort(arr,l,i-1);
			quickSort(arr,i+1,h);
		}
	}

	public static int partition(int[] items, int startIndex, int endIndex) {
        int left = startIndex;
        int right = endIndex ;
        int pivot = items[startIndex];

        while (left < right) {
            while (items[left] < pivot) {
                ++left;
            }
            while (items[right] > pivot) {
                --right;
            }
            if (left < right) {
                int temp_item = items[left];
                items[left] = items[right];
                items[right] = temp_item;
            }
        }
        //swap pivot to the new position
        if (items[left] > pivot) {
            int temp_item = items[left];
            items[left] = pivot;
            items[endIndex] = temp_item;
        }
        return left;
    }
	
	
	public static int partition2(int[] items, int startIndex, int endIndex) {
		int left = startIndex,right = endIndex,pivot = items[startIndex];
        while(left<right) {
        	System.out.println("Pivot 1 "+pivot+ " left :: "+left+" :: "+right);
        	while(items[left]<pivot) left++;
        	while(items[right]>pivot) right--;
        	System.out.println("Pivot 2 "+pivot+ " left :: "+left+" :: "+right);
        	if (left < right) swap(items,left,right);
        	System.out.println(Arrays.toString(items));
        }
        items[right] = pivot;
        return right;
	}
        
	
	private static void swap(int arr[],int i, int j) {
		int x=arr[i];
		arr[i]=arr[j];
		arr[j]=x;
	}

}
