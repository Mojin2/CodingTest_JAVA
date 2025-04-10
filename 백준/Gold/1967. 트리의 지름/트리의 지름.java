
//12
//1 2 3
//1 3 2
//2 4 5
//3 5 11
//3 6 9
//4 7 1
//4 8 7
//5 9 15
//5 10 4
//6 11 6
//6 12 10
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
	static ArrayList<Integer[]>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		boolean[] visited = new boolean[N + 1];
		graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph[from].add(new Integer[] { to, weight });
			graph[to].add(new Integer[] { from, weight });
		}

		int[] tmp = Dij(1);
//		System.out.println(Arrays.toString(tmp));
		int[] answer = Dij(tmp[1]);
		System.out.println(answer[0]);
	}

	private static int[] Dij(int start) {

		int max = 0;
		int MaxNode = start;

		boolean[] visited = new boolean[N + 1];
		int[] distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		PriorityQueue<Integer[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		queue.add(new Integer[] { start, 0 });
		distance[start] = 0;

		while (!queue.isEmpty()) {
			Integer[] currentNode = queue.poll();
			int cur = currentNode[0];
			int cost = currentNode[1];

			if (visited[cur])
				continue;
			visited[cur] = true;

			for (Integer[] nextNode : graph[cur]) {
				int next = nextNode[0];
				if (distance[next] > distance[cur] + nextNode[1]) {
					distance[next] = distance[cur] + nextNode[1];
					if (max < distance[next]) {
						max = distance[next];
						MaxNode = next;
					}

					queue.offer(new Integer[] { next, distance[next] });
				}
			}
		}

		return new int[] { max, MaxNode };
	}
}
