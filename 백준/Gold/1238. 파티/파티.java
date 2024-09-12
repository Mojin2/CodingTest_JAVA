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
	static int P;
	static ArrayList<Integer[]>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[from].add(new Integer[] { to, w });
		}

		int max = Integer.MIN_VALUE;
		int[] toP = dij(P);
		for (int i = 1;i <N+1;i++) {
			int[] fromP = dij(i);
			max = Math.max(max, fromP[P]+ toP[i]);  
		}
		System.out.println(max);
	}

	private static int[] dij(int P) {
		int[] distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		PriorityQueue<Integer[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		queue.add(new Integer[] { P, 0 });
		distance[P] = 0;

		while (!queue.isEmpty()) {
			Integer[] tmp = queue.poll();
			int cur = tmp[0];

			for (Integer[] nextTmp : graph[cur]) {
				int next = nextTmp[0];
				int nextDistance = nextTmp[1];

				if (distance[next] > distance[cur] + nextDistance) {
					distance[next] = distance[cur] + nextDistance;
					queue.add(new Integer[] { next, nextDistance });
				}
			}
		}
		return distance;

	}

}