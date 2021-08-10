package com.graph.program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CreateGraph {
	static int vertex;
	int egdes;
	static Map<Integer,List<Integer>> adj;
	public CreateGraph(int v) {
		CreateGraph.vertex=v;
		adj=new HashMap<>();
		for(int i=0;i<=v;i++) {
			adj.put(i, new ArrayList<Integer>());
		}
	}
	
	public void addEdges(int v, int e) {
		if(adj.containsKey(v))
		  adj.get(v).add(e);
		else {
			ArrayList<Integer>  list= new ArrayList<Integer>();
			list.add(e);
			adj.put(v,list);
		}
	}
	
  public void printGraph() {
	  for(Map.Entry<Integer, List<Integer>> entry :adj.entrySet()) {
		  System.out.println("vertex "+entry.getKey()+" -- >"+entry.getValue());
	  }
  }

	public static void main(String[] args) {
	
		CreateGraph graph= new CreateGraph(10);
		
		graph.addEdges(1, 3);
	    graph.addEdges(1, 4);
	    graph.addEdges(1, 5);
	    graph.addEdges(2, 3);
	    graph.addEdges(2, 8);
	    graph.addEdges(2, 9);
	    graph.addEdges(3, 6);
	    graph.addEdges(4, 6);
	    graph.addEdges(4, 8);
	    graph.addEdges(5, 8);
	    graph.addEdges(6, 7);
	    graph.addEdges(7, 8);
	    graph.addEdges(8, 10);

		graph.printGraph();
		
		GraphBFS bfs= new GraphBFS();
		List<Integer> list=bfs.BFS(adj,vertex);
		System.out.println("BFS -> "+list);
		
		GraphDFS dfs= new GraphDFS();
		List<Integer> listDfs=dfs.DFS(adj,vertex);
		System.out.println("DFS -> "+listDfs);
		
		
		ArticulationPointInGraph ap= new ArticulationPointInGraph();
		List<Integer> listAp=ap.findArticularPoint(vertex,adj);
		System.out.println("Find arti -> "+listAp);
		
		BrigdeIntheGrapth brigde=new BrigdeIntheGrapth();
		List<List<Integer>> listBri=brigde.findBirdgeInGraph(vertex,adj);
		System.out.println("Find bridge -> "+listBri);
		
		ShortedPathToReachSorceToDest shrt=new ShortedPathToReachSorceToDest();
		List<Integer> listshrt=shrt.SortedPath(adj, vertex);
		System.out.println("Find shorted path -> "+listshrt);
		
		MinimumTimeTakenByEachJob min=new MinimumTimeTakenByEachJob();
		int [] ans=min.minimumTimeTakenByEachJobInDirectedGraph(adj, vertex);
		for(int a: ans) { if(a==0) continue; System.out.print(a+" ");}
	}

}
