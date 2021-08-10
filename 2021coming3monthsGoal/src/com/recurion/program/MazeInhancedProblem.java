package com.recurion.program;

import java.util.ArrayList;

public class MazeInhancedProblem {

	public static void main(String[] args) {
		int dr = 4;
		int dc = 4;
		int sr = 1;
		int sc = 1;

		printPossiblePath(sr, sc, dr, dc, "");

	}

	private static void printPossiblePath(int sr, int sc, int dr, int dc, String ans) {

		if (sr == dr && sc == dc) {
			System.out.println(ans);
			return;
		}
	
	    for(int m=1; m<=dr-sr;m++) {
	    	printPossiblePath(sr+m, sc, dr, dc, ans+"v"+m);
	    }
	    
	    for(int m=1; m<=dc-sc;m++) {
	    	printPossiblePath(sr, sc+m, dr, dc, ans+"h"+m);
	    }
	    
	    for(int m=1; m<=dc-sc && m<=dr-sr ;m++) {
	    	printPossiblePath(sr+m, sc+m, dr, dc, ans+"d"+m);
	    }

	}

}
