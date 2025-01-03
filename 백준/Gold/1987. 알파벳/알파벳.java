import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

//3 6
//HFDFFB
//AJHGDH
//DGAGEH

public class Main {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static String[][] board;
	static HashSet<String> visited;
	static int R;
	static int C;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new String[R][C];
		visited = new HashSet<>();

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			board[i] = st.nextToken().split("");
		}

		if (R == 1 && C == 1) {
			System.out.println(1);
			return;
		}

		DFS(0, 0, 0);

		System.out.println(max);

	}

	private static void DFS(int x, int y, int count) {
		if (visited.contains(board[x][y])) {
			max = Math.max(max, count);
			return;
		}

		visited.add(board[x][y]);

		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx < 0 || nx >= R || ny < 0 || ny >= C)
				continue;

			DFS(nx, ny, count + 1);

		}
		visited.remove(board[x][y]);

	}
}