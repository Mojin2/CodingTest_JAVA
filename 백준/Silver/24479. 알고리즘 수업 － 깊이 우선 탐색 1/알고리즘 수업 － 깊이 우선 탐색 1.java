//5 5 1
//1 4
//1 2
//2 3
//2 4
//3 4

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static boolean[] visited;
	static ArrayList<Integer>[] graph;
	static int[] order;
	static int orderIndex = 1;
	static int[] answer;

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
		visited = new boolean[V + 1];
		order = new int[V + 1];
		answer = new int[V + 1];

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

		DFS(start);
		for (int i = 1; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	private static void DFS(int cur) {
		visited[cur] = true;

		order[orderIndex] = cur;
		answer[cur] = orderIndex;

		orderIndex++;

		for (int next : graph[cur]) {
			if (!visited[next]) {
				DFS(next);
			}
		}
	}
}