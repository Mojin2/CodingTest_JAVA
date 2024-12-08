import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder basic = new StringBuilder();
	static String[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		board = new String[N][N];

		print(N, 0, 0, false);
		
		for (int i = 0 ;i < N;i++) {
			for (int j = 0 ;j <N;j++) {
				basic.append(board[i][j]);
			}
			basic.append("\n");
		}
		
		System.out.println(basic);
	}

	public static void print(int N, int x, int y, boolean check) { // 9
		if (N == 3) {
			if (check == false) {
				for (int i = x; i < x + 3; i++) {
					for (int j = y; j < y + 3; j++) {
						if (i == x + 1 && j == y + 1) {
							board[i][j] = " ";
						} else {
							board[i][j] = "*";
						}
					}
				}
			} else {
				for (int i = x; i < x + 3; i++) {
					for (int j = y; j < y + 3; j++) {
						board[i][j] = " ";
					}
				}
			}
			return;
		}

		print(N / 3, x, y, check);
		print(N / 3, x + N / 3, y, check);
		print(N / 3, x + N / 3 * 2, y, check);
		print(N / 3, x, y + N / 3, check);
		print(N / 3, x, y + N / 3 * 2, check);
		print(N / 3, x + N / 3, y + N / 3 * 2, check);
		print(N / 3, x + N / 3 * 2, y + N / 3, check);
		print(N / 3, x + N / 3 * 2, y + N / 3 * 2, check);

		// 중간에 지워져야하는 부분
		print(N / 3, x + N / 3, y + N / 3, true);
	}

}