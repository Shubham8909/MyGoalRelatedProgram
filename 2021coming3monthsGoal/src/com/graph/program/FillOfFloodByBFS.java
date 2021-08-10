package com.graph.program;

import java.util.LinkedList;
import java.util.Queue;

public class FillOfFloodByBFS {

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int x = image.length;
		int y = image[0].length;
		boolean visited[][] = new boolean[x][y];
		int oldColor = image[sr][sc];

		Queue<int[]> queue = new LinkedList<>();
		int[] start = { sr, sc };
		queue.add(start);

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int i = curr[0];
			int j = curr[1];
			image[i][j] = newColor;
			visited[i][j] = true;

			if ((i + 1) >= 0 && j >= 0 && (i + 1) < x && j < y && image[i + 1][j] == oldColor && !visited[i + 1][j]) {
				image[i + 1][j] = newColor;
				int[] a = { i + 1, j };
				queue.add(a);
			}
			if (i >= 0 && (j + 1) >= 0 && i < x && (j + 1) < y && image[i][j + 1] == oldColor && !visited[i][j + 1]) {
				image[i][j + 1] = newColor;
				int[] a = { i, j + 1 };
				queue.add(a);
			}
			if ((i - 1) >= 0 && j >= 0 && (i - 1) < x && j < y && image[i - 1][j] == oldColor && !visited[i - 1][j]) {
				image[i - 1][j] = newColor;
				int[] a = { i - 1, j };
				queue.add(a);
			}
			if (i >= 0 && (j - 1) >= 0 && i < x && (j - 1) < y && image[i][j - 1] == oldColor && !visited[i][j - 1]) {
				image[i][j - 1] = newColor;
				int[] a = { i, j - 1 };
				queue.add(a);
			}

		}
		return image;
	}

}
