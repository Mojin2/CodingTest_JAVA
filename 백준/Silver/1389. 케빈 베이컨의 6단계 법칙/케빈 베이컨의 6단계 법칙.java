import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

//5 5
//1 3
//1 4
//4 5
//4 3
//3 2
public class Main {

	static int N, M;
	static int[][] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// dist 배열 생성 및 초기화
		dist = new int[N + 1][N + 1];

		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				if (i == j) {
					dist[i][j] = 0;
					continue;
				}
				dist[i][j] = Integer.MAX_VALUE;
			}
		}

		// 인접한 노드들 초기화 (현재 가중치가 1로 모두 동일)
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			dist[from][to] = Math.min(dist[from][to], 1);
			dist[to][from] = Math.min(dist[to][from], 1);
		}

//		System.out.println(Arrays.deepToString(dist));

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (dist[i][k] == Integer.MAX_VALUE)
					continue;
				for (int j = 1; j <= N; j++) {
					if (dist[k][j] == Integer.MAX_VALUE)
						continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		// 출력
//		for (int i = 1; i < N + 1; i++) {
//			for (int j = 1; j < N + 1; j++) {
//				if (dist[i][j] == Integer.MAX_VALUE) {
//					System.out.print("INF ");
//				} else {
//					System.out.print(dist[i][j] + " ");
//				}
//			}
//			System.out.println();
//		}

		int min = Integer.MAX_VALUE;
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				sum += dist[i][j];
			}
			if (min > sum) {
				answer = i;
				min = sum;
			}
		}

		System.out.println(answer);

	}
}