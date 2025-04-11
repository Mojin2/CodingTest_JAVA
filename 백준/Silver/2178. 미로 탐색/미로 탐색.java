import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.plaf.IconUIResource;

//4 6
//101111
//101010
//101011
//111011

public class Main {

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static boolean[][] visited;
	static int[][] board;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String[] s = st.nextToken().split("");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(s[j]);
			}
		}
		int[] start = new int[] { 0, 0 };
//		[[1, 0, 1, 1, 0, 0], 
//		[1, 0, 1, 0, 0, 0], 
//		[1, 0, 1, 0, 0, 0], 
//		[1, 1, 1, 0, 0, 0]]

		BFS(start);

//		System.out.println(Arrays.deepToString(board));

	}

	private static void BFS(int[] start) {
		int startX = start[0];
		int startY = start[1];
		ArrayDeque<Integer[]> queue = new ArrayDeque<>();
		queue.add(new Integer[] { startX, startY, 1 });
		visited[startX][startY] = true;

		while (!queue.isEmpty()) {
			Integer[] tmp = queue.poll();
			int curX = tmp[0];
			int curY = tmp[1];
			int distance = tmp[2];

			if (curX == N - 1 && curY == M - 1) {
				System.out.println(distance);
				break;
			}

			for (int k = 0; k < 4; k++) {
				int nx = curX + dx[k];
				int ny = curY + dy[k];

				if (0 > nx || nx >= N || 0 > ny || ny >= M)
					continue;

				if (!visited[nx][ny] && board[nx][ny] == 1) {
					visited[nx][ny] = true;
					queue.add(new Integer[] { nx, ny, distance + 1 });

				}
			}
		}

	}
}
