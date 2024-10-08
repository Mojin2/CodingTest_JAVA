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

		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(arr[i], -1);
		}

		int[][] dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}

		int tmp = 1;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < tmp; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (i == 0) {
					dp[i][j] = arr[i][j];
				}
			}
			tmp++;
		}

		// 사이드 값 먼저 맞추기
		int tmp2 = 2;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < tmp2; j++) {
				if (j == 0) {
					dp[i][j] = arr[i][j] + dp[i - 1][j];
				} else if (j == tmp2 - 1) {
					dp[i][j] = arr[i][j] + dp[i - 1][j - 1];
				}
			}
			tmp2++;
		}

		// 중앙 값 맞추기
		int tmp3 = 2;
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < tmp3 - 1; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + arr[i][j];
			}
			tmp3++;
		}

		// 최대 값 뽑기
		int ans = Integer.MIN_VALUE;
		for (int a : dp[N - 1]) {
			ans = Math.max(a, ans);
		}

//		System.out.println(Arrays.deepToString(dp));

		System.out.println(ans);

//		[[7, -1, -1, -1, -1], 
//		 [10, 15, -1, -1, -1], 
//		 [18, 16, 15, -1, -1], 
//		 [20, 25, 20, 19, -1], 
//		 [24, 30, 27, 26, 24]]

	}
}