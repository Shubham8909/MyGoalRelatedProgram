package com.array.program;

public class JumpingCloud {

	public static void main(String[] args) {
		int arr[]= {0,1,1,0,1,0,0};
		
		
		//here 0 means normal cloud
		//1 means thunder cloud If you jump on thunder cloud your game is over.
         System.out.println("Minimun jumb in cloud : "+minimumJump(arr));
	}

	private static int minimumJump(int[] arr) {
		
		int case1=1;
		int case2=2;
		int i=0;
		int jump=0;
		while(i<arr.length) {
			System.out.println(" i "+ i);
			if((i+case2)<arr.length && arr[i+case2]==0) {
				System.out.println(" in case 2 "+ arr[i+case2]);
				i=i+case2;
			}else if((i+case1)<arr.length && arr[i+case1]==0) {
				System.out.println(" in case 1 "+ arr[i+case1]);
				i=i+case1;
			}else {
				break;
			}
			jump++;
		}
		return jump;
	}

}
