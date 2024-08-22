import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] score;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int test = 0; test < 4; test++) {

            score = new int[6][3];
            flag = false;

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    score[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if (isValid()) {
                flag = false;
                backtrack(0, 1);
            }

            sb.append(flag ? 1 : 0).append(" ");
        }

        System.out.println(sb);
    }

    static boolean isValid() {
        int winSum = 0, drawSum = 0, loseSum = 0;

        for (int i = 0; i < 6; i++) {
            winSum += score[i][0];
            drawSum += score[i][1];
            loseSum += score[i][2];

            if (score[i][0] + score[i][1] + score[i][2] != 5) {
                return false;
            }
        }

        return winSum == loseSum && drawSum % 2 == 0;
    }

    static void backtrack(int a, int b) {
        if (flag) return;

        if (a == 5) {
            flag = true;
            return;
        }

        if (b == 6) {
            backtrack(a + 1, a + 2);
            return;
        }

        // 승리의 경우
        if (score[a][0] > 0 && score[b][2] > 0) {
            score[a][0]--;
            score[b][2]--;
            backtrack(a, b + 1);
            score[a][0]++;
            score[b][2]++;
        }

        // 무승부의 경우
        if (score[a][1] > 0 && score[b][1] > 0) {
            score[a][1]--;
            score[b][1]--;
            backtrack(a, b + 1);
            score[a][1]++;
            score[b][1]++;
        }

        // 패배의 경우
        if (score[a][2] > 0 && score[b][0] > 0) {
            score[a][2]--;
            score[b][0]--;
            backtrack(a, b + 1);
            score[a][2]++;
            score[b][0]++;
        }
    }
}