import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		
		// 배열 받아오기 
		for (int i = 0 ;i < N;i++) {
			arr[i]= Integer.parseInt(st.nextToken()); 
		}
		
		// 누적합 배열 만들기 
		for (int i = 1 ;i < N;i++) {
			arr[i]= arr[i]+ arr[i-1];  
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			if (start == 1) {
				sb.append(arr[end-1]).append("\n");
				continue;
			}
			sb.append(arr[end-1]-arr[start-2]).append("\n");
		}
		System.out.println(sb);
		

	}

}
