//3 11
//0 2
//5 0
//4 3

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static boolean[] visited;
	static int[] parent;
	static int cost;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];
		parent = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			parent[i] = i;
		}

		int[][] list = new int[fac(N - 1)][3];
		cost = 0;
		count = 0;
		int listIndex = 0;

		int[][] points = new int[N][2];
		int pointsIndex = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			points[pointsIndex++] = new int[] { x, y };
		}

		for (int i = 0; i < N; i++) {
			int cx = points[i][0];
			int cy = points[i][1];

			for (int j = i + 1; j < N; j++) {
				int nx = points[j][0];
				int ny = points[j][1];

				int distance = getDistance(new int[] { cx, cy }, new int[] { nx, ny });
				list[listIndex++] = new int[] { i, j, distance };
			}
		}

		// 길이가 먼 순서대로 정렬
		Arrays.sort(list, (a, b) -> a[2] - b[2]);
//		System.out.println(Arrays.deepToString(list));

		// 크루스칼 알고리즘
		for (int i = 0; i < list.length; i++) {

			if (list[i][2] < C)
				continue;
			if ((find(list[i][0]) != find(list[i][1]))) {
				union(list[i][0], list[i][1]);
				cost += list[i][2];
				count++;
			}
		}

		if (count == N - 1) {
			System.out.println(cost);
		} else {
			System.out.println(-1);
		}

	}

	public static int find(int x) {
		if (parent[x] == x)
			return x;
		else
			return find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x < y)
			parent[y] = x;
		else
			parent[x] = y;
	}

	public static int getDistance(int[] one, int[] two) {
		return (int) Math.pow(one[0] - two[0], 2) + (int) Math.pow(one[1] - two[1], 2);
	}

	public static int fac(int n) {
		if (n == 1)
			return 1;

		return n + fac(n - 1);
	}
}

class Edge {
	int from, weight;

	Edge(int from, int weight) {
		this.from = from;
		this.weight = weight;
	}

	@Override
	public String toString() {
		String tmp = String.valueOf(from) + "로 가는 " + String.valueOf(weight) + "의 거리";
		return tmp;
	}
}