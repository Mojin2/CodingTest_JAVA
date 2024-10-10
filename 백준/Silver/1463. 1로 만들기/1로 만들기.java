import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
//
//X가 3으로 나누어 떨어지면, 3으로 나눈다.
//X가 2로 나누어 떨어지면, 2로 나눈다.
//1을 뺀다.
//정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int cur = 1;

		int[] dp = new int[N + 1];
		if (N== 1) {
			System.out.println(0);
			return;
		} else if (N == 2) {
			System.out.println(1);
			return;
		} else if(N == 3) {
			System.out.println(1);
			return;
		}
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;

		for (int i = 4; i < N + 1; i++) {
			dp[i] = dp[i - 1] + 1;
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], Math.min(dp[i / 3], dp[i - 1]) + 1);
			}
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], Math.min(dp[i / 2], dp[i - 1]) + 1);
			}
		}

		System.out.println(dp[N]);

	}
}