import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.imageio.ImageTranscoder;

public class Main {

	static int max;
	static int min;
	static int[] operations;
	static int[] number;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		number = new int[N];
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}

//		System.out.println(Arrays.toString(number));

		st = new StringTokenizer(br.readLine());
		int sum = 0;
		int[] op = new int[4];
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
			sum += op[i];
		}

		operations = new int[sum];
		int operationsIdx = 0;
		for (int i = 0; i < 4; i++) {
			while (op[i] > 0) {
				operations[operationsIdx++] = i;
				op[i]--;
			}
		}

//		System.out.println(Arrays.toString(operations));

//		System.out.println(Arrays.toString(op));

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		int num = number[0];

		backtrack(num, number, operations, new boolean[number.length], 0, sum);

		System.out.println(max);
		System.out.println(min);
	}

	private static int cal(int a, int b, int oper) {
		if (oper == 0) {
			return a + b;
		} else if (oper == 1) {
			return a - b;
		} else if (oper == 2) {
			return a * b;
		} else {
			return a / b;
		}
	}

	private static int reverseCal(int a, int b, int oper) {
		if (oper == 0) {
			return a - b;
		} else if (oper == 1) {
			return a + b;
		} else if (oper == 2) {
			return a / b;
		} else {
			return a * b;
		}
	}

	private static void backtrack(int num, int[] number, int[] operations, boolean[] visited, int depth, int r) {
		if (depth == r) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}

		for (int i = 0; i < operations.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				num = cal(num, number[depth + 1], operations[i]);
				backtrack(num, number, operations, visited, depth + 1, r);
				num = reverseCal(num, number[depth + 1], operations[i]);
				visited[i] = false;
			}
		}

	}
}