package com.graph.program;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MinimumTimeTakenByEachJob {

	public static void main(String[] args) {
     
	}
	
	public int [] minimumTimeTakenByEachJobInDirectedGraph(Map<Integer, List<Integer>> adj, int v) {
		int [] ans= new int[v+1];
		
		int [] in_degree= new int[v+1];
		
		Iterator<Map.Entry<Integer, List<Integer>>> it = adj.entrySet().iterator();
		// iterating every set of entry in the HashMap. 
		while (it.hasNext()) {
			Map.Entry<Integer, List<Integer>> set = (Map.Entry<Integer, List<Integer>>) it.next();
			System.out.println(set.getKey() + " = " + set.getValue());
		}
		
		
		for(Map.Entry<Integer, List<Integer>> entry :adj.entrySet()) {
			for(int i:entry.getValue()) {
				in_degree[i]++;
			}
		}
		Queue<Integer> q= new LinkedList<Integer>();
		
		for(int i=1; i<v;i++) {
			if(in_degree[i]==0) {
				q.add(i);
				ans[i]=1;
			}
		}
		while(!q.isEmpty()) {
			int x=q.poll();
			for(int i:adj.get(x)) {
				in_degree[i]--;
				if(in_degree[i]==0) {
					ans[i]=ans[x]+1;
					q.add(i);
				}
			}
		}
		
		
		return ans;
	}

}
