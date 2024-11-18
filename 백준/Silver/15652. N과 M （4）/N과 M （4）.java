import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static int[] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();

		int start = 1;
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = start++;
		}
//		System.out.println(Arrays.toString(arr));
		backtrack(0,0,new int[K]);
		
		System.out.println(sb);
	}

	private static void backtrack(int start,int cnt,int[] out) {
		if (cnt == K) {
			for (int i =0  ;i <out.length;i++) {
				sb.append(out[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < arr.length; i++) {
			out[cnt] = arr[i];
			backtrack(i, cnt+1,out);
		}
	}
}