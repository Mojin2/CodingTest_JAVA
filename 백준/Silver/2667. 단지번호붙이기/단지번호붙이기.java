import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//7
//0110100
//0110101
//1110101
//0000111
//0100000
//0111110
//0111000

public class Main {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static ArrayList<Integer> answer = new ArrayList<>();
	static String[][] board;
	static boolean[][] visited;
	static int N;
	static int cnt;
	static int total;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		board = new String[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			board[i] = st.nextToken().split("");
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j].equals("1") && !visited[i][j]) {
					total++;
					cnt = 0;
					DFS(i, j);
					answer.add(cnt);
				}
			}
		}
		System.out.println(total);
		Collections.sort(answer);
		for (int ans : answer) {
			System.out.println(ans);
		}

	}

	private static void DFS(int x, int y) {
		visited[x][y] = true;
		cnt++;

		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (0 > nx || nx >= N || 0 > ny || ny >= N)
				continue;

			if (!visited[nx][ny] && board[nx][ny].equals("1")) {
				DFS(nx, ny);
			}
		}

	}
}