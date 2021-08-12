package com.shubham.learning.graph;

import java.util.ArrayList;

public class Graph {

	private Integer vCount;
	private Integer eCount;
	public ArrayList<ArrayList<Integer>> adjacent;

	public Graph(Integer vCount) {
		adjacent = new ArrayList<ArrayList<Integer>>();
		this.vCount = vCount;
		this.eCount = 0;

		for (int i = 0; i < vCount; i++) {
			ArrayList<Integer> a = new ArrayList<Integer>();
			adjacent.add(a);
		}
	}

	public void addEdge(int list, Integer value) {
		adjacent.get(list).add(value);
		eCount++;
	}

	public ArrayList<Integer> showEdge(int list) {
		return adjacent.get(list);
	}

	public Integer getvCount() {
		return vCount;
	}

	public Integer geteCount() {
		return eCount;
	}
	
	public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
		ArrayList<Integer> a= new ArrayList<Integer>();
		for(int i=0;i<V;i++) {
			a.addAll(adj.get(i));
		}
		return a;
    }
}
