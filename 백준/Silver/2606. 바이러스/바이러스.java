//7
//6
//1 2
//2 3
//1 5
//5 2
//5 6
//4 7

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken());

		graph = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}
		visited = new boolean[V + 1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			graph[from].add(to);
			graph[to].add(from);
		}

		BFS(1);

		System.out.println(answer);

	}

	private static void BFS(int start) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		visited[start] = true;

		while (queue.size() > 0) {
			int cur = queue.poll();

			for (int next : graph[cur]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next);
					answer++;
				}
			}
		}

	}
}