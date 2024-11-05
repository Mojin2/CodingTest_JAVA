import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int mod = 2147483647;

		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		long C = Integer.parseInt(st.nextToken());

		System.out.println(pow(A, B, C));
	}

	private static long pow(long a, long b, long c) {
		if (b == 0) {
			return 1;
		} else if (b == 1) {
			return a % c;
		}

		long tmp = pow(a, b / 2, c);
		if (b % 2 == 1) {
			return tmp * tmp %c * a % c;
		} else {
			return tmp * tmp % c;
		}
	}
}