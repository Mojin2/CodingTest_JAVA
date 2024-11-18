import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static boolean solved;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[9][9];
        solved = false;

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtrack(0, 0); // 시작 위치를 지정하여 순회
    }

    private static void backtrack(int row, int col) {
        if (row == 9) { // 모든 행을 다 채운 경우
            printBoard();
            solved = true;
            return;
        }

        if (board[row][col] != 0) { // 이미 숫자가 있는 칸은 다음 칸으로 이동
            nextCell(row, col);
        } else {
            boolean[] list = canUse(row, col);

            for (int num = 1; num <= 9; num++) {
                if (list[num]) {
                    board[row][col] = num;
                    nextCell(row, col); // 다음 칸으로 이동
                    if (solved) return; // 이미 해결된 경우 중지
                    board[row][col] = 0; // 백트래킹: 숫자 제거
                }
            }
        }
    }

    private static void nextCell(int row, int col) {
        if (col == 8) {
            backtrack(row + 1, 0);
        } else {
            backtrack(row, col + 1);
        }
    }

    private static boolean[] canUse(int x, int y) {
        boolean[] list = new boolean[10];
        Arrays.fill(list, true);

        for (int i = 0; i < 9; i++) {
            list[board[x][i]] = false; // 가로
            list[board[i][y]] = false; // 세로
        }

        int startX = 3 * (x / 3);
        int startY = 3 * (y / 3);

        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                list[board[i][j]] = false;
            }
        }

        return list;
    }

    private static void printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}