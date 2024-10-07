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

		int[][] list = new int[N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int red = Integer.parseInt(st.nextToken());
			int green = Integer.parseInt(st.nextToken());
			int blue = Integer.parseInt(st.nextToken());

			list[i] = new int[] { red, green, blue };
		}

		int[][] dp = new int[N][3];

		dp[0] = list[0];

		for (int i = 1; i < N; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + list[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + list[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + list[i][2];
		}
		
		int min = Integer.MAX_VALUE;
		min = Math.min(dp[N-1][0], dp[N-1][1]);
		min = Math.min(min, dp[N-1][2]);
		
		System.out.println(min);
	}
}