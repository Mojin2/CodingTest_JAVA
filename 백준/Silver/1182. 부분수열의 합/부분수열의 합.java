import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.BiConsumer;

public class Main {

	static int N;
	static int S;
	static int sum;
	static int[] numbers;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		sum = 0;
		count = 0;
		st = new StringTokenizer(br.readLine());
		numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		backtrack(0, 0);
		if (S == 0) {
			System.out.println(count - 1);
		} else {
			System.out.println(count);
		}
	}

	private static void backtrack(int depth, int sum) {
		if (depth == N) {
			if (sum == S)
				count++;
			return;
		}

		backtrack(depth + 1, sum + numbers[depth]);
		backtrack(depth + 1, sum);
	}
}