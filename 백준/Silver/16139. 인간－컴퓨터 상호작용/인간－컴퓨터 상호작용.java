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

		String str = st.nextToken();

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		String some = "";

		int[][] range = new int[N][2];

		for (int k = 0; k < N; k++) {
			st = new StringTokenizer(br.readLine());
			some = st.nextToken();

			range[k] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

			int[] cum = new int[str.length()];
			for (int i = 0; i < str.length(); i++) {
				String tmp = String.valueOf(str.charAt(i));
				if (tmp.equals(some)) {
					cum[i]++;
				}
				if (i != 0) {
					cum[i] += cum[i - 1];
				}
			}

			int start = range[k][0];
			int end = range[k][1];
			if (start == 0) {
				System.out.println(cum[end]);
			} else {
				System.out.println(cum[end] - cum[start - 1]);
			}
		}
	}

//		int[] cum = new int[str.length()];
//		for (int i = 0; i < str.length(); i++) {
//			String tmp = String.valueOf(str.charAt(i));
//			if (tmp.equals(some)) {
//				cum[i]++;
//			}
//			if (i != 0) {
//				cum[i] += cum[i - 1];
//			}
//		}
//
//		System.out.println(Arrays.toString(cum));
//
//		for (int i = 0; i < N; i++) {
//			int start = range[i][0];
//			int end = range[i][1];
//			if (start == 0) {
//				System.out.println(cum[end]);
//			} else {
//				System.out.println(cum[end] - cum[start - 1]);
//			}
//		}
}