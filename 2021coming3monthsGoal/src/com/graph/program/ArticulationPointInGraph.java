package com.graph.program;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ArticulationPointInGraph {
    int time=0;
    
	public List<Integer> findArticularPoint(int V, Map<Integer, List<Integer>> adj){
		List<Integer> list=new ArrayList<Integer>();
		
		int [] parent = new int[V+1];
		boolean visited[]= new boolean[V+1];
		int disc []= new int[V+1];
		int low []= new int[V+1];
		boolean ap[] = new boolean[V+1];
		
		 for (int i = 0; i < V; i++) {
	            parent[i] = -1;
	            visited[i] = false;
	            ap[i] = false;
	        }
		 
		 for (int i = 0; i < V; i++)
	            if (visited[i] == false)
	                APUtil(i, visited, disc, low, parent, ap,adj);
		 
		 for (int i = 0; i < V; i++)
	            if (ap[i] == true)
	                list.add(i);
		 
		return list; 
	}

	private void APUtil(int i, boolean[] visited, int[] disc, int[] low, int[] parent, boolean[] ap,Map<Integer, List<Integer>> adj) {
		
		int child=0;
		visited[i]=true;
		disc[i]=low[i]=++time;
		Iterator<Integer> itr = adj.get(i).listIterator();
		while(itr.hasNext()) {
			int x=itr.next();
			 if (!visited[x]) {
				    child++;
	                parent[x] = i;
	                APUtil(x, visited, disc, low, parent, ap,adj);
	                low[i]  = Math.min(low[i], low[x]);
	                
	               // (1) i is root of DFS tree and has two or more children.
	                if (parent[i] == -1 && child > 1)
	                    ap[i] = true;
	                // (2) If i is not root and low value of one of its child
	                // is more than discovery value of i.
	                if (parent[i] != -1 && low[x] >= disc[i])
	                    ap[i] = true;
			 } else if (x != parent[i])
	                low[i]  = Math.min(low[i], disc[x]);
			
		}
		
		
	}

}
