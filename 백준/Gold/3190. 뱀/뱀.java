import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//6
//3
//3 4
//2 5
//5 3
//3
//3 D
//15 L
//17 D

public class Main {

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int N, K, L;
	static int[][] board;
	static String[][] move;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());

		// 보드판 생성 후 사과 위치를 1로 초기화
		board = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			board[x - 1][y - 1] = 1;
		}

		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());

		// 뱀이 머리를 돌리는 경우에 대한 정보 저장
		move = new String[L][2];
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			String time = st.nextToken();
			String dir = st.nextToken();

			move[i] = new String[] { time, dir };
		}

		int time = 0;
		int timeIdx = 0;
		int dir = 0;

		ArrayDeque<Integer[]> queue = new ArrayDeque<>();
		visited[0][0] = true;
		queue.add(new Integer[] { 0, 0 });

		while (!queue.isEmpty()) {
			Integer[] now = queue.peekLast();
			int cx = now[0];
			int cy = now[1];

			int nx = cx + dx[dir];
			int ny = cy + dy[dir];

//			System.out.println(cx + " " + cy);
//			System.out.println("time: " + time);

			if (0 > nx || nx >= N || 0 > ny || ny >= N || visited[nx][ny]) {
				break;
			}

			if (!visited[nx][ny]) {
				if (board[nx][ny] == 0) {
					visited[nx][ny] = true;
					Integer[] tmp = queue.pollFirst();
					visited[tmp[0]][tmp[1]] = false;
					queue.add(new Integer[] { nx, ny });
				} else if (board[nx][ny] == 1) {
					visited[nx][ny] = true;
					board[nx][ny] = 0;
					queue.add(new Integer[] { nx, ny });
				}
			}

			time++;
			if (timeIdx >= L) {
				continue;
			}
			if (time == Integer.parseInt(move[timeIdx][0])) {
				if (move[timeIdx][1].equals("D")) {
					dir = (dir + 1) % 4;
				} else if (move[timeIdx][1].equals("L")) {
					if (dir == 0) {
						dir = 3;
					} else {
						dir--;
					}
				}
				timeIdx++;
			}
		}

		System.out.println(time + 1);

	}
}
