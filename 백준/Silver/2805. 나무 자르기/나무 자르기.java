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

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}

//		System.out.println(Arrays.toString(arr));

		int start = 0;
		int end = max;

		while (start <= end) {  // <= 로 변경
			int mid = (start + end) / 2;

			long sum = 0;  // sum을 long으로 변경
			for (int i = 0; i < N; i++) {
				if (arr[i] > mid) {
					sum += arr[i] - mid;
				}
			}
			
			if (sum >= M) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		System.out.println(end);  // end가 정답

	}
}