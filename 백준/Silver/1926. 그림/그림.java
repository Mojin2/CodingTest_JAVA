//6 5
//1 1 0 1 1
//0 1 1 0 0
//0 0 0 0 0
//1 0 1 1 1
//0 0 1 1 1
//0 0 1 1 1

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int N, M;
	static int[][] board;
	static boolean[][] visited;
	static int ex;
	static int max = Integer.MIN_VALUE;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && board[i][j] == 1) {
					ex = 1;
					DFS(i, j, 1);
					max = Math.max(max, ex);
					cnt++;
				}
			}
		}
		if (cnt == 0) {
			System.out.println(0);
			System.out.println(0);
		} else {
			System.out.println(cnt);
			System.out.println(max);
		}
	}

	private static void DFS(int x, int y, int cnt) {
		visited[x][y] = true;

		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (0 > nx || nx >= N || 0 > ny || ny >= M)
				continue;

			if (!visited[nx][ny] && board[nx][ny] == 1) {
				DFS(nx, ny, cnt + 1);
				ex++;
			}
		}
	}
}
