package com.graph.program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class PrimsAlgo {
	
	public String primsAlgo(Map<Integer, List<EdgesWithWeight1>> adj, int v) {
		boolean visited[]= new boolean[v+1];
	    PriorityQueue<Pair1> pQueue=new PriorityQueue<Pair1>();
	    pQueue.add(new Pair1(0, -1, 0));
	    while(!pQueue.isEmpty()) {
	    	Pair1 p= pQueue.poll();
			
			if (visited[p.v]) {
				continue;
			}
			visited[p.v] = true;
			 
	    	System.out.println("p -: "+p);
	    	Iterator<EdgesWithWeight1> itr= adj.get(p.v).iterator();
	    	while(itr.hasNext()) {
	    		EdgesWithWeight1 ed=itr.next();
	    		if(!visited[ed.edge]) {
	    			Pair1 p1=new Pair1(ed.edge, p.v, ed.weight);
	    			pQueue.add(p1);
	    		}
	    	}
	    }
		
	    return "";
	}
	
	public static void main(String[] args) {
		
		Map<Integer, List<EdgesWithWeight1>> adj= new HashMap<Integer, List<EdgesWithWeight1>>();
		List<EdgesWithWeight1> list= new ArrayList<EdgesWithWeight1>();
		list.add(new EdgesWithWeight1(3, 40));
		list.add(new EdgesWithWeight1(1, 10));
		adj.put(0, list);
		
		List<EdgesWithWeight1> list1= new ArrayList<EdgesWithWeight1>();
		list1.add(new EdgesWithWeight1(0, 10));
		list1.add(new EdgesWithWeight1(2, 10));
		adj.put(1, list1);
		
		List<EdgesWithWeight1> list2= new ArrayList<EdgesWithWeight1>();
		list2.add(new EdgesWithWeight1(1, 10));
		list2.add(new EdgesWithWeight1(3, 10));
		adj.put(2, list2);
		
		List<EdgesWithWeight1> list3= new ArrayList<EdgesWithWeight1>();
		list3.add(new EdgesWithWeight1(0, 40));
		list3.add(new EdgesWithWeight1(2, 10));
		list3.add(new EdgesWithWeight1(4, 2));
		adj.put(3, list3);
		
		List<EdgesWithWeight1> list4= new ArrayList<EdgesWithWeight1>();
		list4.add(new EdgesWithWeight1(3, 2));
		list4.add(new EdgesWithWeight1(6, 8));
		list4.add(new EdgesWithWeight1(5, 3));
		adj.put(4, list4);
		
		List<EdgesWithWeight1> list5= new ArrayList<EdgesWithWeight1>();
		list5.add(new EdgesWithWeight1(4, 3));
		list5.add(new EdgesWithWeight1(6, 3));
		adj.put(5, list5);
		
		List<EdgesWithWeight1> list6= new ArrayList<EdgesWithWeight1>();
		list6.add(new EdgesWithWeight1(4, 8));
		list6.add(new EdgesWithWeight1(5, 3));
		adj.put(6, list6);
		PrimsAlgo d= new PrimsAlgo();
		String str= d.primsAlgo(adj, 6);
		
		System.out.println(" str "+str);
	}
}




class EdgesWithWeight1 implements Comparable<EdgesWithWeight1> {
	int edge;
	int weight;
	public EdgesWithWeight1(int edge, int weight) {
		this.edge = edge;
		this.weight = weight;
	}
	@Override
	public int compareTo(EdgesWithWeight1 o) {
		return this.weight-o.weight;
	}
}

class Pair1 implements Comparable<Pair1>{
	int v;
	int parent;
	int w;
	@Override
	public String toString() {
		return "Pair [v=" + v + ", parent=" + parent + ", w=" + w + "]";
	}
	public Pair1(int v, int parent, int w) {
		this.v = v;
		this.parent = parent;
		this.w = w;
	}
	@Override
	public int compareTo(Pair1 o) {
		return (this.w -o.w);
	}

}
