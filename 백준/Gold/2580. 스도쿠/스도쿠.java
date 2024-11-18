import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] board;
	static boolean check;
	static boolean[][] rowUsed;
	static boolean[][] colUsed;
	static boolean[][][] boxUsed;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		board = new int[9][9];
		check = false;
		rowUsed = new boolean[9][10];  // 각 행에 사용된 숫자 추적
		colUsed = new boolean[9][10];  // 각 열에 사용된 숫자 추적
		boxUsed = new boolean[3][3][10];  // 각 3x3 박스에 사용된 숫자 추적

		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] != 0) {  // 초기 값이 있는 경우 사용된 숫자로 마킹
					rowUsed[i][board[i][j]] = true;
					colUsed[j][board[i][j]] = true;
					boxUsed[i / 3][j / 3][board[i][j]] = true;
				}
			}
		}

		backtrack(0, 0);
	}

	private static void backtrack(int x, int y) {
		if (x == 9) {  // 보드를 다 채운 경우
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(board[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			check = true;
			return;
		}

		if (board[x][y] != 0) {  // 이미 채워진 칸인 경우 다음 칸으로 이동
			backtrack(y == 8 ? x + 1 : x, (y + 1) % 9);
			return;
		}

		// 1~9 숫자를 시도
		for (int num = 1; num <= 9; num++) {
			if (!rowUsed[x][num] && !colUsed[y][num] && !boxUsed[x / 3][y / 3][num]) {
				board[x][y] = num;
				rowUsed[x][num] = colUsed[y][num] = boxUsed[x / 3][y / 3][num] = true;

				backtrack(y == 8 ? x + 1 : x, (y + 1) % 9);
				if (check) return;  // 답을 찾은 경우

				// 되돌리기
				board[x][y] = 0;
				rowUsed[x][num] = colUsed[y][num] = boxUsed[x / 3][y / 3][num] = false;
			}
		}
	}
}