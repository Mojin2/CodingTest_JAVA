import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] board;
	static int N;
	static int[] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		answer = new int[] { 0, 0, 0 };

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		paper(N, 0, 0);
		
		System.out.println(answer[0]);
		System.out.println(answer[1]);
		System.out.println(answer[2]);
	}

	private static void paper(int N, int x, int y) {
		if (N == 1) {
			if (board[x][y] == -1) {
				answer[0]++;
			} else if (board[x][y] == 0) {
				answer[1]++;
			} else {
				answer[2]++;
			}
			return;
		}

		if (check(N, x, y) == -1) {
			answer[0]++;
			return;
		} else if (check(N, x, y) == 0) {
			answer[1]++;
			return;
		} else if (check(N, x, y) == 1) {
			answer[2]++;
			return;
		}

		paper(N / 3, x, y);
		paper(N / 3, x, y + N / 3);
		paper(N / 3, x, y + N / 3 * 2);
		/////////////////////////////
		paper(N / 3, x + N / 3, y);
		paper(N / 3, x + N / 3, y + N / 3);
		paper(N / 3, x + N / 3, y + N / 3 * 2);
		/////////////////////////////
		paper(N / 3, x + N / 3 * 2, y);
		paper(N / 3, x + N / 3 * 2, y + N / 3);
		paper(N / 3, x + N / 3 * 2, y + N / 3 * 2);
	}

	private static int check(int N, int x, int y) {
		int target = N * N;
		int[] totalCount = new int[] { 0, 0, 0 };

		for (int i = x; i < x + N; i++) {
			for (int j = y; j < y + N; j++) {
				if (board[i][j] == -1) {
					totalCount[0]++;
				} else if (board[i][j] == 0) {
					totalCount[1]++;
				} else {
					totalCount[2]++;
				}
			}
		}
		if (totalCount[0] == target) {
			return -1;
		} else if (totalCount[1] == target) {
			return 0;
		} else if (totalCount[2] == target) {
			return 1;
		} else {
			return 2;
		}
	}
}