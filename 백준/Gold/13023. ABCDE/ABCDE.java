import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;
	static ArrayList<Integer>[] graph;
	static int answer;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[2000];

		for (int i = 0; i < 2000; i++)
			graph[i] = new ArrayList<>();

		answer = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from].add(to);
			graph[to].add(from);
		}

		flag = false;
		for (int i = 0; i < N; i++) {
			boolean[] visited = new boolean[2000];

			if (!visited[i]) {
				visited[i] = true;
				DFS(i, 0, graph, visited);
				visited[i] = false;

				if (flag)
					break;
			}
		}

		System.out.println(answer);
	}

	private static void DFS(int cur, int cnt, ArrayList<Integer>[] graph, boolean[] visited) {
		if (cnt == 4) {
			answer = 1;
			flag = true;
			return;
		}

		for (int next : graph[cur]) {
			if (!visited[next]) {
				visited[next] = true;
				DFS(next, cnt + 1, graph, visited);
				visited[next] = false;
			}
		}
	}

}