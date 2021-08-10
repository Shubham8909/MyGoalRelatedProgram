package com.trie.program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Findshortestuniqueprefixforeveryword {
	public static void main(String[] args) {
		Trie1 t=new Trie1();
		String arr[]= {"zebra","dog","dove","duck"};
		List<String> res=new ArrayList<>();
		for(String s: arr) {
			System.out.println(" "+s);
			t.insert(s);
		}
		System.out.println(t.root);
		for(String s: arr) {
			int index=t.search(s);
			if(index>0) {
			String pre=s.substring(0,index);
			res.add(pre);
			}
		}
		System.out.println(res);
		
	}
}

class Trie1{
	
	private class TrieNode{
		Map<Character, TrieNode> children;
		int frequency;
		public TrieNode(int frequency) {
			this.children=new HashMap<>();
			this.frequency=frequency;
		}
		@Override
		public String toString() {
			return "TrieNode [children=" + children + ", frequency=" + frequency + "]";
		}
		
	}
	public final  TrieNode root;
	
	
	@Override
	public String toString() {
		return "Trie1 [root=" + root + "]";
	}

	public Trie1() {
		root= new TrieNode(0);
	}
	
	void insert(String word) {
		TrieNode current= root;
		for(int i=0; i<word.length(); i++) {
			char ch=word.charAt(i);
			TrieNode node=current.children.get(ch);
			if(node==null) {
				node= new TrieNode(1);
				current.children.put(ch, node);
			}else if(node!=null) {
				int freq=node.frequency;
				freq++;
				node.frequency=freq;
			}
			current=node;
		}
	}
	
	int search(String word) {
		TrieNode current= root;
		int count=0;
		for(int i=0; i<word.length(); i++) {
			char ch=word.charAt(i);
			count++;
			TrieNode node=current.children.get(ch);
			if(node!=null && node.frequency==1) {
				return count;
			}
			current=node;
		}
		return -1;
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}