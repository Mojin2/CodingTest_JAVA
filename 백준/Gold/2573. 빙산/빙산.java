import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[][] board;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int year = 1;
		while (true) {

			boolean[][] visited = new boolean[N][M];
			int[][] zeroArray = new int[N][M];
			int zeroCount = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (board[i][j] == 0) {
						zeroCount++;
						visited[i][j] = true;
					}
					int cx = i;
					int cy = j;

					for (int k = 0; k < 4; k++) {
						int nx = cx + dx[k];
						int ny = cy + dy[k];

						if (0 > nx || nx >= N || 0 > ny || ny >= M)
							continue;

						if (board[nx][ny] == 0) {
							zeroArray[cx][cy]++;
						}
					}

				}
			}
			// 다 녹았는지 확인
			if (zeroCount == N * M) {
				System.out.println(0);
				break;
			}

			// 1년 뒤 빙하 녹이기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					board[i][j] = Math.max(0, board[i][j] - zeroArray[i][j]);
				}
			}
			
			zeroCount = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (board[i][j] == 0) {
						zeroCount++;
						visited[i][j] = true;
					}
					int cx = i;
					int cy = j;

					for (int k = 0; k < 4; k++) {
						int nx = cx + dx[k];
						int ny = cy + dy[k];

						if (0 > nx || nx >= N || 0 > ny || ny >= M)
							continue;

						if (board[nx][ny] == 0) {
							zeroArray[cx][cy]++;
						}
					}

				}
			}
			
			if (zeroCount == N * M) {
				System.out.println(0);
				break;
			}
			
			// 1년 지나서 빙산 확인
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visited[i][j]) {
						BFS(i, j, visited);
						count++;
					}
				}
			}

			// 2덩이 이상이면 year return
			if (count >= 2) {
				System.out.println(year);
				break;
			} else {
				// 2덩이 미만이면 year++ 루
				year++;
			}
		}
	}

	private static void BFS(int startX, int startY, boolean[][] visited) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { startX, startY });
		visited[startX][startY] = true;

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int cx = tmp[0];
			int cy = tmp[1];

			for (int k = 0; k < 4; k++) {
				int nx = cx + dx[k];
				int ny = cy + dy[k];

				if (0 > nx || nx >= N || 0 > ny || ny >= M || visited[nx][ny])
					continue;

				if (!visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new int[] { nx, ny });
				}
			}
		}

	}
}