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

		int N = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N];
		int ans = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			if (i == 0) {
				dp[i] = arr[0];
				ans = Math.max(ans, dp[i]);
			} else if (i == 1) {
				dp[i] = arr[0] + arr[1];
				ans = Math.max(ans, dp[i]);
			}

			else if (i == 2) {
				dp[i] = Math.max(dp[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));
				ans = Math.max(ans, dp[i]);
			} else {
				dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1]);
				dp[i] = Math.max(dp[i], dp[i - 3] + arr[i - 1] + arr[i]);
				ans = Math.max(ans, dp[i]);
			}
		}

		System.out.println(ans);
	}
}