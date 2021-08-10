package com.trie.program;

public class MainTrie {
	
	public static void main(String[] args) {
		Trie tr= new Trie();
		tr.insert("a");
		tr.insert("a");
		
		
		System.out.println("Root +>"+tr.root);
		System.out.println(tr.search("nitin"));
		System.out.println(tr.search("shubham"));
		
	
		System.out.println(tr.deleteRecusion("ver"));
		System.out.println("Root +>"+tr.root);
		
		
	}

}
