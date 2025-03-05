//4 4
//0 0 0 0
//0 0 0 0
//0 0 0 0
//0 0 0 0
//1 1 1
//1 2 1
//1 3 1
//3 3 3

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { -1, 0, 0, -1, 1 };
	static int[] dy = { -1, 1, -1, 0, 0 };

	static int[][] board;
	static ArrayDeque<Integer[]>[][] points;
	static int N, K, stage;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		stage = 0;

		board = new int[N][N];
		points = new ArrayDeque[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				points[i][j] = new ArrayDeque<>();
			}
		}

		// 보드판에 대한 INPUT 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		System.out.println(Arrays.deepToString(board));
		// 좌표에 대한 INPUT 저장
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());

			points[x - 1][y - 1].add(new Integer[] { i + 1, dir });
		}
//		System.out.println("******초기 보드판******");
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				StringBuilder sb = new StringBuilder();
//				for (Integer[] tmp : points[i][j]) {
//					sb.append(Arrays.toString(tmp));
//				}
//				sb.append("|");
//				System.out.print(sb);
//			}
//			System.out.println();
//		}
		// BOARD 게임 플레이
		System.out.println(gamePlay());
	}

	// BOARD 게임 플레이 함수
	private static int gamePlay() {
		while (true) {

			// 한 좌표에 4개 이상이 올라가 있을 경우 게임 종료
			if (isMoreThanFour())
				return stage;

			// 1번말부터 K번째말까지 모두 다 차례대로 돌거임
			for (int num = 1; num <= K; num++) {
				boolean check = false;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						// 이러면 이제 해당 번호가 움직일 수 있는거임!
						if (points[i][j].size() >= 1 && points[i][j].peekFirst()[0] == num) {
							int dir = points[i][j].peekFirst()[1];
//							System.out.println("움직이는 번호 : " + points[i][j].peekFirst()[0] + " 움직이는 방향 : " + dir);
							// 정방향
							int nx = i + dx[dir];
							int ny = j + dy[dir];

							// 반대방향
							int reverseDir = 0;
							if (dir == 1) {
								reverseDir = 2;
							} else if (dir == 2) {
								reverseDir = 1;
							} else if (dir == 3) {
								reverseDir = 4;
							} else if (dir == 4) {
								reverseDir = 3;
							}
							int rnx = i + dx[reverseDir];
							int rny = j + dy[reverseDir];

							// 범위를 벗어날 경우 && 파란색일 경우 반대로하고 한칸 전진
							// 근데 반대로 한칸 전진하는 칸이 파란색인 경우 그 자리에 그냥 정지
							// 반대로 전진할 수 있는 경우에는 원래 있던거 + 맨 밑에만 방향 반대로 된거
							if (0 > nx || nx >= N || 0 > ny || ny >= N) {
								// 뒤 돌아서 가야하는 곳이 파란색이라면?
								if (board[rnx][rny] == 2) {
									Integer[] cur = points[i][j].pollFirst();
									points[i][j].addFirst(new Integer[] { cur[0], reverseDir });
								} else if (board[rnx][rny] == 1) {
									List<Integer[]> list = new ArrayList<>(points[i][j]);
									Collections.reverse(list);
									points[rnx][rny].addAll(list);
									Integer[] cur = points[rnx][rny].pollLast();
									points[rnx][rny].addLast(new Integer[] { cur[0], reverseDir });
									points[i][j].clear();
								}
								// 뒤 돌아서 가야하는 곳이 하얀색이라면?
								else {
									Integer[] cur = points[i][j].pollFirst();
									points[i][j].addFirst(new Integer[] { cur[0], reverseDir });
									points[rnx][rny].addAll(points[i][j]);
									points[i][j].clear();
								}
							}
							if (0 <= nx && nx < N && 0 <= ny && ny < N && board[nx][ny] == 2) {
								if (0 > rnx || rnx >= N || 0 > rny || rny >= N) {
									Integer[] cur = points[i][j].pollFirst();
									points[i][j].addFirst(new Integer[] { cur[0], reverseDir });
								} else if (board[rnx][rny] == 2) {
									Integer[] cur = points[i][j].pollFirst();
									points[i][j].addFirst(new Integer[] { cur[0], reverseDir });
									// 뒤 돌아서 가야하는 곳이 빨간색이라면?
								} else if (board[rnx][rny] == 1) {
									ArrayDeque<Integer[]> newDq = new ArrayDeque<>();
									List<Integer[]> list = new ArrayList<>(points[i][j]);
									Collections.reverse(list);
									points[rnx][rny].addAll(list);
									Integer[] cur = points[rnx][rny].pollLast();
									points[rnx][rny].addLast(new Integer[] { cur[0], reverseDir });
									points[i][j].clear();
								}
								// 뒤 돌아서 가야하는 곳이 하얀색이라면?
								else {
									Integer[] cur = points[i][j].pollFirst();
									points[i][j].addFirst(new Integer[] { cur[0], reverseDir });
									points[rnx][rny].addAll(points[i][j]);
									points[i][j].clear();
								}
							}

							// 빨간색인 경우 전진하고 해당 칸에서 원래 있던거 + 뒤바뀐 순서
							if (0 <= nx && nx < N && 0 <= ny && ny < N && board[nx][ny] == 1) {
//								System.out.println("빨강인 경우에 포함");

								List<Integer[]> list = new ArrayList<>(points[i][j]);
								Collections.reverse(list);
								points[nx][ny].addAll(list);
								points[i][j].clear();
							}

							// 흰색인 경우 전진하고 해당 칸에 원래 있던거 + 원래 순서
							if (0 <= nx && nx < N && 0 <= ny && ny < N && board[nx][ny] == 0) {
//								System.out.println("흰색인 경우에 포함");
								ArrayDeque<Integer[]> newDq = new ArrayDeque<>();
								newDq.addAll(points[nx][ny]);
								newDq.addAll(points[i][j]);
								points[nx][ny] = newDq;
								points[i][j].clear();
							}

							check = true;
						}
						if (check)
							break;
					}
					if (check)
						break;
				}
//				if (stage < 5) {
//					System.out.println("******" + num + "번 움직일 차례******");
//					for (int i = 0; i < N; i++) {
//						for (int j = 0; j < N; j++) {
//							StringBuilder sb = new StringBuilder();
//							for (Integer[] tmp : points[i][j]) {
//								sb.append(Arrays.toString(tmp));
//							}
//							sb.append("|");
//							System.out.print(sb);
//						}
//						System.out.println();
//					}
//				}
			}

//			System.out.println("****************");
			stage++;
			if (stage >= 1000)
				return -1;
		}
	}

	// BOARD 좌표에서 4개 이상이 올라간 좌표가 있는지 확인 하는 함수
	private static boolean isMoreThanFour() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (points[i][j].size() >= 4) {
					return true;
				}
			}
		}
		return false;
	}
}