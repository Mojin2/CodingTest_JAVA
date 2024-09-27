import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int[][] board;
	static boolean[][] visited;
	static int N;
	static int M;
	static int num;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		visited = new boolean[N][M];
		num = 0;
		max = Integer.MIN_VALUE;

		int roomCount = 0;
		int maxRoomSize = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j]) {
					int round = BFS(i, j);
					maxRoomSize = Math.max(maxRoomSize, round);
					list.add(round);
					roomCount++;
					num++;
				}
			}
		}
		int[] arr = new int[roomCount];
		int arrIndex = 0;
		for (Integer a : list) {
			arr[arrIndex++] = a;
		}
		System.out.println(roomCount);
		System.out.println(maxRoomSize);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int cx = i;
				int cy = j;

				for (int k = 0; k < 4; k++) {
					int nx = cx + dx[k];
					int ny = cy + dy[k];

					if (0 > nx || nx >= N || 0 > ny || ny >= M)
						continue;

					if (board[cx][cy] == board[nx][ny])
						continue;

					max = Math.max(max, arr[board[cx][cy]] + arr[board[nx][ny]]);
				}
			}
		}
		System.out.println(max);
	}

	private static int BFS(int startX, int startY) {
		int cnt = 1;
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { startX, startY });
		visited[startX][startY] = true;

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int cx = tmp[0];
			int cy = tmp[1];
			int number = board[cx][cy];
			board[cx][cy] = num;
//			System.out.println("number: " + number);

			for (int k = 0; k < 4; k++) {
				if (((number & (1 << k)) != (1 << k))) {
//					System.out.println(k);
					int nx = cx + dx[k];
					int ny = cy + dy[k];

					if (0 > nx || nx >= N || 0 > ny || ny >= M || visited[nx][ny])
						continue;

					if (!visited[nx][ny]) {
						visited[nx][ny] = true;
						queue.add(new int[] { nx, ny });
						cnt++;
					}
				}
//				number >>= 1;
			}

		}

		return cnt;

	}

}