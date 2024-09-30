import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int count1 = 0;
	static int count2 = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int answer1 = fibo(N);

		int answer2 = fiboByDP(N);
		System.out.println(count1 + " " + count2);

	}

	private static int fibo(int N) {
		if (N <= 2) {
			count1++;
			return 1;
		}

		else
			return fibo(N - 1) + fibo(N - 2);

	}

	private static int fiboByDP(int N) {
		int[] dp = new int[N + 1];
		dp[1] = 1;
		dp[2] = 1;

		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
			count2++;
		}

		return dp[N];
	}
}