package com.graph.program;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GraphDFS {

	public List<Integer> DFS(Map<Integer, List<Integer>> adj, int v) {
		boolean visited[]= new boolean[v+1];
		List<Integer> list= new ArrayList<>();
		UtilDfs(v,visited,adj,list);
		return list;
	}

	private void UtilDfs(int i, boolean[] visited, Map<Integer, List<Integer>> adj, List<Integer> list) {
		visited[i]=true;
		list.add(i);
			Iterator<Integer> itr=adj.get(i).listIterator();
			while(itr.hasNext()) {
				int y=itr.next();
				if(!visited[y]) {
					UtilDfs(y,visited,adj,list);
				}
			}
		}
		
	}

