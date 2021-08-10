package com.interview.prgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrimeCompositNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
        int res[]=primeComposite(N,arr);
        System.out.println(Arrays.toString(res));
	}

	private static int[] primeComposite(int n, int[] arr) {
		
		List<Integer> l= new ArrayList<>();
		List<Integer> l2= new ArrayList<>();
		
		int res[]= new int[n];
		for(int i=0; i<n;i++) {
			boolean flag=isPrime(arr[i]);
			if(flag) l.add(arr[i]);
			else l2.add(arr[i]);
		}
		Collections.sort(l);
		Collections.sort(l2,Collections.reverseOrder());
		
		for(int i:l) {
			if(i==2) {
				res[0]=i;
			}else {
				res[i-1]=i;
			}
		}
		for(int i=0,j=0; i<n && j<l2.size(); ) {
			if(res[i]==0) {
				res[i]=l2.get(j);
				j++;
			}
			i++;
		}
		
		return res;

	}

	private static boolean isPrime(int n) {
		if (n <= 1)
            return false;
 
        // Check if number is 2
        else if (n == 2)
            return true;
 
        // Check if n is a multiple of 2
        else if (n % 2 == 0)
            return false;
 
        // If not, then just check the odds
        for (int i = 3; i <= Math.sqrt(n); i += 2)
        {
            if (n % i == 0)
                return false;
        }
        return true;
	}

}
