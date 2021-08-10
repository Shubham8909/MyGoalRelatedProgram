package com.trie.program;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	
	private class TrieNode{
		Map<Character, TrieNode> children;
		boolean endOfWord;
		public TrieNode() {
			this.children = new HashMap<>();
			this.endOfWord=false;
		}
		@Override
		public String toString() {
			return "TrieNode [children=" + children + ", endOfWord=" + endOfWord + "]";
		}
		
	}
	
	public final TrieNode root;
	public Trie() {
		root=new TrieNode();
	}
	
	@Override
	public String toString() {
		return "Trie [root=" + root + "]";
	}

	//without recursion 
	public void insert(String word) {
		TrieNode currentNode=root;
		for(int i=0; i<word.length(); i++) {
			char ch= word.charAt(i);
			TrieNode node= currentNode.children.get(ch);
			if(node==null) {
				node=new TrieNode();
				currentNode.children.put(ch, node);
			}
			currentNode=node;
		}
		currentNode.endOfWord=true;
	}
	
	//with recursion
	public void inserWithRecursion(String word) {
		inserWithRecursionUtil(root,word,0);
	}
	
	private void inserWithRecursionUtil(TrieNode current, String word, int index) {
		if(index==word.length()) {
			current.endOfWord=true;
			return;
		}
		char ch= word.charAt(index);
		TrieNode node= current.children.get(ch);
		if(node==null) {
			node=new TrieNode();
			current.children.put(ch, node);
		}
		inserWithRecursionUtil(node,word,index+1);
	}
	
	//Search trie
	
	public boolean search(String word) {
		TrieNode current = root;
		for(int i=0; i<word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if(node==null) {
				return false;
			}
			current=node;
		}
		return current.endOfWord;
	}
	
	//Search Using Recursion
	
	public boolean searchRecusion(String word) {
		return searchRecusionUtil(word,root,0);
	}
	private boolean searchRecusionUtil(String word, TrieNode current, int index) {
		if(index==word.length()) {
			return current.endOfWord;
		}
		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		if(node==null) {
			return false;
		}
		return searchRecusionUtil(word,node,index+1);
	}
	//delete Recursion
	public boolean deleteRecusion(String word) {
		return deleteRecusionUtil(word,root,0);
	}
	
	private boolean deleteRecusionUtil(String word, TrieNode current, int index) {
		if(index==word.length()) {
			//when end of the word is reached only delete if current.endOfWord is true.
			if(!current.endOfWord) {
				return false;
			}
			current.endOfWord=false;
			return current.children.size()==0;
		}
		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		if(node==null) {
			return false;
		}
		boolean deleteCurrentnode=deleteRecusionUtil(word,node,index+1);
		if(deleteCurrentnode) {
			current.children.remove(ch);
			return current.children.size()==0;
		}
		return false;
	}
	

}
