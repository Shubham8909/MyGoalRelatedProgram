package com.backtracking.program;

import java.util.List;

public class M_ColouringProblem {
	
	
	
	
	
	public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int C) 
    {
        return utilGraphColor(i,G,color,C);
    }
    
    private static boolean utilGraphColor(int v,List<Integer>[] G, int[] color, int C) {
        
        if(v>=G.length){
            return true;
        }
        
        for(int i=1; i<=C; i++){
           List<Integer> adj=G[v];
            if(isSafe(adj,i,color)){
                color[v]=i;
                if(utilGraphColor(v+1,G,color,C)){
                    return true;
                }
                color[v]=0;
            }
        }
        return false;
    }
    
    
    private static boolean isSafe(List<Integer> adj,int i,int color[]){

         for(int e: adj){
             if(color[e]==i){
                 return false;
             }
         }  
         
         return true;
    }

}
