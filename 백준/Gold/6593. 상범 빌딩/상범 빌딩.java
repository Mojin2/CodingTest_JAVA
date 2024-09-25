import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.xml.stream.events.EndDocument;

public class Main {

	static StringTokenizer st;
	static int[] dx = { 1, -1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, 1, -1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			st = new StringTokenizer(br.readLine());

			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			if (L == 0 && R == 0 && C == 0) {
				break;
			}

			// 보드 초기화
			String[][][] board = new String[L][R][C];
			boolean[][][] visited = new boolean[L][R][C];
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					st = new StringTokenizer(br.readLine());
					board[i][j] = st.nextToken().split("");
					// System.out.println(Arrays.deepToString(board[i]));
				}
				st = new StringTokenizer(br.readLine());
			}

			// 시작, 끝 좌표 확인
			int[] start = new int[3];
			int[] destination = new int[3];

			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					for (int r = 0; r < C; r++) {
						if (board[i][j][r].equals("S")) {
							start[0] = i;
							start[1] = j;
							start[2] = r;
						}
						if (board[i][j][r].equals("E")) {
							destination[0] = i;
							destination[1] = j;
							destination[2] = r;
						}
					}
				}
			}
//			System.out.println("start: "+Arrays.toString(start));
//			System.out.println("destination: "+ Arrays.toString(destination));

			ArrayDeque<int[]> queue = new ArrayDeque<>();
			queue.add(new int[] { start[0], start[1], start[2], 0 });
			visited[start[0]][start[1]][start[2]] = true;

			int answer = 0;

			while (!queue.isEmpty()) {
				int[] tmp = queue.poll();
				int cx = tmp[0];
				int cy = tmp[1];
				int cz = tmp[2];	
				int cnt = tmp[3];
				
				if (cx == destination[0] && cy == destination[1] && cz == destination[2]) {
					answer = cnt;
					break;
				}

				for (int k = 0; k < 6; k++) {
					int nx = cx + dx[k];
					int ny = cy + dy[k];
					int nz = cz + dz[k];

					if (0 > nx || nx >= L || 0 > ny || ny >= R || 0 > nz || nz >= C || board[nx][ny][nz].equals("#"))
						continue;

					if (!visited[nx][ny][nz] && !board[nx][ny][nz].equals("#")) {
						visited[nx][ny][nz] = true;
						queue.add(new int[] { nx, ny, nz ,cnt+1});
					}
				}
			}
			if (answer != 0) {
				System.out.println("Escaped in "+answer+" minute(s).");
			} else {
				System.out.println("Trapped!");
			}
		}
	}
}