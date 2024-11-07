import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardDownRightHandler;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Integer[] arr = new Integer[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] target = new int[M];
		for (int i = 0; i < M; i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}

//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(target));
		StringBuilder sb = new StringBuilder();

		Arrays.sort(arr, (a, b) -> a - b);
		for (int i = 0; i < M; i++) {
			int num = target[i];
			int min = binarySearch(arr, num, "min");
			int max = binarySearch(arr, num, "max");
			sb.append(max - min).append(" ");
		}
		System.out.println(sb);
	}

	private static int binarySearch(Integer[] arr, int num, String option) {
		int start = 0;
		int end = arr.length;

		if (option.equals("min")) {
			while (start < end) {
				int mid = (start + end) / 2;

				if (num <= arr[mid]) {
					end = mid;
				} else {
					start = mid + 1;
				}
			}
			return start;
		} else {
			while (start < end) {
				int mid = (start + end) / 2;

				if (num < arr[mid]) {
					end = mid;
				} else {
					start = mid + 1;
				}
			}
			return start;
		}
	}
}