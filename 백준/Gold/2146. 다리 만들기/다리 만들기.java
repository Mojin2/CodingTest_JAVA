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
	static int N;
	static int[][] board;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int islandNum = 1;
		int cnt = 0;
		// 섬을 나눠서 번호 매기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && board[i][j] != 0) {
					find(i, j, islandNum);
					islandNum++;
					cnt++;
				}
			}
		}
//		System.out.println(Arrays.deepToString(board));

		// 섬위 좌표마다 BFS를 돌며 다른 섬으로 가는 최단 거리를 계산
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 0)
					continue;

				boolean[][] cVisited = new boolean[N][N];
				int startX = i;
				int startY = j;
				int iNum = board[startX][startY];

				int ans = BFS(startX, startY, iNum, 0, cVisited);
				min = Math.min(min, ans);
//				System.out.println("*******************");

			}
		}
		System.out.println(min);

	}

	private static int BFS(int startX, int startY, int iNum, int cnt, boolean[][] visited) {
		ArrayDeque<Integer[]> queue = new ArrayDeque<>();
		queue.add(new Integer[] { startX, startY, cnt });
		visited[startX][startY] = true;

		while (!queue.isEmpty()) {
			Integer[] tmp = queue.poll();
			int cx = tmp[0];
			int cy = tmp[1];
			int count = tmp[2];
//			System.out.println("cx: " + cx + " cy: " + cy + " count: " + count);

			if (board[cx][cy] != iNum && board[cx][cy] != 0) {
				return count - 1;
			}

			for (int k = 0; k < 4; k++) {
				int nx = cx + dx[k];
				int ny = cy + dy[k];

				if (0 > nx || nx >= N || 0 > ny || ny >= N || board[nx][ny] == iNum || visited[nx][ny])
					continue;

				if (!visited[nx][ny] && board[nx][ny] != iNum) {
					visited[nx][ny] = true;
					queue.add(new Integer[] { nx, ny, count + 1 });
				}
			}
		}

		return Integer.MAX_VALUE;

	}
//	[[1, 1, 1, 0, 0, 0, 0, 2, 2, 2], 
//	 [1, 1, 1, 1, 0, 0, 0, 0, 2, 2], 
//	 [1, 0, 1, 1, 0, 0, 0, 0, 2, 2], 
//	 [0, 0, 1, 1, 1, 0, 0, 0, 0, 2], 
//	 [0, 0, 0, 1, 0, 0, 0, 0, 0, 2], 
//	 [0, 0, 0, 0, 0, 0, 0, 0, 0, 2], 
//	 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0], 
//	 [0, 0, 0, 0, 3, 3, 0, 0, 0, 0], 
//	 [0, 0, 0, 0, 3, 3, 3, 0, 0, 0], 
//	 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]]

	public static void find(int startX, int startY, int islandNum) {
		ArrayDeque<Integer[]> queue = new ArrayDeque<>();
		queue.add(new Integer[] { startX, startY });
		visited[startX][startY] = true;

		while (!queue.isEmpty()) {
			Integer[] tmp = queue.poll();
			int cx = tmp[0];
			int cy = tmp[1];
			board[cx][cy] = islandNum;

			for (int k = 0; k < 4; k++) {
				int nx = cx + dx[k];
				int ny = cy + dy[k];

				if (0 > nx || nx >= N || 0 > ny || ny >= N || visited[nx][ny] || board[nx][ny] == 0)
					continue;

				if (!visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new Integer[] { nx, ny });
				}
			}
		}

	}
}