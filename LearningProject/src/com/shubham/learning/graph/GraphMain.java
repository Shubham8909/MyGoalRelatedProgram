package com.shubham.learning.graph;

import java.util.ArrayList;

public class GraphMain {

	public static void main(String[] args) {
		
		Graph g= new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 5);
		g.addEdge(1, 2);
		g.addEdge(3, 4);
		g.addEdge(4, 6);
		g.addEdge(2, 6);
		g.addEdge(4, 3);
		
		ArrayList<Integer> value=g.showEdge(1);
		for(Integer i: value) {
			System.out.println( i);
		}		
		System.out.println( g.geteCount() +"----"+g.getvCount());
		
		ArrayList<Integer> value1=g.bfsOfGraph(5, g.adjacent);
		for(Integer i: value1) {
			System.out.println( i);
		}
	}
}
