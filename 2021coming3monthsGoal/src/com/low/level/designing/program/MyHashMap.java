package com.low.level.designing.program;
public class MyHashMap {

	/** Initialize your data structure here. */
	Node[] nodes;

	public MyHashMap() {
		nodes = new Node[2096];
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		Node node = nodes[key % 2096];
		if (node == null) {
			nodes[key % 2096] = new Node(key, value);
		} else {
			while (node.getNextNode() != null && node.getKey() != key) {
				node = node.getNextNode();
			}
			if (node.getKey() == key) {
				node.setVal(value);
			} else {
				node.setNextNode(new Node(key, value));
			}
		}
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map
	 * contains no mapping for the key
	 */
	public int get(int key) {
		Node node = nodes[key % 2096];
		while (node != null && node.getKey() != key) {
			node = node.getNextNode();
		}
		return node == null ? -1 : node.getVal();
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping
	 * for the key
	 */
	public void remove(int key) {
		Node node = nodes[key % 2096];
		if (node != null) {
			if (node.getKey() == key) {
				nodes[key % 2096] = node.getNextNode();
			} else {
				while (node.getNextNode() != null && node.getNextNode().getKey() != key) {
					node = node.getNextNode();
				}
				if (node.getNextNode() != null) {
					node.setNextNode(node.getNextNode().getNextNode());
				}
			}
		}
	}
}

class Node {
	int val;
	int key;
	Node nextNode;

	public Node(int key, int val) {
		this.key = key;
		this.val = val;
		this.nextNode = null;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	public int getVal() {
		return val;
	}

	public int getKey() {
		return key;
	}

	public Node getNextNode() {
		return nextNode;
	}
}