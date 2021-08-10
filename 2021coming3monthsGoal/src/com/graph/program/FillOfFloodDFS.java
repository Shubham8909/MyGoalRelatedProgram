package com.graph.program;

public class FillOfFloodDFS {
	
	 public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
	    {
	       int x=image.length;
	       int y=image[0].length;
	       boolean visited[][]=new boolean[x][y];
	       int oldColor = image[sr][sc];
	       dfs(image,sr,sc,newColor,oldColor,visited,x,y);
	       return image;
	    }
	    
	    public void dfs(int[][] image, int i, int j, int newColor,int oldColor,boolean visited[][],int m,int n )
	    {
	        if(i<0 || j<0 || i>=m || j>=n) return;
	        if(visited[i][j] || image[i][j]!=oldColor) return;
	        image[i][j]=newColor;
	        visited[i][j]=true;
	        dfs(image,i+1,j,newColor,oldColor,visited,m,n);
	        dfs(image,i-1,j,newColor,oldColor,visited,m,n);
	        dfs(image,i,j+1,newColor,oldColor,visited,m,n);
	        dfs(image,i,j-1,newColor,oldColor,visited,m,n);
	        
	    }

}
