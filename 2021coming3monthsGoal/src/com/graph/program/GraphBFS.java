package com.graph.program;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GraphBFS {

	public List<Integer> BFS(Map<Integer, List<Integer>> adj, int v) {
		boolean visited[]= new boolean[v+2];
		List<Integer> list= new ArrayList<>();
		Queue<Integer> queue= new LinkedList<>();
		visited[v]=true;
		queue.add(v);
		while(!queue.isEmpty()) {
			int x= queue.poll();
			list.add(x);
			Iterator<Integer> itr=adj.get(x).listIterator();
			
			while(itr.hasNext()) {
				int y=itr.next();
				if(!visited[y]) {
					visited[y]=true;
					queue.add(y);
				}
			}
		}
		return list;
	}

  

}
