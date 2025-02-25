import java.awt.font.GraphicAttribute;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

//4 3
//1 2 3
//2 3 2
//2 4 4
//1 2
//4 1
//3 1

public class Main {

	static ArrayDeque<Integer[]>[] graph;
	static boolean[] visited;
	static int N, Q;
	static int count;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		// 그래프 생성
		graph = new ArrayDeque[N + 1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayDeque<>();
		}

		Q = Integer.parseInt(st.nextToken());
		answer = 0;

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			graph[p].add(new Integer[] { q, r });
			graph[q].add(new Integer[] { p, r });
		}

		for (int i = 0; i < Q; i++) {
//			System.out.println("================");
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			visited = new boolean[N + 1];
			count = 0;
			BFS(v, k);
			System.out.println(count);
//			System.out.println("================");
		}

	}

	private static void BFS(int start, int limit) {
		ArrayDeque<Integer[]> queue = new ArrayDeque<>();
		queue.add(new Integer[] { start, Integer.MAX_VALUE });
		visited[start] = true;

		while (!queue.isEmpty()) {
			Integer[] tmp = queue.poll();
			int cur = tmp[0];
			int curUsado = tmp[1];

			for (Integer[] n : graph[cur]) {
				int next = n[0];
				int nextUsado = n[1];
//				System.out.println("차례 : " + next);

				int usado = Math.min(curUsado, nextUsado);

				if (usado >= limit && !visited[next]) {
//					System.out.println(next);
					queue.add(new Integer[] { next, usado });
					visited[next] = true;
					count++;
//					System.out.println("들어감 : " + next);

				}
			}
		}
	}
}