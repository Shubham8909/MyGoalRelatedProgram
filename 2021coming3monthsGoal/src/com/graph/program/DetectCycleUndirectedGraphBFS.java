package com.graph.program;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleUndirectedGraphBFS {
	
	 public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		 boolean visited[]= new boolean[V];
		 Queue<Integer> queue= new 	LinkedList<Integer>();
		 for(int i=0; i<V; i++) {
			if(!visited[i]) {
				return utilCyclic(queue,i,visited,adj);
			}
		 }
		 return false;
	    }

	private boolean utilCyclic(Queue<Integer> queue, int i, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
		  int parent[]= new int[visited.length];	  
		  for(int z:parent) parent[z]=-1;

		visited[i]=true;
		queue.add(i);
		while(!queue.isEmpty()) {
			int x=queue.poll();
			Iterator<Integer> itr= adj.get(x).listIterator();
			while(itr.hasNext()) {
				int y=itr.next();
				if(!visited[y]) {
					visited[y]=true;
					parent[y]=x;
					queue.add(y);
				}else if(parent[x] !=y) {
					return true;
				}
			}
		}
		return false;
	}

}
