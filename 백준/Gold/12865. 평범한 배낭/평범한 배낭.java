import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		ArrayList<Integer[]> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			list.add(new Integer[] { weight, value });
		}
		Collections.sort(list, (a, b) -> a[0] - b[0]);

		int[] dp = new int[K + 1];
		int answer = Integer.MIN_VALUE;

		for (Integer[] tmp : list) {
			int w = tmp[0];
			int v = tmp[1];

			for (int i = K; i >=w; i--) {
				int d = Math.max(dp[i], dp[i - 1]);
				dp[i] = Math.max(d, dp[i - w] + v);
			}
		}
		System.out.println(dp[K]);
	}
}