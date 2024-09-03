import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ArrayList<int[]> queue = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			queue.add(new int[] { from, to, w });
		}

		Collections.sort(queue, (a, b) -> b[2] - a[2]);

		parent = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			parent[i] = i;
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int des = Integer.parseInt(st.nextToken());

		for (int[] cur : queue) {
			int cx = cur[0];
			int cy = cur[1];
			int cw = cur[2];
			union(cx, cy);
			if (find(start) == find(des)) {
				System.out.println(cw);
				break;
			}
		}
	}

	static void union(int u, int v) {
		u = find(u);
		v = find(v);

		if (u == v)
			return;

		if (u > v) {
			parent[u] = v;
		} else {
			parent[v] = u;
		}
	}

	static int find(int v) {
		if (v == parent[v])
			return v;

		parent[v] = find(parent[v]);
		return parent[v];
	}
}