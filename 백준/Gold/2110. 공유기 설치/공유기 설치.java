import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		Integer[] arr = new Integer[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, (a, b) -> a - b);
//		System.out.println(Arrays.toString(arr));

		int start = 1;
		int end = arr[arr.length - 1] - arr[0];

		while (start <= end) {
			int mid = (start + end) / 2;

			ArrayList<Integer> list = new ArrayList<>();
			list.add(arr[0]);
			int pv = arr[0];
			for (int i = 1; i < arr.length; i++) {
				int cur = arr[i];
				if (cur - pv >= mid) {
					list.add(cur);
					pv = cur;
				}
			}
//			System.out.println(mid);
//			for (Integer a : list) {
//				System.out.print(a + " ");
//			}
//			System.out.println();

			if (list.size() >= C) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(end);
	}
}