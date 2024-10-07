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

		int T = Integer.parseInt(st.nextToken());

		for (int test = 0; test < T; test++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());

			if (N <= 3) {
				System.out.println(1);
				continue;
			}
			long[] dp = new long[N + 1];

			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 1;

			for (int i = 4; i < N + 1; i++) {
				dp[i] = dp[i - 3] + dp[i - 2];
			}
//			System.out.println(Arrays.toString(dp));
//			0, 1, 1, 1, 2, 2, 3, 4, 5, 7, 9
			System.out.println(dp[N]);
		}
	}
}