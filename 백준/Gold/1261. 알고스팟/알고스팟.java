import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;

public class Main {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int N;
	static int M;
	static int[][] board;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		board = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String[] tmp = st.nextToken().split("");
			int[] t = new int[M];
			for (int j = 0; j < M; j++) {
				t[j] = Integer.parseInt(tmp[j]);
			}
			board[i] = t;
		}
//		System.out.println(Arrays.deepToString(board));

		visited = new boolean[N][M];

		BFS(0, 0);
	}

	private static void BFS(int x, int y) {
		PriorityQueue<Integer[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		queue.add(new Integer[] { 0, 0, 0 }); // {x,y,count};
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			Integer[] tmp = queue.poll();
			int cx = tmp[0];
			int cy = tmp[1];
			int cnt = tmp[2];

			if (cx == N - 1 && cy == M - 1) {
				System.out.println(cnt);
			}

			for (int k = 0; k < 4; k++) {
				int nx = cx + dx[k];
				int ny = cy + dy[k];

//				System.out.println(nx + " " + ny);

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;

//				System.out.println("************");
//				System.out.println(nx + " " + ny);

				if (!visited[nx][ny] && board[nx][ny] == 0) {
					visited[nx][ny] = true;
					queue.add(new Integer[] { nx, ny, cnt });
				}

				if (!visited[nx][ny] && board[nx][ny] == 1) {
					visited[nx][ny] = true;
					queue.add(new Integer[] { nx, ny, cnt + 1 });
				}
			}
		}
	}
}