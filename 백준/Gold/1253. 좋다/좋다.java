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
		boolean[] check = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;

		Arrays.sort(arr, (a, b) -> a - b);

		for (int i = 0; i < N; i++) {
			int cur = arr[i];
			int left = 0;
			int right = N - 1;

			while (left < right) {
				if (left == i || right == i) { // 본인 이라면
					if (left == i)
						left++;
					else
						right--;
				} else {
					int sum = arr[left] + arr[right];

					if (sum == cur) {
						if (!check[i]) {
							check[i] = true;
							answer++;
						}
					}

					if (sum > cur) {
						right--;
					} else {
						left++;
					}
				}
			}

		}

		System.out.println(answer);
	}

}