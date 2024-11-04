import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] board;
	static int[] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		board = new int[N][N];
		answer = new int[] { 0, 0 };
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		paper(N, 0, 0);
//		System.out.println(Arrays.deepToString(board));

		System.out.println(answer[0]);
		System.out.println(answer[1]);

	}

	private static void paper(int N, int x, int y) {
		if (N == 1) {
			if (board[x][y] == 0) {
				answer[0]++;
			} else {
				answer[1]++;
//				System.out.println("(" + x + "," + y + ")에서 시작하는 부분");
			}
			return;
		}

		if (check(N, x, y) == 0) {
//			System.out.println("HI");
			answer[0]++;
			return;
		} else if (check(N, x, y) == 1) {
//			System.out.println("HELLO");
			answer[1]++;
//			System.out.println("(" + x + ","x + y + ")에서 시작하는 부분");
			return;
		}

		paper(N / 2, x, y);
		paper(N / 2, x + N / 2, y);
		paper(N / 2, x, y + N / 2);
		paper(N / 2, x + N / 2, y + N / 2);
	}

	private static int check(int N, int x, int y) {
		int target = N * N;
		int[] totalCount = new int[] { 0, 0 };

		for (int i = x; i < x + N; i++) {
			for (int j = y; j < y + N; j++) {
				if (board[i][j] == 0) {
					totalCount[0]++;
				} else {
					totalCount[1]++;
				}
			}
		}
//		System.out.println(Arrays.toString(totalCount));
		if (totalCount[0] == target) {
			return 0;
		} else if (totalCount[1] == target) {
			return 1;
		} else {
			return 2;
		}
	}
}