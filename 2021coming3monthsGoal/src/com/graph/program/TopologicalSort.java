package com.graph.program;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {
	
	static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        
	       int ans[]= new int[V];
	       Queue<Integer> queue= new LinkedList<Integer>();
	       int in_degree[]= new int[V];
	       for(List<Integer> list :adj){
	           for(int i: list){
	               in_degree[i]++;
	           }
	       }
	       
	      for(int j=0; j<V;j++){
	          if(in_degree[j]==0){
	              queue.add(j);
	          }
	      }
	      
	      int i=0;
	      while(!queue.isEmpty()){
	          int x=queue.poll();
	          ans[i]=x;
	          Iterator<Integer> itr= adj.get(x).listIterator();
	          while(itr.hasNext()) {
					int y=itr.next();
			          in_degree[y]--;
			          if(in_degree[y]==0){
			              queue.add(y);
			          }
				}
				i++;
	      }
	        
	        return ans;
	    }

}
