package com.binarysearchProgram;

public class FirstANDLastOccurance {

	public static void main(String[] args) {
		
		int input[]= {2,4,10,10,10,11,18};
        int elm=10;
        int firstOccurance=firstOccFind(input,elm);
        System.out.println(firstOccurance);
        
        int lastOccurance=lstOccFind(input,elm);
        System.out.println(lastOccurance);
        
        
        int countOfelm=CountOfemmet(input,elm);
        System.out.println("---> "+countOfelm);
	}

	private static int CountOfemmet(int[] input, int elm) {
		int indexFromMidToStart=firstOccFind(input,elm);
		System.out.println("countFromMidToStart "+indexFromMidToStart);
		int indexFromMidToEnd=lstOccFind(input,elm);
		System.out.println("countFromMidToEnd "+indexFromMidToEnd);
		return indexFromMidToEnd-indexFromMidToStart+1;
	}
	
	private static int lstOccFind(int[] input, int elm) {
		int l=0;
		int h=input.length-1;
		int res=0;
		while(l<=h) {
			int mid= l+(h-l)/2;
			if(input[mid]==elm) {
				res=mid;
				l=mid+1;
			}else if(input[mid]>elm) {
				h=mid-1;
			}else {
				l=mid+1;
			}
		}
		return res;
	}

	private static int firstOccFind(int[] input, int elm) {
		int l=0;
		int h=input.length-1;
		int res=0;
		while(l<=h) {
			int mid= l+(h-l)/2;
			if(input[mid]==elm) {
				res=mid;
				h=mid-1;
			}else if(input[mid]>elm) {
				h=mid-1;
			}else {
				l=mid+1;
			}
		}
		return res;
	}

}
