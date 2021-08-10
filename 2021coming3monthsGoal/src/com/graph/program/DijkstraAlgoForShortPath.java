package com.graph.program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraAlgoForShortPath {
	
	public String DijkstraAlgo(Map<Integer, List<EdgesWithWeight>> adj, int v) {
		boolean visited[]= new boolean[v+1];
	    PriorityQueue<Pair> pQueue=new PriorityQueue<Pair>();
	    pQueue.add(new Pair(0, "0", 0));
	    while(!pQueue.isEmpty()) {
	    	Pair p= pQueue.poll();
			
			if (visited[p.v]) {
				continue;
			}
			visited[p.v] = true;
			 
	    	System.out.println("p -: "+p);
	    	Iterator<EdgesWithWeight> itr= adj.get(p.v).iterator();
	    	while(itr.hasNext()) {
	    		EdgesWithWeight ed=itr.next();
	    		if(!visited[ed.edge]) {
	    			Pair p1=new Pair(ed.edge, p.path+" "+ed.edge, p.w+ed.weight);
	    			System.out.println("p1 -: "+p1);
	    			pQueue.add(p1);
	    		}
	    	}
	    }
		
	    return "";
	}
	
	public static void main(String[] args) {
		
		Map<Integer, List<EdgesWithWeight>> adj= new HashMap<Integer, List<EdgesWithWeight>>();
		List<EdgesWithWeight> list= new ArrayList<EdgesWithWeight>();
		list.add(new EdgesWithWeight(3, 25));
		list.add(new EdgesWithWeight(1, 10));
		adj.put(0, list);
		
		List<EdgesWithWeight> list1= new ArrayList<EdgesWithWeight>();
		list1.add(new EdgesWithWeight(0, 10));
		list1.add(new EdgesWithWeight(2, 10));
		adj.put(1, list1);
		
		List<EdgesWithWeight> list2= new ArrayList<EdgesWithWeight>();
		list2.add(new EdgesWithWeight(1, 10));
		list2.add(new EdgesWithWeight(3, 10));
		adj.put(2, list2);
		
		List<EdgesWithWeight> list3= new ArrayList<EdgesWithWeight>();
		list3.add(new EdgesWithWeight(0, 25));
		list3.add(new EdgesWithWeight(2, 10));
		list3.add(new EdgesWithWeight(4, 2));
		adj.put(3, list3);
		
		List<EdgesWithWeight> list4= new ArrayList<EdgesWithWeight>();
		list4.add(new EdgesWithWeight(3, 2));
		list4.add(new EdgesWithWeight(6, 8));
		list4.add(new EdgesWithWeight(5, 3));
		adj.put(4, list4);
		
		List<EdgesWithWeight> list5= new ArrayList<EdgesWithWeight>();
		list5.add(new EdgesWithWeight(4, 3));
		list5.add(new EdgesWithWeight(6, 3));
		adj.put(5, list5);
		
		List<EdgesWithWeight> list6= new ArrayList<EdgesWithWeight>();
		list6.add(new EdgesWithWeight(4, 8));
		list6.add(new EdgesWithWeight(5, 3));
		adj.put(6, list6);
		DijkstraAlgoForShortPath d= new DijkstraAlgoForShortPath();
		String str= d.DijkstraAlgo(adj, 6);
		
		System.out.println(" str "+str);
	}
}




class EdgesWithWeight implements Comparable<EdgesWithWeight> {
	int edge;
	int weight;
	public EdgesWithWeight(int edge, int weight) {
		this.edge = edge;
		this.weight = weight;
	}
	@Override
	public int compareTo(EdgesWithWeight o) {
		return this.weight-o.weight;
	}
}

class Pair implements Comparable<Pair>{
	int v;
	String path;
	int w;
	@Override
	public String toString() {
		return "Pair [v=" + v + ", path=" + path + ", w=" + w + "]";
	}
	public Pair(int v, String path, int w) {
		this.v = v;
		this.path = path;
		this.w = w;
	}
	@Override
	public int compareTo(Pair o) {
		return (this.w -o.w);
	}
}