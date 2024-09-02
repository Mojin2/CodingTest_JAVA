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
		ArrayList<Integer>[] works = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			works[i] = new ArrayList<>();
		}

		int[] dp = new int[N + 1];
		int[] times = new int[N + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			if (i == 0) {
				dp[1] = time;
			}
			times[i + 1] = time;
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				works[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		int answer = dp[1];

		for (int i = 1; i < works.length; i++) {
			int max = 0;
			for (Integer tmp : works[i]) {
				max = Math.max(max, dp[tmp]);
			}
			dp[i + 1] = max + times[i + 1];
			answer = Math.max(answer, dp[i + 1]);
		}
		System.out.println(answer);
	}
}