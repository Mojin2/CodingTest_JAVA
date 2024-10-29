import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[][][] dp = new int[100001][5][5];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        dp[0][0][0] = 0;
        
        int index = 0;
        while (true) {
            int mv = Integer.parseInt(st.nextToken());
            if (mv == 0) break;
            index++;
            
            for (int left = 0; left < 5; left++) {
                for (int right = 0; right < 5; right++) {
                    if (dp[index - 1][left][right] != Integer.MAX_VALUE) {
                        if (mv != right) {
                            dp[index][mv][right] = Math.min(dp[index][mv][right], dp[index - 1][left][right] + moveCost(left, mv));
                        }
                        if (mv != left) {
                            dp[index][left][mv] = Math.min(dp[index][left][mv], dp[index - 1][left][right] + moveCost(right, mv));
                        }
                    }
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                answer = Math.min(answer, dp[index][i][j]);
            }
        }
        System.out.println(answer);
    }
    
    static int moveCost(int from, int to) {
        if (from == to) return 1;
        if (from == 0) return 2;
        if (Math.abs(from - to) == 2) return 4;
        return 3;
    }
}