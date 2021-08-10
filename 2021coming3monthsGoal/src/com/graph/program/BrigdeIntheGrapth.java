package com.graph.program;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BrigdeIntheGrapth {

	int time = 0;

	public List<List<Integer>> findBirdgeInGraph(int V, Map<Integer, List<Integer>> adj) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		int[] parent = new int[V + 1];
		boolean visited[] = new boolean[V + 1];
		int disc[] = new int[V + 1];
		int low[] = new int[V + 1];
		boolean ap[] = new boolean[V + 1];

		for (int i = 0; i < V; i++) {
			parent[i] = -1;
			visited[i] = false;
			}

		for (int i = 0; i < V; i++)
			if (visited[i] == false)
				BridgeUtil(i, visited, disc, low, parent, ap, adj,list);
		
		return list;

	}

	private void BridgeUtil(int i, boolean[] visited, int[] disc, int[] low, int[] parent, boolean[] ap,
			Map<Integer, List<Integer>> adj,List<List<Integer>> list) {
		visited[i] = true;
		disc[i] = low[i] = ++time;
		Iterator<Integer> itr = adj.get(i).listIterator();
		while (itr.hasNext()) {
			int x = itr.next();
			if (!visited[x]) {
				parent[x] = i;
				BridgeUtil(x, visited, disc, low, parent, ap, adj,list);
				low[i] = Math.min(low[i], low[x]);
			    if(low[x]>low[i]) {
			       List<Integer> lst= new ArrayList<Integer>();
			       lst.add(i);
			       lst.add(x);
			       list.add(lst);
			    }
			} else if (x != parent[i])
				low[i] = Math.min(low[i], disc[x]);
		}
	}
}
