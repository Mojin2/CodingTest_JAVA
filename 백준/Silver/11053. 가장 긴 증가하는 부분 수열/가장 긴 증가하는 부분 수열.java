import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		int max = Integer.MIN_VALUE;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(arr[i], max);
		}

		int[] dp = new int[N];
		dp[0] = 1;
		int[] check = new int[max + 1];
		int ans = 1;

		for (int i = 1; i < N; i++) {
			int a = 0;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					a = Math.max(dp[j], a);
				}
			}
			dp[i] = a + 1;
			ans = Math.max(ans, dp[i]);
		}

		System.out.println(ans);

	}
}