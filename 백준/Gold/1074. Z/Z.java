import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int count;
	static int r;
	static int c;
	static String[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		count = 0;

		int t = (int) Math.pow(2, N);

		dv(0, 0, t);
	}

	private static void dv(int x, int y, int size) {
		if (size == 1) {
			if (x == r && y == c) {
				System.out.println(count);
			}
			count++;
			return;
		}

		int t = size / 2;

		// 1사분면 (왼쪽 위)
		if (r < x + t && c < y + t) {
			dv(x, y, t);
		}
		// 2사분면 (오른쪽 위)
		else if (r < x + t && c >= y + t) {
			count += t * t;
			dv(x, y + t, t);
		}
		// 3사분면 (왼쪽 아래)
		else if (r >= x + t && c < y + t) {
			count += 2 * t * t;
			dv(x + t, y, t);
		}
		// 4사분면 (오른쪽 아래)
		else {
			count += 3 * t * t;
			dv(x + t, y + t, t);
		}
	}
//	private static void dv(int x, int y, int t) {
//		
//		int size = t;
//		
//		if (x > r || r >= x + t || y > c || c >= y + t) {
//			count += t * t;
//			return;
//		}
//
//		if (x <= r && r < x + t && y <= c && c < y + t) {
//			for (int i = x; i < x + t; i++) {
//				for (int j = y; j < y + t; j++) {
//					if (i == r && j == c) {
//						System.out.println(count);
//					} else {
//						count++;
//					}
//				}
//			}
//
//			return;
//		}
//
//		dv(x, y, size / 2);
//		dv(x + size / 2, y, size / 2);
//		dv(x, y + size / 2, size / 2);
//		dv(x + size / 2, y + size / 2, size / 2);

}