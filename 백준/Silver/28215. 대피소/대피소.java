import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.zip.CheckedInputStream;

//5 2
//1 5
//3 0
//3 3
//6 12
//8 9

public class Main {

	static int N, K;
	static boolean[] checked;
	static int[][] houses;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		houses = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			houses[i] = new int[] { x, y };
		}

		checked = new boolean[N];

		combination(K, 0, 0);

		System.out.println(min);
	}

	private static void combination(int r, int depth, int start) {
		if (depth == r) {
			int calMax = cal();
			min = Math.min(min, calMax);
			return;
		}

		for (int i = start; i < N; i++) {
			if (checked[i])
				continue;

			checked[i] = true;
			combination(r, depth + 1, i + 1);
			checked[i] = false;
		}
	}

	private static int cal() {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			int in = Integer.MAX_VALUE;

			for (int j = 0; j < N; j++) {
				// 대피소인 지점만
				if (!checked[j])
					continue;

				int dx = Math.abs(houses[i][0] - houses[j][0]);
				int dy = Math.abs(houses[i][1] - houses[j][1]);
				in = Math.min(in, dx + dy);
			}

			max = Math.max(max, in);
		}

		return max;
	}
}
