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
		int M = Integer.parseInt(st.nextToken());

		int[] numbers = new int[N];

		for (int i = 1; i <= N; i++) {
			numbers[i - 1] = i;
		}
		permutation(numbers, new int[M], new boolean[N], 0, M);
	}

	public static void permutation(int[] arr, int[] out, boolean[] visited, int depth, int r) {
		if (depth == r) {
			for (int num : out)
				System.out.print(num+" ");
			System.out.println();
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				out[depth] = arr[i];
				permutation(arr, out, visited, depth + 1, r);
				visited[i] = false;
			}
		}
	}

}