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
	int K = Integer.parseInt(st.nextToken());
	
	Integer[] coins = new Integer[N];
	
	for (int i = 0 ;i <N;i++) {
		st = new StringTokenizer(br.readLine());
		coins[i] = Integer.parseInt(st.nextToken()); 
	}
	
	Arrays.sort(coins,(a,b)->b-a);
	
	int answer = 0;
	
	for (int i = 0 ;i <N;i++) {
		answer += K / coins[i];
		K = K % coins[i];
	}
	
	System.out.println(answer);
}
}