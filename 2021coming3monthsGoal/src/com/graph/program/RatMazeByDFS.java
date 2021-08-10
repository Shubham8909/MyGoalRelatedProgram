package com.graph.program;

import java.util.ArrayList;
import java.util.Collections;

public class RatMazeByDFS {
	
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> list= new ArrayList<String>();
        int[][] visited= new int[n][n];
        if(m[0][0]==0) return list; 
        if(m[n-1][n-1]==0) return list;
        String s="";
        dfs(m,n,0,0,list,s,visited);
        Collections.sort(list);
        return list;
        
      }
      
      public static void dfs(int[][] m, int n,int i, int j, ArrayList<String> list,String s,int[][] visited){
          
          if(i<0 || j<0 || i>=n || j>=n) return;
          if(m[i][j] ==0 || visited[i][j]==1) return ;
          if(i==n-1 && j==n-1){
              list.add(s);
              return;
          }
          visited[i][j]=1;
          dfs(m,n,i+1,j,list,s+"D",visited);
          dfs(m,n,i-1,j,list,s+"U",visited);
          dfs(m,n,i,j+1,list,s+"R",visited);
          dfs(m,n,i,j-1,list,s+"L",visited);

           visited[i][j]=0;
      }

}
