import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] visited;
	static int N;
	static int M;
	static int K;
	static int[][] board;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		board = new int[M][N];
		list = new ArrayList<>();

		for (int snow = 0; snow < K; snow++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			for (int i = Math.min(x1, x2); i < Math.max(x1, x2); i++) {
				for (int j = Math.min(y1, y2); j < Math.max(y1, y2); j++) {
					board[i][j] = 1;
				}
			}
		}

		visited = new boolean[M][N];

		int BFScount = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && board[i][j] != 1) {
					BFS(i, j);
					BFScount++;
				}
			}
		}
		Integer[] answer = new Integer[BFScount];
		int answerIndex = 0;
		for (int a : list) {
			answer[answerIndex++] = a;
		}
		Arrays.sort(answer,(a,b)->a-b);
		
		StringBuilder sb = new StringBuilder();
		sb.append(BFScount).append("\n");
		for (int i = 0 ;i < BFScount;i++) {
			sb.append(answer[i]).append(" ");
		}
		System.out.println(sb);
	}

	private static void BFS(int x, int y) {
		int count = 1;
		ArrayDeque<Integer[]> queue = new ArrayDeque<>();
		queue.add(new Integer[] { x, y });
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			Integer[] tmp = queue.poll();
			int cx = tmp[0];
			int cy = tmp[1];

			for (int k = 0; k < 4; k++) {
				int nx = cx + dx[k];
				int ny = cy + dy[k];

				if (0 > nx || nx >= M || 0 > ny || ny >= N)
					continue;

				if (!visited[nx][ny] && board[nx][ny] != 1) {
					visited[nx][ny] = true;
					queue.add(new Integer[] { nx, ny });
					count++;
				}
			}
		}
		list.add(count);
	}
}