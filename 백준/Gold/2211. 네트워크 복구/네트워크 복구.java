import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 그래프 생성
		ArrayList<Integer[]>[] graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		// 거리 배열 생성
		int[] distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		// 그래프에 인풋 넣기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph[from].add(new Integer[] { to, weight });
			graph[to].add(new Integer[] { from, weight });
		}

		// 우선순위 큐 생성
		PriorityQueue<Integer[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		queue.add(new Integer[] { 1, 0 });
		distance[1] = 0;

		// 추가되는 간선을 담을 배열 생성
		ArrayList<Integer[]> list = new ArrayList<>();
		int count = 0;
//		boolean[] visited = new boolean[N + 1];
		int[] path = new int[N + 1];

		while (!queue.isEmpty()) {
//			for (Integer[] tm : queue) {
//				System.out.println(Arrays.toString(tm));
//			}
			Integer[] tmp = queue.poll();
			int cur = tmp[0];

			if (tmp[1] > distance[cur])
				continue;

//			if (visited[cur])
//				continue;
//			
//			visited[cur] = true;

			for (Integer[] nextTmp : graph[cur]) {
				int next = nextTmp[0];
				int nextDistance = nextTmp[1];

				if (distance[next] > distance[cur] + nextDistance) {
					list.add(new Integer[] { cur, next });
					path[next] = cur;
					distance[next] = distance[cur] + nextDistance;
					queue.add(new Integer[] { next, distance[next] });

				}
			}
		}
		for (int i = 0; i < N + 1; i++) {
			if (path[i] != 0)
				count++;
		}
		System.out.println(count);

		for (int i = 0; i < N + 1; i++) {
			if (path[i] != 0)
				System.out.println(i+" "+path[i]);
		}

	}

}