package com.array.program;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        @SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int d=sc.nextInt();
        int arr[]= new int[n];
        Map<Integer, Queue<Integer>> map1= new HashMap<>();
       
        //Created Array
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
            if(map1.containsKey(arr[i])){
             Queue<Integer> queue=map1.get(arr[i]);
              Queue<Integer> queue1=new LinkedList<>();
                for(int k=0; k<queue.size();k++) {
                	queue1.add(i+1);
                }
                map1.put(arr[i],queue1);
            } else{
            Queue<Integer> queue=new LinkedList<>();
            queue.add(i+1);
            map1.put(arr[i],queue);
            }
        }
        
        
        for(int j=0; j<d;j++){
        int case1=sc.nextInt();
        int first=0,second=0;
        Map<Integer, Queue<Integer>> map= new HashMap<>(map1);
         for(int i=0; i<n; i++){
             if(map.containsKey(arr[i]+case1)){
                 first=i+1;
                 second=map.get(arr[i]+case1).peek();
             }
                 Queue<Integer> queue=map.get(arr[i]);
                 if(queue!=null && queue.size()>1){
                     queue.poll();
                     map.put(arr[i],queue);
                 }else{
                     map.remove(arr[i]);
                 }
             
         }
        if(first==0 && second==0)
             System.out.println("-1");
        else
         System.out.println(first+" "+second);
            
        }    

    }
}