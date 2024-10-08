import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;
	static int V;
	static int E;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			queue.add(new Integer[] { from, to, w });
		}

		int answer = 0;
		parent = new int[V + 1];
		for (int i = 0; i < V + 1; i++) {
			parent[i] = i;
		}

		while (!queue.isEmpty()) {
			Integer[] tmp = queue.poll();
			int x = tmp[0];
			int y = tmp[1];
			int w = tmp[2];

			if (find(x) != find(y)) {
				union(x, y);
				answer += w;
			}
		}

		System.out.println(answer);
	}

	private static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);

	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return;

		if (x < y) {
			parent[y] = x;
		} else {
			parent[x] = y;
		}
	}

}