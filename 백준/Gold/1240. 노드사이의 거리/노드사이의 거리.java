import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer[]>[] graph;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[from].add(new Integer[] { to, w });
			graph[to].add(new Integer[] { from, w });
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int des = Integer.parseInt(st.nextToken());
			dij(start, des);
		}

	}

	private static void dij(int start, int des) {
		int[] distance = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[start] = 0;

		PriorityQueue<Integer[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		queue.add(new Integer[] { start, 0 });

		while (!queue.isEmpty()) {
			Integer[] curNode = queue.poll();
			int cur = curNode[0];

			for (Integer[] t : graph[cur]) {
				int next = t[0];
				int nextDistance = t[1];
				int tmp = distance[cur] + nextDistance;
				if (distance[next] > tmp) {
					distance[next] = tmp;
					queue.add(new Integer[] { next, distance[next] });
				}
			}
		}
		System.out.println(distance[des]);
	}

}