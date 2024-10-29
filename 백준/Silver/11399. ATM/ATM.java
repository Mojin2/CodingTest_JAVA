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
		
		Integer[] arr = new Integer[N];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0 ;i <N;i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		Arrays.sort(arr,(a,b)->a-b);
		
		int[] cum = new int[N];
		
		cum[0] = arr[0];
		
		int answer = cum[0];
		
		for (int i = 1 ; i <N;i++) {
			cum[i] = cum[i-1] + arr[i]; 
			answer += cum[i];
		}
		
		System.out.println(answer);
	}
}