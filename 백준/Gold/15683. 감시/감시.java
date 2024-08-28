import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static String[][] board;
	static int N;
	static int M;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new String[N][M];

		answer = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = st.nextToken();
			}
		}

		ArrayList<String> cctvs = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!board[i][j].equals("0") && !board[i][j].equals("6")) {
					cctvs.add(board[i][j]);
				}
			}
		}
		int[] numbers = { 0, 1, 2, 3 };
		permutation(numbers, new int[cctvs.size()], 0, cctvs.size());

		System.out.println(answer);
	}

	public static void permutation(int[] arr, int[] out, int depth, int r) {
		if (depth == r) {
			cal(out);
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			out[depth] = arr[i];
			permutation(arr, out, depth + 1, r);

		}
	}

	private static void cal(int[] out) {
		String[][] boardClone = new String[N][M];
		for (int i = 0; i < N; i++) {
			boardClone[i] = board[i].clone();
		}
		int index = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!boardClone[i][j].equals("0") && !boardClone[i][j].equals("6") && !boardClone[i][j].equals("#")) {
					String cctvNum = boardClone[i][j];
					int cx = i;
					int cy = j;
					int position = out[index++];
					if (cctvNum.equals("1")) {
						while (true) {
							int nx = cx + dir[position][0];
							int ny = cy + dir[position][1];
							if (0 > nx || nx >= N || 0 > ny || ny >= M || boardClone[nx][ny].equals("6"))
								break;
							if (boardClone[nx][ny].equals("1") || boardClone[nx][ny].equals("2")
									|| boardClone[nx][ny].equals("3") || boardClone[nx][ny].equals("4")
									|| boardClone[nx][ny].equals("5")) {
								cx = nx;
								cy = ny;
								continue;
							}
							boardClone[nx][ny] = "#";
							cx = nx;
							cy = ny;
						}
					} else if (cctvNum.equals("2")) {
						for (int k = position; k <= position + 2; k += 2) {
							cx = i;
							cy = j;
							int direction = k;
							if (direction > 3) {
								direction %= 4;
							}
							while (true) {
								int nx = cx + dir[direction][0];
								int ny = cy + dir[direction][1];
								if (0 > nx || nx >= N || 0 > ny || ny >= M || boardClone[nx][ny].equals("6"))
									break;
								if (boardClone[nx][ny].equals("1") || boardClone[nx][ny].equals("2")
										|| boardClone[nx][ny].equals("3") || boardClone[nx][ny].equals("4")
										|| boardClone[nx][ny].equals("5")) {
									cx = nx;
									cy = ny;
									continue;
								}
								boardClone[nx][ny] = "#";
								cx = nx;
								cy = ny;
							}
						}
					} else if (cctvNum.equals("3")) {
						for (int k = position; k <= position + 1; k++) {
							cx = i;
							cy = j;
							int direction = k;
							if (direction > 3) {
								direction %= 4;
							}
							while (true) {
								int nx = cx + dir[direction][0];
								int ny = cy + dir[direction][1];
								if (0 > nx || nx >= N || 0 > ny || ny >= M || boardClone[nx][ny].equals("6"))
									break;
								if (boardClone[nx][ny].equals("1") || boardClone[nx][ny].equals("2")
										|| boardClone[nx][ny].equals("3") || boardClone[nx][ny].equals("4")
										|| boardClone[nx][ny].equals("5")) {
									cx = nx;
									cy = ny;
									continue;
								}
								boardClone[nx][ny] = "#";
								cx = nx;
								cy = ny;
							}
						}
					} else if (cctvNum.equals("4")) {
						for (int k = position; k <= position + 2; k++) {
							cx = i;
							cy = j;
							int direction = k;
							if (direction > 3) {
								direction %= 4;
							}
							while (true) {
								int nx = cx + dir[direction][0];
								int ny = cy + dir[direction][1];
								if (0 > nx || nx >= N || 0 > ny || ny >= M || boardClone[nx][ny].equals("6"))
									break;
								if (boardClone[nx][ny].equals("1") || boardClone[nx][ny].equals("2")
										|| boardClone[nx][ny].equals("3") || boardClone[nx][ny].equals("4")
										|| boardClone[nx][ny].equals("5")) {
									cx = nx;
									cy = ny;
									continue;
								}
								boardClone[nx][ny] = "#";
								cx = nx;
								cy = ny;
							}
						}
					} else if (cctvNum.equals("5")) {

						for (int k = position; k <= position + 3; k++) {
							cx = i;
							cy = j;
							int direction = k;
							if (direction > 3) {
								direction %= 4;
							}
							while (true) {
								int nx = cx + dir[direction][0];
								int ny = cy + dir[direction][1];
								if (0 > nx || nx >= N || 0 > ny || ny >= M || boardClone[nx][ny].equals("6"))
									break;
								if (boardClone[nx][ny].equals("1") || boardClone[nx][ny].equals("2")
										|| boardClone[nx][ny].equals("3") || boardClone[nx][ny].equals("4")
										|| boardClone[nx][ny].equals("5")) {
									cx = nx;
									cy = ny;
									continue;
								}
								boardClone[nx][ny] = "#";
								cx = nx;
								cy = ny;
							}
						}
					}
				}
			}
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (boardClone[i][j].equals("0")) {
					count++;
				}
			}
		}

		answer = Math.min(answer, count);

	}

}