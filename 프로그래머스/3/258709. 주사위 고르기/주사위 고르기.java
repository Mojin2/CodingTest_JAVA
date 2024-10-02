import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Solution {

	static boolean[] visited;
	static int[] num;
	static int N;
	static int max;
	static int[] ans;

	public int[] solution(int[][] dice) {

		N = dice.length;
		num = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			num[i] = i;
		}

		max = Integer.MIN_VALUE;
		ans = new int[N / 2];

		combination(num, N / 2, 0, 0,dice);
		

		return ans;
	}

	// A가 가져갈 수 있는 주사위의 인덱스 조합
	private static void combination(int[] num, int depth, int r, int start,int[][] dice) {
		if (r == depth) {
			cal(visited,dice);
			return;
		}

		for (int i = start; i < N; i++) {
			visited[i] = true;
			combination(num, depth, r + 1, i + 1,dice);
			visited[i] = false;
		}

	}

	// 해당 주사위 조합을 가지고 승률 계산
	private static void cal(boolean[] visited,int[][] dice) {

		// 주사위 소유자 지정
		int[][] Alist = new int[N / 2][6];
		int[][] Blist = new int[N / 2][6];
		int Aindex = 0;
		int Bindex = 0;
		for (int i = 0; i < N; i++) {
			if (visited[i]) {
				Alist[Aindex++] = dice[i];
			} else {
				Blist[Bindex++] = dice[i];
			}
		}

		// 승률 계산을 위한 배열 {win,draw,lose}
		int[] rate = new int[3];

		// A 계산
		ArrayList<Integer> Ascore = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			Ascore.add(Alist[0][i]);
		}

		int count = 1;

		while (true) {

			if (count >= N / 2)
				break;

			ArrayList<Integer> tmp = new ArrayList<>();
			for (int i = 0; i < 6; i++) {
				int add = Alist[count][i];
				for (Integer as : Ascore) {
					tmp.add(add + as);
				}
			}

			Ascore = tmp;
			count++;
		}

		// B 계산
		ArrayList<Integer> Bscore = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			Bscore.add(Blist[0][i]);
		}

		int countB = 1;

		while (true) {

			if (countB >= N / 2)
				break;

			ArrayList<Integer> tmp = new ArrayList<>();
			for (int i = 0; i < 6; i++) {
				int add = Blist[countB][i];
				for (Integer as : Bscore) {
					tmp.add(add + as);
				}
			}
			Bscore = tmp;
			countB++;
		}

		Collections.sort(Ascore, (a, b) -> a - b);
		Collections.sort(Bscore, (a, b) -> a - b);

		int indexA = 0;
		int indexB = 0;
        int[] dp = new int[501];

		for (int bb : Bscore) {
			indexA = 0;
			for (int aa : Ascore) {
				if (dp[bb] != 0) {
					rate[0] += dp[bb];
					break;
				} else if (aa > bb && dp[bb] == 0) {
					dp[bb] = Bscore.size() - indexA;
					rate[0] += Bscore.size() - indexA;
					break;
				} else {
					indexA++;
				}
			}
			indexB++;
		}

//		System.out.println(Arrays.toString(rate));
//		for (int aa : Bscore) {
//			System.out.print(aa + " ");
//		}
//		System.out.println();
//
//		for (int bb : Ascore) {
//			System.out.print(bb + " ");
//		}
//
//		System.out.println();
//		System.out.println("*************");

		if (rate[0] > max) {
			max = rate[0];
			int in = 0;
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					ans[in++] = i + 1;
				}
			}
		} 
	}

}
