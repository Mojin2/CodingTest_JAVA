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

		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[][] list = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
		}

		int[] dp = new int[C + 101];
		Arrays.fill(dp, 987654321);
		dp[0] = 0;
		
		
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			int cost = list[i][0];
			int value = list[i][1];
			
			for (int j = value; j <C+101;j++) {
				dp[j]= Math.min(dp[j], dp[j-value]+cost);
			}
		}
		
		for (int i = C; i <C+101;i++) {
			min = Math.min(min, dp[i]);
		}

		System.out.println(min);

	}
}