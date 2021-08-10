package com.goalOf3Month;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DetectedCycleInGraph {

	public static void main(String[] args) {

	}
	
	//graph 
	public boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean visited[]=new boolean[V];
		Queue<Integer> queue= new LinkedList<>();
		int s=0;
		visited[s]=true;
		queue.add(s);
		while(queue.size()!=0) {
			int x=queue.poll();
			Iterator<Integer> itr= adj.get(x).listIterator();
			while(itr.hasNext()) {
				int y=itr.next();
				if(visited[y]) {
					return true;
				}
				visited[y]=true;
				queue.add(y);
			}
		}
		return false;
	}

}
