import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[] parent1;
	static int[] parent2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		ArrayList<Integer[]>[] graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		// 그래프 생성
		int prev = 0;
		for (int i = 0; i < M + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[from].add(new Integer[] { to, w });
			graph[to].add(new Integer[] { from, w });
		}

		boolean[] visited = new boolean[N + 1];
		PriorityQueue<Integer[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		queue.add(new Integer[] { 0, 1 });

		boolean[] visited1 = new boolean[N + 1];
		PriorityQueue<Integer[]> queue1 = new PriorityQueue<>((a, b) -> b[1] - a[1]);
		queue1.add(new Integer[] { 0, 1 });

		int answer = 0;
		while (!queue.isEmpty()) {
			Integer[] tmp = queue.poll();
			int cur = tmp[0];
			int w = tmp[1];

			if (visited[cur])
				continue;

			visited[cur] = true;
			if (w == 0) {
				answer += 1;
			}

			for (Integer[] next : graph[cur]) {
				if (!visited[next[0]]) {
					queue.add(next);
				}
			}
		}

		int answer1 = 0;
		while (!queue1.isEmpty()) {
			Integer[] tmp = queue1.poll();
			int cur = tmp[0];
			int w = tmp[1];

			if (visited1[cur])
				continue;

			visited1[cur] = true;
			if (w == 0) {
				answer1 += 1;
			}

			for (Integer[] next : graph[cur]) {
				if (!visited1[next[0]]) {
					queue1.add(next);
				}
			}
		}

		System.out.println(answer * answer - answer1 * answer1);
	}

}