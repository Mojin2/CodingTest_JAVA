import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

//			ArrayList<Integer>[] graph = new ArrayList[N + 1];
//			for (int i = 0; i < N + 1; i++) {
//				graph[i] = new ArrayList<>();
//			}

//			boolean[] visited = new boolean[N + 1];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
//				int from = Integer.parseInt(st.nextToken());
//				int to = Integer.parseInt(st.nextToken());
//				graph[from].add(to);
			}

			System.out.println(N - 1);

		}
	}
}