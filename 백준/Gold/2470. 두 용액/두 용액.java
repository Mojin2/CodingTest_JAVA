import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int min = Integer.MAX_VALUE;
	static int[] ans = new int[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = N - 1;
		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));

		while (start < end) {
			int sum = arr[start] + arr[end];
			if (Math.abs(sum) < Math.abs(min)) {
//				System.out.println("몇번 들어옴");
//				System.out.println(sum);
//				System.out.println(arr[start] + ":::" + arr[end]);
				min = sum;
				ans[0] = arr[start];
				ans[1] = arr[end];
			}

			if (sum >= 0) {
				end = end - 1;
			} else {
				start = start + 1;
			}
		}
		System.out.println(ans[0] + " " + ans[1]);
	}
}