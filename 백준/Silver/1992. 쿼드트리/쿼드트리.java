import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] board;
	static int N;
	static String answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		answer = "";
		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(String.valueOf(tmp.charAt(j)));
			}
		}

		String tm = dc(N, 0, 0);

		System.out.println(tm);
	}

	private static String dc(int N, int x, int y) {
		String tmp = "(";

		if (N < 1) {

			return "";
		}

		if (check(N, x, y) == "0") {
			return "0";
		} else if (check(N, x, y) == "1") {
			return "1";
		}

		tmp += dc(N / 2, x, y);
		tmp += dc(N / 2, x, y + N / 2);
		tmp += dc(N / 2, x + N / 2, y);
		tmp += dc(N / 2, x + N / 2, y + N / 2);

		tmp += ")";
		return tmp;
	}

	private static String check(int N, int x, int y) {
		int target = N * N;
		int[] count = new int[] { 0, 0 };
		for (int i = x; i < x + N; i++) {
			for (int j = y; j < y + N; j++) {
				if (board[i][j] == 0) {
					count[0]++;
				} else {
					count[1]++;
				}
			}
		}
		if (target == count[0]) {
			return "0";
		} else if (target == count[1]) {
			return "1";
		} else {
			return "2";
		}
	}
}