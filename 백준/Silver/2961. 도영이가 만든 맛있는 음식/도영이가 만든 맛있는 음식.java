import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int min = Integer.MAX_VALUE;
	static int[][] lists;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		lists = new int[N][2];

		int[] idx = new int[N];
		for (int i = 0; i < N; i++) {
			idx[i] = i;
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			lists[i] = new int[] { a, b };
		}

//		System.out.println(Arrays.deepToString(lists));

		for (int i = 1; i <= N; i++) {
			backtrack(idx, new int[i], 0, 0, i);
		}
		System.out.println(min);
	}

	static void backtrack(int[] idx, int[] out, int start, int depth, int r) {
		if (depth == r) {
			int multiple = 0;
			int sum = 0;
			for (int i = 0; i < out.length; i++) {
				if (i == 0) {
					multiple = lists[out[i]][0];
					sum = lists[out[i]][1];
				} else {
					multiple *= lists[out[i]][0];
					sum += lists[out[i]][1];
				}
			}
			min = Math.min(min, Math.abs(multiple - sum));
			return;
		}

		for (int i = start; i < idx.length; i++) {
			out[depth] = idx[i];
			backtrack(idx, out, i + 1, depth + 1, r);
		}
	}

}