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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			queue.add(new Integer[] { from, to, weight });
			queue.add(new Integer[] { to, from, weight });
		}

		ArrayList<Integer> list = new ArrayList<>();
		parent = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			parent[i] = i;
		}

		while (!queue.isEmpty()) {
			Integer[] tmp = queue.poll();
			int x = tmp[0];
			int y = tmp[1];
			int w = tmp[2];

			if (find(x) != find(y)) {
				union(x, y);
				list.add(w);

			}
		}
		int max = 0;
		int answer = 0;
		for (Integer a : list) {
			max = Math.max(max, a);
			answer += a;
		}
		answer -= max;
		System.out.println(answer);

	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return;

		if (x < y)
			parent[y] = x;
		else
			parent[x] = y;
	}

	private static int find(int x) {
		if (x == parent[x])
			return x;
		else
			return parent[x] = find(parent[x]);
	}
}