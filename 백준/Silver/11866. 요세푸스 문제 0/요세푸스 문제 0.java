import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		boolean[] visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<");

		int index = 0;
		int count = 0;
		while (true) {
			if (count == N)
				break;

			if (visited[index]) {
				while (visited[index]) {
					if (!visited[index])
						break;
					index = (index + 1) % N;
				}
			}
			for (int i = 0; i < K - 1; i++) {
				index = (index + 1) % N;
				if (visited[index]) {
					while (visited[index]) {
						if (!visited[index])
							break;
						index = (index + 1) % N;
					}
				}
			}

			sb.append(arr[index]);
			if (count < N-1) {
				sb.append(", ");
			}
			visited[index] = true;
			count++;
			index = (index + 1) % N;

		}
		// <3, 6, 2, 7, 5, 1, 4>
		sb.append(">");
		System.out.println(sb);

	}
}