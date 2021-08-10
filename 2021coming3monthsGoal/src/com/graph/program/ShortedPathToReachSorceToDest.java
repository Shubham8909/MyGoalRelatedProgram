package com.graph.program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ShortedPathToReachSorceToDest {

	
	public List<Integer> SortedPath(Map<Integer, List<Integer>> adj, int v){
		List<Integer> path= new ArrayList<>();
		Queue<Integer> queue= new LinkedList<Integer>();
		boolean visited[] = new boolean[v+1];
		int dist[]= new int[v+1];
		int pred[]= new int[v+1];
		
		for(int i=0;i<=v;i++) {
			dist[i]=Integer.MAX_VALUE;
			pred[i]=-1;
		}
		if(modifiedBFS(dist,pred,0,v,visited,adj,queue)==false) {
			return new ArrayList<>();
		}
		int curr=v;
		path.add(curr);
		while(pred[curr]!=-1) {
			path.add(pred[curr]);
			curr=pred[curr];
		}
		System.out.println("Short Distant "+dist[v]);
		Collections.reverse(path);
		return path;
		
	}

	private boolean modifiedBFS(int[] dist, int[] pred, int start, int dest, boolean[] visited,
		Map<Integer, List<Integer>> adj, Queue<Integer> queue) {
		visited[start]=true;
		dist[start]=0;
		queue.add(start);
		while(!queue.isEmpty()) {
			int x= queue.poll();
			Iterator<Integer> itr=adj.get(x).listIterator();
			while(itr.hasNext()) {
				int y=itr.next();
				if(!visited[y]) {
					visited[y]=true;
					dist[y]=dist[x]+1;
					pred[y]=x;
					queue.add(y);
					if(y==dest) 
						return true;
				}
			}
		}
	
		return false;
	}
	
}
