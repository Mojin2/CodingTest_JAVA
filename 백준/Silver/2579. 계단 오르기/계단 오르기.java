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

		dp[0] = arr[0];
		if (N == 1) {
			System.out.println(dp[0]);
			return;
		}
		dp[1] = arr[0] + arr[1];
		if (N == 2) {
			System.out.println(dp[1]);
			return;
		}

		dp[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);
		if (N == 3) {
			System.out.println(dp[2]);
			return;
		}

		for (int i = 3; i < N; i++) {
			dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
		}

		System.out.println(dp[N - 1]);

	}
}