import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;
	static int N;
	static int M;
	static int t;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		ArrayList<Integer[]>[] graph = new ArrayList[N + 1];
		boolean[] visited = new boolean[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		PriorityQueue<Integer[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph[from].add(new Integer[] { to, weight });
			graph[to].add(new Integer[] { from, weight });
		}

		queue.add(new Integer[] { 1, 0 });
		int answer = 0;
		int level = 0;

		while (!queue.isEmpty()) {

			Integer[] tmp = queue.poll();
			int cur = tmp[0];
			int weight = tmp[1];

			if (visited[cur])
				continue;

			visited[cur] = true;
			answer += weight + level * t;
			if (cur != 1)
				level++;

			for (Integer[] next : graph[cur]) {
				if (!visited[next[0]]) {
					queue.add(next);
				}
			}
		}
		System.out.println(answer);

	}
}