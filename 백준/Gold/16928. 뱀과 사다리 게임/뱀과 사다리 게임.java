import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

//3 7
//32 62
//42 68
//12 98
//95 13
//97 25
//93 37
//79 27
//75 19
//49 47
//67 17

public class Main {

	static HashMap<Integer, Integer> map;
	static boolean[] visited = new boolean[101];
	static int[] move = new int[101];
	static int[] dx = { 1, 2, 3, 4, 5, 6 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new HashMap<>();
		Arrays.fill(move, Integer.MAX_VALUE);

		// 사다리 정보
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map.put(from, to);
		}

		// 뱀 정보
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map.put(from, to);
		}

		int ans = BFS(1);
		System.out.println(ans);

	}

	private static int BFS(int start) {
		ArrayDeque<Integer[]> queue = new ArrayDeque<>();
		queue.add(new Integer[] { start, 0 });
		visited[start] = true;

		while (queue.size() > 0) {
//			for (Integer[] a : queue) {
//				System.out.print(Arrays.toString(a) + ", ");
//			}
//			System.out.println();
			Integer[] tmp = queue.poll();
			int cur = tmp[0];
			int count = tmp[1];

			if (cur == 100) {
				return count;
			}

			for (int k = 0; k < 6; k++) {
				int next = cur + dx[k];

				if (map.containsKey(next)) {
					int newNext = map.get(next);
					queue.add(new Integer[] { newNext, count + 1 });
				} else {
					if (next < 1 || next > 100)
						continue;

					if (!visited[next]) {
						visited[next] = true;
						queue.add(new Integer[] { next, count + 1 });
					}
				}
			}
		}
		return 0;
	}
}