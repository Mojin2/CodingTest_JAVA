import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		sb.append((int) (Math.pow(2, N) - 1)).append('\n');

		hanoi(N, 1, 2, 3);
		System.out.println(sb);
	}

	private static void hanoi(int n, int start, int mid, int to) {
		if (n == 1) {
			sb.append(start + " " + to).append("\n");
			return;
		}

		hanoi(n - 1, start, to, mid);
		sb.append(start + " " + to).append("\n");
		hanoi(n - 1, mid, start, to);

	}
}