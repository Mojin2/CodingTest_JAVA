import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
//		int N = 3;

		long mod = 1000000000;
		long[][] dp = new long[N + 1][10];

		dp[1] = new long[] { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 };

		for (int i = 2; i < N + 1; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][1] % mod;
				} else if (j == 9) {
					dp[i][j] = dp[i - 1][8] % mod;
				} else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
				}

			}
		}

		long ans = Arrays.stream(dp[N]).sum()% mod;

		System.out.println(ans);
	}

	private static boolean check(int number) {
		ArrayList<Integer> list = new ArrayList<>();
		while (number > 0) {
			list.add(number % 10);
			number = number / 10;
		}

		int[] tmp = list.stream().mapToInt(num -> num).toArray();

		for (int i = 1; i < tmp.length; i++) {
			int diff = Math.abs(tmp[i] - tmp[i - 1]);
			if (diff != 1) {
				return false;
			}
		}

		return true;
	}
}