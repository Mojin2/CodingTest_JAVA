import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		String s1 = st.nextToken();
		int N = s1.length();

		st = new StringTokenizer(br.readLine());
		String s2 = st.nextToken();
		int M = s2.length();

		int[][] dp = new int[N + 1][M + 1];

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				char c1 = s1.charAt(i - 1);
				char c2 = s2.charAt(j - 1);

				if (c1 == c2) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		System.out.println(dp[N][M]);
	}
}