import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] visited;
	static char[][] board;
	static int N;
	static int M;
	// R, D, L, U
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new char[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			board[i] = st.nextToken().toCharArray();
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j]) {
					BFS(i, j);
					count++;
//					System.out.println(Arrays.deepToString(visited));
				}
			}
		}

		System.out.println(count);
	}

	private static void BFS(int i, int j) {
		ArrayDeque<Integer[]> queue = new ArrayDeque<>();
		queue.add(new Integer[] { i, j });
		visited[i][j] = true;
		// R, D, L, U
		while (!queue.isEmpty()) {
			Integer[] tmp = queue.poll();
			int cx = tmp[0];
			int cy = tmp[1];

			// 진행 방향은 무조건 넣기
			int dir = 0;
			if (board[cx][cy] == 'R') {
				dir = 0;
			} else if (board[cx][cy] == 'D') {
				dir = 1;
			} else if (board[cx][cy] == 'L') {
				dir = 2;
			} else if (board[cx][cy] == 'U') {
				dir = 3;
			}

			int nx = cx + dx[dir];
			int ny = cy + dy[dir];
			if (0 > nx || nx >= N || 0 > ny || ny >= M)
				continue;

			if (!visited[nx][ny]) {
				visited[nx][ny] = true;
				queue.add(new Integer[] { nx, ny });
			}

			// 현재 기준 4방향 중 본인을 바라보고 있는 방향 넣기
			for (int k = 0; k < 4; k++) {
				nx = cx + dx[k];
				ny = cy + dy[k];

				if (0 > nx || nx >= N || 0 > ny || ny >= M)
					continue;

				if (k == 0 && board[nx][ny] == 'L' && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new Integer[] { nx, ny });
				} else if (k == 1 && board[nx][ny] == 'U' && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new Integer[] { nx, ny });
				} else if (k == 2 && board[nx][ny] == 'R' && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new Integer[] { nx, ny });
				} else if (k == 3 && board[nx][ny] == 'D' && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new Integer[] { nx, ny });
				}

			}
		}

	}
}