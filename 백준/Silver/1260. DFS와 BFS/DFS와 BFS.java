//4 5 1
//1 2
//1 3
//1 4
//2 4
//3 4

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer>[] graph;
	static boolean[] BFSvisited;
	static boolean[] DFSvisited;
	static StringBuilder BFSsb;
	static StringBuilder DFSsb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int start = Integer.parseInt(st.nextToken());

		graph = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}

		BFSvisited = new boolean[V + 1];
		DFSvisited = new boolean[V + 1];
		BFSsb = new StringBuilder();
		DFSsb = new StringBuilder();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			graph[from].add(to);
			graph[to].add(from);
		}

		for (int i = 0; i <= V; i++) {
			Collections.sort(graph[i]);
		}

		BFS(start);
		DFS(start);

		System.out.println(DFSsb);
		System.out.println(BFSsb);
	}

	private static void DFS(int start) {
		DFSvisited[start] = true;
		DFSsb.append(start).append(" ");

		for (int next : graph[start]) {
			if (!DFSvisited[next]) {
				DFS(next);
			}
		}
	}

	private static void BFS(int start) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		BFSvisited[start] = true;

		while (queue.size() > 0) {
			int cur = queue.poll();
			BFSsb.append(cur).append(" ");

			for (int next : graph[cur]) {
				if (!BFSvisited[next]) {
					BFSvisited[next] = true;
					queue.add(next);
				}
			}
		}
	}
}