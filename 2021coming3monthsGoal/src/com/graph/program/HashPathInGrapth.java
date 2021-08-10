package com.graph.program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class HashPathInGrapth {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int vertex = sc.nextInt();

		Map<Integer, List<Edges>> adj = new HashMap<Integer, List<Edges>>();
		for (int i = 0; i < vertex; i++) {
			adj.put(i, new ArrayList<Edges>());
		}
		int edges = sc.nextInt();
		for (int i = 0; i < edges; i++) {
			String edgesValue1 = sc.next();
			String edgesValue[] = edgesValue1.split("");
			int v1 = Integer.parseInt(edgesValue[0]);
			int v2 = Integer.parseInt(edgesValue[1]);
			int wt = Integer.parseInt(edgesValue[2]);
			adj.get(v1).add(new Edges(v1, v2, wt));
			adj.get(v2).add(new Edges(v2, v1, wt));
		}

		int src = sc.nextInt();
		int des = sc.nextInt();
		System.out.println("ADj " + adj);
		boolean hasPath = isHavingPath(adj, src, des, vertex);
		System.out.println("It having path = " + hasPath);
		sc.close();

	}

	private static boolean isHavingPath(Map<Integer, List<Edges>> adj, int src, int des, int vertex) {

		boolean visited[] = new boolean[vertex];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(src);
		visited[src] = true;
		while (!queue.isEmpty()) {
			int v = queue.poll();
			Iterator<Edges> itr = adj.get(v).iterator();
			while (itr.hasNext()) {
				Edges ed = itr.next();
				int v2 = ed.v2;
				if (v2 == des)
					return true;
				if (!visited[v2]) {
					visited[v2] = true;
					queue.add(v2);
				}
			}
		}

		System.out.println(Arrays.toString(visited));

		return false;
	}

}

class Edges {
	int v1;
	int v2;
	int wt;

	public Edges(int v1, int v2, int wt) {
		this.v1 = v1;
		this.v2 = v2;
		this.wt = wt;
	}

	@Override
	public String toString() {
		return "Edges [v1=" + v1 + ", v2=" + v2 + ", wt=" + wt + "]";
	}

}
