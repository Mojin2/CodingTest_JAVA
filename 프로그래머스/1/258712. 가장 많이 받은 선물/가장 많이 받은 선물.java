import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {
		int N = friends.length;
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			map.put(friends[i], i);
		}

		// 주고받은 선물에 대한 배열
		int[][] arr = new int[N][N];
		for (int i = 0; i < gifts.length; i++) {
			String[] tmp = gifts[i].split(" ");
			String from = tmp[0];
			String to = tmp[1];

			arr[map.get(from)][map.get(to)]++;
		}

		// 선물지수에 대한 배열
		int[] score = new int[N];
		for (int i = 0; i < N; i++) {
			String who = friends[i];

			int give = 0;
			for (int j = 0; j < N; j++) {
				give += arr[map.get(who)][j];
			}

			int take = 0;
			for (int j = 0; j < N; j++) {
				take += arr[j][map.get(who)];
			}

			score[i] = give - take;
		}

		// 선물에 대한 최종 계산
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			int who = map.get(friends[i]);
			int total = 0;

			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;

				int target = map.get(friends[j]);

				if (arr[who][target] > arr[target][who]) {
					total++;
				} else if (arr[who][target] == arr[target][who]) {
					if (score[who] > score[target]) {
						total++;
					}
				}
			}

			max = Math.max(max, total);
		}

		return max;
	}
}