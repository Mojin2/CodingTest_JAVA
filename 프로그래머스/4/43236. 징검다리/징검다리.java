import java.util.Arrays;

public class Solution {
	public static int solution(int distance, int[] rocks, int n) {
		int answer = 0;

		int start = 1;
		int end = distance;

		Arrays.sort(rocks);

		int[] dis = new int[rocks.length + 1];
		dis[0] = rocks[0];
		for (int i = 1; i < rocks.length; i++) {
			dis[i] = rocks[i] - rocks[i - 1];
		}
		dis[rocks.length] = distance - rocks[rocks.length - 1];

		int cnt = rocks.length - n;

		// System.out.println(Arrays.toString(dis));

		while (start <= end) {
			int mid = (start + end) / 2;

			if (check(mid, dis, cnt,n)) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return end;
	}

	private static boolean check(int mid, int[] dis, int cnt,int n) {
		int sum = 0;
		int island = 0;
        int broke = 0;
		for (int i = 0; i < dis.length; i++) {
			sum += dis[i];
			if (sum >= mid) {
				island++;
				sum = 0;
			} else {
                broke++;
            }
		}

		if (broke > n) {
			return true;
		} else {
			return false;
		}

	}
}
