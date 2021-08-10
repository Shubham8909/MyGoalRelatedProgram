package com.graph.program;

import java.util.ArrayList;
import java.util.Iterator;

public class DetectCycleUndirectedGrapthDFS {

	public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean visited[] = new boolean[V];

		for (int j = 0; j < V; j++)
			visited[j] = false;

		for (int i = 0; i < V; i++) {
			if (!visited[i])
				if (isCyclicUtil(i, visited, -1, adj))
					return true;

		}
		return false;
	}

	boolean isCyclicUtil(int v, boolean visited[], int parent, ArrayList<ArrayList<Integer>> adj) {
		visited[v] = true;
		Integer i;
		Iterator<Integer> it = adj.get(v).iterator();
		while (it.hasNext()) {
			i = it.next();
			if (!visited[i]) {
				if (isCyclicUtil(i, visited, v, adj))
					return true;
			} else if (i != parent)
				return true;
		}
		return false;
	}

}
