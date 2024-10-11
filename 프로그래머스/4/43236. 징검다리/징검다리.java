import java.util.*;

public class Solution {
	
	public  int solution(int distance, int[] rocks, int n) {
		int answer = 0;

		Arrays.sort(rocks);
		int[] dis = new int[rocks.length + 1];
		dis[0] = rocks[0];

		for (int i = 1; i < rocks.length; i++) {
			dis[i] = rocks[i] - rocks[i - 1];
		}
		dis[rocks.length] = distance - rocks[rocks.length - 1];

		int start = 1;
		int end = distance;

		while (start <= end) {
			int mid = (start + end) / 2;
//			System.out.println(mid);

			if (check(mid, dis, n)) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return end;
	}

	private static boolean check(int mid, int[] dis, int n) {
		ArrayList<Integer> len = new ArrayList<>();
		int broke = 0;

		int sum = 0;
		for (int i = 0; i < dis.length; i++) {
			sum += dis[i];
			if (sum >= mid) {
				len.add(sum);
				sum = 0;
			} else if (sum < mid) {
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
