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
		int M = Integer.parseInt(st.nextToken());

		int[] memories = new int[N];
		int[] costs = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			memories[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			costs[i] = Integer.parseInt(st.nextToken());
		}

		
		int[][] dp = new int[N][10001];
		int min = Integer.MAX_VALUE;
		
		for (int i = 0 ;i <N;i++) {
			int memory = memories[i];
			int cost = costs[i];
			
			for (int j = 0 ; j <10001;j++) {
				if (i == 0) {
					if (j>=cost) dp[i][j] = memory; 
				} else {
					if (j>=cost) {
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost]+memory);
					} else {
						dp[i][j] = dp[i-1][j]; 
					}
				}
				if (dp[i][j]>= M ) {
					min = Math.min(min, j);
				}
			}
		}
		
		System.out.println(min);
	}
}