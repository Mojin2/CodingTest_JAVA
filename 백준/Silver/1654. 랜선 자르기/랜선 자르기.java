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

		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] list = new int[K];
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, list[i]);
		}

		long start = 1;
		long end = max;

		while (start <= end) {
			long mid = (long) Math.floor((start+end)/2);
			long count = 0;
			for (long leng : list) {
				count += (long) Math.floor(leng/mid);
			}
			
			if (count < N) {
				end = mid-1;
			} else {
				start = mid+1;
			}
		}
		System.out.println(end);

	}
}