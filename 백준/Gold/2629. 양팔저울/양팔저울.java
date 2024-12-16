//2
//1 4
//2
//3 2

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] beads = new int[N]; // {1, 4}
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			beads[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int max = Integer.MIN_VALUE;
		int[] targets = new int[M]; // {3, 2}
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			targets[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, targets[i]);
		}

		HashSet<Integer> set = new HashSet<>();
		set.add(beads[0]);
		for (int i = 1; i < N; i++) {
			int newBead = beads[i];
			HashSet<Integer> tmp = new HashSet<>();
			for (Integer b : set) {
				tmp.add(b);
				tmp.add(b + newBead);
				tmp.add(Math.abs(b + newBead));
				tmp.add(b - newBead);
				tmp.add(Math.abs(b - newBead));
			}
			tmp.add(newBead);
			set = tmp;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			if (set.contains(targets[i])) {
				sb.append("Y").append(" ");
			} else {
				sb.append("N").append(" ");
			}
		}
//		System.out.println(set);
		System.out.println(sb);

//		첫째 줄에는 추의 개수가 자연수로 주어진다. 추의 개수는 30 이하이다. 
//		둘째 줄에는 추의 무게들이 자연수로 가벼운 것부터 차례로 주어진다. 
//		같은 무게의 추가 여러 개 있을 수도 있다. 추의 무게는 500g이하이며, 입력되는 무게들 사이에는 빈칸이 하나씩 있다. 
//		세 번째 줄에는 무게를 확인하고자 하는 구슬들의 개수가 주어진다. 확인할 구슬의 개수는 7이하이다. 
//		네 번째 줄에는 확인하고자 하는 구슬들의 무게가 자연수로 주어지며, 입력되는 무게들 사이에는 빈 칸이 하나씩 있다. 
//		확인하고자 하는 구슬의 무게는 40,000보다 작거나 같은 자연수이다.

		// dp[i][j] : i번째 구슬까지 썼을때 j의 무게를 만들 수 있는지
		// dp[i][j] =
//					1 2 3
//		1번째(무게 1)	T F F
//		2번째(무게 4)	T F T
		// 첫번째 무게는 그냥 돌림
		// 두번째 무게 포함 부터는 +,- 다 봐야됨
		// 두번째 무게가 4이므로
		// 무게 1,2,3까지 a라고 가정하면 4+a, 4-a가 가능한지 확인
		// 가능하다면 T

//		boolean[][] dp = new boolean[N + 1][max + 1];
//		for (int i = 1; i < N + 1; i++) {
//			if (i == 1) { // 첫번째 무게만 포함하는 경우
//				int weight = beads[i - 1];
//				for (int j = 1; j < max + 1; j++) {
//					if (weight == j) {
//						dp[i][j] = true;
//					}
//				}
//			} else {
//				int weight = beads[i - 1];
//				for (int j = 1; j < max + 1; j++) {
//					if (dp[i - 1][j] == true) {
//						dp[i][j] = true;
//						continue;
//					}
//					int plus = Math.abs(weight + j);
//					int minus = Math.abs(weight - j);
//					// plus랑 minus는 1<= x < max+1 사이의 값이어야함
//					if (0 < plus && plus < max + 1) {
//						if (dp[i - 1][plus] == true) {
//							dp[i][j] = true;
//						}
//					}
//					if (0 < minus && minus < max + 1) {
//						if (dp[i - 1][minus] == true) {
//							dp[i][j] = true;
//						}
//					}
//
//				}
//			}
//		}
//
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < M; i++) {
//			if (dp[N][targets[i]] == true) {
//				sb.append("Y").append(" ");
//			} else {
//				sb.append("N").append(" ");
//			}
//		}
//		System.out.println(sb);
	}
}