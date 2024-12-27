import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

//5 5 1
//1 4
//1 2
//2 3
//2 4
//3 4

public class Main {

	static boolean[] visited;
	static ArrayList<Integer>[] graph;
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

		BFS(start, 1);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			sb.append(answer[i]).append("\n");
		}
		System.out.println(sb);
	}

	private static void BFS(int start, int order) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		visited[start] = true;
		queue.add(start);
//		answer.add(start);

		while (queue.size() > 0) {
			int cur = queue.poll();
			answer[cur] = order++;

			for (int next : graph[cur]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next);
				}
			}
		}

	}
}