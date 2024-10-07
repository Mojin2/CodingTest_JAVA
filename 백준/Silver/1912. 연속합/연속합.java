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
		
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0 ;i <N;i++) {
			 arr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		int[] dp = new int[N];
		dp[0] = arr[0];
        int max = arr[0];
		
		for (int i = 1; i <N;i++) {
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]); 
			max = Math.max(dp[i], max);
		}
		
		System.out.println(max);
	}
}