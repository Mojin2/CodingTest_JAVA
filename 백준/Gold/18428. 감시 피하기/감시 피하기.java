//5
//X S X X T
//T X S X X
//X X X X X
//X T X X X
//X X T X X

import java.awt.Checkbox;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.lang.model.type.DeclaredType;

//해당 위치에 학생이 있다면 S, 선생님이 있다면 T, 아무것도 존재하지 않는다면 X가 주어진다.
public class Main {

	static int N, count;
	static String[][] board;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static boolean isEnd;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		count = 0;

		board = new String[N][N];
		visited = new boolean[N][N];
		isEnd = false;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = st.nextToken();
			}
		}

		backtrack();
		if (isEnd) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
//		System.out.println(Arrays.deepToString(board));

	}

	private static void backtrack() {
		if (count == 3 && !isEnd) {
			if (!check()) {
				isEnd = true;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j].equals("X") && !visited[i][j] && count < 3) {
					visited[i][j] = true;
					board[i][j] = "O";
					count++;
					backtrack();
					visited[i][j] = false;
					board[i][j] = "X";
					count--;
				}
			}
		}
	}

//	[[X, S, X, X, T], 
//	 [T, X, S, O, X], 
//	 [X, X, X, X, X], 
//	 [X, T, X, X, X], 
//	 [O, X, T, X, O]]

//  [[X, S, X, X, T],
//	 [T, X, S, X, O], 
//	 [X, X, X, X, X], 
//	 [X, T, X, X, X], 
//	 [O, X, T, X, O]]

	private static boolean check() {
		boolean returnValue = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j].equals("S")) {
					for (int k = 0; k < 4; k++) {
						int len = 1;
						while (true) {
							int nx = i + dx[k] * len;
							int ny = j + dy[k] * len;

							if (0 > nx || nx >= N || 0 > ny || ny >= N)
								break;

							if (board[nx][ny].equals("O"))
								break;

							if (board[nx][ny].equals("T")) {
								return true;
							}

							len++;
						}
					}
				}
			}
		}

		return returnValue;
	}
}