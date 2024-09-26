import java.awt.Checkbox;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int min;
	static boolean[] member;
	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		member = new boolean[N];

		backtrack(0, 0);

		System.out.println(min);
	}

	private static void backtrack(int depth, int idx) {
		if (depth == N / 2) {
			int score = cal(member);
			min = Math.min(min, score);
		}

		for (int i = idx; i < N; i++) {
			member[i] = true;
			backtrack(depth + 1, i + 1);
			member[i] = false;
		}
	}

	private static int cal(boolean[] member) {
		int startTeam = 0;
		int linkTeam = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;

				if (member[i] && member[j])
					startTeam += board[i][j];
				if (!member[i] && !member[j])
					linkTeam += board[i][j];
			}
		}
		return Math.abs(startTeam - linkTeam);
	}
}