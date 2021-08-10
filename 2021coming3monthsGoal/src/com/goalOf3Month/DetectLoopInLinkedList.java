package com.goalOf3Month;

import java.util.HashSet;

public class DetectLoopInLinkedList {

	public static void main(String[] args) {
		Node1 n = null;
		detectedLoop(n);
	}

	/// 1- 2- 3 -4-5-
//	          |    |

	private static boolean detectedLoop(Node1 n) {
		HashSet<Node1> h = new HashSet<Node1>();
		while (n != null) {
			if (h.contains(n)) {
				return true;
			}
			h.add(n);
			n = n.next;
		}
		return false;
	}

	private static boolean detectedAndRemovedLoop(Node1 n) {
		HashSet<Node1> h = new HashSet<Node1>();
		Node1 curr=n;
		Node1 prev=n;
		int count=0;
		boolean flag =false;
		while (curr != null) {
			if (h.contains(curr)) {
				flag=true;
				break;
			}
			h.add(curr);
			curr = curr.next;
			if(count>0) {
			  prev= prev.next;
			}
			count++;
		}
		if(flag) {
			prev.next=null;
			
		}
		return false;
	}

}

class Node1 {

	int data;
	Node1 next;
}
