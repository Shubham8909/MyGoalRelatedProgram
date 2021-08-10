package com.graph.program;

import java.util.ArrayList;
import java.util.List;

public class DetectCylceUsingDFS {

public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean[] visited = new boolean[V]; 
        boolean[] recStack = new boolean[V]; 
          
          
        // Call the recursive helper function to 
        // detect cycle in different DFS trees 
        for (int i = 0; i < V; i++) 
            if (isCyclicUtil1(i, visited,recStack, adj)) 
                return true; 
  
        return false;
    }
    
    
     boolean isCyclicUtil1(int i, boolean[] visited, 
                                      boolean[] recStack,ArrayList<ArrayList<Integer>> adj)  
    { 
        if (recStack[i]) 
            return true; 
  
        if (visited[i]) 
            return false; 
              
        visited[i] = true; 
  
        recStack[i] = true; 
        List<Integer> children = adj.get(i); 
          
        for (Integer c: children) 
            if (isCyclicUtil1(c, visited, recStack,adj)) 
                return true; 
                  
        recStack[i] = false; 
  
        return false; 
    }
}
