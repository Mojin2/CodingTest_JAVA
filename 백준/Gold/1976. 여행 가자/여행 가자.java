//3
//3
//0 1 0
//1 0 1
//0 1 0
//1 2 3

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] arr;
	static int[] route, parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			parent[i] = i;
		}

		// 인접행렬로 그래프 생성
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 경로 저장된 부분
		route = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			route[i] = Integer.parseInt(st.nextToken());
		}
//		System.out.println(Arrays.deepToString(arr));

//		[[0, 1, 0, 0, 0], 
//		 [1, 0, 0, 0, 1], 
//		 [0, 0, 0, 1, 0], 
//		 [0, 0, 1, 0, 1], 
//		 [0, 1, 0, 1, 0]]

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] != 0) {
//					System.out.println((i + 1) + " " + (j + 1));
					if (find(i + 1) != find(j + 1)) {
						union(i + 1, j + 1);
					}
				}
			}
		}

//		System.out.println(Arrays.toString(parent));

		for (int i = 0; i < M - 1; i++) {
			if (find(route[i]) != find(route[i + 1])) {
				System.out.println("NO");
				return;
			}
		}

		System.out.println("YES");

	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x < y)
			parent[y] = x;
		else
			parent[x] = y;
	}

	private static int find(int x) {
		if (parent[x] == x)
			return x;
		else
			return find(parent[x]);
	}
}