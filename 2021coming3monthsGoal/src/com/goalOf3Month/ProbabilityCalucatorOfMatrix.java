package com.goalOf3Month;

public class ProbabilityCalucatorOfMatrix {

	public static void main(String[] args) {
	   System.out.println(probabilityOFMatrix(4,4,1,1,2));
	}

	private static double probabilityOFMatrix( int m, int n, int x, int y, int N) {
		if(!isSafe(m, n, x, y)) 
			return 0.0;
		
		if(N==0) 
			return 1.0;
		double prob=0.0;
		System.out.println("prob0- "+prob+" if x -> "+x+" y -> "+y+" N-> "+N);
        System.out.println();
       
		prob+=probabilityOFMatrix(m,n,x-1,y,N-1)*.25;
		System.out.println("prob1 - "+prob+" if x -> "+x+" y -> "+y+" N-> "+N);
		prob+=probabilityOFMatrix(m,n,x,y+1,N-1)*.25;
		System.out.println("prob2 - "+prob+" if x -> "+x+" y -> "+y+" N-> "+N);
		prob+=probabilityOFMatrix(m,n,x+1,y,N-1)*.25;
		System.out.println("prob3 - "+prob+" if x -> "+x+" y -> "+y+" N-> "+N);
		prob+=probabilityOFMatrix(m,n,x,y-1,N-1)*.25;
		System.out.println("prob4 - "+prob+" if x -> "+x+" y -> "+y+" N-> "+N);
		
		return prob;
	}
    
	private static boolean isSafe(int m, int n, int x, int y) {
		return (x>=0 && x<m && y>=0 && y<n);
	}
}
