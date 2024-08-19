import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] students = { 1, 2, 3, 4, 5, 6, 7, 8 };
	static int N = 8;
	static int[][] rounds;
	static long max;
	static int[] selected;
	static int pCount = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		max = Integer.MIN_VALUE;
		selected = new int[N + 1];

		// 인풋 받아오기
		int round = Integer.parseInt(st.nextToken());
		rounds = new int[round][9];
		for (int i = 0; i < round; i++) {
			int[] tmp = new int[9];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				tmp[j] = Integer.parseInt(st.nextToken());
			}
			rounds[i] = tmp;

		}
		selected[3] = 0;

		// 모든 순열 확인하기
		permutation(0, selected, new boolean[N]);

		System.out.println(max);
//		System.out.println(pCount);
	}

	private static void permutation(int cnt, int[] selected, boolean[] visited) {
		if(cnt == 3) {
			permutation(cnt + 1, selected, visited);
			return;
		}
		if (cnt == N + 1) {
			// System.out.println(Arrays.toString(selected));
			pCount++;
			int score = calScore(rounds, selected);
			max = Math.max(max, score);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (cnt == 3) {
//				cnt++;
//				continue;
			} else {
				if (!visited[i]) {
					visited[i] = true;
					selected[cnt] = students[i];
					permutation(cnt + 1, selected, visited);
					visited[i] = false;
				}
			}
		}
	}

	private static int calScore(int[][] rounds, int[] order) {

		int totalScore = 0;
		int start = 0;

		for (int i = 0; i < rounds.length; i++) {
			int outCount = 0;
			int base = 0;
			while (true) {
				if (outCount == 3)
					break;
				int currentPlayer = order[start];
				int target = rounds[i][currentPlayer];
				if (target == 0) {
					outCount++;
					start = (start + 1) % 9;
					continue;
				} else {
					base = base << target;
					base |= (1 << (target - 1));
				}
				int bitCount = Integer.bitCount(base);
				int bitPattern = (1 << 0) | (1 << 1) | (1 << 2);

				base &= bitPattern;
				int score = bitCount - Integer.bitCount(base);
				totalScore += score;

				start = (start + 1) % 9;
			}
		}

		return totalScore;
	}

}