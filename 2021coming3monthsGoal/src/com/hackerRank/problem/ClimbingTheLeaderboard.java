package com.hackerRank.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ClimbingTheLeaderboard {
	
	public static void main(String[] args) {
		Integer[] ranked= {100,100,50,40,40,20,10};
		Integer[] player= {5,25,50,120};
		List<Integer> rankedList=Arrays.asList(ranked);
		List<Integer> playerList=Arrays.asList(player);
		
		List<Integer> ranksOfPlayer= FindPlayerRanks(rankedList,playerList);
		
		System.out.println("ranksOfPlayer "+ranksOfPlayer);
	}

	private static List<Integer> FindPlayerRanks(List<Integer> rankedList, List<Integer> playerList) {
		
		int n=rankedList.size();
		List<Integer> result=new ArrayList<>();
		HashMap<Integer,Integer> mapRank= new HashMap<>();
        int rank=1;
	    for(int ranks:rankedList) {
	    	if(!mapRank.containsKey(ranks)) {
	    		mapRank.put(ranks, rank++);
	    	}
	    }
        
	    int j=n-1;
	    for(int play: playerList ) {
	    	for(int i=j;i>=0;i--) {
	    		if(play>=rankedList.get(j)) {
	    			rank=mapRank.get(rankedList.get(j));
	    			j=j-1;
	    		}else {
	    			break;
	    		}
	    	}
	    	result.add(rank);
	    }
		return result;
	}

	private static Integer binarySearch(List<Integer> rankedList, Integer key) {
		int lo= 1;
		int hi=rankedList.size()-1;
		
		while(lo<=hi) {
			int mid=lo+(hi-lo)/2;
			if(rankedList.get(mid)==key) {
				return mid;
			}else if(rankedList.get(mid)<key && key<rankedList.get(mid-1)) {
				return mid;
			}else if(rankedList.get(mid)>key && key>=rankedList.get(mid+1)) {
				return mid+1;
			}else if(rankedList.get(mid)>key) {
				lo= mid+1;
			}else if(rankedList.get(mid)<key) {
				hi=mid-1;
			}
			
		}
		return -1;
	}

}
