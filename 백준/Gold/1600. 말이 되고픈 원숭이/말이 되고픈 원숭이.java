import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int K;
    static int W;
    static int H;
    static int[][] board;
    static boolean[][][] visited; // 3차원 배열: [x][y][남은 말 이동 횟수]
    static int[] dx = {1, -1, 0, 0}; // 상하좌우 이동
    static int[] dy = {0, 0, 1, -1};
    static int[] hx = {-2, -2, -1, -1, 2, 2, 1, 1}; // 말처럼 이동
    static int[] hy = {1, -1, 2, -2, 1, -1, 2, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        board = new int[H][W];
        visited = new boolean[H][W][K + 1]; // 말처럼 이동 가능한 횟수를 포함한 3차원 배열

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0, K}); // x, y, 이동 횟수, 남은 말 이동 횟수
        visited[0][0][K] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int moveCount = cur[2];
            int remainingK = cur[3];

            // 도착점에 도달한 경우
            if (x == H - 1 && y == W - 1) {
                return moveCount;
            }

            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < H && ny < W && !visited[nx][ny][remainingK] && board[nx][ny] == 0) {
                    visited[nx][ny][remainingK] = true;
                    queue.add(new int[]{nx, ny, moveCount + 1, remainingK});
                }
            }

            // 말처럼 이동
            if (remainingK > 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = x + hx[i];
                    int ny = y + hy[i];

                    if (nx >= 0 && ny >= 0 && nx < H && ny < W && !visited[nx][ny][remainingK - 1] && board[nx][ny] == 0) {
                        visited[nx][ny][remainingK - 1] = true;
                        queue.add(new int[]{nx, ny, moveCount + 1, remainingK - 1});
                    }
                }
            }
        }
        return -1; // 도착할 수 없는 경우
    }
}