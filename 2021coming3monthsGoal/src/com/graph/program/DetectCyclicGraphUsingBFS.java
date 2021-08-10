package com.graph.program;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCyclicGraphUsingBFS {
	
	
	public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
		
		int in_degree[]= new int[V];
		// increase in degree of adjacent vetex
		for(List<Integer> list: adj) {
			for(int i: list) {
				in_degree[i]++;
			}
		}
		Queue<Integer> queue= new LinkedList<Integer>();
		for(int i=0;i<V;i++) {
			if(in_degree[i]==0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int x= queue.poll();
			Iterator<Integer> itr= adj.get(x).listIterator();
			while(itr.hasNext()) {
				int y=itr.next();
				in_degree[y]--;
				if(in_degree[y]==0) {
					queue.add(y);
				}
			}
		}
		
		//Finished queue iteration : need to check if in_degree is 0 or not
		
		for(int i=0;i<V;i++) {
			if(in_degree[i]!=0) {
				return true;
			}
		}
		
		
		return false;
	}

}
